package net.mastereq;

import net.mastereq.commands.MotdCommand;
import net.mastereq.commands.SlotsCommand;
import net.mastereq.configuration.Config;
import net.mastereq.listeners.ServerListPingListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main plugin;

	public void onEnable() {

		Config.reloadConfig();
		Bukkit.getConsoleSender().sendMessage("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
		Bukkit.getConsoleSender().sendMessage("                MQ-Motd              ");
		Bukkit.getConsoleSender().sendMessage(" -> Plugin zostal pomyslnie wlaczony!");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("             Developers:");
		Bukkit.getConsoleSender().sendMessage(" - MastereQ (Discord: MastereQ#0427)");
		Bukkit.getConsoleSender().sendMessage(" - sadcenter (Discord: sadcenter#2046)");
		Bukkit.getConsoleSender().sendMessage(" ");
		Bukkit.getConsoleSender().sendMessage("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");

		Bukkit.getServer().getPluginManager().registerEvents(new ServerListPingListener(), this);
		getCommand("motd").setExecutor(new MotdCommand());
		getCommand("slots").setExecutor(new SlotsCommand());

	}

	public static Main getPlugin(){
		return plugin;
	}

	public void onLoad() {
		plugin = this;
	}

}
