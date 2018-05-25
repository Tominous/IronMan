package com.spigotcodingacademy.ironman;

import com.spigotcodingacademy.ironman.cmds.IronManCmds;
import com.spigotcodingacademy.ironman.listeners.PlayerJoin;
import com.spigotcodingacademy.ironman.listeners.PlayerDeath;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerHeal;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerLowHealth;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main plugin;

    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerHeal(), this);
        getServer().getPluginManager().registerEvents(new PlayerLowHealth(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);

        getCommand("ironman").setExecutor(new IronManCmds());

    }

    public static Main getPlugin() {
        return plugin;
    }
}