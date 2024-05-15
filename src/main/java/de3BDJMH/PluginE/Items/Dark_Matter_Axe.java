package de3BDJMH.PluginE.Items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Dark_Matter_Axe {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED,5,true);
        itemMeta.setDisplayName(ChatColor.YELLOW+"暗物质斧");
        itemMeta.setLocalizedName("暗物质斧");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
