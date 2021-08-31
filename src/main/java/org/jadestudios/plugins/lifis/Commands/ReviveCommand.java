package org.jadestudios.plugins.lifis.Commands;

import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ReviveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (player.getInventory().getItemInMainHand().getType() == Material.AIR) {
                player.sendMessage("Please hold the Extra Heart item to revive somebody.");
                return true;
            }
            if (args.length == 1) {
                if (player.getInventory().getItemInMainHand().getItemMeta().getDisplayName().equals(ChatColor.RED + "" + ChatColor.BOLD + "EXTRA HEART")) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (!(target == null)) {
                        if (target.getGameMode() == GameMode.SPECTATOR) {
                            target.setGameMode(GameMode.SURVIVAL);
                            target.teleport(player);
                            player.getInventory().getItemInMainHand().setAmount(player.getInventory().getItemInMainHand().getAmount() - 1);
                            target.playSound(target.getLocation(), Sound.BLOCK_ENCHANTMENT_TABLE_USE, 1f, 1f);
                            player.sendMessage(ChatColor.GREEN + "Revived.");
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
