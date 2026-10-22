# Contributing

1. Install JDK 25 and an IDE (see the [Fabric docs](https://docs.fabricmc.net/develop/getting-started/creating-a-project#setting-up)).
2. Clone the repo.
3. `./gradlew build` – build the mod (jar in `build/libs`).
4. `./gradlew runClient` – start a dev client.
5. `./gradlew javadoc` – generate API docs.

## Docs
Wiki pages live in `docs/` in the main repo and are built with MkDocs. Edit them via pull request; the `Deploy wiki` workflow publishes them to GitHub Pages on merge to `master`.
