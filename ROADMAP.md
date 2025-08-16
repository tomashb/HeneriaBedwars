# HeneriaBedwars — Roadmap (Étape 1)

## Vision (contexte rapide)
Créer un Bedwars performant et stable, 100% Spigot, sans dépendances dures, avec un socle code propre et testable.

## Étape 1 — Bootstrap & Fondation (cette livraison)
Objectif : livrer un dépôt exploitable **prod** avec CI et squelette plugin, prêt pour itérations gameplay.
- **AJOUT (Ticket #002) — Qualité & Gouvernance**
  - Checkstyle + JaCoCo intégrés au build.
  - CI renforcée (cache, rapports, artefacts) et garde-fou anti-wrapper Gradle.
  - Templates Issues/PR, CODEOWNERS, SECURITY.md.
  - Dependabot (actions + gradle).
  - Release Drafter pour notes de version auto.

### 1. Build & Toolchain
- Java 21 (toolchain).
- Gradle ≥ 8.9 **sans wrapper** (installé localement / provisionné par CI).
- Dépendance compileOnly : `org.spigotmc:spigot-api:1.21-R0.1-SNAPSHOT` (repo snapshots).
- Tests JUnit5 (base).

### 2. Structure de projet
```

src/main/java/fr/heneria/bedwars/...
src/main/resources/
.github/workflows/ci.yml
README.md, CHANGELOG.md, ROADMAP.md
settings.gradle.kts, build.gradle.kts

```
Conventions : packages `fr.heneria.bedwars.*`, UTF-8, logs simples, zéro allocation au tick.

### 3. Plugin minimal
- Classe main `HeneriaBedwarsPlugin`.
- Commande `/hbw <version|reload|help>` + tab-complete.
- `plugin.yml` (api-version: "1.21"), `config.yml`, `messages.yml`.

### 4. CI GitHub Actions (sans wrapper)
- `actions/setup-java@v4` (Temurin 21, cache Gradle).
- `gradle/actions/setup-gradle@v3` (Gradle 8.9).
- Vérification absence wrapper.
- Build + upload artefact jar.

### 5. Perf/Sécu/Qualité
- **Perf** : aucune tâche longue sur main thread; recommandation serveur `sync-chunk-writes=false`.
- **Sécu** : permissions `heneria.admin` pour `/hbw reload`.
- **Qualité** : messages externalisés, logs clairs, NPE évités (null-check commandes).

### 6. Livrables Étape 1
- Code & ressources listés ci-dessus.
- CI fonctionnelle avec artefact.
- Docs complètes (README, CHANGELOG, cette ROADMAP).

### 7. Critères d’acceptation Étape 1
- `gradle build` OK local/CI (Java 21).
- Plugin charge sur Spigot 1.21 sans erreur (log “activé”).
- `/hbw version` & `/hbw reload` opérationnels.
- Aucun fichier wrapper Gradle dans le repo.
