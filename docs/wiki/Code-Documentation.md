# Code Documentation

Package root: `astro.tjm` (mod id `tjm`). Entrypoints are declared in `fabric.mod.json`.

## Classes
| Class | Role |
|---|---|
| `TheJourneyMatters` | Main entrypoint (`ModInitializer`). Registers an end-of-level-tick listener (Nether roof check) and an after-death listener (wolf kill check). `award(...)` grants a criterion of an `adventure/*` advancement. |
| `TheJourneyMattersModMenu` | Mod Menu entrypoint; returns the config screen factory. |
| `config.TheJourneyMattersConfig` | Config values: `maxBuildHeight`, `disallowedNetherBlocks`. |
| `config.TheJourneyMattersConfigManager` | Loads and saves the config as JSON (Gson) in the Fabric config dir. `getConfig()` lazy-loads. |
| `config.TheJourneyMattersConfigScreen` | Builds the YACL config screen. |
| `mixin.TJMMixin` | Mixin on `BlockItem#place`, cancelling placement in the Nether for the height limit and disallowed blocks. Registered in `overworldinfrastructure.mixins.json`. |

## Resources
- `data/tjm/advancement/root.json` and `adventure/*.json` – advancements.
- `assets/tjm/lang/en_us.json`, `de_de.json` – translations (advancement titles, config labels, messages).
- `assets/tjm/textures/gui/advancements/journey.png` – tab background.

## How to add an advancement
1. Create `data/tjm/advancement/adventure/<name>.json` with `"parent": "tjm:root"`.
2. Add `advancements.tjm.<name>.title` / `.description` to every lang file.
3. Data driven: use a vanilla trigger (see `the_grocer.json`).
   Code driven: use the `minecraft:impossible` trigger and call `award(player, world, "<name>", "<criterion>")` from an event in `TheJourneyMatters`.

## Build
`./gradlew build` (JDK 25). See [[Contributing]].
