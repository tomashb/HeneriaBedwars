# Changelog

## [0.0.1] - 2025-08-16
### Ajouté
- Gradle (Kotlin DSL) **sans wrapper**, Java toolchain 21.
- CI GitHub Actions (compile/tests, **no JAR** + vérification).
- Squelette plugin: main, `plugin.yml`, `config.yml`, `messages.yml`.
- **Commande `/hbw`**: `version`, `reload` + tab-complete.
- Normalisation: `.editorconfig`, `.gitattributes`, `.gitignore`.
- Docs: README, ROADMAP (Étape 1 verrouillée).

### Corrigé
- CI: échec `:test` sous **Gradle 9** (« Failed to load JUnit Platform ») → ajout de `testRuntimeOnly("org.junit.platform:junit-platform-launcher")` conformément à la documentation Gradle 9.

