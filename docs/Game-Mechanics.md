# Game Mechanics

## Journey advancement tab
The root advancement `tjm:root` ("The Journey Matters", bedrock icon) creates the **Journey** tab. It is granted automatically (tick trigger) with no toast or chat message. All other advancements are children of it.

## Advancements
| Advancement | ID | Icon | How to get it |
|---|---|---|---|
| The Roof Is Lava | `tjm:adventure/nether_roof` | Bedrock | Stand on the bedrock roof in the Nether (feet at Y >= 128, bedrock directly below). Checked every tick. |
| The First of Its Kind | `tjm:adventure/first_of_its_kind` | Bone | Have your tamed wolf kill a mob in the Nether. |
| The Grocer | `tjm:adventure/the_grocer` | Emerald | Trade with a villager of every profession (13 criteria, all required). |

All three use the "goal" frame and grant no rewards. `nether_roof` and `first_of_its_kind` use the `minecraft:impossible` trigger and are awarded from code (see [Code Documentation](Code-Documentation.md)). `the_grocer` is fully data driven.

Villager professions required: armorer, butcher, cartographer, cleric, farmer, fisherman, fletcher, leatherworker, librarian, mason, shepherd, toolsmith, weaponsmith.

## Nether rules
Both rules apply only when placing a block in the Nether.

- **Build height limit** – blocks cannot be placed at or above `maxBuildHeight` (default `127`). An overlay message "You can't place blocks over Y=127 in the Nether" is shown.
- **Disallowed blocks** – a list of block IDs that cannot be placed. Default: `minecraft:ice`, `minecraft:packed_ice`, `minecraft:frosted_ice`, `minecraft:blue_ice`.

## Configuration
Open via Mod Menu (needs YACL). Category **Nether**:

| Option | Default | Description |
|---|---|---|
| Nether build height | 127 | Maximum allowed build height in the Nether. |
| Disallowed blocks | ice variants | Blocks that cannot be placed in the Nether. |

The config file is `config/overworldinfrastructure.json`.
