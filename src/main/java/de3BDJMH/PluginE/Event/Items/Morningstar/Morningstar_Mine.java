package de3BDJMH.PluginE.Event.Items.Morningstar;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Morningstar_Mine implements Listener {
    public static List<Material> unbreakable = Arrays.asList(Material.BEDROCK,Material.BARRIER,Material.COMMAND_BLOCK,Material.CHAIN_COMMAND_BLOCK,Material.REPEATING_COMMAND_BLOCK);
    static FileConfiguration data;
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质钉头锤")) {
            Block block = e.getBlock();
            Location location = block.getLocation();
            File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
            data = YamlConfiguration.loadConfiguration(PI);
            int mode = data.getInt(player.getName() + ".morningstar_mode");
            Block block1 = block, block2 = block;
            BlockFace playerFace;
            switch (mode) {
                case 1:
                    block1 = block.getWorld().getBlockAt(location.add(0, 1, 0));
                    block2 = block.getWorld().getBlockAt(location.add(0, -2, 0));
                    if (!unbreakable.contains(block1.getType())) {
                        player.getInventory().addItem(block1.getDrops().toArray(new ItemStack[0]));
                        block1.setType(Material.AIR);
                    }
                    if (!unbreakable.contains(block2.getType())) {
                        player.getInventory().addItem(block2.getDrops().toArray(new ItemStack[0]));
                        block2.setType(Material.AIR);
                    }
                    return;
                case 2:
                    playerFace = e.getPlayer().getTargetBlockFace(4);
                    if (playerFace == BlockFace.EAST || playerFace==BlockFace.WEST) {
                        block1 = block.getWorld().getBlockAt(location.add(0,0,1));
                        block2 = block.getWorld().getBlockAt(location.add(0,0,-2));//这个add会更改原来的location，要-1需要+1-2，也就是这两句上下顺序不能换
                    }else if (playerFace == BlockFace.NORTH || playerFace == BlockFace.SOUTH) {
                        block1 = block.getWorld().getBlockAt(location.add(1,0,0));
                        block2 = block.getWorld().getBlockAt(location.add(-2,0,0));
                    }
                    if (!unbreakable.contains(block1.getType())) {
                        player.getInventory().addItem(block1.getDrops().toArray(new ItemStack[0]));
                        block1.setType(Material.AIR);
                    }
                    if (!unbreakable.contains(block2.getType())) {
                        player.getInventory().addItem(block2.getDrops().toArray(new ItemStack[0]));
                        block2.setType(Material.AIR);
                    }
                    return;
                case 3:
                    playerFace = e.getPlayer().getTargetBlockFace(4);
                    if (playerFace == BlockFace.UP) {
                        block1 = block.getWorld().getBlockAt(location.add(0,-1,0));
                        block2 = block.getWorld().getBlockAt(location.add(0,-1,0));
                    }else if (playerFace == BlockFace.DOWN) {
                        block1 = block.getWorld().getBlockAt(location.add(0,1,0));
                        block2 = block.getWorld().getBlockAt(location.add(0,1,0));
                    }else if (playerFace == BlockFace.EAST) {
                        block1 = block.getWorld().getBlockAt(location.add(-1,0,0));
                        block2 = block.getWorld().getBlockAt(location.add(-1,0,0));
                    }else if (playerFace == BlockFace.WEST) {
                        block1 = block.getWorld().getBlockAt(location.add(1,0,0));
                        block2 = block.getWorld().getBlockAt(location.add(1,0,0));
                    }else if (playerFace == BlockFace.SOUTH) {
                        block1 = block.getWorld().getBlockAt(location.add(0,0,-1));
                        block2 = block.getWorld().getBlockAt(location.add(0,0,-1));
                    }else if (playerFace == BlockFace.NORTH) {
                        block1 = block.getWorld().getBlockAt(location.add(0,0,1));
                        block2 = block.getWorld().getBlockAt(location.add(0,0,1));
                    }
                    if (!unbreakable.contains(block1.getType())) {
                        player.getInventory().addItem(block1.getDrops().toArray(new ItemStack[0]));
                        block1.setType(Material.AIR);
                    }
                    if (!unbreakable.contains(block2.getType())) {
                        player.getInventory().addItem(block2.getDrops().toArray(new ItemStack[0]));
                        block2.setType(Material.AIR);
                    }
                    return;
                case 4:
                    int energy = data.getInt(player.getName() + ".morningstar_energy");
                    int bottom = -2 - energy;
                    int top = 2 + energy;
                    Material bt = block.getType();
                    for (int x = bottom; x <= top; x++) {
                        for (int y = bottom; y <= top; y++) {
                            for (int z = bottom; z <= top; z++) {
                                Location nn = new Location(block.getWorld(), location.getX() + x, location.getY() + y, location.getZ() + z);
                                Block b = block.getWorld().getBlockAt(nn);
                                if (b.getType() == bt) {
                                    if (!unbreakable.contains(block.getType())) {
                                        player.getInventory().addItem(b.getDrops().toArray(new ItemStack[0]));
                                        b.setType(Material.AIR);
                                    }
                                }
                            }
                        }
                    }
                case 5://铲，在click事件里检测
                    return;
                case 6://锤，在click事件里检测
                    return;
            }
        }
    }
}
