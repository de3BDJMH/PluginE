package de3BDJMH.PluginE.Event.Items.Morningstar;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.checkerframework.checker.units.qual.A;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Morningstar_Click implements Listener {
    static FileConfiguration data;
    private static final List<Material> mineable = Arrays.asList(Material.DIRT,Material.GRASS_BLOCK,Material.SAND,Material.GRAVEL,Material.CLAY,Material.WATER,Material.LAVA);
    private static final List<Material> banned = Arrays.asList(Material.DIRT,Material.GRASS_BLOCK,Material.SAND,Material.GRAVEL,Material.CLAY,Material.WATER,Material.LAVA);

    @EventHandler
    public void onMine(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {//潜行是充能
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质钉头锤")) {
                e.setCancelled(true);
                Block block = e.getClickedBlock();
                Location location = block.getLocation();
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int mode = data.getInt(player.getName() + ".morningstar_mode");
                int energy = data.getInt(player.getName() + ".morningstar_energy");
                if (mode==5) {//铲
                    int range = energy;
                    for (int dx = -range; dx <= range; dx++) {
                        for (int dz = -range; dz <= range; dz++) {
                            Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY(), location.getZ() + dz);
                            if (mineable.contains(block.getWorld().getBlockAt(nl).getType())) {
                                player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                block.getWorld().getBlockAt(nl).setType(Material.AIR);
                            }
                        }
                    }
                }else if (mode==6) {
                    Location pl = player.getEyeLocation();
                    List<Integer> range;
                    if (energy==0) {
                        return;
                    }else if (energy==1) {
                        range = Arrays.asList(1,1,2);//这里前两个数字其实指的是1*2+1，下面同理
                    }else if (energy==2) {
                        range = Arrays.asList(2,2,3);
                    }else if (energy==3) {
                        range = Arrays.asList(3,3,4);
                    }else {
                        range = Arrays.asList(4,4,5);
                    }
                    if (Math.abs(pl.getBlockX() - location.getBlockX()) >= Math.abs(pl.getBlockZ() - location.getBlockZ()) && Math.abs(pl.getBlockX() - location.getBlockX()) >= Math.abs(pl.getBlockY() - location.getBlockY())) {
                        if (pl.getBlockX() - location.getBlockX() > 0) {
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
                        }else {
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
                        }
                    } else if (Math.abs(pl.getBlockZ() - location.getBlockZ()) >= Math.abs(pl.getBlockX() - location.getBlockX()) && Math.abs(pl.getBlockZ() - location.getBlockZ()) >= Math.abs(pl.getBlockY() - location.getBlockY())) {
                        if (pl.getBlockZ() - location.getBlockZ() > 0) {
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
                        }else {
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
                    } else {
                        if (pl.getBlockY() - location.getBlockY() > 0) {
                            for (int dy = 0; dy > -range.get(2); dy--) {
                                for (int dz = -range.get(0); dz <= range.get(0); dz++) {
                                    for (int dx = -range.get(0); dx <= range.get(0); dx++) {
                                        Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY() + dy, location.getZ() + dz);
                                        if (!banned.contains(block.getWorld().getBlockAt(nl).getType())) {
                                            player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                                            block.getWorld().getBlockAt(nl).setType(Material.AIR);
                                        }
                                    }
                                }
                            }
                        }else {
                            for (int dy = 0; dy < range.get(2); dy++) {
                                for (int dz = -range.get(0); dz <= range.get(0); dz++) {
                                    for (int dx = -range.get(0); dx <= range.get(0); dx++) {
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
        }else if (e.getAction()==Action.LEFT_CLICK_BLOCK) {//原型是镐子，但是它挖泥土和木头都很快，用急迫模拟
            PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, 1, 10);
            e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }
}
