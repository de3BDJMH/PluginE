package de3BDJMH.PluginE.Recipes.Blocks;

import de3BDJMH.PluginE.Blocks.Aeternalis_Fuel_Block;
import de3BDJMH.PluginE.Blocks.Dark_Matter_Block;
import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Dark_Matter_Block_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"dark_matter_block"), Dark_Matter_Block.get());
        shapedRecipe=shapedRecipe.shape("ddd",
                                        "ddd",
                                        "ddd");
        shapedRecipe.setIngredient('d', Dark_Matter.get());
        return shapedRecipe;
    }
}
