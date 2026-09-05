# NepaliStream CNC Repo

> A modern, automated CloudStream `.cs3` archive and decoded inspection repository maintained by **Diwas Khatri**.

[![Auto Decode and Push](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml/badge.svg)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml)
[![Latest commit](https://img.shields.io/github/last-commit/DiwasKhatri07/NepaliStream-CNC-Repo?logo=github)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/commits/master)
[![Repository size](https://img.shields.io/github/repo-size/DiwasKhatri07/NepaliStream-CNC-Repo?logo=github)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo)
[![Automation](https://img.shields.io/github/actions/workflow/status/DiwasKhatri07/NepaliStream-CNC-Repo/decode-and-publish.yml?label=automation&logo=githubactions)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml)

## What it is

NepaliStream CNC Repo combines the published `builds` branches from two public CloudStream extension repositories into one clean collection. It automatically synchronizes new `.cs3` files, keeps the **original plugin filenames**, organizes every plugin in a simple `decoded/` folder, extracts manifests/resources, generates Kotlin metadata, validates the result, and pushes updates with GitHub Actions.

## Credits and upstream sources

- **Maintainer/developer:** Diwas Khatri
- **CNCVerse source:** [NivinCNC/CNCVerse-Cloud-Stream-Extension/builds](https://github.com/NivinCNC/CNCVerse-Cloud-Stream-Extension/tree/builds)
- **Phisher98 source:** [phisher98/cloudstream-extensions-phisher/builds](https://github.com/phisher98/cloudstream-extensions-phisher/tree/builds)
- **Decoder tool:** [JADX](https://github.com/skylot/jadx)

Upstream authors remain credited in their manifests. This repository does not claim ownership of upstream code, trademarks, provider implementations, or third-party assets.

## Final folder structure

There are **no `.cs3` files in the repository root**. There are no `CNCVerse__` or `Phisher98__` prefixes in plugin filenames.

```text
decoded/
├── AniKoto/
│   ├── CNCVerse/
│   │   ├── AniKoto.cs3
│   │   ├── java/sources/...
│   │   ├── kotlin/PluginMetadata.kt
│   │   ├── manifests/manifest.json
│   │   └── resources/...
│   └── Phisher98/
│       ├── AniKoto.cs3
│       ├── java/sources/...
│       ├── kotlin/PluginMetadata.kt
│       ├── manifests/manifest.json
│       └── resources/...
├── MovieBoxProvider/
│   ├── CNCVerse/MovieBoxProvider.cs3
│   └── Phisher98/MovieBoxProvider.cs3
└── _sources/
    └── upstream metadata

decoder.py                         # Root decoder entry point
auto-pusher.py                     # Root automatic source updater
scripts/organize_existing.py       # One-time existing-output organizer
scripts/decode_sources.py          # Decoder implementation
scripts/update_sources.py           # Upstream synchronization
scripts/validate_layout.py         # Final structure checks
.github/workflows/decode-and-publish.yml
```

This structure keeps duplicate plugin names safely separated by **source folders**, while each `.cs3` retains its original filename.

## Automatic workflow

The workflow is [`Auto Decode and Push Builds`](.github/workflows/decode-and-publish.yml).

It runs hourly and also supports manual execution from:

**GitHub → Actions → Auto Decode and Push Builds → Run workflow**

Each run performs these stages:

1. Checks out the repository.
2. Installs Python and the pinned JADX release.
3. Pulls both public upstream `builds` branches.
4. Stores each archive at `decoded/<plugin>/<source>/<plugin>.cs3`.
5. Extracts each manifest and Android resource directory.
6. Decompiles `classes.dex` into the plugin’s `java/sources/` inspection layer.
7. Generates `kotlin/PluginMetadata.kt` from the embedded manifest.
8. Rebuilds `decoded-index.json` with SHA-256 hashes and sizes.
9. Validates archive, Kotlin, manifest, workflow, and folder counts.
10. Writes a GitHub Actions summary and uploads the index as an artifact.
11. Commits and pushes only if files changed.

The source repositories do not provide a guaranteed webhook into this repository, so the hourly schedule is the reliable automatic detector. Manual dispatch is available for immediate updates.

## How to access files

Browse online:

- [Decoded plugins](decoded/)
- [Workflow](.github/workflows/decode-and-publish.yml)
- [Root decoder](decoder.py)
- [Root auto-pusher](auto-pusher.py)
- [Scripts](scripts/)
- [Actions runs](../../actions)

Clone locally:

```bash
git clone https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo.git
cd NepaliStream-CNC-Repo
python3 scripts/validate_layout.py
```

## Kotlin note

A `.cs3` archive contains compiled Android DEX bytecode, not the original Kotlin source. The generated `PluginMetadata.kt` files are valid Kotlin metadata/index files containing plugin identity, original class, version, resource requirement, and content types. They are not exact restorations of the original provider implementation. The decompiled Java inspection layer is retained under each plugin for behavior reference; building a complete Kotlin provider still requires manual SDK porting and testing.

## Reliability and organization

- Original plugin filenames are preserved.
- CNCVerse and Phisher98 copies are separated by source directory only.
- No root-level `.cs3` files are used.
- No source-prefix filenames are used.
- The decoder is deterministic and rebuilds generated layers per plugin.
- Layout validation runs before the automated push.
- Workflow concurrency prevents overlapping update pushes.
- The workflow has a 30-minute timeout and writes a run summary.
- No secrets are required because both upstream repositories are public.

## License and redistribution

No universal license for all upstream build artifacts was inferred. Review the upstream repositories, provider authorship, manifests, and third-party asset terms before redistribution or production use.

## Tags

`cloudstream` `cs3` `kotlin` `jadx` `decompiler` `nepalistream` `cnc-repo` `github-actions` `automated-builds` `streaming` `anime` `movies` `tv-series` `developer-tools`
