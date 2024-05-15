package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Aeternalis_Fuel;
import de3BDJMH.PluginE.Items.Alchemical_Coal;
import de3BDJMH.PluginE.Items.Mobius_Fuel;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ShapelessRecipe;

public class Aeternalis_Fuel_Recipe {//永恒燃料
    public static ShapelessRecipe get(){
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new NamespacedKey(PluginE.instance,"aeternalis_fuel"), Aeternalis_Fuel.get());
        shapelessRecipe=shapelessRecipe.addIngredient(4, Mobius_Fuel.get());
        shapelessRecipe=shapelessRecipe.addIngredient(1, Philosophers_Stone.get());
        return shapelessRecipe;
    }
}
