package de3BDJMH.PluginE.Event.Items.Philosophers_Stone;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.ItemStack;

public class Philosophers_Stone_Close implements Listener {
    @EventHandler
    public void close(InventoryCloseEvent e) {
        if (e.getPlayer().getOpenInventory().getTitle().equals(Philosophers_Stone_Inventory.Furname) && !Philosophers_Stone_Click.ongoing.get(e.getPlayer().getName())) {
            ItemStack i1 = e.getView().getItem((10));
            ItemStack i2 = e.getView().getItem((13));
            ItemStack i3 = e.getView().getItem((16));
            if (i1!=null) e.getPlayer().getInventory().addItem(i1);
            if (i2!=null) e.getPlayer().getInventory().addItem(i2);
            if (i3!=null) e.getPlayer().getInventory().addItem(i3);
        }
    }
}
