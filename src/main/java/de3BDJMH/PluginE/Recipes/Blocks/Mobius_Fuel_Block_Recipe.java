package de3BDJMH.PluginE.Recipes.Blocks;

import de3BDJMH.PluginE.Blocks.Alchemical_Coal_Block;
import de3BDJMH.PluginE.Blocks.Mobius_Fuel_Block;
import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Mobius_Fuel;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Mobius_Fuel_Block_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"mobius_fuel_block"), Mobius_Fuel_Block.get());
        shapedRecipe=shapedRecipe.shape("mmm",
                                        "mmm",
                                        "mmm");
        shapedRecipe.setIngredient('m', Mobius_Fuel.get());
        return shapedRecipe;
    }
}
