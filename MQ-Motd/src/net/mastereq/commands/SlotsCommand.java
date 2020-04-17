package net.mastereq.commands;

import net.mastereq.configuration.Config;
import net.mastereq.utils.ChatUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SlotsCommand implements CommandExecutor {


	@Override
	public boolean onCommand(CommandSender cs, Command cmd, String label, String[] args) {
		Player p = (Player) cs;

		if (!p.hasPermission(Config.Permission)) {
			return ChatUtil.sendMessage(p, Config.NotPermission);
		}
		if (args.length != 1) {
			return ChatUtil.sendMessage(p, Config.UsageSLOTS);
		}
		if (!ChatUtil.parseInt(args[0])) {
			return ChatUtil.sendMessage(p, Config.IntegerError.replace("{ARG}", args[0]));
		}

		int slots = Integer.parseInt(args[0]);

		Config.Slots = slots;
		Config.saveConfig();

		p.sendMessage(ChatUtil.fixColor(Config.SlotsChanged).replace("{SLOTS}", args[0]));
		return true;

	}
}