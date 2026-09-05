# NepaliStream CNC Repo

> A transparent, automated CloudStream build archive that synchronizes two public `builds` branches, organizes every `.cs3` artifact at the repository root, generates inspection layers, and publishes validated updates through GitHub Actions.

[![Auto Decode and Push](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml/badge.svg)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml)
[![Latest commit](https://img.shields.io/github/last-commit/DiwasKhatri07/NepaliStream-CNC-Repo?logo=github)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/commits/master)
[![Repository size](https://img.shields.io/github/repo-size/DiwasKhatri07/NepaliStream-CNC-Repo?logo=github)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo)
[![Issues](https://img.shields.io/github/issues/DiwasKhatri07/NepaliStream-CNC-Repo?logo=github)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/issues)
[![Actions](https://img.shields.io/github/actions/workflow/status/DiwasKhatri07/NepaliStream-CNC-Repo/decode-and-publish.yml?label=automation&logo=githubactions)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml)

## Project identity

| Field | Value |
|---|---|
| Project title | NepaliStream CNC Repo |
| Maintainer | **Diwas Khatri** |
| Purpose | Automated `.cs3` archive synchronization and inspection |
| Update mode | Hourly schedule + manual workflow dispatch |
| Output organization | Mixed root-level archives with collision-safe prefixes |
| Primary decoder | [JADX](https://github.com/skylot/jadx) |
| Repository | [DiwasKhatri07/NepaliStream-CNC-Repo](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo) |

## What this project does

NepaliStream CNC Repo monitors the current `builds` branch of two public upstream repositories. It pulls the published `.cs3` artifacts, places all builds into one root-level collection, extracts manifests and Android resources, generates source inspection layers, creates Kotlin metadata indexes, validates the resulting layout, and pushes changes only when the upstream content changes.

The project is designed to make the update process repeatable and visible. The workflow, source updater, decoder, validation script, generated index, and attribution are all stored in this repository rather than hidden in an external service.

## Upstream sources and credits

| Upstream | Branch | Role |
|---|---|---|
| [NivinCNC/CNCVerse-Cloud-Stream-Extension](https://github.com/NivinCNC/CNCVerse-Cloud-Stream-Extension/tree/builds) | `builds` | CNCVerse published plugin builds |
| [phisher98/cloudstream-extensions-phisher](https://github.com/phisher98/cloudstream-extensions-phisher/tree/builds) | `builds` | Phisher98 published plugin builds |
| [JADX](https://github.com/skylot/jadx) | release `v1.5.6` in automation | DEX inspection/decompilation tool |

**Developer and repository maintainer:** Diwas Khatri.

Upstream plugin authors remain credited in their original manifests. This repository does not claim ownership of upstream code, trademarks, provider implementations, or third-party artwork.

## Current repository layout

All `.cs3` build files are intentionally stored in the **main repository folder**. The old `sources/cncverse`, `sources/phisher98`, `decoded/cncverse`, and `decoded/phisher98` layout is not used.

```text
.
├── CNCVerse__*.cs3                 # CNCVerse builds at root
├── Phisher98__*.cs3                # Phisher98 builds at root
├── java/                           # Decompiled inspection layers
├── kotlin/                         # Kotlin metadata indexes
├── manifests/                      # Embedded manifest JSON files
├── resources/                      # Extracted layouts and drawables
├── decoder.py                      # Root decoder entry point
├── auto-pusher.py                  # Root upstream synchronization entry point
├── decoded-index.json              # SHA-256 and size index
├── scripts/
│   ├── decode_sources.py           # Decoder implementation
│   ├── update_sources.py           # Upstream updater implementation
│   └── validate_layout.py          # Organization and count checks
├── .github/workflows/
│   └── decode-and-publish.yml      # Automatic decode, validation, summary, push
└── README.md
```

When two upstreams publish the same filename, the prefix preserves both files without overwriting either one. For example:

```text
CNCVerse__AniKoto.cs3
Phisher98__AniKoto.cs3
```

## How the automation works

The workflow is [`Auto Decode and Push Builds`](.github/workflows/decode-and-publish.yml). It runs once per hour at minute 17 and supports manual execution through **Actions → Auto Decode and Push Builds → Run workflow**.

### Pipeline stages

1. **Checkout:** loads the repository with write permission for the automation commit.
2. **Tool setup:** installs Python 3.12 and downloads the pinned JADX `v1.5.6` release.
3. **Source synchronization:** clones both public `builds` branches and refreshes the root-level `CNCVerse__*.cs3` and `Phisher98__*.cs3` files.
4. **Archive decoding:** reads each `.cs3` ZIP container, extracts its `manifest.json`, copies `res/` files, and sends `classes.dex` through JADX.
5. **Kotlin index generation:** creates one valid `kotlin/<source>__<plugin>/PluginMetadata.kt` file from the verified embedded manifest.
6. **Validation:** checks archive, manifest, Kotlin metadata, workflow, decoder, and index counts and rejects a malformed layout.
7. **Reporting:** writes a run summary with counts and uploads `decoded-index.json` as a short-retention workflow artifact.
8. **Publishing:** commits and pushes only when generated or source files changed.

The upstream repositories do not provide a guaranteed cross-repository webhook to this repository. The hourly schedule is therefore the reliable automatic detector. A manual dispatch gives you an immediate refresh without waiting for the next hourly run.

## How to use the repository

### Browse online

- [Root build archives](.)
- [Kotlin metadata](kotlin/)
- [Decoded inspection layers](java/)
- [Manifests](manifests/)
- [Resources](resources/)
- [Actions and workflow runs](../../actions)

### Clone and inspect locally

```bash
git clone https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo.git
cd NepaliStream-CNC-Repo

# View one Kotlin metadata file
find kotlin -name PluginMetadata.kt | head -1 | xargs sed -n '1,80p'

# Validate the checked-in layout
python3 scripts/validate_layout.py
```

### Run the updater and decoder locally

Requirements: Python 3.12+, Git, Java, and JADX available on `PATH`.

```bash
python3 auto-pusher.py
python3 decoder.py
python3 scripts/validate_layout.py
```

## Kotlin and decompilation scope

A `.cs3` file is a ZIP container containing compiled Android DEX bytecode. It does not contain the original `.kt` source. The generated files under `kotlin/` are valid Kotlin **metadata/index files** containing the plugin name, original class name, version, resource requirement, and supported content types. They are not claims of exact recovery of the original Kotlin implementation.

The `java/` directory is retained as a decompiler inspection reference. A complete buildable Kotlin provider still requires manual porting into the appropriate CloudStream SDK project, dependency setup, compilation, and runtime testing.

## Reliability and safety details

- Upstream names are prefixed to prevent collisions.
- The decoder is deterministic: generated collections are cleared and rebuilt on each run.
- `decoded-index.json` records SHA-256 hashes and sizes for root archives.
- GitHub Actions uses concurrency control so two updates cannot publish over each other.
- Workflow writes are limited to repository contents through `permissions: contents: write`.
- The workflow has a 30-minute timeout and validates before publishing.
- No secrets are required because both upstream repositories are public.

## License and redistribution notice

No common upstream license was inferred for all published artifacts. Review each upstream repository, plugin manifest, and applicable third-party asset terms before redistribution or production use. This is an attribution-focused archive and inspection project, not a claim of ownership over upstream content.

## Tags

`cloudstream` `cs3` `kotlin` `jadx` `decompiler` `nepalistream` `cnc-repo` `github-actions` `automated-builds` `streaming` `anime` `movies` `tv-series` `developer-tools`
