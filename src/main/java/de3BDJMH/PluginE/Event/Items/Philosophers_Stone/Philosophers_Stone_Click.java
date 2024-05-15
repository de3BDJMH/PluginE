package de3BDJMH.PluginE.Event.Items.Philosophers_Stone;

import de3BDJMH.PluginE.Functions.FurRecipes;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Philosophers_Stone_Click implements Listener {
    public static Map<String,Boolean> ongoing = new HashMap<>();
    @EventHandler
    public void onClick(InventoryClickEvent e) {
        if (e.getWhoClicked().getOpenInventory().getTitle().equals(Philosophers_Stone_Inventory.Mainname)) {
            e.setCancelled(true);
            if (e.getSlot()==2) {
                e.getWhoClicked().openWorkbench(null,true);
            }else if (e.getSlot()==6) {
                Player player = (Player) e.getWhoClicked();
                e.getWhoClicked().openInventory(Philosophers_Stone_Inventory.getFur(player));
            }
        }else if (e.getWhoClicked().getOpenInventory().getTitle().equals(Philosophers_Stone_Inventory.Furname) && e.getClickedInventory().getType().toString().equals("CHEST")) {
            //Bukkit.broadcastMessage(e.getClickedInventory().getType().toString());
            //Bukkit.broadcastMessage(String.valueOf(e.getSlot()));
            Player player = (Player) e.getWhoClicked();
            if (e.getSlot()!=10 && e.getSlot()!=13 && e.getSlot()!=16) {
                e.setCancelled(true);
            }
            if (e.getSlot()>=27 && e.getSlot()<=35) {
                ongoing.replace(player.getName(), true);
                if (e.getClickedInventory().getItem(10)==null || e.getClickedInventory().getItem(13)==null) {
                    Inventory fur = player.getOpenInventory().getTopInventory();
                    ItemStack blank = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                    ItemMeta blankim = blank.getItemMeta();
                    blankim.setDisplayName(ChatColor.RED+"缺少煤炭或原料");
                    blank.setItemMeta(blankim);
                    for (int n=27;n<=35;n++) {
                        fur.setItem(n,blank);
                    }
                    player.openInventory(fur);
                }else {
                    if ((e.getClickedInventory().getItem(10).getType().equals(Material.COAL) || e.getClickedInventory().getItem(10).getType().equals(Material.CHARCOAL)) && FurRecipes.recipes.keySet().contains(e.getClickedInventory().getItem(13).getType())) {
                        Inventory fur = player.getOpenInventory().getTopInventory();
                        ItemStack blank = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
                        ItemMeta blankim = blank.getItemMeta();
                        blankim.setDisplayName(ChatColor.GREEN + "点击开始烧炼");
                        blank.setItemMeta(blankim);
                        for (int n = 27; n <= 35; n++) {
                            fur.setItem(n, blank);
                        }
                        player.openInventory(fur);
                    } else {
                        Inventory fur = player.getOpenInventory().getTopInventory();
                        ItemStack blank = new ItemStack(Material.RED_STAINED_GLASS_PANE);
                        ItemMeta blankim = blank.getItemMeta();
                        blankim.setDisplayName(ChatColor.RED + "缺少煤炭或原料");
                        blank.setItemMeta(blankim);
                        for (int n = 27; n <= 35; n++) {
                            fur.setItem(n, blank);
                        }
                        player.openInventory(fur);
                    }
                }
                if (e.getClickedInventory().getItem(e.getSlot()).getType().equals(Material.GREEN_STAINED_GLASS_PANE)) {
                    Material res = FurRecipes.recipes.get(e.getClickedInventory().getItem(13).getType());
                    Inventory fur = player.getOpenInventory().getTopInventory();
                    ItemStack fuel = e.getClickedInventory().getItem(10);
                    ItemStack raw = e.getClickedInventory().getItem(13);
                    int fuels = fuel.getAmount();
                    int raws = raw.getAmount() /7+1;
                    int de;
                    if (e.getClickedInventory().getItem(16)!=null) {
                        player.getInventory().addItem(e.getClickedInventory().getItem(16));
                    }
                    if (fuels>=raws) {
                        de=raws;
                        fur.setItem(16,new ItemStack(res,raw.getAmount()));
                        fuel.setAmount(fuel.getAmount()-de);
                        raw.setAmount(0);
                    }else {
                        de=fuels;
                        fur.setItem(16,new ItemStack(res,de*7));
                        fuel.setAmount(fuel.getAmount()-de);
                        raw.setAmount(raw.getAmount()-de*7);
                    }
                    fur.setItem(10,fuel);
                    fur.setItem(13,raw);
                    player.openInventory(fur);
                }
                ongoing.replace(player.getName(), false);
            }
        }
    }
}
