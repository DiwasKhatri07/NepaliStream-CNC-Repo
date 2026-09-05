#!/usr/bin/env python3
import json
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
archives = sorted(ROOT.glob('*.cs3'))
kotlin = sorted((ROOT/'kotlin').glob('*/PluginMetadata.kt'))
manifests = sorted((ROOT/'manifests').glob('**/*.json'))
java = sorted((ROOT/'java').glob('*/sources/**/*.java'))
errors=[]
if not archives: errors.append('no root-level .cs3 archives found')
if len(kotlin) != len(archives): errors.append(f'Kotlin metadata count {len(kotlin)} != archive count {len(archives)}')
if len(manifests) != len(archives): errors.append(f'manifest count {len(manifests)} != archive count {len(archives)}')
for forbidden in ('sources','decoded'):
    if (ROOT/forbidden).exists(): errors.append(f'forbidden legacy directory exists: {forbidden}/')
if not (ROOT/'.github/workflows/decode-and-publish.yml').is_file(): errors.append('workflow file missing')
if not (ROOT/'decoder.py').is_file(): errors.append('decoder.py missing')
if not (ROOT/'auto-pusher.py').is_file(): errors.append('auto-pusher.py missing')
try:
    index=json.loads((ROOT/'decoded-index.json').read_text())
    if len(index) != len(archives): errors.append('decoded-index.json count does not match archives')
except Exception as exc:
    errors.append(f'cannot read decoded-index.json: {exc}')
if errors:
    print('LAYOUT VALIDATION FAILED')
    for error in errors: print(f'- {error}')
    raise SystemExit(1)
print(f'LAYOUT OK: {len(archives)} archives, {len(kotlin)} Kotlin metadata files, {len(manifests)} manifests, {len(java)} Java files')
