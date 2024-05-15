package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.inventory.ShapelessRecipe;

public class Philosophers_Stone_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"philosophers_stone"),Philosophers_Stone.get());
        shapedRecipe=shapedRecipe.shape("grg",
                                        "rdr",
                                        "grg");
        shapedRecipe.setIngredient('g',Material.GLOWSTONE_DUST)
                    .setIngredient('r',Material.REDSTONE)
                    .setIngredient('d',Material.DIAMOND);
        return shapedRecipe;
    }
}
