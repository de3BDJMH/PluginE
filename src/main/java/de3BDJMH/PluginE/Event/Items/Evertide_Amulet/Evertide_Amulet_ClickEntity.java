package de3BDJMH.PluginE.Event.Items.Evertide_Amulet;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;

public class Evertide_Amulet_ClickEntity implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEntityEvent e) {
        Entity entity = e.getRightClicked();
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("潮汐护符")) {
            if (entity.isVisualFire()) {
                entity.setFireTicks(0);
            }
        }
    }
}
