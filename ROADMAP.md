# ROADMAP — HeneriaBedwars

> **Vision**: BedWars performant, modulaire, multi-arènes, reset rapide, UX inspirée d’Hypixel mais **améliorée** (équilibrages, anti-abus, features toggle-ables).

## Étape 1 (focus actuel) — Bootstrapping (v0.0.1)
- Reset repo, base Gradle **sans wrapper**, CI compile-only.
- Squelette plugin (main, YAML), docs et normes (EditorConfig, Git attrs).
- Définition des **États de partie** & des **services internes** (draft, docs):
  - États: `LOBBY → STARTING → PLAYING → ENDING → RESET → IDLE`.
  - Interfaces (draft): `ArenaRegistry`, `GameService`, `TeamService`, `ShopService`,
    `GeneratorService`, `ResetService`, `StatsService`, `SpectatorService`.
- Formats YAML (draft): `arena.yml` (coords, teams, spawns, generators), `shops/*.yml`, `kits.yml`.
- Stratégie CI: compilation Java 21, **pas d'artefacts**.

## Étape 2 — Core Moteur de Jeu (multi-arènes)
- Gestion arènes, lifecycle strict (tick-safe), tasks programmées, pool schedulers.
- Sélection d’équipe, lobby GUI, compte à rebours, téléportations, safe-guards.

## Étape 3 — Générateurs & Économie
- Générateurs (Fer/Or/Émeraude/Diamant) par temps/phases globales; réglages.
- Boutique PNJ/GUI configurable; monnaie par items; presets & balancement. *(Hypixel: upgrades programmés + events tardifs.)*

## Étape 4 — Lits, Mort/Réapparition & Fin de partie
- Gestion lit (break rules), respawn tant que lit actif; victoire; récapitulatif.

## Étape 5 — **Reset d’arène** performant
- **SlimeWorldManager**/schémas (option) + **fallback** vanilla (copie snapshot).
- Zéro fuite mémoire, nettoyage entités/inventaires/scoreboards.

## Étape 6 — Spectateurs, Scoreboards/ActionBar, BossBar
- Mode spectateur, invisibilité/anti-interactions; scoreboard dynamiques.

## Étape 7 — Classements & Stats (MySQL/SQLite)
- ELO/points, winstreak, leaderboard GUI; API publique.

## Étape 8 — Anti-abus & Qualité de Service
- Anti-spawnkill, limites de placements, cooldowns; hooks anti-cheat.

## Étape 9 — Réseau (Bungee/Velocity) & Auto-join
- Mode single-arena & auto-join compatibles proxy.

## Étape 10 — Packs d’items spéciaux & events
- Items spéciaux (fireball, ponts, pièges), events globaux (bed destroy, deathmatch).

### Références marché (pour cadrer les features)
- **Bedwars (Bukkit)**: reset map, setup, shop, spawners, scoreboard, Bungee, MySQL stats. :contentReference[oaicite:5]{index=5}
- **ScreamingBedWars**: 1.8.8→1.21.8, hautement configurable, Bungee/Velocity mode. :contentReference[oaicite:6]{index=6}
- **Hypixel BedWars**: générateurs à paliers, events (Beds Destroyed, Sudden Death). :contentReference[oaicite:7]{index=7}
