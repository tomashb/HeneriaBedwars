# HeneriaBedwars (Spigot 1.21) — Étape 1

Base “prod” du plugin Bedwars maison (Java 21, Spigot 1.21).

## Build local (sans wrapper)
- Prérequis : Java 21 + Gradle ≥ 8.9 installé.
- Commande : `gradle build`
- Jar : `build/libs/HeneriaBedwars-0.0.1.jar`

## Installation
1) Serveur **Spigot 1.21** (Java 21).
2) Déposer le JAR dans `plugins/`.
3) Démarrer, vérifier les logs.
4) Test : `/hbw version`, `/hbw reload`.

## Commandes
- `/hbw version` — affiche la version.
- `/hbw reload` — recharge `config.yml`.

## Permissions
- `heneria.use` (true par défaut)
- `heneria.admin` (op)

## Performances (Spigot)
Mettre `sync-chunk-writes=false` dans `server.properties` (I/O chunks off-thread). *(Recommandation Étape 1)*

## Roadmap
Voir [ROADMAP.md](./ROADMAP.md).

## Licence
MIT
