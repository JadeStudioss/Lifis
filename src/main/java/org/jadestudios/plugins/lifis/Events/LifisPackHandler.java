package org.jadestudios.plugins.lifis.Events;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerResourcePackStatusEvent;
import org.jadestudios.plugins.lifis.Lifis;

public class LifisPackHandler implements Listener {

    String url = "https://drive.google.com/uc?export=download&id=1p8bnHVILQEa7A9QBQJnKM1XJJymMcCoq";
    Lifis plugin;

    public LifisPackHandler(Lifis plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onJoinEvent(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        player.setResourcePack(url);
    }


}
