package com.spigotcodingacademy.ironman.cmds;

import com.spigotcodingacademy.ironman.Main;
import com.spigotcodingacademy.ironman.Menus;
import com.spigotcodingacademy.ironman.manager.Data;
import com.spigotcodingacademy.ironman.utils.Chat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuitCmds implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) return true;
        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("suits")) {
            if (!player.hasPermission("ironman.suits")) {
                Chat.msg(player, Chat.perm);
                return true;
            }

            if (args.length == 0) {
                Chat.msg(
                        player,
                        Chat.prefix + "&7Suit commands:",
                        "&8&l >> &7/suits menu",
                        "&8&l >> &7/suits set <Player> <SuitName>",
                        "&8&l >> &7/suits list",
                        "&8&l >> &7/suits eject"
                );
                return true;
            }

            if (args[0].equalsIgnoreCase("menu")) {
                Menus.createTestMenu(player);
                return true;
            }

            if (args[0].equalsIgnoreCase("list")) {
                Chat.msg(
                        player,
                        Chat.prefix + "&7Suit list:",
                        "&8&l >> &7Mk1",
                        "&8&l >> &7Mk42"
                );
                return true;
            }

            if (args[0].equalsIgnoreCase("eject")) {
                if (Data.Suit.contains(player)){
                    Main.getSuitManager().eject(player);
                    return true;
                } else{
                    Chat.msg(player, Chat.jarvis + "&4No suit to eject from!");
                }
            }

            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (player.hasPermission("ironman.suits.set")) {

                        if (args.length < 3) {
                            Chat.msg(
                                    player,
                                    Chat.prefix + "&cIncorrect usage detected!",
                                    Chat.prefix + "&6/suits set <Player> <SuitName>"
                                    );
                        }

                        Player target = Bukkit.getServer().getPlayer(args[1]);
                        String suit = args[2];
                        if (target == null) {
                            Chat.msg(
                                    player,
                                    Chat.prefix + "&cError! Player is not online or does not exist!"
                            );
                            return true;
                        }

                        if (Data.Suit.contains(target)) {
                            Chat.msg(player, Chat.prefix + "&6Suit set by: &a" + ((Player) sender).getDisplayName() + "&6!");
                            Main.getSuitManager().eject(target);
                            Main.getSuitManager().apply(target);
                            return true;
                        }

                        if (suit.equalsIgnoreCase("mk1")) {
                            Chat.msg(player, Chat.prefix + "&6Suit set by: &a" + ((Player) sender).getDisplayName() + "&6!");
                            Data.suitAssigned.put(target, "MK1");
                            Main.getSuitManager().apply(target);
                        }

                        if (suit.equalsIgnoreCase("mk42")) {
                            Chat.msg(player, Chat.prefix + "&6Suit set by: &a" + ((Player) sender).getDisplayName() + "&6!");
                            Data.suitAssigned.put(target, "MK42");
                            Main.getSuitManager().apply(target);
                        }
                    }
                }
            }
        }
        return false;
    }
}