package com.spigotcodingacademy.ironman.listeners;

import com.spigotcodingacademy.ironman.manager.Data;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class PlayerDeath implements Listener {

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        Data.Suit.remove(player);
        Data.isLowHealth.remove(player);
        Data.buildingSuit.remove(player);
    }
}
