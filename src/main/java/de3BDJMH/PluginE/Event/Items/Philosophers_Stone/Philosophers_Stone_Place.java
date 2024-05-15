package de3BDJMH.PluginE.Event.Items.Philosophers_Stone;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.EquipmentSlot;

import java.util.Arrays;
import java.util.List;

public class Philosophers_Stone_Place implements Listener {
    List<Material> saplings = Arrays.asList(Material.OAK_SAPLING,Material.SPRUCE_SAPLING,Material.BIRCH_SAPLING,Material.JUNGLE_SAPLING,Material.ACACIA_SAPLING,Material.DARK_OAK_SAPLING,Material.CHERRY_SAPLING);
    List<Material> logs = Arrays.asList(Material.OAK_LOG,Material.SPRUCE_LOG,Material.BIRCH_LOG,Material.JUNGLE_LOG,Material.ACACIA_LOG,Material.DARK_OAK_LOG,Material.CHERRY_LOG);
    List<Material> leaves = Arrays.asList(Material.OAK_LEAVES,Material.SPRUCE_LEAVES,Material.BIRCH_LEAVES,Material.JUNGLE_LEAVES,Material.ACACIA_LEAVES,Material.DARK_OAK_LEAVES,Material.CHERRY_LEAVES);
    List<Material> wools = Arrays.asList(Material.WHITE_WOOL,Material.LIGHT_GRAY_WOOL,Material.GRAY_WOOL,Material.BLACK_WOOL,
                                         Material.BROWN_WOOL,Material.RED_WOOL,Material.ORANGE_WOOL,Material.YELLOW_WOOL,
                                         Material.LIME_WOOL,Material.GREEN_WOOL,Material.CYAN_WOOL,Material.LIGHT_BLUE_WOOL,
                                         Material.BLUE_WOOL,Material.PURPLE_WOOL,Material.MAGENTA_WOOL,Material.PINK_WOOL);
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {//贤者之石转化方块
        if (e.getItemInHand().getItemMeta().getLocalizedName().equals("贤者之石")) {
            e.setCancelled(true);
            if (e.getHand()== EquipmentSlot.OFF_HAND) {//在主手才算
                return;
            }
            Block block = e.getBlockAgainst();
            if (!e.getPlayer().isSneaking()) {
                if (block.getBlockData().getMaterial()== Material.STONE) {
                    block.setType(Material.COBBLESTONE);
                }else if (block.getBlockData().getMaterial()==Material.COBBLESTONE) {
                    block.setType(Material.STONE);
                }else if (block.getBlockData().getMaterial()==Material.GRASS_BLOCK) {
                    block.setType(Material.SAND);
                }else if (block.getBlockData().getMaterial()==Material.DIRT) {
                    block.setType(Material.STONE);
                }else if (block.getBlockData().getMaterial()==Material.SAND) {//这个官方写这是又可以变草方块又可以变泥土，这里就统一草方块了
                    block.setType(Material.GRASS_BLOCK);
                }else if (block.getBlockData().getMaterial()==Material.OBSIDIAN) {
                    block.setType(Material.LAVA);
                }else if (block.getBlockData().getMaterial()==Material.ICE) {
                    block.setType(Material.WATER);
                }else if (block.getBlockData().getMaterial()==Material.GRAVEL) {
                    block.setType(Material.SANDSTONE);
                }else if (block.getBlockData().getMaterial()==Material.SANDSTONE) {
                    block.setType(Material.GRAVEL);
                }
                //树苗轮流转化
                if (block.getBlockData().getMaterial().toString().contains("SAPLING")) {
                    int i = saplings.indexOf(block.getBlockData().getMaterial());
                    i=(i+1)%saplings.size();
                    block.setType(saplings.get(i));
                }
                //原木转化
                if (block.getBlockData().getMaterial().toString().contains("LOG")) {
                    int i = logs.indexOf(block.getBlockData().getMaterial());
                    i=(i+1)%logs.size();
                    block.setType(logs.get(i));
                }
                //树叶转化
                if (block.getBlockData().getMaterial().toString().contains("LEAVES")) {
                    int i = leaves.indexOf(block.getBlockData().getMaterial());
                    i=(i+1)%leaves.size();
                    block.setType(leaves.get(i));
                }
                //羊毛转化
                if (block.getBlockData().getMaterial().toString().contains("WOOL")) {
                    int i = wools.indexOf(block.getBlockData().getMaterial());
                    i=(i+1)%wools.size();
                    block.setType(wools.get(i));
                }
            }else {
                if (block.getBlockData().getMaterial()== Material.STONE) {
                    block.setType(Material.GRASS_BLOCK);
                }else if (block.getBlockData().getMaterial()==Material.COBBLESTONE) {
                    block.setType(Material.GRASS_BLOCK);
                }else if (block.getBlockData().getMaterial()==Material.GRASS_BLOCK) {
                    block.setType(Material.STONE);
                }else if (block.getBlockData().getMaterial()==Material.SAND) {
                    block.setType(Material.COBBLESTONE);
                }else if (block.getBlockData().getMaterial()==Material.LAVA) {
                    block.setType(Material.OBSIDIAN);
                }
                //树苗轮流转化
                if (block.getBlockData().getMaterial().toString().contains("SAPLING")) {
                    int i = saplings.indexOf(block.getBlockData().getMaterial());
                    if (i-1==-1) {
                        i= saplings.size()-1;
                    }else {
                        i = i-1;
                    }
                    block.setType(saplings.get(i));
                }
                //原木转化
                if (block.getBlockData().getMaterial().toString().contains("LOG")) {
                    int i = logs.indexOf(block.getBlockData().getMaterial());
                    if (i-1==-1) {
                        i= logs.size()-1;
                    }else {
                        i = i-1;
                    }
                    block.setType(logs.get(i));
                }
                //树叶转化
                if (block.getBlockData().getMaterial().toString().contains("LEAVES")) {
                    int i = leaves.indexOf(block.getBlockData().getMaterial());
                    if (i-1==-1) {
                        i= leaves.size()-1;
                    }else {
                        i = i-1;
                    }
                    block.setType(leaves.get(i));
                }
                //羊毛转化
                if (block.getBlockData().getMaterial().toString().contains("WOOL")) {
                    int i = wools.indexOf(block.getBlockData().getMaterial());
                    if (i-1==-1) {
                        i= wools.size()-1;
                    }else {
                        i = i-1;
                    }
                    block.setType(wools.get(i));
                }
            }
        }
    }
}
