package org.jadestudios.plugins.lifis.Events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jadestudios.plugins.lifis.Utils;

import java.util.Objects;
import java.util.function.Supplier;

public class LifisExtraHeartHandler implements Listener {

    @EventHandler (priority = EventPriority.HIGH)
    public void extraHeartHandler(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if (!(event.getAction() == Action.RIGHT_CLICK_AIR)) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
            return;
        }

        if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "EXTRA HEART")) {
            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
            Utils utils = new Utils();
            utils.modifyHealth(player, 2.0);
            player.sendMessage(ChatColor.GREEN + "You gained one heart!");
            return;
        }
    }
}
