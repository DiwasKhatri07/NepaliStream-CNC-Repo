#!/usr/bin/env python3
import os, shutil, subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
SOURCES = ROOT / 'sources'
UPSTREAMS = {
    'cncverse': ('NivinCNC/CNCVerse-Cloud-Stream-Extension', 'builds'),
    'phisher98': ('phisher98/cloudstream-extensions-phisher', 'builds'),
}
for key, (repo, branch) in UPSTREAMS.items():
    checkout = ROOT / '.upstream' / key
    if checkout.exists(): shutil.rmtree(checkout)
    subprocess.run(['git', 'clone', '--depth', '1', '--branch', branch, f'https://github.com/{repo}.git', str(checkout)], check=True)
    dest = SOURCES / key
    dest.mkdir(parents=True, exist_ok=True)
    for old in dest.glob('*.cs3'): old.unlink()
    for archive in checkout.glob('*.cs3'):
        shutil.copy2(archive, dest / archive.name)
    for name in ('CNC.json', 'CXX.json', 'plugins.json', 'cnc.png'):
        source = checkout / name
        if source.exists(): shutil.copy2(source, dest / name)
    print(f'Updated {key} from {repo}@{branch}')
shutil.rmtree(ROOT / '.upstream', ignore_errors=True)
