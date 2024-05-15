package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Katar_Recipe {
    public static ShapedRecipe get() {//合成无法实现，转事件，合成时产物栏可能为空，直接点就好可以合成的
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_katar"), Red_Katar.get());
        shapedRecipe=shapedRecipe.shape("abc",
                                        "drr",
                                        "rrr");
        shapedRecipe.setIngredient('a', Red_Matter_Shears.get())
                    .setIngredient('b', Red_Matter_Axe.get())
                    .setIngredient('c', Red_Matter_Sword.get())
                    .setIngredient('d', Red_Matter_Hoe.get())
                    .setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
