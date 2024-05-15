package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Transmutation_Table_Pages implements Listener {
    static FileConfiguration data;
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Transmutation_Table_Inventory.Transmutation_Table_Name)) {
            e.setCancelled(true);
            if (e.getSlot()==43) {//下一页
                File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
                data= YamlConfiguration.loadConfiguration(PEI);
                if (data.getInt(e.getWhoClicked().getName()+".page")<=data.getStringList(e.getWhoClicked().getName()+".r").size()/8-1) {
                    Transmutation_Table_Load.load((Player) e.getWhoClicked(), data.getInt(e.getWhoClicked().getName() + ".page") + 1,"none");
                    data.set(e.getWhoClicked().getName() + ".page", data.getInt(e.getWhoClicked().getName() + ".page") + 1);
                    try {
                        data.save(PEI);
                    } catch (IOException ee) {
                        PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
                        ee.printStackTrace();
                    }
                }
            }
            if (e.getSlot()==41) {//上一页
                File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
                data= YamlConfiguration.loadConfiguration(PEI);
                if (data.getInt(e.getWhoClicked().getName()+".page")>0) {
                    Transmutation_Table_Load.load((Player) e.getWhoClicked(), data.getInt(e.getWhoClicked().getName() + ".page") - 1,"none");
                    data.set(e.getWhoClicked().getName() + ".page", data.getInt(e.getWhoClicked().getName() + ".page") - 1);
                    try {
                        data.save(PEI);
                    } catch (IOException ee) {
                        PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
                        ee.printStackTrace();
                    }
                }
            }
        }
    }
}
