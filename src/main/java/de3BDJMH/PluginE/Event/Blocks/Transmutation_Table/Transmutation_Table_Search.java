package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.PluginE;
import io.papermc.paper.event.player.AsyncChatEvent;
import io.papermc.paper.event.player.ChatEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Transmutation_Table_Search implements Listener {
    static FileConfiguration data;

    public static List<ItemStack> find(String key) {
        List<ItemStack> items = new java.util.ArrayList<>(Collections.emptyList());
        for (ItemStack itemStack: Transmutation_Table_Load.all) {
            String name;
            if (itemStack.getItemMeta().hasLocalizedName()) {
                name = itemStack.getItemMeta().getLocalizedName();
            }else {
                File ZH = new File(PluginE.instance.getDataFolder(),"zh_cn.yml");
                data= YamlConfiguration.loadConfiguration(ZH);
                if (data.getString(itemStack.getType().toString())==null) {
                    name=itemStack.getType().toString();
                }else {
                    name = data.getString(itemStack.getType().toString());
                }
            }
            /*if (names.size()==0) {
                names.add(name);
            }else if (names.size()==1) {
                if (names.get(0).compareTo(name)<=0) {
                    names.add(name);
                }else {
                    names.add(0,name);
                }
            }else {
                for (int p = 0; p + 1 < names.size(); p++) {
                    if (names.get(p).compareTo(name) <= 0 && names.get(p + 1).compareTo(name) > 0) {
                        names.add(p + 1, name);
                    }
                }
            }*/
            if (name!=null) {
                if (name.contains(key)) {
                    items.add(itemStack);
                }
            }
        }
        Transmutation_Table_Load.all.clear();
        return items;
    }
    public static Map<String,Boolean> searching = new HashMap<>();
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Transmutation_Table_Inventory.Transmutation_Table_Name) && e.getClickedInventory().getType().toString().equals("CHEST")) {
            if (e.getSlot()==4) {
                e.getWhoClicked().closeInventory();
                e.getWhoClicked().sendMessage(ChatColor.AQUA+"你要搜索些什么呢？");
                if (searching.containsKey(e.getWhoClicked().getName())) {
                    searching.replace(e.getWhoClicked().getName(),true);
                }else {
                    searching.put(e.getWhoClicked().getName(),true);
                }
            }
        }
    }
    @EventHandler
    public void onchat(PlayerChatEvent e) {
        //Bukkit.broadcastMessage(String.valueOf(searching.get(e.getPlayer().getName())));
        if (searching.get(e.getPlayer().getName())==null) {
            return;
        }
        if (searching.get(e.getPlayer().getName())) {
            e.setCancelled(true);
            File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
            data= YamlConfiguration.loadConfiguration(PEI);
            Transmutation_Table_Load.load(e.getPlayer(),data.getInt(e.getPlayer().getName()+".page"),e.getMessage());
            searching.replace(e.getPlayer().getName(),false);
        }
    }
}
