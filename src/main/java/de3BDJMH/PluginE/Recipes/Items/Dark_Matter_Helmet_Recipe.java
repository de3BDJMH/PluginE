package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Dark_Matter_Boots;
import de3BDJMH.PluginE.Items.Dark_Matter_Helmet;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Dark_Matter_Helmet_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"dark_matter_helmet"), Dark_Matter_Helmet.get());
        shapedRecipe=shapedRecipe.shape("ddd",
                                        "d d");
        shapedRecipe.setIngredient('d', Dark_Matter.get());
        return shapedRecipe;
    }
}
