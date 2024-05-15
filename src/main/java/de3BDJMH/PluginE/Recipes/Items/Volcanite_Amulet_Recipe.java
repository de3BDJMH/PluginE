package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Volcanite_Amulet;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Volcanite_Amulet_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"volcanite_amulet"), Volcanite_Amulet.get());
        shapedRecipe=shapedRecipe.shape("lll",
                                        "ddd",
                                        "lll");
        shapedRecipe.setIngredient('l', Material.LAVA_BUCKET)
                    .setIngredient('d', Dark_Matter.get());
        return shapedRecipe;
    }
}
