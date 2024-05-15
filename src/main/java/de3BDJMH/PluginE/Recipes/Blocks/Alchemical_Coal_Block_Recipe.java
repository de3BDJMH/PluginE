package de3BDJMH.PluginE.Recipes.Blocks;

import de3BDJMH.PluginE.Blocks.Alchemical_Coal_Block;
import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Alchemical_Coal_Block_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"alchemical_coal_block"), Alchemical_Coal_Block.get());
        shapedRecipe=shapedRecipe.shape("aaa",
                                        "aaa",
                                        "aaa");
        shapedRecipe.setIngredient('a', Alchemical_Coal.get());
        return shapedRecipe;
    }
}
