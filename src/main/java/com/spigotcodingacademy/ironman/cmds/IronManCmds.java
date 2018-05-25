package com.spigotcodingacademy.ironman.cmds;

import com.spigotcodingacademy.ironman.manager.Data;
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
                return true;
            }

            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("info")) {
                    Chat.msg(
                            player,
                            Chat.prefix + "&7Information:",
                            "&7IronMan is a plugin created by BLitZzMc in 2018 to bring the Marvel character, IronMan, to your game. " +
                                    "This plugin aims to bring his abilities, J.A.R.V.I.S and suits to the servers running it.",
                            "&8&l >> &7Version: " + Chat.version()
                    );
                    return true;
                }

                if (args[0].equalsIgnoreCase("version")) {
                    Chat.msg(player, Chat.prefix + "Version: " + Chat.version());

                    if (Data.Suit.contains(player)) {
                        Data.Suit.remove(player);
                        return true;
                    }
                    Data.Suit.add(player);
                    return true;
                }

                if (args[0].equalsIgnoreCase("reload")) {
                    if (player.hasPermission("ironman.reload")) {
                        Chat.msg(player, Chat.prefix + "Plugin has been reloaded!");
                        return true;
                    }
                    else{
                        Chat.msg(player, Chat.perm);
                        return true;
                    }
                }
            }
        }
        return false;
    }
}