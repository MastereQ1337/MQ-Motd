package net.mastereq.utils;

import org.bukkit.entity.Player;

public class ChatUtil {
	public static String fixColor(final String t) {
		return t.replace("&", "§");

	}
	public static Boolean sendMessage(final Player p, final String m) {
		p.sendMessage(fixColor(m));
		return false;

	}
}