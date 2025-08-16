package gg.heneria.bedwars;

import gg.heneria.bedwars.command.HbwCommand;
import gg.heneria.bedwars.i18n.Messages;
import org.bukkit.Bukkit;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeneriaBedwarsPlugin extends JavaPlugin {

  private static HeneriaBedwarsPlugin instance;
  private Messages messages;

  public static HeneriaBedwarsPlugin get() {
    return instance;
  }

  @Override
  public void onEnable() {
    instance = this;

    // Config par défaut
    saveDefaultConfig();

    // Messages
    this.messages = new Messages(this);
    this.messages.loadOrCreate();

    // Commande /hbw
    final HbwCommand cmd = new HbwCommand(this, messages);
    final PluginCommand pc = getCommand("hbw");
    if (pc != null) {
      pc.setExecutor(cmd);
      pc.setTabCompleter(cmd);
    } else {
      getLogger().severe("Commande 'hbw' introuvable (plugin.yml).");
    }

    getLogger().info(() -> "[HeneriaBedwars] v" + getDescription().getVersion() + " enabled on " + Bukkit.getName());
  }

  @Override
  public void onDisable() {
    getLogger().info("[HeneriaBedwars] disable");
  }

  public Messages messages() {
    return messages;
  }

  public boolean reloadAll() {
    try {
      reloadConfig();
      messages.reload();
      return true;
    } catch (Exception e) {
      getLogger().severe("Erreur lors du reload: " + e.getMessage());
      return false;
    }
  }
}

