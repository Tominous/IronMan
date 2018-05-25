package com.spigotcodingacademy.ironman.listeners.j.a.r.v.i.s;

import com.spigotcodingacademy.ironman.Main;
import com.spigotcodingacademy.ironman.manager.Data;
import com.spigotcodingacademy.ironman.utils.Chat;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class PlayerLowHealth implements Listener {

    @EventHandler
    public void onPlayerTakeDamage(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (Data.Suit.contains(player)) {
                if (player.getHealth() < 10 && !Data.isLowHealth.contains(player)) {
                    Data.isLowHealth.add(player);
                    Chat.msg(
                            player,
                            Chat.jarvis + "&cWarning! High damage sustained!",
                            Chat.jarvis + "&6Adrenaline has been administered."
                    );
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, Integer.MAX_VALUE, 1));
                            player.sendMessage("added potion effect");
                        }
                    }.runTaskLater(Main.getPlugin(), 2*20);
                }
            }
        }
    }
}
