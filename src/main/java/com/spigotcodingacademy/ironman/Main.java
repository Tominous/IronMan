package com.spigotcodingacademy.ironman;

import com.spigotcodingacademy.ironman.cmds.IronManCmds;
import com.spigotcodingacademy.ironman.listeners.PlayerJoin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main plugin;

    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);

        getCommand("ironman").setExecutor(new IronManCmds());

    }

    public static Main getPlugin() {
        return plugin;
    }
}