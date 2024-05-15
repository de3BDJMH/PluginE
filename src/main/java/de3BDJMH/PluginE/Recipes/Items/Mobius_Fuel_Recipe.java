package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Mobius_Fuel;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class Mobius_Fuel_Recipe {//莫比乌斯染料
    public static ShapelessRecipe get(){
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new NamespacedKey(PluginE.instance,"mobius_fuel"), Mobius_Fuel.get());
        shapelessRecipe=shapelessRecipe.addIngredient(4, Alchemical_Coal.get());
        shapelessRecipe=shapelessRecipe.addIngredient(1, Philosophers_Stone.get());
        return shapelessRecipe;
    }
}
