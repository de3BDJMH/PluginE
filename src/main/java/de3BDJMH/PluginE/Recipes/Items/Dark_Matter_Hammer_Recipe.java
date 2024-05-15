package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Dark_Matter_Hammer;
import de3BDJMH.PluginE.Items.Dark_Matter_Pickaxe;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Dark_Matter_Hammer_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"dark_matter_hammer"), Dark_Matter_Hammer.get());
        shapedRecipe=shapedRecipe.shape("dsd",
                                        " s ",
                                        " s ");
        shapedRecipe.setIngredient('d', Dark_Matter.get())
                    .setIngredient('s', Material.DIAMOND);
        return shapedRecipe;
    }
}
