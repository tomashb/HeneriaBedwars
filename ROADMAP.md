# ROADMAP — HeneriaBedwars

## Étape 1 — Bootstrapping (v0.0.1) — **FOCUS**
- [x] Reset repo / base Gradle **sans wrapper**
- [x] Java toolchain 21 / Spigot API 1.21 snapshot
- [x] CI compile-only + **assert no JAR**
- [x] Classe Main + **commande `/hbw` (version/reload)** + tab-complete
- [x] `plugin.yml`, `config.yml`, `messages.yml` robustes
- [x] `.editorconfig`, `.gitattributes`, `.gitignore`
- [x] README/CHANGELOG/ROADMAP à jour
- [x] Tests unitaires de base

> Réfs: Java 21 requis 1.21 ; Spigot snapshots 1.21. :contentReference[oaicite:5]{index=5}

## Étape 2 — Core moteur (multi-arènes)
- États: `LOBBY → STARTING → PLAYING → ENDING → RESET → IDLE`
- Services: `ArenaRegistry`, `GameService`, `TeamService`, etc.
- GUI lobby/équipes, countdown, TP, safe-guards.

*(Les étapes suivantes restent inchangées, seront détaillées au fur et à mesure.)*

