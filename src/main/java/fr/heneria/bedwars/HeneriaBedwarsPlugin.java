package fr.heneria.bedwars;

import fr.heneria.bedwars.command.HbwCommand;
import fr.heneria.bedwars.command.HbwTabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeneriaBedwarsPlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        saveDefaultConfig();
        getLogger().info(() -> "HeneriaBedwars v" + getDescription().getVersion() + " activé.");
        if (getCommand("hbw") != null) {
            getCommand("hbw").setExecutor(new HbwCommand(this));
            getCommand("hbw").setTabCompleter(new HbwTabCompleter());
        } else {
            getLogger().severe("Commande /hbw non enregistrée (vérifier plugin.yml).");
        }
    }

    @Override
    public void onDisable() {
        getLogger().info("HeneriaBedwars désactivé.");
    }
}
