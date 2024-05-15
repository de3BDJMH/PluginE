package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Iron_Band {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.IRON_INGOT);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("铁指环");
        itemMeta.setLocalizedName("铁指环");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
