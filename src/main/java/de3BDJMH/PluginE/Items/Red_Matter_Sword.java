package de3BDJMH.PluginE.Items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Red_Matter_Sword {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DAMAGE_ALL,20,true);
        itemMeta.setDisplayName(ChatColor.YELLOW+"红物质剑");
        itemMeta.setLocalizedName("红物质剑");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
