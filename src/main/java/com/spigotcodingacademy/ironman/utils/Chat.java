package com.spigotcodingacademy.ironman.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Chat {

    public static void msg(Player player, String... message) {
        for (String s : message) {
            player.sendMessage(color(s));
        }
    }

    public static String color(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static String perm(String message) {
        return color(prefix + "&cInsufficient permissions!");
    }

    public static String version() {
        return Bukkit.getServer().getPluginManager().getPlugin("IronMan").getDescription().getVersion();
    }

    public static String prefix = color("&7[&c&lIronMan&7] ");
}