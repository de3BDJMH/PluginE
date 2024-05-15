package de3BDJMH.PluginE.Recipes.Items;

import de3BDJMH.PluginE.Items.Philosophers_Stone;
import de3BDJMH.PluginE.PluginE;
import de3BDJMH.PluginE.Items.Alchemical_Coal;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapelessRecipe;

public class Alchemical_Coal_Recipe {//炼金煤炭
    public static ShapelessRecipe get(){
        ShapelessRecipe shapelessRecipe = new ShapelessRecipe(new NamespacedKey(PluginE.instance,"alchemical_coal"),Alchemical_Coal.get());
        shapelessRecipe=shapelessRecipe.addIngredient(4,new ItemStack(Material.COAL));
        shapelessRecipe=shapelessRecipe.addIngredient(1, Philosophers_Stone.get());
        return shapelessRecipe;
    }
}
