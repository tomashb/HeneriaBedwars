# HeneriaBedwars (v0.0.1) — Étape 1

Plugin BedWars pour **Spigot 1.21** / **Java 21**.  
> 1.21 requiert **Java 21+** ; dépendance `spigot-api:1.21-R0.1-SNAPSHOT`. :contentReference[oaicite:3]{index=3}

## Build local (sans wrapper, compile-only)
1. Installer **Java 21** (JDK).
2. Installer **Gradle 9** sur le poste.
3. Lancer:
   ```bash
   gradle compileJava test
   ```

> ⚠️ Le **CI ne produit pas de JAR** et les tâches `jar/assemble` sont désactivées. Vous ne devez **pas** publier de `.jar` via ce dépôt.

## Tests (Gradle 9)
Gradle 9 **nécessite** le `junit-platform-launcher` sur le runtime des tests. Déjà déclaré dans `build.gradle.kts` via :
```kotlin
testRuntimeOnly("org.junit.platform:junit-platform-launcher")
```
Réf. doc Gradle 9 (Testing / JUnit 5). ([docs.gradle.org][1])

## Commandes

* `/hbw version` — affiche la version.
* `/hbw reload` — recharge `config.yml` + `messages.yml`. (perm: `heneria.admin`)

## Permissions

* `heneria.use` (par défaut: true)
* `heneria.admin` (par défaut: op)

## CI

GitHub Actions: Java 21 + Gradle (no wrapper), `compileJava test`, **assert no JAR**. ([GitHub][4], [GitHub Docs][5])

## Roadmap

Voir [ROADMAP.md](ROADMAP.md).

