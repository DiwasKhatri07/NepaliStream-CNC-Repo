#!/usr/bin/env python3
#this is rooot enrty file of decoder 
from pathlib import Path
import runpy
runpy.run_path(str(Path(__file__).parent / 'scripts' / 'decode_sources.py'), run_name='__main__')
