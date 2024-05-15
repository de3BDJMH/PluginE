package de3BDJMH.PluginE.Event.Items.Philosophers_Stone;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.checkerframework.checker.units.qual.A;

import java.util.Arrays;
import java.util.List;

public class Philosophers_Stone_Inventory {
    public static String Mainname = ChatColor.GOLD+""+ChatColor.BOLD+"选择功能";
    public static String Furname = ChatColor.GOLD+""+ChatColor.BOLD+"快捷熔炼";
    public static Inventory getMain(Player player) {
        Inventory psinv = Bukkit.createInventory(player,1*9,Mainname);
        ItemStack craft = new ItemStack(Material.CRAFTING_TABLE);
        ItemMeta craftim = craft.getItemMeta();
        craftim.setDisplayName(ChatColor.AQUA+"点击打开合成界面");
        craft.setItemMeta(craftim);
        psinv.setItem(2,craft);
        ItemStack fur = new ItemStack(Material.FURNACE);
        ItemMeta furim = craft.getItemMeta();
        furim.setDisplayName(ChatColor.AQUA+"点击打开烧炼界面");
        fur.setItemMeta(furim);
        psinv.setItem(6,fur);
        return psinv;
    }
    public static Inventory getFur(Player player) {
        Inventory fur = Bukkit.createInventory(player,4*9,Furname);
        List<Integer> left = Arrays.asList(0,1,2,9,11,18,19,20);
        List<Integer> middle = Arrays.asList(3,4,5,12,14,21,22,23);
        List<Integer> right = Arrays.asList(6,7,8,15,17,24,25,26);
        List<Integer> air = Arrays.asList(10,13,16);
        for (int n=0 ; n< fur.getSize();n++) {
            if (left.contains(n)) {
                ItemStack lefti = new ItemStack(Material.GRAY_STAINED_GLASS_PANE);
                ItemMeta leftim = lefti.getItemMeta();
                leftim.setDisplayName(ChatColor.AQUA+"在这里放入燃料，仅支持煤炭和木炭，1个燃料烧7个物品");
                lefti.setItemMeta(leftim);
                fur.setItem(n,lefti);
            }else if (middle.contains(n)) {
                ItemStack midi = new ItemStack(Material.LIGHT_BLUE_STAINED_GLASS_PANE);
                ItemMeta midim = midi.getItemMeta();
                midim.setDisplayName(ChatColor.AQUA+"在这里放入原料");
                midi.setItemMeta(midim);
                fur.setItem(n,midi);
            }else if (right.contains(n)) {
                ItemStack righti = new ItemStack(Material.ORANGE_STAINED_GLASS_PANE);
                ItemMeta rightim = righti.getItemMeta();
                rightim.setDisplayName(ChatColor.GOLD+"产物在这里");
                righti.setItemMeta(rightim);
                fur.setItem(n,righti);
            }else if (!air.contains(n)) {
                ItemStack blank = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
                ItemMeta blankim = blank.getItemMeta();
                blankim.setDisplayName(ChatColor.GRAY+"状态栏，这里变成绿色时可以点击开始烧炼");
                blank.setItemMeta(blankim);
                fur.setItem(n,blank);
            }
        }
        return fur;
    }
}
