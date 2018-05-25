package com.spigotcodingacademy.ironman.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class Chat {

    public static String prefix = color("&7[&c&lIronMan&7] ");
    public static String jarvis = color("&7[&c&lJ.A.R.V.I.S&7] ");
    public static String jarvisMenu = color("&c&lJ.A.R.V.I.S ");
    public static String perm = color(prefix + "&cInsufficient permissions!");

    public static void msg(Player player, String... message) {
        Arrays.stream(message).forEach(s -> player.sendMessage(color(s)));
    }

    public static String color(String message) { return ChatColor.translateAlternateColorCodes('&', message);}

    public static String version() {
        return Bukkit.getServer().getPluginManager().getPlugin("IronMan").getDescription().getVersion();
    }
}