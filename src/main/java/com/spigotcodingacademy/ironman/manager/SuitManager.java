package com.spigotcodingacademy.ironman.manager;

import com.spigotcodingacademy.ironman.Main;
import com.spigotcodingacademy.ironman.utils.Chat;
import com.spigotcodingacademy.ironman.utils.Delay;
import com.spigotcodingacademy.ironman.utils.ItemStackBuilder;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public class SuitManager {

    private Main main;

    public SuitManager(Main main) {
        this.main = main;
    }

    public void apply(Player player) {
        Data.buildingSuit.add(player);
        Delay.until(20*3, () -> {
            setBoots(player);
            player.sendMessage(Chat.jarvis + "Suit percentage: 25%");
        });

        Delay.until(20*4, () -> {
            setChestplate(player);
            player.sendMessage(Chat.jarvis + "Suit percentage: 50%");
        });

        Delay.until(20*5, () -> {
            setLeggings(player);
            player.sendMessage(Chat.jarvis + "Suit percentage: 75%");
        });

        Delay.until(20*6, () -> {
            setHelemet(player);
            player.sendMessage(Chat.jarvis + "Suit percentage: 100%");
        });
        Data.buildingSuit.remove(player);
        Data.Suit.add(player);
    }

    public void eject(Player player) {

        if (Data.buildingSuit.contains(player)) {
            Chat.msg(player, Chat.jarvis + "&4Suit not built yet!");
            return;
        }

        player.getInventory().setHelmet(null);
        player.getInventory().setChestplate(null);
        player.getInventory().setLeggings(null);
        player.getInventory().setBoots(null);
        Chat.msg(player, Chat.jarvis + "&cEjected from suit!");
        Data.Suit.remove(player);
        player.setVelocity(new Vector(0, 1, -3));

        double x = player.getLocation().getX();
        double y = player.getLocation().getY() + 1;
        double z = player.getLocation().getZ() - 3;

        Location location = new Location(player.getWorld(),x, y, z);

        Delay.until(20, () -> player.getWorld().createExplosion(location, 0));

    }

    private void setHelemet(Player player) {
        player.getInventory().setHelmet(new ItemStackBuilder(Material.IRON_HELMET).setName("&8&lMark 1").build());
    }

    private void setChestplate(Player player) {
        player.getInventory().setChestplate(new ItemStackBuilder(Material.IRON_CHESTPLATE).setName("&8&lMark 1").build());
    }

    private void setLeggings(Player player) {
        player.getInventory().setLeggings(new ItemStackBuilder(Material.IRON_LEGGINGS).setName("&8&lMark 1").build());
    }

    private void setBoots(Player player) {
        player.getInventory().setBoots(new ItemStackBuilder(Material.IRON_BOOTS).setName("&8&lMark 1").build());
    }
}