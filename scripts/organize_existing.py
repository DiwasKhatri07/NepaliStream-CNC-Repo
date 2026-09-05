#!/usr/bin/env python3
import hashlib
import json
import shutil
from pathlib import Path

ROOT=Path(__file__).resolve().parents[1]
DEST=ROOT/'decoded'
DEST.mkdir(exist_ok=True)

for archive in sorted(ROOT.glob('*.cs3')):
    source, _, original = archive.name.partition('__')
    plugin=Path(original or archive.name).stem.replace(' ', '_')
    plugin_dir=DEST/plugin/source
    plugin_dir.mkdir(parents=True, exist_ok=True)
    shutil.move(str(archive), str(plugin_dir/f'{Path(original or archive.name).stem}.cs3'))
    for collection in ('java','kotlin','manifests','resources'):
        old=ROOT/collection/f'{source}__{plugin}'
        if not old.exists(): continue
        target=plugin_dir/collection
        if collection=='manifests':
            target.mkdir(parents=True,exist_ok=True)
            manifest=old/'manifest.json'
            if manifest.exists(): shutil.move(str(manifest), str(target/'manifest.json'))
        elif collection=='kotlin':
            target.mkdir(parents=True,exist_ok=True)
            if (old/'PluginMetadata.kt').exists(): shutil.move(str(old/'PluginMetadata.kt'), str(target/'PluginMetadata.kt'))
        else:
            shutil.move(str(old), str(target))

# Keep upstream collection metadata under decoded/_sources, without polluting the root.
meta=DEST/'_sources'; meta.mkdir(exist_ok=True)
for p in ROOT.glob('*__CNC.json'):
    target=meta/'CNCVerse'/p.name.replace('CNCVerse__','')
    target.parent.mkdir(parents=True,exist_ok=True); shutil.move(str(p),str(target))
for p in ROOT.glob('*__CXX.json'):
    target=meta/'Phisher98'/p.name.replace('Phisher98__','')
    target.parent.mkdir(parents=True,exist_ok=True); shutil.move(str(p),str(target))
for p in ROOT.glob('*__plugins.json'):
    target=meta/p.name; shutil.move(str(p),str(target))
for p in ROOT.glob('*__cnc.png'):
    target=meta/p.name; shutil.move(str(p),str(target))

for collection in ('java','kotlin','manifests','resources'):
    shutil.rmtree(ROOT/collection, ignore_errors=True)

index=[]
for archive in sorted((DEST).glob('*/*/*.cs3')):
    source=archive.parent.name
    plugin=archive.parent.parent.name
    index.append({'file':str(archive.relative_to(ROOT)),'source':source,'plugin':plugin,'sha256':hashlib.sha256(archive.read_bytes()).hexdigest(),'bytes':archive.stat().st_size})
(ROOT/'decoded-index.json').write_text(json.dumps(index,indent=2)+'\n')
print('Organized existing decoded layers without running JADX')
