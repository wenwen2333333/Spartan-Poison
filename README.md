# Spartan Poison

A Spartan Weaponry addon for the Poison Dragons mod. Adds 24 types of Spartan weapons in two materials: Poisoned Dragon Bone and Poison Dragonsteel.

## Features

- 24 Spartan Weaponry weapon types in 2 materials (48 weapons total)
- Poisoned Dragon Bone weapons
- Poison Dragonsteel weapons
- Custom "Poisoned" weapon trait that applies poison on hit
- Configurable recipe integration with Spartan Fire and Ice and Fire
- Optional texture override for the Poison Dragonbone Sword

## Requirements

- Minecraft 1.20.1
- Forge 47.x

### Mandatory dependencies

- [Spartan Weaponry](https://www.curseforge.com/minecraft/mc-mods/spartan-weaponry)
- [Spartan Weaponry Addon Toolkit](https://www.curseforge.com/minecraft/mc-mods/spartan-weaponry-addon-toolkit)
- [Poison Dragons](https://www.curseforge.com/minecraft/mc-mods/poison-dragons-ice-fire-addon)

### Optional dependencies

- [Ice and Fire: Dragons](https://www.curseforge.com/minecraft/mc-mods/ice-and-fire-dragons) — enables Ice-and-Fire style recipe overrides
- [Spartan Weaponry: Ice and Fire](https://www.curseforge.com/minecraft/mc-mods/spartan-weaponry-ice-and-fire) — enables Spartan Fire style recipes

## Installation

1. Install Minecraft Forge 1.20.1 (47.x)
2. Install all mandatory dependencies
3. Drop the Spartan Poison JAR into your `mods` folder
4. Launch the game

## Configuration

The mod provides a config file at `config/spartan_poison-common.toml`:

| Option | Default | Description |
|---|---|---|
| `spartan_weapons.remove_default_recipe` | `true` | Remove default recipes when Spartan Fire is loaded |
| `spartan_weapons.add_spartanfire_recipe` | `true` | Add Spartan Fire-style recipes when Spartan Fire is loaded |
| `poison_dragons.remove_default_recipe` | `true` | Remove some Poison Dragons recipes when Ice and Fire is loaded |
| `poison_dragons.add_iceandfire_recipe` | `true` | Add Ice-and-Fire style recipes when Ice and Fire is loaded |
| `client.override_sword_texture` | `true` | Override the Poison Dragonbone Sword texture (requires restart or F3+T) |

## Credits

See [CREDITS.txt](CREDITS.txt).

## License

Licensed under the GNU General Public License v3.0.
See [LICENSE](LICENSE) for the full text.

