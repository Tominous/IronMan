package com.spigotcodingacademy.ironman.cmds;

import com.spigotcodingacademy.ironman.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IronManCmds implements CommandExecutor{

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ironman")) {
            if (args.length == 0) {
                Chat.msg(
                        player,
                        Chat.prefix + "&7Commands found:",
                        "&8&l >> &7/ironman info",
                        "&8&l >> &7/ironman version",
                        "&8&l >> &7/ironman commands",
                        "&8&l >> &7/ironman reload"
                );
            }
        }

        return false;
    }
}
