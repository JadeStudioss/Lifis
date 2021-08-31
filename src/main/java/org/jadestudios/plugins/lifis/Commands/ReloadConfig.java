package org.jadestudios.plugins.lifis.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jadestudios.plugins.lifis.Lifis;

public class ReloadConfig implements CommandExecutor {

    Lifis plugin;

    public ReloadConfig(Lifis plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if(!player.hasPermission("lifis.reloadconfig")) {
                player.sendMessage(ChatColor.RED + "No permissions");
                return true;
            }

            plugin.reloadConfig();
            player.sendMessage(ChatColor.GREEN + "Reloaded config.");
            return true;

        }
        return false;
    }
}
