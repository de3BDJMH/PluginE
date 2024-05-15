package de3BDJMH.PluginE.Event.Items.Katar;

import de3BDJMH.PluginE.Items.Red_Katar;
import de3BDJMH.PluginE.Items.Red_Morningstar;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.CraftingInventory;
import org.bukkit.inventory.ItemStack;

public class Katar_Craft implements Listener {
    @EventHandler
    public void onCraft(InventoryClickEvent e) {//合成无法实现，转事件，合成时产物栏可能为空，直接点就好可以合成的
        if (e.getClickedInventory().getType()== InventoryType.WORKBENCH) {
            CraftingInventory inventory = (CraftingInventory) e.getClickedInventory();
            ItemStack[] matrix = inventory.getMatrix();
            int red = 0;
            boolean shear = false;
            boolean axe = false;
            boolean sword = false;
            boolean hoe = false;
            for (ItemStack i : matrix) {
                if (i==null) {
                    return;
                }
                if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质")) {
                    red+=1;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质剪刀")) {
                    shear=true;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质斧")) {
                    axe=true;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质剑")) {
                    sword=true;
                }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质锄")) {
                    hoe=true;
                }
            }
            if (shear&&axe&&sword&&hoe&&red==5) {
                inventory.setResult(Red_Katar.get());
            }
        }
    }
}
