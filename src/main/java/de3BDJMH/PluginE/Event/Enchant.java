package de3BDJMH.PluginE.Event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.enchantment.EnchantItemEvent;
import org.bukkit.inventory.ItemStack;

public class Enchant implements Listener {
    @EventHandler
    public void onEnchant(EnchantItemEvent e) {//暗物质红物质装备无法附魔
        ItemStack itemStack = e.getItem();
        if (itemStack.getItemMeta().hasLocalizedName()) {
            if (itemStack.getItemMeta().getLocalizedName().contains("暗物质")||itemStack.getItemMeta().getLocalizedName().contains("红物质")) {
                e.setCancelled(true);
            }
        }
    }
}
