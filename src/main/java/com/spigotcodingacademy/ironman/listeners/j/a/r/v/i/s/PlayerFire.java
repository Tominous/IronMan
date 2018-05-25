package com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s;

import com.spigotcodingacademy.ironman.manager.Data;
import com.spigotcodingacademy.ironman.utils.Chat;
import com.spigotcodingacademy.ironman.utils.Delay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class PlayerFire implements Listener {

    @EventHandler
    public void onPlayerFire(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (Data.Suit.contains(player)) {
                if (event.getCause() == EntityDamageEvent.DamageCause.FIRE || event.getCause() == EntityDamageEvent.DamageCause.FIRE_TICK) {
                    if (!Data.isOnFire.contains(player)) {
                        Data.isOnFire.add(player);
                        Chat.msg(
                                player,
                                Chat.jarvis + "&cWarning! Fire detected!",
                                Chat.jarvis + "&6Fire suppression started!"
                        );
                        Delay.until(40, () -> {
                            player.setFireTicks(0);
                            Chat.msg(player, Chat.jarvis + "&6Fire suppression successful!");
                            Data.isOnFire.remove(player);
                        });
                    }
                }

                if (event.getCause() == EntityDamageEvent.DamageCause.POISON) {
                    if (!Data.isPoisened.contains(player)) {
                        Chat.msg(
                                player,
                                Chat.jarvis + "&cWarning! Unknown synthetic detected!",
                                Chat.jarvis + "&6Starting scan..."
                        );
                    }
                }
            }
        }
    }
}