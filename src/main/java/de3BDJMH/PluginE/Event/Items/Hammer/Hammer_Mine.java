package de3BDJMH.PluginE.Event.Items.Hammer;

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
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Hammer_Mine implements Listener {
    static FileConfiguration data;
    private static final List<Material> banned = Arrays.asList(Material.DIRT,Material.GRASS_BLOCK,Material.SAND,Material.GRAVEL,Material.CLAY,Material.WATER,Material.LAVA);

    @EventHandler
    public void onBreak(PlayerInteractEvent e) {
        if (e.getHand().toString().equals("OFF_HAND")) {
            return;
        }
        if (e.getPlayer().getInventory().getItemInMainHand().getItemMeta()==null) {
            return;
        }
        if (e.getAction()== Action.RIGHT_CLICK_BLOCK) {
            Player player = e.getPlayer();
            if (player.isSneaking()) {//潜行是在充能
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质锤") || player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质锤"))) {
                Block block = e.getClickedBlock();
                Location location = block.getLocation();
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".hammer_energy");
                Location pl = player.getEyeLocation();
                List<Integer> range;
                if (energy==0) {
                    return;
                }else if (energy==1) {
                    range = Arrays.asList(1,1,2);//这里前两个数字其实指的是1*2+1，下面同理
                }else if (energy==2) {
                    range = Arrays.asList(2,2,3);
                }else {
                    range = Arrays.asList(3,3,4);
                }
                BlockFace blockFace = e.getBlockFace();
                if (blockFace == BlockFace.UP) {
                    for (int dx = -range.get(0); dx <= range.get(0); dx++) {
                        for (int dz = -range.get(0); dz <= range.get(0); dz++) {
                            for (int dy = 0; dy > -range.get(2); dy--) {
                                Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                    player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                    block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }else if (blockFace == BlockFace.DOWN) {
                    for (int dx = -range.get(0); dx <= range.get(0); dx++) {
                        for (int dz = -range.get(0); dz <= range.get(0); dz++) {
                            for (int dy = 0; dy < range.get(2); dy++) {
                                Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                    player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                    block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }else if (blockFace == BlockFace.EAST) {
                    for (int dx = 0; dx > -range.get(2); dx--) {
                        for (int dz = -range.get(0); dz <= range.get(0); dz++) {
                            for (int dy = -range.get(0); dy <= range.get(0); dy++) {
                                Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                    player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                    block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }else if (blockFace == BlockFace.WEST) {
                    for (int dx = 0; dx < range.get(2); dx++) {
                        for (int dz = -range.get(0); dz <= range.get(0); dz++) {
                            for (int dy = -range.get(0); dy <= range.get(0); dy++) {
                                Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                    player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                    block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }else if (blockFace == BlockFace.SOUTH) {
                    for (int dz = 0; dz > -range.get(2); dz--) {
                        for (int dx = -range.get(0); dx <= range.get(0); dx++) {
                            for (int dy = -range.get(0); dy <= range.get(0); dy++) {
                                Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                    player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                    block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }else if (blockFace == BlockFace.NORTH) {
                    for (int dz = 0; dz < range.get(2); dz++) {
                        for (int dx = -range.get(0); dx <= range.get(0); dx++) {
                            for (int dy = -range.get(0); dy <= range.get(0); dy++) {
                                Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                    player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                    block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
