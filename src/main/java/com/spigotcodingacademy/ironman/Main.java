package com.spigotcodingacademy.ironman;

import com.spigotcodingacademy.ironman.cmds.IronManCmds;
import com.spigotcodingacademy.ironman.cmds.SuitCmds;
import com.spigotcodingacademy.ironman.listeners.PlayerJoin;
import com.spigotcodingacademy.ironman.listeners.PlayerDeath;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerHeal;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerLowHealth;
import com.spigotcodingacademy.ironman.utils.menu.GuiListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    private static Main plugin;

    public void onEnable() {
        plugin = this;

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerHeal(), this);
        getServer().getPluginManager().registerEvents(new PlayerLowHealth(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);

        getCommand("ironman").setExecutor(new IronManCmds());
        getCommand("suits").setExecutor(new SuitCmds());

    }

    public static Main getPlugin() {
        return plugin;
    }
}