package net.mastereq.listeners;


import net.mastereq.configuration.Config;
import net.mastereq.utils.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;


public class ServerListPingListener implements Listener
{
  @EventHandler
  public void onPlayerPing(ServerListPingEvent event) {

	  event.setMotd(String.valueOf(ChatUtil.fixColor((Config.Linia_1))) + "\n" + ChatUtil.fixColor((Config.Linia_2)));
	  event.setMaxPlayers(Config.Slots);
  }
}


  

