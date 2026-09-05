#!/usr/bin/env python3
import shutil, subprocess
from pathlib import Path
ROOT=Path(__file__).resolve().parents[1]
UPSTREAMS={'CNCVerse':('NivinCNC/CNCVerse-Cloud-Stream-Extension','builds'),'Phisher98':('phisher98/cloudstream-extensions-phisher','builds')}
for source,(repo,branch) in UPSTREAMS.items():
    checkout=ROOT/'.upstream'/source
    shutil.rmtree(checkout,ignore_errors=True)
    subprocess.run(['git','clone','--depth','1','--branch',branch,f'https://github.com/{repo}.git',str(checkout)],check=True)
    for old in (ROOT/'decoded').glob(f'*/{source}/*.cs3'):
        old.unlink()
    for archive in checkout.glob('*.cs3'):
        plugin=archive.stem.replace(' ','_')
        dest=ROOT/'decoded'/plugin/source
        dest.mkdir(parents=True,exist_ok=True)
        shutil.copy2(archive,dest/f'{archive.name}')
    meta=ROOT/'decoded'/'_sources'/source; meta.mkdir(parents=True,exist_ok=True)
    for name in ('CNC.json','CXX.json','plugins.json','cnc.png'):
        p=checkout/name
        if p.exists(): shutil.copy2(p,meta/name)
    print(f'Updated {source} from {repo}@{branch}')
shutil.rmtree(ROOT/'.upstream',ignore_errors=True)
