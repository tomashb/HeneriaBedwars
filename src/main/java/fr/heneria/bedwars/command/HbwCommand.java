package fr.heneria.bedwars.command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.Plugin;

public class HbwCommand implements CommandExecutor {
    private final Plugin plugin;

    public HbwCommand(Plugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0 || "version".equalsIgnoreCase(args[0])) {
            sender.sendMessage(ChatColor.AQUA + "HeneriaBedwars v" + plugin.getDescription().getVersion());
            return true;
        }
        if ("reload".equalsIgnoreCase(args[0])) {
            if (!sender.hasPermission("heneria.admin")) {
                sender.sendMessage(ChatColor.RED + "Permission manquante: heneria.admin");
                return true;
            }
            plugin.reloadConfig();
            sender.sendMessage(ChatColor.GREEN + "Configuration rechargée.");
            return true;
        }
        if ("help".equalsIgnoreCase(args[0])) {
            sender.sendMessage(ChatColor.YELLOW + "/hbw version" + ChatColor.GRAY + " - Affiche la version");
            sender.sendMessage(ChatColor.YELLOW + "/hbw reload" + ChatColor.GRAY + " - Recharge la config");
            return true;
        }
        sender.sendMessage(ChatColor.RED + "Sous-commande inconnue. Essayez /hbw help");
        return true;
    }
}
