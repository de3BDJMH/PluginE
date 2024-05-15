package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.Recipes.Items.Alchemical_Coal_Recipe;
import net.kyori.adventure.text.ComponentLike;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

public class Craft implements Listener {
    @EventHandler
    public void onCraft(CraftItemEvent e) {
        ItemStack[] matrix = e.getInventory().getMatrix();
        int p = 0,temp=0;
        int nn = 0;
        boolean has = false;
        for (ItemStack i : matrix) {
            if (i==null) {
                nn++;
                continue;
            }
            if (i.getItemMeta().getLocalizedName().equals("贤者之石")) {
                has=true;
                e.setCancelled(true);
                temp=p;
            }
            p+=1;
        }
        if (nn==8 && has) {
            e.getWhoClicked().sendMessage(ChatColor.RED+"你不能用贤者之石合成红石粉！");
            return;
        }
        if (has) {
            for (int c = 0;c<matrix.length;c++) {
                if (matrix[c]==null ||c==temp) {
                    continue;
                }else {
                    matrix[c].setAmount(matrix[c].getAmount()-1);
                }
            }
            e.getInventory().setMatrix(matrix);
            e.getWhoClicked().getInventory().addItem(e.getRecipe().getResult());
        }
    }
}
