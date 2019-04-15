package com.spigotcodingacademy.ironman;

import com.spigotcodingacademy.ironman.manager.Data;
import com.spigotcodingacademy.ironman.utils.Chat;
import com.spigotcodingacademy.ironman.utils.ItemStackBuilder;
import com.spigotcodingacademy.ironman.utils.menu.Gui;
import com.spigotcodingacademy.ironman.utils.menu.GuiItem;
import org.bukkit.Material;
import org.bukkit.entity.Player;

public class Menus {

    public static void createTestMenu(Player player) {
        Gui gui = new Gui(Chat.jarvisMenu + "&8Suit Selection", 1);

        gui.setItems(
                new GuiItem<>(
                        new ItemStackBuilder(Material.IRON_CHESTPLATE)
                                .setName("&8&lMark 1")
                                .addLore("Code Name: None")
                                .addLore("Armour Type: None")
                                .build(),
                        (clicker, event) -> {
                            if (Data.Suit.contains(clicker)) {
                                Main.getSuitManager().eject(clicker);
                                Main.getSuitManager().apply(clicker);
                                clicker.sendMessage(Chat.jarvis + "Mark 1 is on its way!");
                                clicker.closeInventory();
                                return;
                            }
                            Main.getSuitManager().apply(clicker);
                            clicker.sendMessage(Chat.jarvis + "Mark 1 is on its way!");
                            clicker.closeInventory();
                        }
                ),

                new GuiItem<>(
                        new ItemStackBuilder(Material.DIAMOND_CHESTPLATE)
                                .setName("&8&lMark 42")
                                .addLore("Code Name: The Prodigal Son")
                                .addLore("Armour Type: Prehensile Suit")
                                .build(),
                        (clicker, event) -> {
                            if (Data.Suit.contains(clicker)) {
                                Main.getSuitManager().eject(clicker);
                                Main.getSuitManager().apply(clicker);
                                clicker.sendMessage(Chat.jarvis + "Mark 42 is on its way!");
                                clicker.closeInventory();
                                return;
                            }
                            Main.getSuitManager().apply(clicker);
                            clicker.sendMessage(Chat.jarvis + "Mark 42 is on its way!");
                            clicker.closeInventory();
                        }
                )

        );

        gui.open(player);

    }

}
