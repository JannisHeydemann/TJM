# TJM — The Journey Matters

TJM is a Fabric mod focused on changing how players travel, starting with
configurable building rules in the Nether. Custom advancements are a smaller
part of the mod.

## Features

### Nether travel and building

- Configure the maximum height for placing blocks in the Nether.
- Prevent selected blocks from being placed in the Nether. Ice, packed ice,
  frosted ice, and blue ice are disallowed by default.

Both settings can be changed in the mod's configuration screen.

### Advancements

The mod also includes a small collection of custom advancements:

- **The Roof Is Lava** — stand on the Nether roof.
- **The First of Its Kind** — have your tamed wolf kill a mob in the Nether.
- **The Grocer** — trade with a villager of every profession.

## Progress and roadmap

The configurable Nether placement rules and current advancements are
implemented. The main focus is to continue developing travel-focused mechanics.
Potential future directions include:

- Add more ways to customize Nether travel and building rules.
- Explore additional gameplay features that change how players travel.
- Expand the advancement collection as a supporting feature.

Have an idea? [Open an issue](https://github.com/JannisHeydemann/TJM/issues) to
discuss it.

## Requirements

- Minecraft 26.3
- Fabric Loader 0.19.5 or newer
- Fabric API
- YetAnotherConfigLib (YACL)

Mod Menu is optional.

## Build from source

You need Java 25 and Git. Clone the repository and run the Gradle wrapper:

```sh
git clone https://github.com/JannisHeydemann/TJM.git
cd TJM
./gradlew build
```

On Windows, run `gradlew.bat build` instead. The built mod JAR is placed in
`build/libs/`.

## Contributing

Bug reports, suggestions, and pull requests are welcome. For larger changes,
please [open an issue](https://github.com/JannisHeydemann/TJM/issues) first so
we can discuss the approach. For a pull request, describe the change and verify
that `./gradlew build` succeeds.

## Author

**Jannis Heydemann** — [GitHub](https://github.com/JannisHeydemann)

## License

TJM is licensed under the [GNU General Public License v3.0](LICENSE).
