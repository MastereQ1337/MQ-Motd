package net.mastereq.listeners;


import net.mastereq.configuration.Config;
import net.mastereq.utils.ChatUtil;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerListPingEvent;


public class ServerListPingListener implements Listener {

    @EventHandler
    public void onPlayerPing(ServerListPingEvent event) {

        event.setMotd(ChatUtil.fixColor((Config.get().getString("firstLine"))) + "\n" + ChatUtil.fixColor((Config.get().getString("secondLine"))));
    }
}


  

