package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Iron_Band_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"iron_band"), Iron_Band.get());
        shapedRecipe=shapedRecipe.shape("iii",
                                        "ibi",
                                        "iii");
        shapedRecipe.setIngredient('i', Material.IRON_INGOT)
                    .setIngredient('b', Material.LAVA_BUCKET);
        return shapedRecipe;
    }
}
