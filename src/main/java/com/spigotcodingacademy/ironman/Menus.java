package com.spigotcodingacademy.ironman;

import com.spigotcodingacademy.ironman.utils.menu.Gui;
import com.spigotcodingacademy.ironman.utils.menu.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

/**
 * Created by IVenomX (BantaGaming)
 */
public class Menus {

    public static void createTestMenu(Player player) {
        Gui gui = new Gui("Test", 1);

        gui.setItems(
                new GuiItem<>(
                        new ItemStack(Material.GLASS),
                        (clicker, event) -> {
                            clicker.sendMessage("you clicked glass");
                            event.setCancelled(true);
                        }
                ),

                new GuiItem<>(
                        new ItemStack(Material.REDSTONE),
                        (clicker, event) -> {
                            clicker.sendMessage("you clicked redstone");
                            event.setCancelled(true);
                        }
                ),

                new GuiItem<>(
                        new ItemStack(Material.BOW),
                        (clicker, event) -> {
                            clicker.sendMessage("you clicked a bow");
                            event.setCancelled(true);
                        }
                )
        );

        gui.setCloseAction((closer, e) -> closer.sendMessage("closed"));

        /*
        gui.setItem(
                0,
                new ItemStack(Material.GRASS),
                (clicker, event) -> {
                    clicker.sendMessage("you clicked grass");
                    event.setCancelled(true);
                });
                */

        gui.open(player);

    }

}
