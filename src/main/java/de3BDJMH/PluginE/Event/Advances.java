package de3BDJMH.PluginE.Event;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class Advances implements Listener {
    @EventHandler
    public void tt(CraftItemEvent e) {//合成转化桌
        if (e.getRecipe().getResult().getItemMeta()==null) {
            return;
        }
        if (!e.getRecipe().getResult().getItemMeta().hasLocalizedName()) {
            return;
        }
        if (e.getRecipe().getResult().getItemMeta().getLocalizedName().equals("转化桌")) {
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(),"advancement grant "+e.getWhoClicked().getName()+" only plugine:craft_transmutation_table");
        }
    }
}
