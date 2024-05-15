package de3BDJMH.PluginE.Blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Alchemical_Coal_Block {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.RED_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("炼金煤炭块");
        itemMeta.setLocalizedName("炼金煤炭块");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
