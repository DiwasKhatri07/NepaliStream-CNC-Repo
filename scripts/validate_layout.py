#!/usr/bin/env python3
import json
from pathlib import Path
ROOT=Path(__file__).resolve().parents[1]
archives=sorted((ROOT/'decoded').glob('*/*/*.cs3')) if (ROOT/'decoded').exists() else []
metadata=sorted((ROOT/'decoded').glob('*/*/kotlin/PluginMetadata.kt'))
manifests=sorted((ROOT/'decoded').glob('*/*/manifests/manifest.json'))
java=sorted((ROOT/'decoded').glob('*/*/java/sources/**/*.java'))
errors=[]
if len(archives)!=116: errors.append(f'expected 116 decoded archives, found {len(archives)}')
if len(metadata)!=len(archives): errors.append(f'Kotlin metadata {len(metadata)} != archives {len(archives)}')
if len(manifests)!=len(archives): errors.append(f'manifests {len(manifests)} != archives {len(archives)}')
for forbidden in ('CNCVerse__*.cs3','Phisher98__*.cs3'):
    if list(ROOT.glob(forbidden)): errors.append(f'prefixed root archives remain: {forbidden}')
for name in ('decoder.py','auto-pusher.py','.github/workflows/decode-and-publish.yml'):
    if not (ROOT/name).exists(): errors.append(f'missing {name}')
try:
    index=json.loads((ROOT/'decoded-index.json').read_text())
    if len(index)!=len(archives): errors.append('decoded-index count mismatch')
except Exception as exc: errors.append(f'index error: {exc}')
if errors:
    print('VALIDATION FAILED'); print('\n'.join('- '+e for e in errors)); raise SystemExit(1)
print(f'LAYOUT OK: {len(archives)} archives, {len(metadata)} Kotlin files, {len(manifests)} manifests, {len(java)} Java files')
