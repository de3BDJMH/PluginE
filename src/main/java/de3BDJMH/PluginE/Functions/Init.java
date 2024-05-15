package de3BDJMH.PluginE.Functions;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Bukkit;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Init {
    static FileConfiguration data;
    public static Map<String,Integer> emcs = new HashMap<>();
    public static void emc() {
        File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
        data= YamlConfiguration.loadConfiguration(PEI);
        ConfigurationSection allemc = data.getConfigurationSection("");
        for (String s : allemc.getKeys(false)) {
            emcs.put(s, data.getInt(s+".emc"));
        }
    }
}
