package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Dark_Matter;
import de3BDJMH.PluginE.Items.Dark_Matter_Helmet;
import de3BDJMH.PluginE.Items.Red_Matter;
import de3BDJMH.PluginE.Items.Red_Matter_Helmet;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapedRecipe;

public class Red_Matter_Helmet_Recipe {
    public static ShapedRecipe get() {//处于未知原因，貌似背包里的皮革靴子和.get()获取的不是同一个，虽然应该是同一个才对，所以合成被移到Event.Items.Armor.Armor_Craft里了
        ShapedRecipe shapedRecipe = new ShapedRecipe(new NamespacedKey(PluginE.instance,"red_matter_helmet"), Red_Matter_Helmet.get());
        shapedRecipe=shapedRecipe.shape("rrr",
                                        "rdr");
        shapedRecipe.setIngredient('r', Red_Matter.get())
                    .setIngredient('d',Dark_Matter_Helmet.get());
        return shapedRecipe;
    }
}
