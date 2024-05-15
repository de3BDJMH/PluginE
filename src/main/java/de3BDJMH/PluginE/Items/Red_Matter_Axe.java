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

public class Red_Matter_Axe {
    public static ItemStack get() {//所有攻击伤害攻击速度加成都会被集成到攻击事件中，因为写在这里会导致无法合成
        ItemStack itemStack = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setUnbreakable(true);
        itemMeta.addEnchant(Enchantment.DIG_SPEED,10,true);
        AttributeModifier am1 = new AttributeModifier(UUID.randomUUID(),"伤害",10,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        AttributeModifier am2 = new AttributeModifier(UUID.randomUUID(),"攻速",1,AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.HAND);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE,am1);
        itemMeta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED,am2);
        itemMeta.setDisplayName(ChatColor.YELLOW+"红物质斧");
        itemMeta.setLocalizedName("红物质斧");
        itemStack.setItemMeta(itemMeta);
        return itemStack;
    }
}
