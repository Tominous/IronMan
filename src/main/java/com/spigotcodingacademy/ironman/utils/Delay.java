package com.spigotcodingacademy.ironman.utils;

import com.spigotcodingacademy.ironman.Main;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

/**
 * Created by IVenomX (BantaGaming)
 */
public class Delay {

    public static void until(long time, Runnable runnable) {
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), runnable, time);
    }

}
