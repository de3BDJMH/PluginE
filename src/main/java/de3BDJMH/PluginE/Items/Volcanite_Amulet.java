package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Volcanite_Amulet {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.RED_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("熔岩护符");
        itemMeta.setLocalizedName("熔岩护符");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
