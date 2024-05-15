package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Evertide_Amulet;
import de3BDJMH.PluginE.Items.Iron_Band;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Evertide_Amulet_Recipe {
    public static ShapedRecipe get(){
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"evertide_amulet"), Evertide_Amulet.get());
        shapedRecipe=shapedRecipe.shape("www",
                                        "ddd",
                                        "www");
        shapedRecipe.setIngredient('w', Material.WATER_BUCKET)
                    .setIngredient('d', Dark_Matter.get());
        return shapedRecipe;
    }
}
