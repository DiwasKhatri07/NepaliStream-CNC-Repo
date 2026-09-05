#!/usr/bin/env python3
import hashlib, json, shutil, subprocess, zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
for collection in ('java', 'kotlin', 'manifests', 'resources'):
    shutil.rmtree(ROOT / collection, ignore_errors=True)
    (ROOT / collection).mkdir()

index=[]
for archive in sorted(ROOT.glob('*.cs3')):
    label, _, original = archive.name.partition('__')
    safe = f'{label}__{Path(original or archive.name).stem}'.replace(' ', '_')
    java_out = ROOT / 'java' / safe
    manifest_out = ROOT / 'manifests' / f'{safe}.json'
    resource_out = ROOT / 'resources' / safe
    kotlin_out = ROOT / 'kotlin' / safe
    for p in (java_out, resource_out, kotlin_out): p.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(archive) as z:
        names=z.namelist()
        manifest=json.loads(z.read('manifest.json')) if 'manifest.json' in names else {'name': original}
        manifest_out.write_text(json.dumps(manifest, indent=2)+'\n')
        if 'classes.dex' in names:
            dex=java_out/'classes.dex'; dex.write_bytes(z.read('classes.dex'))
            subprocess.run(['jadx','--deobf','--show-bad-code','--threads-count','2','-d',str(java_out/'sources'),str(dex)], check=False, stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)
            dex.unlink(missing_ok=True)
        for name in names:
            if name.startswith('res/') and not name.endswith('/'):
                target=resource_out/name.removeprefix('res/'); target.parent.mkdir(parents=True,exist_ok=True); target.write_bytes(z.read(name))
    def ks(v): return json.dumps('' if v is None else str(v), ensure_ascii=False)
    package=''.join(c if c.isalnum() else '_' for c in safe).lower()
    tv=', '.join(ks(x) for x in manifest.get('tvTypes', []))
    (kotlin_out/'PluginMetadata.kt').write_text(f'''package nepali.stream.decoded.{package}\n\n/** Metadata reconstructed from the published .cs3 manifest. */\nobject PluginMetadata {{\n    const val name: String = {ks(manifest.get("name", original))}\n    const val originalPluginClass: String = {ks(manifest.get("pluginClassName"))}\n    const val version: Int = {int(manifest.get("version", 0) or 0)}\n    const val requiresResources: Boolean = {str(bool(manifest.get("requiresResources"))).lower()}\n    val tvTypes: List<String> = listOf({tv})\n}}\n''')
    index.append({'file':archive.name,'source':label,'plugin':manifest.get('name'),'sha256':hashlib.sha256(archive.read_bytes()).hexdigest(),'bytes':archive.stat().st_size})
(ROOT/'decoded-index.json').write_text(json.dumps(index,indent=2)+'\n')
print(f'Processed {len(index)} root-level .cs3 archives')
