package de3BDJMH.PluginE;

import de3BDJMH.PluginE.Commands.*;
import de3BDJMH.PluginE.Event.*;
import de3BDJMH.PluginE.Event.Blocks.Transmutation_Table.*;
import de3BDJMH.PluginE.Event.Items.Armor.Armor_Craft;
import de3BDJMH.PluginE.Event.Items.Armor.Armor_Damaged;
import de3BDJMH.PluginE.Event.Items.Axe.Axe_Mine;
import de3BDJMH.PluginE.Event.Items.Evertide_Amulet.Evertide_Amulet_ClickBlock;
import de3BDJMH.PluginE.Event.Items.Evertide_Amulet.Evertide_Amulet_ClickEntity;
import de3BDJMH.PluginE.Event.Items.Hammer.Hammer_Mine;
import de3BDJMH.PluginE.Event.Items.Hoe.Hoe_Farm;
import de3BDJMH.PluginE.Event.Items.Katar.Katar_Craft;
import de3BDJMH.PluginE.Event.Items.Katar.Katar_Damage;
import de3BDJMH.PluginE.Event.Items.Katar.Katar_Mine;
import de3BDJMH.PluginE.Event.Items.Katar.Katar_ModeChange;
import de3BDJMH.PluginE.Event.Items.Morningstar.Morningstar_Click;
import de3BDJMH.PluginE.Event.Items.Morningstar.Morningstar_Craft;
import de3BDJMH.PluginE.Event.Items.Morningstar.Morningstar_Mine;
import de3BDJMH.PluginE.Event.Items.Morningstar.Morningstar_ModeChange;
import de3BDJMH.PluginE.Event.Items.Philosophers_Stone.*;
import de3BDJMH.PluginE.Event.Items.Pickaxe.Pickaxe_Mine;
import de3BDJMH.PluginE.Event.Items.Pickaxe.Pickaxe_ModeChange;
import de3BDJMH.PluginE.Event.Items.Shears.Shears_Shear;
import de3BDJMH.PluginE.Event.Items.Shovel.Shovel_Mine;
import de3BDJMH.PluginE.Event.Items.Sword.Sword_Damage;
import de3BDJMH.PluginE.Event.Items.Sword.Sword_ModeChange;
import de3BDJMH.PluginE.Event.Items.Volcanite_Amulet.Volcanite_Amulet_ClickBlock;
import de3BDJMH.PluginE.Event.Items.Volcanite_Amulet.Volcanite_Amulet_ClickEntity;
import de3BDJMH.PluginE.Functions.EMCOperations;
import de3BDJMH.PluginE.Functions.FurRecipes;
import de3BDJMH.PluginE.Functions.Init;
import de3BDJMH.PluginE.Functions.Load;
import de3BDJMH.PluginE.Recipes.Blocks.*;
import de3BDJMH.PluginE.Recipes.Items.*;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.logging.Level;

