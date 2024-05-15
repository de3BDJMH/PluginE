package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.Functions.EMCOperations;
import de3BDJMH.PluginE.Functions.PlayerEMCInfo;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.List;

public class Transmutation_Table_Learn implements Listener {
    static FileConfiguration data;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Transmutation_Table_Inventory.Transmutation_Table_Name)&& e.getClickedInventory().getType().toString().equals("PLAYER")) {
            File PEI = new File(PluginE.instance.getDataFolder(), "PlayerEMCInfo.yml");
            data = YamlConfiguration.loadConfiguration(PEI);
            e.setCancelled(true);
            if (e.isLeftClick()) {
                ItemStack itemStack = e.getCurrentItem();
                if (itemStack==null) {
                    return;
                }
                if (!EMCOperations.EMCs.containsKey(itemStack.getType().toString()) && !EMCOperations.PEEMCs.containsKey(itemStack.getItemMeta().getLocalizedName())) {
                    return;
                }
                e.setCurrentItem(new ItemStack(Material.AIR));
                Player player = (Player) e.getWhoClicked();
                if (itemStack.getItemMeta().hasLocalizedName()) {
                    PlayerEMCInfo.input(player.getName(), itemStack.getItemMeta().getLocalizedName(), EMCOperations.PEEMCs.get(itemStack.getItemMeta().getLocalizedName()) * itemStack.getAmount(), data.getInt(e.getWhoClicked().getName() + ".page"));
                } else {
                    PlayerEMCInfo.input(player.getName(), itemStack.getType().toString(), EMCOperations.EMCs.get(itemStack.getType().toString()) * itemStack.getAmount(), data.getInt(e.getWhoClicked().getName() + ".page"));
                }
            }
            Transmutation_Table_Load.load((Player) e.getWhoClicked(), data.getInt(e.getWhoClicked().getName()+".page"),"none");
        }
    }
}
