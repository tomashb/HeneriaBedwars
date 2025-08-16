# HeneriaBedwars (v0.0.1)

Plugin BedWars pour **Spigot 1.21**. Ce dépôt est initialisé avec:
- Build **Gradle (sans wrapper)**, Java 21.
- **CI GitHub Actions**: compile & tests **sans produire de JAR**.
- **Squelette** plugin (plugin.yml, config.yml, messages.yml, classe Main minimale).
- **ROADMAP** (Étape 1 détaillée), **CHANGELOG**.

> Java 21 / 1.21 confirmés par écosystème Spigot/Paper; dépendances API via hub.spigotmc.org (snapshots 1.21). Voir références en fin de ROADMAP.

## Build local
1. Installer **Java 21** (JDK).
2. Installer **Gradle** (système) si absent.
3. `gradle --version` puis `gradle compileJava test` (pas de jar).

## CI
Voir `.github/workflows/ci.yml` (compile-only).

## Licence
MIT.
