package net.mastereq.configuration;

import java.lang.reflect.Field;

import net.mastereq.Main;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;


public class Config {
	public static String Permission = "motd.*";
	public static String Linia_1 = "&8>> &cMQ-Motd";
	public static String Linia_2 = "&8>> &ePlugin zostal zaladowany!";
	public static int Slots = 100;
	public static String UsageMOTD = "&8>> &7Poprawne uzycie: &a/motd (set/info) {1/2} [text]";
	public static String UsageSLOTS = "&8>> &7Poprawne uzycie: &a/slots (Ilosc)";
	public static String NotPermission = "&8>> &cNie masz permisji! &8(&6motd.*&8)";
	public static String MotdChanged = "&8>> &aPomyslnie zmieniles opis serwera!";
	public static String SlotsChanged = "&8>> &aZmieniles liczbe slotow na: &f{SLOTS}";
    public static String IntegerError = "&8>> &cArgument &e{ARG} &cnie jest liczba!";

    public Config() {
    }

    public static void loadConfig() {
        try {
            Main.getPlugin().saveDefaultConfig();
            FileConfiguration c = Main.getPlugin().getConfig();
            Field[] fields;
            int length = (fields = Config.class.getFields()).length;

            for(int i = 0; i < length; ++i) {
                Field f = fields[i];
                if (c.isSet("config." + f.getName().toLowerCase().replace("_", "."))) {
                    f.set((Object)null, c.get("config." + f.getName().toLowerCase().replace("_", ".")));
                }
            }
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public static void saveConfig() {
        try {
            FileConfiguration c = Main.getPlugin().getConfig();
            Field[] fields;
            int length = (fields = Config.class.getFields()).length;

            for(int i = 0; i < length; ++i) {
                Field f = fields[i];
                c.set("config." + f.getName().toLowerCase().replace("_", "."), f.get((Object)null));
            }

            Main.getPlugin().saveConfig();
        } catch (Exception var5) {
            var5.printStackTrace();
        }
    }

    public static void setLocation(Location loc) {
        Main.getPlugin().reloadConfig();
        loadConfig();
        saveConfig();
    }

    public static void reloadConfig() {
        Main.getPlugin().reloadConfig();
        loadConfig();
        saveConfig();

    }
}