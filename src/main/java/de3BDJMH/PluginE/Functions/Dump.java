package de3BDJMH.PluginE.Functions;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;

public class Dump {
    static FileConfiguration data;

    public static void Dump(HashMap<String,String> meta, String loc) {
        File BI = new File(PluginE.instance.getDataFolder(),"blockInfo.yml");
        data= YamlConfiguration.loadConfiguration(BI);
        data.set(loc,meta);
        try {
            data.save(BI);
        } catch (IOException e) {
            PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
            e.printStackTrace();
        }
    }
    public static void Del(String loc) {
        File BI = new File(PluginE.instance.getDataFolder(),"blockInfo.yml");
        data= YamlConfiguration.loadConfiguration(BI);
        data.set(loc+".bname","null");
        try {
            data.save(BI);
        } catch (IOException e) {
            PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
            e.printStackTrace();
        }
    }
}
