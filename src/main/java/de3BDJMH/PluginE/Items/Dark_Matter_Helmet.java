package de3BDJMH.PluginE.Items;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import java.util.UUID;

public class Dark_Matter_Helmet {
    public static ItemStack get() {
        ItemStack itemStack = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta itemMeta = (LeatherArmorMeta) itemStack.getItemMeta();
        itemMeta.setColor(Color.BLACK);
        AttributeModifier am1 = new AttributeModifier(UUID.randomUUID(),"护甲值",7,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        AttributeModifier am2 = new AttributeModifier(UUID.randomUUID(),"韧性",2,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HEAD);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR,am1);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS,am2);
        itemMeta.setUnbreakable(true);
        itemMeta.setDisplayName(ChatColor.YELLOW+"暗物质头盔");
        itemMeta.setLocalizedName("暗物质头盔");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
