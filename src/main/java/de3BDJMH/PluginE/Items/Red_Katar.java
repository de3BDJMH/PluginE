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

public class Red_Katar {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED,15,true);
        AttributeModifier am = new AttributeModifier(UUID.randomUUID(),"伤害",24,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,am);
        itemMeta.setDisplayName(ChatColor.YELLOW+"红物质拳剑");
        itemMeta.setLocalizedName("红物质拳剑");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
