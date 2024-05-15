package de3BDJMH.PluginE.Functions;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

public class PlayerEMCInfo {
    static FileConfiguration data;

    public static void input(String playername,String itemname,int emc,int page) {//学习物品，并增加emc
        File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
        data= YamlConfiguration.loadConfiguration(PEI);
        List<String> pi = data.getStringList(playername+".r");
        if (!pi.contains(itemname)) {
            pi.add(itemname);
        }
        data.set(playername+".r",pi);
        Init.emcs.replace(playername,Init.emcs.get(playername)+emc);
        data.set(playername+".page",page);
        try {
            data.save(PEI);
        } catch (IOException e) {
            PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
            e.printStackTrace();
        }
    }

    public static void pickout(String playername,int emc) {//扣除emc
        Init.emcs.replace(playername,Init.emcs.get(playername)-emc);
    }

    public static void forget(String playername,String itemname) {//遗忘物品
        File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
        data= YamlConfiguration.loadConfiguration(PEI);
        List<String> pi = data.getStringList(playername+".r");
        if (pi.contains(itemname)) {
            pi.remove(itemname);
        }
        data.set(playername+".r",pi);
        try {
            data.save(PEI);
        } catch (IOException e) {
            PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
            e.printStackTrace();
        }
    }
    public static int getEMC(String playername) {//获取emc
        return Init.emcs.get(playername);
    }
    public static void increaseEMC(String playername, int emc) {//增加emc
        Init.emcs.replace(playername, Init.emcs.get(playername)+emc);
    }
}
