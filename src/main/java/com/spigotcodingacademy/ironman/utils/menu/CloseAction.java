package com.spigotcodingacademy.ironman.utils.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryCloseEvent;

/**
 * Created by IVenomX (BantaGaming)
 */
public interface CloseAction {

    void close(Player player, InventoryCloseEvent e);

}
