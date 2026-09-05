# NepaliStream CNC Repo

> Mixed root-level CloudStream `.cs3` build archive with automatic decoding and GitHub Actions publishing.

[![Auto Decode and Push Builds](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml/badge.svg)](https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo/actions/workflows/decode-and-publish.yml)

## Developer credits

**Maintainer:** Diwas Khatri

**Upstream sources:**

- [NivinCNC/CNCVerse-Cloud-Stream-Extension — builds](https://github.com/NivinCNC/CNCVerse-Cloud-Stream-Extension/tree/builds)
- [phisher98/cloudstream-extensions-phisher — builds](https://github.com/phisher98/cloudstream-extensions-phisher/tree/builds)

**Decoder:** [JADX](https://github.com/skylot/jadx)

## Flat repository layout

All provider archives are mixed into the **repository root**. There is no `decoded/cncverse` or `decoded/phisher98` nesting.

| Path | Purpose |
|---|---|
| `CNCVerse__*.cs3` | CNCVerse build archives at root |
| `Phisher98__*.cs3` | Phisher98 build archives at root |
| `java/` | Decompiled source layers, separated only by provider filename to avoid collisions |
| `kotlin/` | Generated Kotlin `PluginMetadata.kt` files |
| `manifests/` | Extracted embedded manifests |
| `resources/` | Extracted layouts and drawables |
| `decoder.py` | Easy root-level decoder entry point |
| `auto-pusher.py` | Easy root-level upstream updater entry point |
| `scripts/` | Full implementation scripts |
| `.github/workflows/decode-and-publish.yml` | Automatic decode and push workflow |
| `decoded-index.json` | SHA-256 and size index for every root archive |

Duplicate provider names are retained safely with upstream prefixes, for example `CNCVerse__AniKoto.cs3` and `Phisher98__AniKoto.cs3`.

## Automation

The visible workflow is [`Auto Decode and Push Builds`](.github/workflows/decode-and-publish.yml). It runs hourly and can be started manually from the repository’s **Actions** tab.

Every run:

1. Pulls both public `builds` branches.
2. Places all current `.cs3` files in the repository root.
3. Extracts manifests and resources.
4. Runs JADX on every `classes.dex` payload.
5. Generates a Kotlin metadata file for every plugin.
6. Commits and pushes changes automatically.

The source repositories do not provide a guaranteed webhook to this repository, so the hourly schedule detects new uploads. For an immediate update, open [Actions](../../actions), choose **Auto Decode and Push Builds**, and click **Run workflow**.

## Run locally

```bash
git clone https://github.com/DiwasKhatri07/NepaliStream-CNC-Repo.git
cd NepaliStream-CNC-Repo
python3 auto-pusher.py
PATH=/path/to/jadx/bin:$PATH python3 decoder.py
```

## Kotlin limitation

A `.cs3` file contains compiled Android DEX bytecode, not the original Kotlin source. The generated files under `kotlin/` are valid Kotlin metadata/index files; they are not exact recovered provider implementations. The `java/` directory is retained as the decompiler behavior reference. Building a complete Kotlin provider requires manual porting into the correct CloudStream SDK project and compilation/testing against its dependencies.

## Attribution and licensing

Upstream authors and provider authors remain credited in their original manifests. This repository does not claim ownership of upstream code, trademarks, or third-party assets. Review upstream licensing and author permissions before redistribution or production use.

## Tags

`cloudstream` `cs3` `kotlin` `jadx` `decompiler` `nepalistream` `cnc-repo` `github-actions` `automated-builds` `streaming` `anime` `movies` `tv-series`
