package de3BDJMH.PluginE.Recipes.Blocks;

import de3BDJMH.PluginE.Blocks.Dark_Matter_Block;
import de3BDJMH.PluginE.Blocks.Red_Matter_Block;
import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Block_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_block"), Red_Matter_Block.get());
        shapedRecipe=shapedRecipe.shape("rrr",
                                        "rrr",
                                        "rrr");
        shapedRecipe.setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
