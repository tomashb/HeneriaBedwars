package gg.heneria.bedwars.command;

import gg.heneria.bedwars.HeneriaBedwarsPlugin;
import gg.heneria.bedwars.i18n.Messages;
import gg.heneria.bedwars.util.Colors;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class HbwCommand implements CommandExecutor, TabCompleter {

  private final HeneriaBedwarsPlugin plugin;
  private final Messages messages;

  public HbwCommand(HeneriaBedwarsPlugin plugin, Messages messages) {
    this.plugin = plugin;
    this.messages = messages;
  }

  @Override
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
    if (args.length == 0) {
      sender.sendMessage(Colors.translate("&7Usage: /" + label + " <version|reload>"));
      return true;
    }
    switch (args[0].toLowerCase()) {
      case "version" -> {
        if (!sender.hasPermission("heneria.use")) {
          sender.sendMessage(Colors.translate("&cVous n'avez pas la permission."));
          return true;
        }
        String ver = plugin.getDescription().getVersion();
        sender.sendMessage(Colors.translate(messages.prefixed("version")
          .replace("{version}", ver)));
        return true;
      }
      case "reload" -> {
        if (!sender.hasPermission("heneria.admin")) {
          sender.sendMessage(Colors.translate("&cVous n'avez pas la permission."));
          return true;
        }
        boolean ok = plugin.reloadAll();
        sender.sendMessage(Colors.translate(ok ? messages.prefixed("reloaded-ok") :
                                              messages.prefixed("reloaded-fail")));
        return true;
      }
      default -> {
        sender.sendMessage(Colors.translate("&7Usage: /" + label + " <version|reload>"));
        return true;
      }
    }
  }

  @Override
  public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
    if (args.length == 1) {
      List<String> base = Arrays.asList("version", "reload");
      List<String> out = new ArrayList<>();
      String cur = args[0].toLowerCase();
      for (String s : base) if (s.startsWith(cur)) out.add(s);
      return out;
    }
    return List.of();
  }
}

