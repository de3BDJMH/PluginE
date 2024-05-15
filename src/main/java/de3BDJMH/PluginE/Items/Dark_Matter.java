package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Dark_Matter {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.BLACK_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("暗物质");
        itemMeta.setLocalizedName("暗物质");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
