package net.mastereq.utils;

import java.util.Collection;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;

public class ChatUtil {
	public static String fixColor(final String t) {
		return t.replace("&", "§")
				.replace(">>", "»")
				.replace("<<", "«");
	}
	public static Boolean sendMessage(final Player p, final String m) {
		p.sendMessage(fixColor(m));
		return false;
	}

	public static boolean parseInt(String s) {
		try {
			Integer.parseInt(s);
			return true;
		} catch (NumberFormatException e) {
			return false;

		}
	}
}