package de3BDJMH.PluginE.Event.Items.Armor;

import de3BDJMH.PluginE.Items.Red_Matter_Boots;
import de3BDJMH.PluginE.Items.Red_Matter_Chestplate;
import de3BDJMH.PluginE.Items.Red_Matter_Helmet;
import de3BDJMH.PluginE.Items.Red_Matter_Leggings;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

public class Armor_Craft implements Listener {//处理合成红物质盔甲的事件
    @EventHandler
    public void onCraft(CraftItemEvent e) {
        ItemStack[] matrix = e.getInventory().getMatrix();
        int red = 0;
        ItemStack dark = null;
        for (ItemStack i : matrix) {
            if (i==null) {
                continue;
            }
            if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().contains("暗物质")) {
                dark = i;
            }else if (i.getItemMeta().hasLocalizedName() && i.getItemMeta().getLocalizedName().equals("红物质")) {
                red+=1;
            }
        }
        if (dark!=null) {
            String name = dark.getItemMeta().getLocalizedName();
            Player player = (Player) e.getWhoClicked();
            if (name.equals("暗物质头盔") && red==5) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
                e.setCancelled(true);
                player.getInventory().addItem(Red_Matter_Helmet.get());
                for (ItemStack itemStack : matrix) {
                    if (itemStack == null) {
                        continue;
                    } else {
                        itemStack.setAmount(itemStack.getAmount() - 1);
                    }
                }
            }else if (name.equals("暗物质胸甲") && red==8) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
                e.setCancelled(true);
                player.getInventory().addItem(Red_Matter_Chestplate.get());
                for (ItemStack itemStack : matrix) {
                    if (itemStack == null) {
                        continue;
                    } else {
                        itemStack.setAmount(itemStack.getAmount() - 1);
                    }
                }
            }else if (name.equals("暗物质护腿") && red==7) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
                e.setCancelled(true);
                player.getInventory().addItem(Red_Matter_Leggings.get());
                for (ItemStack itemStack : matrix) {
                    if (itemStack == null) {
                        continue;
                    } else {
                        itemStack.setAmount(itemStack.getAmount() - 1);
                    }
                }
            }else if (name.equals("暗物质靴子") && red==4) {
                e.getInventory().setResult(new ItemStack(Material.AIR));
                e.setCancelled(true);
                player.getInventory().addItem(Red_Matter_Boots.get());
                for (ItemStack itemStack : matrix) {
                    if (itemStack == null) {
                        continue;
                    } else {
                        itemStack.setAmount(itemStack.getAmount() - 1);
                    }
                }
            }
        }
    }
}
