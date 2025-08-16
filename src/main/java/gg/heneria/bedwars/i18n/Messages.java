package gg.heneria.bedwars.i18n;

import gg.heneria.bedwars.HeneriaBedwarsPlugin;
import gg.heneria.bedwars.util.Colors;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public final class Messages {
  private final HeneriaBedwarsPlugin plugin;
  private File file;
  private FileConfiguration cfg;

  public Messages(HeneriaBedwarsPlugin plugin) {
    this.plugin = plugin;
  }

  public void loadOrCreate() {
    file = new File(plugin.getDataFolder(), "messages.yml");
    if (!file.exists()) {
      plugin.saveResource("messages.yml", false);
    }
    reload();
  }

  public void reload() {
    cfg = new YamlConfiguration();
    try {
      cfg.load(file);
    } catch (IOException | InvalidConfigurationException e) {
      plugin.getLogger().severe("Impossible de charger messages.yml: " + e.getMessage());
    }
  }

  public String raw(String key) {
    return cfg.getString("messages." + key, "&cMessage manquant: " + key);
  }

  public String prefixed(String key) {
    String prefix = cfg.getString("prefix", "&7[&bHeneria&7] ");
    return Colors.translate(prefix + raw(key));
  }
}

