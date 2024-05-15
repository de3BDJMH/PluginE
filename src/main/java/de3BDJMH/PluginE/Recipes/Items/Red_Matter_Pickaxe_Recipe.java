package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Dark_Matter_Pickaxe;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.Items.Red_Matter_Pickaxe;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Pickaxe_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_pickaxe"), Red_Matter_Pickaxe.get());
        shapedRecipe=shapedRecipe.shape("rrr",
                                        " s ",
                                        " d ");
        shapedRecipe.setIngredient('d', Dark_Matter.get())
                    .setIngredient('s', Dark_Matter_Pickaxe.get())
                    .setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
