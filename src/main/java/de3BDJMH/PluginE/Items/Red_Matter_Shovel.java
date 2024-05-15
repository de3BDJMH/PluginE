package de3BDJMH.PluginE.Items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.UUID;

public class Red_Matter_Shovel {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED,10,true);
        itemMeta.setDisplayName(ChatColor.YELLOW+"红物质锹");
        itemMeta.setLocalizedName("红物质锹");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
