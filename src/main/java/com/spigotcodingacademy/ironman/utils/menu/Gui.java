package com.spigotcodingacademy.ironman.utils.menu;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.spigotcodingacademy.ironman.utils.Chat;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by IVenomX (BantaGaming)
 */
public class Gui {

    @Getter
    private static Set<Gui> guis = Sets.newConcurrentHashSet();
    @Getter
    private Inventory inventory;

    @Getter
    private Map<Integer, ClickAction> actions;
    private List<GuiItem<ItemStack, ClickAction>> guiItems;

    @Getter
    private CloseAction closeAction;

    private int current = 0;

    public Gui(String name, int rows) {
        inventory = Bukkit.createInventory(null, rows * 9, Chat.color(name));
        actions = Maps.newHashMap();
        guiItems = Lists.newArrayList();
        guis.add(this);
    }

    public void setItem(int slot, ItemStack item, ClickAction clickAction) {
        inventory.setItem(slot, item);
        actions.put(slot, clickAction);
    }

    public void setItems(GuiItem<ItemStack, ClickAction>... items) {
        for (GuiItem<ItemStack, ClickAction> i : items) {
            inventory.setItem(current, i.getA());
            actions.put(current, i.getB());
            guiItems.add(i);

            current++;
        }
    }

    public void setCloseAction(CloseAction closeAction) {
        this.closeAction = closeAction;
    }

    public boolean hasActionAtSlot(int slot) {
        return actions.containsKey(slot);
    }

    public ClickAction getClickAction(int slot) {
        if (!actions.containsKey(slot)) return null;

        for (Map.Entry<Integer, ClickAction> clickActionEntry : actions.entrySet()) {
            if (clickActionEntry.getKey() == slot) {
                return clickActionEntry.getValue();
            }
        }

        return null;
    }

    public void open(Player player) {
        player.openInventory(inventory);
    }

}
