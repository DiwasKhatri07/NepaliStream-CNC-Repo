from datetime import datetime, timezone
from pathlib import Path
import os

root=Path(__file__).resolve().parents[1]
log=root/'logs'/'update-log.md'
log.parent.mkdir(exist_ok=True)
now=datetime.now(timezone.utc)
date=now.strftime('%Y-%m-%d')
existing=log.read_text() if log.exists() else '# Automated update log\n\nThis file is maintained by GitHub Actions.\n\n'
if f'## {date}' not in existing:
    archives=len(list((root/'decoded').glob('*/*/*.cs3')))
    kotlin=len(list((root/'decoded').glob('*/*/kotlin/PluginMetadata.kt')))
    manifests=len(list((root/'decoded').glob('*/*/manifests/manifest.json')))
    java=len(list((root/'decoded').glob('*/*/java/sources/**/*.java')))
    run=os.environ.get('GITHUB_RUN_ID','local')
    event=os.environ.get('GITHUB_EVENT_NAME','local')
    entry=(f'## {date}\n\n'
           f'- **Last automated update (UTC):** {now.strftime("%Y-%m-%d %H:%M:%S")}\n'
           f'- **Workflow run:** `{run}`\n'
           f'- **Trigger:** `{event}`\n'
           f'- **Decoded archives:** {archives}\n'
           f'- **Kotlin metadata files:** {kotlin}\n'
           f'- **Manifest files:** {manifests}\n'
           f'- **Decompiled Java files:** {java}\n\n')
    log.write_text(existing+entry)
    print(f'Added daily update entry for {date}')
else:
    print(f'Daily update entry for {date} already exists')
