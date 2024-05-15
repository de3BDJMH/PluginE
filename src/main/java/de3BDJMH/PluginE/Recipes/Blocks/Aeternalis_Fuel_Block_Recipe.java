package de3BDJMH.PluginE.Recipes.Blocks;

import de3BDJMH.PluginE.Blocks.Aeternalis_Fuel_Block;
import de3BDJMH.PluginE.Blocks.Mobius_Fuel_Block;
import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Mobius_Fuel;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Aeternalis_Fuel_Block_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"aeternalis_fuel_block"), Aeternalis_Fuel_Block.get());
        shapedRecipe=shapedRecipe.shape("aaa",
                                        "aaa",
                                        "aaa");
        shapedRecipe.setIngredient('a', Aeternalis_Fuel.get());
        return shapedRecipe;
    }
}
