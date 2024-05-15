package de3BDJMH.PluginE.Event.Items.Philosophers_Stone;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;

public class Philosophers_Stone_Craft implements Listener {
    @EventHandler
    public void onClick(BlockPlaceEvent e) {
        if (e.getHand()!= EquipmentSlot.OFF_HAND) {//副手右键打开界面
            return;
        }
        if (e.getPlayer().isSneaking()) {//潜行是充能
            return;
        }
        if (e.getItemInHand().getItemMeta().getLocalizedName().equals("贤者之石")) {
            Inventory psinv = Philosophers_Stone_Inventory.getMain(e.getPlayer());
            e.getPlayer().openInventory(psinv);
        }
    }
}
