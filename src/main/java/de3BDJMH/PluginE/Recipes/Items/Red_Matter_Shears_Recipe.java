package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Shears_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_shears"), Red_Matter_Shears.get());
        shapedRecipe=shapedRecipe.shape(" r",
                                        "s ");
        shapedRecipe.setIngredient('s', Dark_Matter_Shears.get())
                    .setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
