package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.Blocks.Aeternalis_Fuel_Block;
import de3BDJMH.PluginE.Blocks.Alchemical_Coal_Block;
import de3BDJMH.PluginE.Blocks.Mobius_Fuel_Block;
import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Mobius_Fuel;
import net.kyori.adventure.text.event.ClickEvent;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.FurnaceBurnEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.FurnaceInventory;
import org.bukkit.inventory.ItemStack;

import java.util.Objects;

public class Burn implements Listener {
    @EventHandler
    public void onBurn (FurnaceBurnEvent e) {
        if (e.getFuel().getItemMeta().getLocalizedName().equals("炼金煤炭")) {
            e.setBurnTime(6400);
        }else if (e.getFuel().getItemMeta().getLocalizedName().equals("莫比乌斯燃料")) {
            e.setBurnTime(25600);
        }else if (e.getFuel().getItemMeta().getLocalizedName().equals("永恒燃料")) {
            e.setBurnTime(102400);
        }else if (e.getFuel().getItemMeta().getLocalizedName().equals("炼金煤炭块")) {
            e.setBurnTime(57600);
        }else if (e.getFuel().getItemMeta().getLocalizedName().equals("莫比乌斯燃料块")) {
            e.setBurnTime(230400);
        }else if (e.getFuel().getItemMeta().getLocalizedName().equals("永恒燃料块")) {
            e.setBurnTime(921600);
        }
    }

    @EventHandler
    public void onClick (InventoryClickEvent e) {
        if (e.getClickedInventory()==null) {
            return;
        }
        if (e.getClickedInventory().getType()== InventoryType.FURNACE) {
            if (e.getCursor().getItemMeta()==null) {
                return;
            }
            if (e.getCursor().getItemMeta().getLocalizedName().equals("炼金煤炭块")
                || e.getCursor().getItemMeta().getLocalizedName().equals("莫比乌斯燃料块")
                || e.getCursor().getItemMeta().getLocalizedName().equals("永恒燃料块")) {
                e.setCancelled(true);
                FurnaceInventory inv = (FurnaceInventory) e.getClickedInventory();
                if (inv.getFuel()!=null) {
                    e.getWhoClicked().getInventory().addItem(inv.getFuel());
                }
                inv.setFuel(e.getCursor());
                e.getView().setCursor(new ItemStack(Material.AIR));
            }
        }
    }
}
