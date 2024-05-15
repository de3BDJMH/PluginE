package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Mobius_Fuel {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.COAL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("莫比乌斯燃料");
        itemMeta.setLocalizedName("莫比乌斯燃料");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
