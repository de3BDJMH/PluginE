package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Dark_Matter_Recipe {//暗物质
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"dark_matter"), Dark_Matter.get());
        shapedRecipe=shapedRecipe.shape("aaa",
                                        "ada",
                                        "aaa");
        shapedRecipe.setIngredient('a', Aeternalis_Fuel.get())
                    .setIngredient('d',Material.DIAMOND_BLOCK);
        return shapedRecipe;
    }
}
