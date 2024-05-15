package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.Functions.Init;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Transmutation_Table_Inventory {
    static FileConfiguration data;

    public static String Transmutation_Table_Name = ChatColor.BOLD +"转化桌";
    public static Inventory get(Player player) {
        Inventory ttinv = Bukkit.createInventory(player,6*9, Transmutation_Table_Name);
        List<Integer> left = Arrays.asList(10,11,12,19,21,28,29,30);
        List<Integer> right = Arrays.asList(14,15,16,23,25,32,33,34);
        for (int x=0;x<9;x++) {
            for (int y=0;y<6;y++) {
                ItemStack blank = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                if (left.contains(y*9+x) || right.contains(y*9+x)) {
                    blank = new ItemStack(Material.LIGHT_GRAY_STAINED_GLASS_PANE);
                }
                ItemMeta blankim = blank.getItemMeta();
                blankim.setDisplayName(" ");
                blank.setItemMeta(blankim);
                ttinv.setItem(y*9+x,blank);
            }
        }
        ItemStack li = new ItemStack(Material.RED_STAINED_GLASS_PANE);
        ItemMeta liim = li.getItemMeta();
        liim.setDisplayName(ChatColor.AQUA+"在这里放置物品使转化桌学习，或放置卡莱恩之星充能");
        li.setItemMeta(liim);
        ttinv.setItem(20,li);
        ItemStack ri = new ItemStack(Material.BLUE_STAINED_GLASS_PANE);
        ItemMeta riim = ri.getItemMeta();
        riim.setDisplayName(ChatColor.AQUA+"在这里放入物品锁定显示");
        ri.setItemMeta(riim);
        ttinv.setItem(24,ri);
        ItemStack search = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta searchim = search.getItemMeta();
        searchim.setDisplayName(ChatColor.GREEN+"点击搜索");
        search.setItemMeta(searchim);
        ttinv.setItem(4,search);
        ItemStack forget = new ItemStack(Material.PURPLE_STAINED_GLASS_PANE);
        ItemMeta forgetim = forget.getItemMeta();
        forgetim.setDisplayName(ChatColor.GOLD+"右键物品遗忘");
        forget.setItemMeta(forgetim);
        ttinv.setItem(48,forget);
        ItemStack learn = new ItemStack(Material.YELLOW_STAINED_GLASS_PANE);
        ItemMeta learnim = learn.getItemMeta();
        learnim.setDisplayName(ChatColor.GOLD+"左键物品学习");
        learn.setItemMeta(learnim);
        ttinv.setItem(50,learn);
        File PEI = new File(PluginE.instance.getDataFolder(),"PlayerEMCInfo.yml");
        data= YamlConfiguration.loadConfiguration(PEI);
        int emc = Init.emcs.get(player.getName());
        ItemStack pemc = new ItemStack(Material.GREEN_STAINED_GLASS_PANE);
        ItemMeta pemcim = pemc.getItemMeta();
        pemcim.setDisplayName(ChatColor.AQUA+String.valueOf(emc));
        pemc.setItemMeta(pemcim);
        ttinv.setItem(0,pemc);
        ItemStack rr = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
        ItemMeta rrim = rr.getItemMeta();
        rrim.setDisplayName(ChatColor.GREEN+"下一页");
        rr.setItemMeta(rrim);
        ttinv.setItem(43,rr);
        ItemStack rl = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
        ItemMeta rlim = rl.getItemMeta();
        rlim.setDisplayName(ChatColor.GREEN+"上一页");
        rl.setItemMeta(rlim);
        ttinv.setItem(41,rl);
        return ttinv;
    }
    public static void event(Player player) {
        Inventory ttinv = get(player);
        player.openInventory(ttinv);
        Transmutation_Table_Load.load(player,0,"none");
    }
}
