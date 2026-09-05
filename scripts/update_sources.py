#!/usr/bin/env python3
import shutil, subprocess
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
UPSTREAMS = {
    'CNCVerse': ('NivinCNC/CNCVerse-Cloud-Stream-Extension', 'builds'),
    'Phisher98': ('phisher98/cloudstream-extensions-phisher', 'builds'),
}
for label, (repo, branch) in UPSTREAMS.items():
    checkout = ROOT / '.upstream' / label
    shutil.rmtree(checkout, ignore_errors=True)
    subprocess.run(['git', 'clone', '--depth', '1', '--branch', branch, f'https://github.com/{repo}.git', str(checkout)], check=True)
    for old in ROOT.glob(f'{label}__*.cs3'):
        old.unlink()
    for archive in checkout.glob('*.cs3'):
        shutil.copy2(archive, ROOT / f'{label}__{archive.name}')
    for name in ('CNC.json', 'CXX.json', 'plugins.json', 'cnc.png'):
        source = checkout / name
        if source.exists(): shutil.copy2(source, ROOT / f'{label}__{name}')
    print(f'Updated {label} from {repo}@{branch}')
shutil.rmtree(ROOT / '.upstream', ignore_errors=True)
