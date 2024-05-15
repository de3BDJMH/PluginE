package de3BDJMH.PluginE.Event.Blocks.Transmutation_Table;

import de3BDJMH.PluginE.Blocks.*;
import de3BDJMH.PluginE.Functions.EMCOperations;
import de3BDJMH.PluginE.Functions.Init;
import de3BDJMH.PluginE.Items.*;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Transmutation_Table_Load {
    static FileConfiguration data;
    public static List<ItemStack> all = new java.util.ArrayList<>(Collections.emptyList());
    ;

    public static void load(Player player, int page, String search) {
        String playername = player.getName();
        File PEI = new File(PluginE.instance.getDataFolder(), "PlayerEMCInfo.yml");
        data = YamlConfiguration.loadConfiguration(PEI);
        List<String> pi = data.getStringList(playername + ".r");
        List<ItemStack> ps = new java.util.ArrayList<>(Collections.emptyList());
        List<Integer> piemc = new java.util.ArrayList<>(Collections.emptyList());
        for (String i : pi) {
            if (EMCOperations.PEEMCs.containsKey(i)) {
                switch (i) {
                    case "炼金煤炭":
                        ps.add(Alchemical_Coal.get());
                        break;
                    case "莫比乌斯燃料":
                        ps.add(Mobius_Fuel.get());
                        break;
                    case "永恒燃料":
                        ps.add(Aeternalis_Fuel.get());
                        break;
                    case "炼金煤炭块":
                        ps.add(Alchemical_Coal_Block.get());
                        break;
                    case "莫比乌斯燃料块":
                        ps.add(Mobius_Fuel_Block.get());
                        break;
                    case "永恒燃料块":
                        ps.add(Aeternalis_Fuel_Block.get());
                        break;
                    case "红物质":
                        ps.add(Red_Matter.get());
                        break;
                    case "暗物质":
                        ps.add(Dark_Matter.get());
                        break;
                    case "红物质块":
                        ps.add(Red_Matter_Block.get());
                        break;
                    case "暗物质块":
                        ps.add(Dark_Matter_Block.get());
                        break;
                    case "贤者之石":
                        ps.add(Philosophers_Stone.get());
                        break;
                    case "转化桌":
                        ps.add(Transmutation_Table.get());
                        break;
                    case "暗物质头盔":
                        ps.add(Dark_Matter_Helmet.get());
                        break;
                    case "暗物质胸甲":
                        ps.add(Dark_Matter_Chestplate.get());
                        break;
                    case "暗物质护腿":
                        ps.add(Dark_Matter_Leggings.get());
                        break;
                    case "暗物质靴子":
                        ps.add(Dark_Matter_Boots.get());
                        break;
                    case "红物质头盔":
                        ps.add(Red_Matter_Helmet.get());
                        break;
                    case "红物质胸甲":
                        ps.add(Red_Matter_Chestplate.get());
                        break;
                    case "红物质护腿":
                        ps.add(Red_Matter_Leggings.get());
                        break;
                    case "红物质靴子":
                        ps.add(Red_Matter_Boots.get());
                        break;
                    case "暗物质镐":
                        ps.add(Dark_Matter_Pickaxe.get());
                        break;
                    case "红物质镐":
                        ps.add(Red_Matter_Pickaxe.get());
                        break;
                    case "暗物质斧":
                        ps.add(Dark_Matter_Axe.get());
                        break;
                    case "红物质斧":
                        ps.add(Red_Matter_Axe.get());
                        break;
                    case "暗物质锹":
                        ps.add(Dark_Matter_Shovel.get());
                        break;
                    case "红物质锹":
                        ps.add(Red_Matter_Shovel.get());
                        break;
                    case "暗物质锄":
                        ps.add(Dark_Matter_Hoe.get());
                        break;
                    case "红物质锄":
                        ps.add(Red_Matter_Hoe.get());
                        break;
                    case "暗物质剪刀":
                        ps.add(Dark_Matter_Shears.get());
                        break;
                    case "红物质剪刀":
                        ps.add(Red_Matter_Shears.get());
                        break;
                    case "暗物质锤":
                        ps.add(Dark_Matter_Hammer.get());
                        break;
                    case "红物质锤":
                        ps.add(Red_Matter_Hammer.get());
                        break;
                    case "红物质钉头锤":
                        ps.add(Red_Morningstar.get());
                        break;
                    case "暗物质剑":
                        ps.add(Dark_Matter_Sword.get());
                        break;
                    case "红物质剑":
                        ps.add(Red_Matter_Sword.get());
                        break;
                    case "红物质拳剑":
                        ps.add(Red_Katar.get());
                        break;
                }
                piemc.add(EMCOperations.PEEMCs.get(i));
            } else {
                ps.add(new ItemStack(Material.getMaterial(i)));
                piemc.add(EMCOperations.EMCs.get(i));
            }
        }
        List<ItemStack> fps = new java.util.ArrayList<>(Collections.emptyList());
        all.clear();
        for (int x = 0; x < ps.size(); x++) {
            int maxi = x;
            for (int y = x; y < ps.size(); y++) {
                if (piemc.get(y) > piemc.get(maxi)) {
                    maxi = y;
                }
            }
            all.add(ps.get(maxi));
            if (piemc.get(maxi) <= Init.emcs.get(playername)) {
                fps.add(ps.get(maxi));
            }
            ItemStack ittemp = ps.get(maxi);
            ps.set(maxi, ps.get(x));
            ps.set(x, ittemp);
            int itemp = piemc.get(maxi);
            piemc.set(maxi, piemc.get(x));
            piemc.set(x, itemp);
        }
        if (!search.equals("none")) {
            fps = Transmutation_Table_Search.find(search);
        }
        Inventory inv = Transmutation_Table_Inventory.get(player);
        List<Integer> right = Arrays.asList(15, 14, 23, 32, 33, 34, 25, 16);
        int i = page * right.size();
        for (int invp : right) {
            if (i >= fps.size()) {
                break;
            }
            inv.setItem(invp, fps.get(i));
            i++;
        }
        player.openInventory(inv);
    }
}
