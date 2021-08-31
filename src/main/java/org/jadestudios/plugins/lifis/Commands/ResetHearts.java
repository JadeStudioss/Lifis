package org.jadestudios.plugins.lifis.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jadestudios.plugins.lifis.Utils;

public class ResetHearts implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (!player.hasPermission("lifis.reset")) {
                return true;
            }
            if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target == null) {
                    player.sendMessage("&cInvalid Player");
                    return true;
                }

                Utils utils = new Utils();
                Double ddouble = utils.getHealth(player);
                Double startingNumber = -10.0;
                while (startingNumber < 11.0) {
                    if (startingNumber + ddouble == 20.0) {
                        utils.modifyHealth(player, startingNumber);
                        startingNumber = 11.0;
                        player.sendMessage(ChatColor.RED + "Reset.");
                        return true;
                    }
                    startingNumber = startingNumber + 2.0;
                }

                return true;
            }
        }
        return false;
    }
}
