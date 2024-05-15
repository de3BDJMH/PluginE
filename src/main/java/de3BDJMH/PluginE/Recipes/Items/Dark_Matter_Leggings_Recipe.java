package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Dark_Matter_Chestplate;
import de3BDJMH.PluginE.Items.Dark_Matter_Leggings;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Dark_Matter_Leggings_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"dark_matter_leggings"), Dark_Matter_Leggings.get());
        shapedRecipe=shapedRecipe.shape("ddd",
                                        "d d",
                                        "d d");
        shapedRecipe.setIngredient('d', Dark_Matter.get());
        return shapedRecipe;
    }
}
