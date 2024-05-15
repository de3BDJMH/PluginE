package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Morningstar_Recipe {
    public static ShapedRecipe get() {//合成无法实现，转事件，合成时产物栏可能为空，直接点就好可以合成的
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_morningstar"), Red_Morningstar.get());
        shapedRecipe=shapedRecipe.shape("abc",
                                        "rrr",
                                        "rrr");
        shapedRecipe.setIngredient('a', Red_Matter_Hammer.get())
                    .setIngredient('b', Red_Matter_Pickaxe.get())
                    .setIngredient('c', Red_Matter_Shovel.get())
                    .setIngredient('r', Red_Matter.get());
        return shapedRecipe;
    }
}
