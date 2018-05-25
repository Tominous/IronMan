package com.spigotcodingacademy.ironman.cmds;

import com.spigotcodingacademy.ironman.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuitCmds implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        // /suit <Player> <SuitName>
        if (cmd.getName().equalsIgnoreCase("suit")) {
            if (!player.hasPermission("ironman.suit")) {
                Chat.msg(player, Chat.perm);
                return true;
            }

            if (args.length == 0) {
                Chat.msg(
                        player,
                        Chat.prefix + "&7Suit commands:",
                        "&8&l >> &7/suits",
                        "&8&l >> &7/suit <Player> <SuitName>",
                        "&8&l >> &7/suit list",
                        "&8&l >> &7/suit eject"
                );
                return true;
            }

            if (args[0].equalsIgnoreCase("list")) {
                Chat.msg(
                        player,
                        Chat.prefix + "&7Suit list:",
                        "&8&l >> &7Mark 1"
                );
            }
        }
        return false;
    }
}