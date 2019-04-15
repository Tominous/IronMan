package com.spigotcodingacademy.ironman.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ItemStackBuilder {

    private ItemStack itemStack;

    public ItemStackBuilder(Material material) {
        this.itemStack = new ItemStack(material);
    }

    public ItemStackBuilder(ItemStack itemStack) {
        this.itemStack = itemStack;
    }

    public ItemStackBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    public ItemStackBuilder setName(String name) {
        ItemMeta meta = itemStack.getItemMeta();
        meta.setDisplayName(Chat.color(name));
        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStackBuilder addLore(String name) {
        ItemMeta meta = itemStack.getItemMeta();
        List<String> lore = meta.getLore();

        if (lore == null) {
            lore = new ArrayList<>();
        }

        lore.add(Chat.color(name));
        meta.setLore(lore);

        itemStack.setItemMeta(meta);
        return this;
    }

    public ItemStackBuilder withData(int data) {
        itemStack.setDurability((short) data);
        return this;
    }

    public ItemStackBuilder addEnchant(Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);

        return this;
    }

    public ItemStack build() {
        return itemStack;
    }

}