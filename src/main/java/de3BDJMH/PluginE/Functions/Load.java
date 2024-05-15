package de3BDJMH.PluginE.Functions;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.metadata.FixedMetadataValue;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

public class Load {
    static FileConfiguration data;

    public static String Load(String loc) {
        File BI = new File(PluginE.instance.getDataFolder(),"blockInfo.yml");
        data= YamlConfiguration.loadConfiguration(BI);
        String ID = data.getString(loc);
        return ID;
    }

    public static HashMap<String,HashMap<String,String>> LoadAll() {
        File BI = new File(PluginE.instance.getDataFolder(),"blockInfo.yml");
        data= YamlConfiguration.loadConfiguration(BI);
        HashMap<String,HashMap<String,String>> meta = new HashMap<>();
        Set<String> keys = data.getKeys(false);
        for (String key:keys) {
            ConfigurationSection configurationSection = data.getConfigurationSection(key);
            Set<String> temp = configurationSection.getKeys(false);
            HashMap<String,String> b = new HashMap<>();
            for (String k : temp) {
                b.put(k,configurationSection.getString(k));
            }
            meta.put(key,b);
        }
        return meta;
    }
    public static void SetMeta(){
        HashMap<String, HashMap<String, String>> info = LoadAll();
        Set<String> locs = info.keySet();
        for (String i : locs) {
            Location loc = new Location(Bukkit.getWorld(i.split("_")[0]),Integer.parseInt(i.split("_")[1]),Integer.parseInt(i.split("_")[2]),Integer.parseInt(i.split("_")[3]));
            Block block = Bukkit.getWorld("world").getBlockAt(loc);
            for (String m: info.get(i).keySet()) {
                block.setMetadata(m,new FixedMetadataValue(PluginE.instance,info.get(i).get(m)));
            }
        }
    }
}
