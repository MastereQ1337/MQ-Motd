package net.mastereq.commands;

import net.mastereq.configuration.Config;
import net.mastereq.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MotdCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {

        Player p = (Player) cs;

        if (!p.hasPermission(Config.Permission)) {
            return ChatUtil.sendMessage(p, Config.NotPermission);
        }
        if (args.length == 0) {
            return ChatUtil.sendMessage(p, Config.UsageMOTD);
        }

        switch (args[0]) {

            case "info": {
                ChatUtil.sendMessage(p, "");
                ChatUtil.sendMessage(p, "&71: &f" + Config.Linia_1);
                ChatUtil.sendMessage(p, "&72: &f" + Config.Linia_2);
                ChatUtil.sendMessage(p, "");
                return true;
            }

            case "set": {
                if (args.length == 1) {
                    ChatUtil.sendMessage(p, Config.UsageMOTD);
                    return true;
                }

                if (args[1].equalsIgnoreCase("1")) {
                    String out = "";
                    for (int i = 2; i < args.length; ++i) out += args[i] + " ";
                    final String message = out;
                    Config.Linia_1 = message;
                    Config.saveConfig();
                    return ChatUtil.sendMessage(p, Config.MotdChanged);

                }

                if (args[1].equalsIgnoreCase("2")) {
                    String out = "";
                    for (int i = 2; i < args.length; ++i) out += args[i] + " ";
                    final String message = out;
                    Config.Linia_2 = message;
                    Config.saveConfig();
                    return ChatUtil.sendMessage(p, Config.MotdChanged);
                }

                if (!ChatUtil.parseInt(args[1])) {
                    return ChatUtil.sendMessage(p, Config.IntegerError.replace("{ARG}", args[1]));

                }
            }
        }
        return true;
    }
}