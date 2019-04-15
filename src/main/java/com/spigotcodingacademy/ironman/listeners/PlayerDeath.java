package com.spigotcodingacademy.ironman.listeners;

import com.google.common.collect.Maps;
import com.spigotcodingacademy.ironman.manager.Data;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerDeath implements Listener {

    private HashMap<UUID, Integer> deaths = Maps.newHashMap();

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        if (deaths.containsKey(player.getUniqueId())) {
            deaths.put(player.getUniqueId(), deaths.get(player.getUniqueId()) + 1);
            return;
        }
        deaths.put(player.getUniqueId(), 1);
        player.sendMessage("&c&l(!) &cDeath Counter: " + String.valueOf(deaths.get(player.getUniqueId())));

        for (Map.Entry<UUID, Integer> values : deaths.entrySet()) {
            player.sendMessage(Bukkit.getPlayer(values.getKey()).getName() + "");
        }

        Data.Suit.remove(player);
        Data.isLowHealth.remove(player);
        Data.buildingSuit.remove(player);
    }
}
