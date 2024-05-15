package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Red_Matter {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.RED_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("红物质");
        itemMeta.setLocalizedName("红物质");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
