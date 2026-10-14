# Contributing

1. Install JDK 25 and an IDE (see the [Fabric docs](https://docs.fabricmc.net/develop/getting-started/creating-a-project#setting-up)).
2. Clone the repo.
3. `./gradlew build` – build the mod (jar in `build/libs`).
4. `./gradlew runClient` – start a dev client.
5. `./gradlew javadoc` – generate API docs.

## Docs
Wiki pages live in `docs/wiki/` in the main repo. Edit them via pull request; the `Wiki sync` workflow publishes them to the GitHub Wiki on merge to `main`. Do not edit the wiki directly, as changes will be overwritten.
