package com.spigotcodingacademy.ironman.utils.menu;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

/**
 * Created by IVenomX (BantaGaming)
 */
public interface ClickAction {

    void click(Player clicker, InventoryClickEvent event);

}
