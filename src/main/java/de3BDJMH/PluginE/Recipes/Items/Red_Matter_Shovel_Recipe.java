package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Shovel_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_shovel"), Red_Matter_Shovel.get());
        shapedRecipe=shapedRecipe.shape("r",
                                        "s",
                                        "d");
        shapedRecipe.setIngredient('d', Dark_Matter.get())
                    .setIngredient('s', Dark_Matter_Shovel.get())
                    .setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