public final class PluginE extends JavaPlugin {
    static FileConfiguration data;
    public static JavaPlugin instance;
    @Override
    @SuppressWarnings("deprecation")
    public void onEnable() {
        // Plugin startup logic
        instance=this;
        Load.SetMeta();
        EMCOperations.initValina();
        EMCOperations.initPE();
        Init.emc();
        FurRecipes.init();
        //命令
        if (Bukkit.getPluginCommand("plugine")!=null) {
            Bukkit.getPluginCommand("plugine").setExecutor(new Items());
        }
        Objects.requireNonNull(Bukkit.getPluginCommand("plugine")).setTabCompleter(new TabComplete());
        if (Bukkit.getPluginCommand("emc")!=null) {
            Bukkit.getPluginCommand("emc").setExecutor(new EMC());
        }
        //文件
        saveResource("blockInfo.yml",false);
        saveResource("advancement.json",false);
        saveResource("PlayerEMCInfo.yml",false);
        saveResource("zh_cn.yml",false);
        saveResource("PlayerInfo.yml",false);
        Advancement.read();
        //事件
        Bukkit.getPluginManager().registerEvents(new Craft(),this);
        Bukkit.getPluginManager().registerEvents(new Burn(),this);
        Bukkit.getPluginManager().registerEvents(new Block_Place(),this);
        Bukkit.getPluginManager().registerEvents(new Interact_Block(),this);
        Bukkit.getPluginManager().registerEvents(new Break_Block(),this);
        Bukkit.getPluginManager().registerEvents(new Advances(),this);
        Bukkit.getPluginManager().registerEvents(new Transmutation_Table_Learn(),this);
        Bukkit.getPluginManager().registerEvents(new Transmutation_Table_Pages(),this);
        Bukkit.getPluginManager().registerEvents(new Transmutation_Table_Pickout(),this);
        Bukkit.getPluginManager().registerEvents(new Transmutation_Table_Forget(),this);
        Bukkit.getPluginManager().registerEvents(new Philosophers_Stone_Place(),this);
        Bukkit.getPluginManager().registerEvents(new Philosophers_Stone_Craft(),this);
        Bukkit.getPluginManager().registerEvents(new Philosophers_Stone_Click(),this);
        Bukkit.getPluginManager().registerEvents(new Philosophers_Stone_Close(),this);
        Bukkit.getPluginManager().registerEvents(new Philosophers_Stone_Transform(),this);
        Bukkit.getPluginManager().registerEvents(new Transmutation_Table_Search(),this);
        Bukkit.getPluginManager().registerEvents(new Armor_Damaged(),this);
        Bukkit.getPluginManager().registerEvents(new Armor_Craft(),this);
        Bukkit.getPluginManager().registerEvents(new Enchant(),this);
        Bukkit.getPluginManager().registerEvents(new Pickaxe_ModeChange(),this);
        Bukkit.getPluginManager().registerEvents(new Pickaxe_Mine(),this);
        Bukkit.getPluginManager().registerEvents(new Hammer_Mine(),this);
        Bukkit.getPluginManager().registerEvents(new Charge(),this);
        Bukkit.getPluginManager().registerEvents(new Energy_Effect(),this);
        Bukkit.getPluginManager().registerEvents(new Hoe_Farm(),this);
        Bukkit.getPluginManager().registerEvents(new Shovel_Mine(),this);
        Bukkit.getPluginManager().registerEvents(new Axe_Mine(),this);
        Bukkit.getPluginManager().registerEvents(new Shears_Shear(),this);
        Bukkit.getPluginManager().registerEvents(new Morningstar_ModeChange(),this);
        Bukkit.getPluginManager().registerEvents(new Morningstar_Click(),this);
        Bukkit.getPluginManager().registerEvents(new Morningstar_Mine(),this);
        Bukkit.getPluginManager().registerEvents(new Morningstar_Craft(),this);
        Bukkit.getPluginManager().registerEvents(new Sword_ModeChange(),this);
        Bukkit.getPluginManager().registerEvents(new Sword_Damage(),this);
        Bukkit.getPluginManager().registerEvents(new Katar_Craft(),this);
        Bukkit.getPluginManager().registerEvents(new Katar_ModeChange(),this);
        Bukkit.getPluginManager().registerEvents(new Katar_Damage(),this);
        Bukkit.getPluginManager().registerEvents(new Katar_Mine(),this);
        Bukkit.getPluginManager().registerEvents(new Evertide_Amulet_ClickBlock(),this);
        Bukkit.getPluginManager().registerEvents(new Evertide_Amulet_ClickEntity(),this);
        Bukkit.getPluginManager().registerEvents(new Volcanite_Amulet_ClickBlock(),this);
        Bukkit.getPluginManager().registerEvents(new Volcanite_Amulet_ClickEntity(),this);
        //配方
        Bukkit.addRecipe(Alchemical_Coal_Recipe.get());
        Bukkit.addRecipe(Mobius_Fuel_Recipe.get());
        Bukkit.addRecipe(Aeternalis_Fuel_Recipe.get());
        Bukkit.addRecipe(Philosophers_Stone_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Recipe.get());
        Bukkit.addRecipe(Alchemical_Coal_Block_Recipe.get());
        Bukkit.addRecipe(Mobius_Fuel_Block_Recipe.get());
        Bukkit.addRecipe(Aeternalis_Fuel_Block_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Block_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Block_Recipe.get());
        Bukkit.addRecipe(Transmutation_Table_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Helmet_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Chestplate_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Leggings_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Boots_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Helmet_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Chestplate_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Leggings_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Boots_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Pickaxe_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Pickaxe_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Axe_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Axe_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Shovel_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Shovel_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Hoe_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Hoe_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Shears_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Shears_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Hammer_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Hammer_Recipe.get());
        Bukkit.addRecipe(Red_Morningstar_Recipe.get());
        Bukkit.addRecipe(Dark_Matter_Sword_Recipe.get());
        Bukkit.addRecipe(Red_Matter_Sword_Recipe.get());
        Bukkit.addRecipe(Red_Katar_Recipe.get());
        Bukkit.addRecipe(Iron_Band_Recipe.get());
        Bukkit.addRecipe(Evertide_Amulet_Recipe.get());
        Bukkit.addRecipe(Volcanite_Amulet_Recipe.get());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        //注销合成
        Bukkit.resetRecipes();
        //注销进度
        try {
            Bukkit.getUnsafe().removeAdvancement(new NamespacedKey(this, "craft_transmutation_table"));
            Bukkit.reloadData();
        } catch (Exception ignored) {}
        //保存EMC
        File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
        data= YamlConfiguration.loadConfiguration(PEI);
        for (String name: Init.emcs.keySet()) {
            data.set(name+".emc",Init.emcs.get(name));
        }
        try {
            data.save(PEI);
        } catch (IOException e) {
            PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
            e.printStackTrace();
        }
    }
}
