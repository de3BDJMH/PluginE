package de3BDJMH.PluginE.Items;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Evertide_Amulet {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.BLUE_DYE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName("潮汐护符");
        itemMeta.setLocalizedName("潮汐护符");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
