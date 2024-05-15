package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Axe_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_axe"), Red_Matter_Axe.get());
        shapedRecipe=shapedRecipe.shape("rr",
                                        "rs",
                                        " d");
        shapedRecipe.setIngredient('d', Dark_Matter.get())
                    .setIngredient('s', Dark_Matter_Axe.get())
                    .setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
