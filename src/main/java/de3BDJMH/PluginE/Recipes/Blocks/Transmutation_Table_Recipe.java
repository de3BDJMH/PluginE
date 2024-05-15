package de3BDJMH.PluginE.Recipes.Blocks;

import de3BDJMH.PluginE.Blocks.Red_Matter_Block;
import de3BDJMH.PluginE.Blocks.Transmutation_Table;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Transmutation_Table_Recipe {//转化桌
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"transmutation_table"), Transmutation_Table.get());
        shapedRecipe=shapedRecipe.shape("sos",
                                        "opo",
                                        "sos");
        shapedRecipe.setIngredient('s', Material.STONE)
                    .setIngredient('o',Material.OBSIDIAN)
                    .setIngredient('p', Philosophers_Stone.get());
        return shapedRecipe;
    }
}
