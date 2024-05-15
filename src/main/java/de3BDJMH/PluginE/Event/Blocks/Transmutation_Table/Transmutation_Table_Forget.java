package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.Functions.PlayerEMCInfo;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;

public class Transmutation_Table_Forget implements Listener {
    static FileConfiguration data;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getClickedInventory()==null) {
            return;
        }
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Transmutation_Table_Inventory.Transmutation_Table_Name)&& e.getClickedInventory().getType().toString().equals("PLAYER")) {
            e.setCancelled(true);
            if (e.getCurrentItem()==null) {
                return;
            }
            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                PlayerEMCInfo.forget(e.getWhoClicked().getName(),e.getCurrentItem().getItemMeta().getLocalizedName());
            }else {
                PlayerEMCInfo.forget(e.getWhoClicked().getName(),e.getCurrentItem().getType().toString());
            }
            File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
            data= YamlConfiguration.loadConfiguration(PEI);
            Transmutation_Table_Load.load((Player) e.getWhoClicked(),data.getInt(e.getWhoClicked().getName()+".page"),"none");
        }
    }
}
