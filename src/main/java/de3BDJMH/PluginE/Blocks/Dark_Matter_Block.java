package de3BDJMH.PluginE.Blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Dark_Matter_Block {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.BLACK_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("暗物质块");
        itemMeta.setLocalizedName("暗物质块");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
