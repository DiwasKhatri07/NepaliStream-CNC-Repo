# NepaliStream CNC Repo

> Automated decoded build archive and Kotlin-oriented inspection workspace for selected CloudStream extension repositories.

[![Decode and publish](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml/badge.svg)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml)

## About

**NepaliStream CNC Repo** tracks published `.cs3` build artifacts from two public upstream build branches, preserves their manifests and resources, and generates JADX source approximations plus Kotlin metadata indexes. The repository is maintained by **Diwas Khatri**.

### Developer credits

- **Project maintainer:** Diwas Khatri
- **CNCVerse upstream:** [NivinCNC/CNCVerse-Cloud-Stream-Extension](https://github.com/NivinCNC/CNCVerse-Cloud-Stream-Extension/tree/builds)
- **Phisher98 upstream:** [phisher98/cloudstream-extensions-phisher](https://github.com/phisher98/cloudstream-extensions-phisher/tree/builds)
- **Decompiler:** [JADX](https://github.com/skylot/jadx)

Upstream authors and provider authors remain credited in their original metadata. This repository does not claim ownership of upstream code, trademarks, provider implementations, or third-party assets.

## What is included

| Directory | Purpose |
|---|---|
| `sources/cncverse/` | Current `.cs3` files from the CNCVerse `builds` branch |
| `sources/phisher98/` | Current `.cs3` files from the Phisher98 `builds` branch |
| `decoded/<source>/<plugin>/sources/` | JADX-generated Java approximation of each `classes.dex` payload |
| `kotlin/<source>/<plugin>/PluginMetadata.kt` | Valid Kotlin metadata index for each decoded plugin |
| `manifests/` | Embedded plugin manifests extracted from `.cs3` files |
| `resources/` | Extracted layouts and drawable resources where present |
| `decoded-index.json` | SHA-256 and size index for all tracked `.cs3` files |
| `scripts/` | Source synchronization and decoding scripts |
| `.github/workflows/decode-and-publish.yml` | Automatic update workflow |

## Automation workflow

The GitHub Actions workflow runs **hourly** and can also be started manually from the **Actions** tab. Each run:

1. Clones the current `builds` branch from both upstream repositories.
2. Copies newly published or changed `.cs3` files into `sources/`.
3. Extracts manifests and resources.
4. Decompiles each `classes.dex` payload with JADX.
5. Generates a Kotlin `PluginMetadata.kt` file for every plugin.
6. Computes the source SHA-256 index.
7. Commits and pushes only when upstream content changed.

The upstream repositories do not provide a guaranteed cross-repository webhook to this repository, so the hourly schedule is the reliable automatic detector. Use **Actions → Update and decode CloudStream builds → Run workflow** for an immediate refresh after an upstream publication.

## Access and local use

Clone the repository:

```bash
git clone https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo.git
cd NepaliStream-CNC-Repo
```

Run the same process locally after installing Python, Git, and JADX:

```bash
python3 scripts/update_sources.py
python3 scripts/decode_sources.py
```

Open a provider’s Kotlin metadata at a path such as:

```text
kotlin/phisher98/AllMovieLandProvider/PluginMetadata.kt
```

## Important Kotlin note

A `.cs3` file is a ZIP container containing compiled Android DEX bytecode. It does not contain the original `.kt` source. Therefore, the Kotlin files generated here are **valid metadata/index files**, not claimed exact restorations of the original provider implementations. JADX output is included as a behavior reference because a reliable source-level Kotlin reconstruction requires manual porting into the correct CloudStream SDK project and compilation/testing against its dependencies.

## Repository tags

`cloudstream`, `cs3`, `kotlin`, `jadx`, `decompiler`, `streaming`, `anime`, `movies`, `tv-series`, `nepalistream`, `cnc-repo`, `automated-builds`, `developer-tools`

## License and attribution

No common license for the upstream build artifacts was inferred automatically. Review the upstream repositories and each provider’s license/author information before redistribution or production use. This repository is an attribution-focused mirror/inspection project and should not be treated as permission to redistribute third-party code or media assets.
