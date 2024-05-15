package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Philosophers_Stone {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.REDSTONE_BLOCK);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("贤者之石");
        itemMeta.setLocalizedName("贤者之石");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
