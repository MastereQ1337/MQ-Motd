package net.mastereq.commands;

import net.mastereq.configuration.Config;
import net.mastereq.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class MotdCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!sender.hasPermission(Config.get().getString("permission"))) {
            sender.sendMessage(ChatUtil.fixColor(Config.get().getString("commandNotPermission")));
            return true;
        }
        if (args.length <= 0) {
            sender.sendMessage(ChatUtil.fixColor(Config.get().getString("commandUsage")));
            return true;
        }

        switch (args[0]) {
            case "reload":
                Config.reload();
                sender.sendMessage(ChatUtil.fixColor(Config.get().getString("commandReloadedConfiguration")));
                break;
            default:
                sender.sendMessage(ChatUtil.fixColor(Config.get().getString("commandUsage")));

        }
        return true;
    }
}