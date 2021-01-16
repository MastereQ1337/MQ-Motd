package net.mastereq;

import net.mastereq.commands.MotdCommand;
import net.mastereq.configuration.Config;
import net.mastereq.listeners.ServerListPingListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Main plugin;

	public void onEnable() {

		getConfig().options().copyDefaults();
		saveDefaultConfig();

		Config.setup();
		Config.get().addDefault("permission", "motd.command");
		Config.get().addDefault("firstLine", "&aMQ-Motd &c1.1");
		Config.get().addDefault("secondLine", "&ePlugin zostal zaladowany! Zajrzyj do: &fconfig.yml");
		Config.get().addDefault("commandUsage", "&cPoprawne uzycie: &e/motd reload");
		Config.get().addDefault("commandNotPermission", "&4&lBlad! &cNie masz uprawnien!");
		Config.get().addDefault("commandReloadedConfiguration", "&2&lMQ-Motd &8| &aPrzeladowano plik konfiguracyjny &fconfig.yml&a!");
		Config.get().options().copyDefaults(true);
		Config.save();

		Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN + "Plugin zostal pomyslnie zaladowany!");
		Bukkit.getConsoleSender().sendMessage("Created by: MastereQ & sadcenter");

		Bukkit.getServer().getPluginManager().registerEvents(new ServerListPingListener(), this);
		getCommand("motd").setExecutor(new MotdCommand());

	}

	public void onLoad() {
		plugin = this;
	}

}
