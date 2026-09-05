#!/usr/bin/env python3
import hashlib, json, os, shutil, subprocess, urllib.request, zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SOURCES = ROOT / 'sources'
for source_name in ('cncverse', 'phisher98'):
    source = SOURCES / source_name
    if not source.exists():
        continue
    for archive in sorted(source.glob('*.cs3')):
        safe = archive.stem.replace(' ', '_')
        out = ROOT / 'decoded' / source_name / safe
        manifest_out = ROOT / 'manifests' / source_name / safe
        resource_out = ROOT / 'resources' / source_name / safe
        kotlin_out = ROOT / 'kotlin' / source_name / safe
        for p in (out, manifest_out, resource_out, kotlin_out):
            p.mkdir(parents=True, exist_ok=True)
        with zipfile.ZipFile(archive) as z:
            names = z.namelist()
            if 'manifest.json' in names:
                manifest = json.loads(z.read('manifest.json').decode('utf-8'))
                (manifest_out / 'manifest.json').write_text(json.dumps(manifest, indent=2) + '\n')
            else:
                manifest = {'name': archive.stem}
            with zipfile.ZipFile(out / 'extracted.zip', 'w') as copied:
                for name in names:
                    if name not in ('classes.dex', 'resources.arsc') and not name.startswith('res/'):
                        copied.writestr(name, z.read(name))
            if 'classes.dex' not in names:
                continue
            dex = out / 'classes.dex'
            dex.write_bytes(z.read('classes.dex'))
            cmd = ['jadx', '--deobf', '--show-bad-code', '--threads-count', '2', '-d', str(out / 'sources'), str(dex)]
            subprocess.run(cmd, check=False, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
            dex.unlink(missing_ok=True)
            if 'res/' in ''.join(names):
                for name in names:
                    if name.startswith('res/') and not name.endswith('/'):
                        target = resource_out / name.removeprefix('res/')
                        target.parent.mkdir(parents=True, exist_ok=True)
                        target.write_bytes(z.read(name))
            def ks(v):
                return json.dumps('' if v is None else str(v), ensure_ascii=False)
            package = ''.join(c if c.isalnum() else '_' for c in archive.stem).lower()
            tv = ', '.join(ks(x) for x in manifest.get('tvTypes', []))
            kotlin = f'''package nepali.stream.decoded.{source_name}.{package}\n\n/** Metadata reconstructed from the published .cs3 manifest. */\nobject PluginMetadata {{\n    const val name: String = {ks(manifest.get("name", archive.stem))}\n    const val originalPluginClass: String = {ks(manifest.get("pluginClassName"))}\n    const val version: Int = {int(manifest.get("version", 0) or 0)}\n    const val requiresResources: Boolean = {str(bool(manifest.get("requiresResources"))).lower()}\n    val tvTypes: List<String> = listOf({tv})\n}}\n'''
            (kotlin_out / 'PluginMetadata.kt').write_text(kotlin)

# Produce source hashes and a consolidated index.
index=[]
for source_name in ('cncverse', 'phisher98'):
    for archive in sorted((SOURCES/source_name).glob('*.cs3')) if (SOURCES/source_name).exists() else []:
        index.append({'source': source_name, 'file': archive.name, 'sha256': hashlib.sha256(archive.read_bytes()).hexdigest(), 'bytes': archive.stat().st_size})
(ROOT/'decoded-index.json').write_text(json.dumps(index, indent=2) + '\n')
print(f'Processed {len(index)} .cs3 archives')
