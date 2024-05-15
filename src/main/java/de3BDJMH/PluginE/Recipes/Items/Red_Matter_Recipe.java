package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter"), Red_Matter.get());
        shapedRecipe=shapedRecipe.shape("aaa",
                                        "ddd",
                                        "aaa");
        shapedRecipe.setIngredient('a', Aeternalis_Fuel.get())
                    .setIngredient('d', Dark_Matter.get());
        return shapedRecipe;
    }
}
