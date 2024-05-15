package de3BDJMH.PluginE.Items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Red_Matter_Shears {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.SHEARS);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED,10,true);
        itemMeta.setDisplayName(ChatColor.YELLOW+"红物质剪刀");
        itemMeta.setLocalizedName("红物质剪刀");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
