package de3BDJMH.PluginE.Event.Items.Morningstar;

import de3BDJMH.PluginE.Items.Red_Morningstar;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class Morningstar_Craft implements Listener {
    @EventHandler
    public void onCraft(InventoryClickEvent e) {//合成无法实现，转事件，合成时产物栏可能为空，直接点就好可以合成的
        if (e.getClickedInventory().getType()== InventoryType.WORKBENCH) {
            CraftingInventory inventory = (CraftingInventory) e.getClickedInventory();
            ItemStack[] matrix = inventory.getMatrix();
            int red = 0;
            boolean pickaxe = false;
            boolean hammer = false;
            boolean shovel = false;
            for (ItemStack i : matrix) {
                if (i==null) {
                    return;
                }
                if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质")) {
                    red+=1;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质镐")) {
                    pickaxe=true;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质锤")) {
                    hammer=true;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质锹")) {
                    shovel=true;
                }
            }
            if (pickaxe&&shovel&&hammer&&red==6) {
                inventory.setResult(Red_Morningstar.get());
            }
        }
    }
}
