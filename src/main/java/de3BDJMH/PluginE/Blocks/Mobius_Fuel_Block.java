package de3BDJMH.PluginE.Blocks;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mobius_Fuel_Block {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.ORANGE_CONCRETE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("莫比乌斯燃料块");
        itemMeta.setLocalizedName("莫比乌斯燃料块");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
