package com.spigotcodingacademy.ironman;

import com.spigotcodingacademy.ironman.cmds.IronManCmds;
import com.spigotcodingacademy.ironman.cmds.SuitCmds;
import com.spigotcodingacademy.ironman.cmds.suits.mk42;
import com.spigotcodingacademy.ironman.listeners.PlayerJoin;
import com.spigotcodingacademy.ironman.listeners.PlayerDeath;
import com.spigotcodingacademy.ironman.listeners.PlayerLeave;
import com.spigotcodingacademy.ironman.listeners.PlayerMoveArmourListener;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerFire;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerHeal;
import com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s.PlayerLowHealth;
import com.spigotcodingacademy.ironman.manager.SuitManager;
import com.spigotcodingacademy.ironman.utils.menu.GuiListener;
import lombok.Getter;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin{

    @Getter
    private static Main plugin;
    @Getter
    private static SuitManager suitManager;

    public void onEnable() {
        plugin = this;

        suitManager = new SuitManager(this);

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
        getServer().getPluginManager().registerEvents(new PlayerHeal(), this);
        getServer().getPluginManager().registerEvents(new PlayerLowHealth(), this);
        getServer().getPluginManager().registerEvents(new PlayerDeath(), this);
        getServer().getPluginManager().registerEvents(new GuiListener(), this);
        getServer().getPluginManager().registerEvents(new PlayerLeave(), this);
        getServer().getPluginManager().registerEvents(new PlayerFire(), this);
        getServer().getPluginManager().registerEvents(new PlayerMoveArmourListener(), this);

        getCommand("ironman").setExecutor(new IronManCmds());
        getCommand("suits").setExecutor(new SuitCmds());
        getCommand("mk42").setExecutor(new mk42());

    }
}