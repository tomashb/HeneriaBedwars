package gg.heneria.bedwars;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.event.Listener;
import org.bukkit.Bukkit;

public final class HeneriaBedwarsPlugin extends JavaPlugin implements Listener {

  @Override
  public void onEnable() {
    getLogger().info(() -> "[HeneriaBedwars] v" + getDescription().getVersion() + " enable");
    Bukkit.getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {
    getLogger().info("[HeneriaBedwars] disable");
  }
}
