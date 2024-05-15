package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Alchemical_Coal {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.COAL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("炼金煤炭");
        itemMeta.setLocalizedName("炼金煤炭");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
