package de3BDJMH.PluginE.Event.Items.Volcanite_Amulet;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

public class Volcanite_Amulet_ClickEntity implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEntityEvent e) {
        Entity entity = e.getRightClicked();
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("潮汐护符")) {
            entity.setFireTicks(4*20);
            ((LivingEntity) entity).damage(5);
        }
    }
}
