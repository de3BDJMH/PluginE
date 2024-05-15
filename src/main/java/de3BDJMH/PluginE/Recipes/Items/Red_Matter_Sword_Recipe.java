package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Dark_Matter_Sword;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.Items.Red_Matter_Sword;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Sword_Recipe {
    public static ShapedRecipe get() {
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_sword"), Red_Matter_Sword.get());
        shapedRecipe=shapedRecipe.shape("r",
                                        "r",
                                        "s");
        shapedRecipe.setIngredient('r', Red_Matter.get())
                    .setIngredient('s', Dark_Matter_Sword.get());
        return shapedRecipe;
    }
}
