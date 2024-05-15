package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.Functions.EMCOperations;
import de3BDJMH.PluginE.Functions.Init;
import de3BDJMH.PluginE.Functions.PlayerEMCInfo;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Transmutation_Table_Pickout implements Listener {
    static FileConfiguration data;

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Transmutation_Table_Inventory.Transmutation_Table_Name) && e.getClickedInventory().getType().toString().equals("CHEST")) {
            e.setCancelled(true);
            List<Integer> right = Arrays.asList(15,14,23,32,33,34,25,16);
            if (right.contains(e.getSlot())) {
                ItemStack itemStack = e.getCurrentItem();
                if (!EMCOperations.EMCs.containsKey(itemStack.getType().toString()) && !EMCOperations.PEEMCs.containsKey(itemStack.getItemMeta().getLocalizedName())) {
                    return;
                }
                if (itemStack.getItemMeta().getDisplayName().equals(" ")) {
                    return;
                }
                File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
                data= YamlConfiguration.loadConfiguration(PEI);
                int emc;
                if (itemStack.getItemMeta().hasLocalizedName()) {
                    emc= EMCOperations.PEEMCs.get(itemStack.getItemMeta().getLocalizedName());
                }else {
                    emc = EMCOperations.EMCs.get(itemStack.getType().toString());
                }
                if (Init.emcs.get(e.getWhoClicked().getName())-emc<0) {
                    return;
                }
                if (e.isLeftClick()) {
                    itemStack.setAmount(1);
                }else if (e.isRightClick()) {
                    itemStack.setAmount(64);
                    emc=emc*64;
                }
                if (Init.emcs.get(e.getWhoClicked().getName())-emc+ itemStack.getAmount()<0) {
                    return;
                }
                e.getWhoClicked().getInventory().addItem(itemStack);
                PlayerEMCInfo.pickout(e.getWhoClicked().getName(),emc);
                Transmutation_Table_Load.load((Player) e.getWhoClicked(),data.getInt(e.getWhoClicked().getName()+".page"),"none");
            }
        }
    }
}
