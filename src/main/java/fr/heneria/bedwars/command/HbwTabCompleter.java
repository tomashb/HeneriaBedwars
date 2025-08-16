package fr.heneria.bedwars.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class HbwTabCompleter implements TabCompleter {
    private static final List<String> SUBS = Arrays.asList("version", "reload", "help");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (args.length == 1) {
            List<String> out = new ArrayList<>();
            for (String s : SUBS) {
                if (s.regionMatches(true, 0, args[0], 0, args[0].length())) {
                    out.add(s);
                }
            }
            Collections.sort(out);
            return out;
        }
        return Collections.emptyList();
    }
}
