#!/usr/bin/env python3
"""Root entry point; implementation lives in scripts/update_sources.py."""
from pathlib import Path
import runpy
runpy.run_path(str(Path(__file__).parent / 'scripts' / 'update_sources.py'), run_name='__main__')
