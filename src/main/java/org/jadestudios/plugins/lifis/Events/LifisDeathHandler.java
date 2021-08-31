package org.jadestudios.plugins.lifis.Events;

import org.bukkit.*;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scheduler.BukkitRunnable;
import org.jadestudios.plugins.lifis.Utils;

public final class LifisDeathHandler implements Listener {

    @EventHandler (priority = EventPriority.HIGHEST)
    public void lifisDeathHandler(PlayerDeathEvent event) {
        Utils utils = new Utils();
        Player killed = event.getEntity();
        Player killer = killed.getKiller();
        if (killer == null) {
            return;
        }

        double killedHealth = utils.getHealth(killed);
        if (killedHealth <= 2.0f) {
            utils.modifyHealth(killer, 2.0);
            event.setDeathMessage(ChatColor.translateAlternateColorCodes('&', "&b" + killed.getName() + "&b's &ffinal heart was destroyed by &b" + killer.getName()));
            killed.setGameMode(GameMode.SPECTATOR);
            World world = killer.getWorld();
            Location location = killer.getLocation();
            world.createExplosion(location.getX(), location.getY(), location.getZ(), 0.0f, false, false);
            return;
        }

        utils.modifyHealth(killed, -2.0);
        utils.modifyHealth(killer, 2.0);
        killer.sendMessage(ChatColor.GREEN + "You gained one heart!");
        return;

    }
}
