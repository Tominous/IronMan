package com.spigotcodingacademy.ironman.listeners;

import com.spigotcodingacademy.ironman.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener{

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        if (player.isOp()) {
            Chat.msg(player, Chat.prefix + Chat.color("IronMan is loaded!"));
            Chat.msg(player, Chat.prefix + Chat.color("IronMan version: " + Chat.version()));
        }
    }
}
