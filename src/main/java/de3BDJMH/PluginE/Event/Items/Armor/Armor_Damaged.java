package de3BDJMH.PluginE.Event.Items.Armor;

import de3BDJMH.PluginE.Items.*;
import org.bukkit.Bukkit;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Arrays;
import java.util.List;

public class Armor_Damaged implements Listener {
    @EventHandler
    public void onDamaged(EntityDamageEvent e) {
        if (e.getEntityType()!= EntityType.PLAYER) {
            return;
        }
        Player player = (Player) e.getEntity();
        if ((player.getInventory().getItem(EquipmentSlot.HEAD).getItemMeta().getLocalizedName().equals("暗物质头盔")
                &&player.getInventory().getItem(EquipmentSlot.CHEST).getItemMeta().getLocalizedName().equals("暗物质胸甲")
                &&player.getInventory().getItem(EquipmentSlot.LEGS).getItemMeta().getLocalizedName().equals("暗物质护腿")
                &&player.getInventory().getItem(EquipmentSlot.FEET).getItemMeta().getLocalizedName().equals("暗物质靴子"))
                ||(player.getInventory().getItem(EquipmentSlot.HEAD).getItemMeta().getLocalizedName().equals("红物质头盔")
                &&player.getInventory().getItem(EquipmentSlot.CHEST).getItemMeta().getLocalizedName().equals("红物质胸甲")
                &&player.getInventory().getItem(EquipmentSlot.LEGS).getItemMeta().getLocalizedName().equals("红物质护腿")
                &&player.getInventory().getItem(EquipmentSlot.FEET).getItemMeta().getLocalizedName().equals("红物质靴子"))) {
            List<EntityDamageEvent.DamageCause> causes = Arrays.asList(EntityDamageEvent.DamageCause.FIRE_TICK,
                                                                       EntityDamageEvent.DamageCause.FALL,
                                                                       EntityDamageEvent.DamageCause.POISON);
            if ((!causes.contains(e.getCause())) || e.getFinalDamage()<=20) {
                e.setDamage(0);
            }
        }
    }
}
