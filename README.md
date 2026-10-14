# TJM — The Journey Matters

TJM is a Fabric mod for Minecraft that adds a collection of custom advancements
for the unexpected moments and milestones along your journey.

## Progress

The current advancement collection includes:

- **The Roof Is Lava** — stand on the Nether roof.
- **The First of Its Kind** — have your tamed wolf kill a mob in the Nether.
- **The Grocer** — trade with a villager of every profession.

The project is under active development. These advancements are implemented;
more are planned.

## Roadmap

Ideas for future development include:

- Add more advancements for memorable exploration and gameplay milestones.
- Continue improving advancement descriptions and translations.
- Test and polish the experience across supported multiplayer setups.

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
