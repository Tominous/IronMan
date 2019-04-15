package com.spigotcodingacademy.ironman.listeners;

import com.spigotcodingacademy.ironman.manager.Data;
import com.spigotcodingacademy.ironman.utils.Chat;
import com.spigotcodingacademy.ironman.utils.Delay;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;

import java.util.ArrayList;

public class PlayerMoveArmourListener implements Listener {

    ArrayList<Player> SpamCheck = new ArrayList<Player>();

    @EventHandler
    public void playerMoveArmourEvent (InventoryClickEvent event) {

        Player player = (Player) event.getWhoClicked();

        if (Data.Suit.contains(player) || (Data.buildingSuit.contains(player))) {
            if (event.getSlotType() == InventoryType.SlotType.ARMOR) {
                event.setCancelled(true);

                if (SpamCheck.contains(player)) {
                    player.closeInventory();
                    return;
                }

                player.closeInventory();
                Chat.msg(player, Chat.prefix + "&7To remove your armour type /suits eject");
                SpamCheck.add(player);

                Delay.until(200, () -> SpamCheck.remove(player));
            }
        }
    }
}