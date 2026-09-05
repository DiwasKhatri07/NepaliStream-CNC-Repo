#!/usr/bin/env python3
import hashlib,json,shutil,subprocess,zipfile
from pathlib import Path
ROOT=Path(__file__).resolve().parents[1]
index=[]
for plugin_dir in sorted((ROOT/'decoded').iterdir() if (ROOT/'decoded').exists() else []):
    if not plugin_dir.is_dir() or plugin_dir.name=='_sources': continue
    for source_dir in sorted(plugin_dir.iterdir()):
        archive=next(source_dir.glob('*.cs3'),None)
        if not archive: continue
        for name in ('java','kotlin','manifests','resources'): shutil.rmtree(source_dir/name,ignore_errors=True)
        java_out=source_dir/'java'; kotlin_out=source_dir/'kotlin'; resource_out=source_dir/'resources'; manifest_out=source_dir/'manifests'
        for p in (java_out,kotlin_out,resource_out,manifest_out): p.mkdir(exist_ok=True)
        with zipfile.ZipFile(archive) as z:
            names=z.namelist(); manifest=json.loads(z.read('manifest.json')) if 'manifest.json' in names else {'name':plugin_dir.name}
            (manifest_out/'manifest.json').write_text(json.dumps(manifest,indent=2)+'\n')
            if 'classes.dex' in names:
                dex=java_out/'classes.dex'; dex.write_bytes(z.read('classes.dex'))
                subprocess.run(['jadx','--deobf','--show-bad-code','--threads-count','2','-d',str(java_out/'sources'),str(dex)],check=False,stdout=subprocess.DEVNULL,stderr=subprocess.DEVNULL)
                dex.unlink(missing_ok=True)
            for name in names:
                if name.startswith('res/') and not name.endswith('/'):
                    target=resource_out/name.removeprefix('res/'); target.parent.mkdir(parents=True,exist_ok=True); target.write_bytes(z.read(name))
        def ks(v): return json.dumps('' if v is None else str(v),ensure_ascii=False)
        package=''.join(c if c.isalnum() else '_' for c in plugin_dir.name).lower()
        tv=', '.join(ks(x) for x in manifest.get('tvTypes',[]))
        (kotlin_out/'PluginMetadata.kt').write_text(f'''package nepali.stream.decoded.{package}\n\n/** Metadata reconstructed from the published .cs3 manifest. */\nobject PluginMetadata {{\n    const val name: String = {ks(manifest.get("name",plugin_dir.name))}\n    const val originalPluginClass: String = {ks(manifest.get("pluginClassName"))}\n    const val version: Int = {int(manifest.get("version",0) or 0)}\n    const val requiresResources: Boolean = {str(bool(manifest.get("requiresResources"))).lower()}\n    val tvTypes: List<String> = listOf({tv})\n}}\n''')
        index.append({'file':str(archive.relative_to(ROOT)),'source':source_dir.name,'plugin':manifest.get('name',plugin_dir.name),'sha256':hashlib.sha256(archive.read_bytes()).hexdigest(),'bytes':archive.stat().st_size})
(ROOT/'decoded-index.json').write_text(json.dumps(index,indent=2)+'\n')
print(f'Processed {len(index)} decoded plugin archives')
