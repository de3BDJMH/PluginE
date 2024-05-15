package de3BDJMH.PluginE.Blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Transmutation_Table {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.SMOOTH_STONE_SLAB);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("转化桌");
        itemMeta.setLocalizedName("转化桌");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
