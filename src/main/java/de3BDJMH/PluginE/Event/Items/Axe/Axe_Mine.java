package de3BDJMH.PluginE.Event.Items.Axe;

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

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Axe_Mine implements Listener {
    static FileConfiguration data;
    List<Material> logs = Arrays.asList(Material.OAK_LOG,Material.SPRUCE_LOG,Material.BIRCH_LOG,Material.JUNGLE_LOG,Material.ACACIA_LOG,Material.DARK_OAK_LOG,Material.CHERRY_LOG);
    List<Material> leaves = Arrays.asList(Material.OAK_LEAVES,Material.SPRUCE_LEAVES,Material.BIRCH_LEAVES,Material.JUNGLE_LEAVES,Material.ACACIA_LEAVES,Material.DARK_OAK_LEAVES,Material.CHERRY_LEAVES);
    @EventHandler
    public void onMine(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {//潜行是充能
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质斧") || player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质斧"))) {
                Block block = e.getClickedBlock();
                Location location = block.getLocation();
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".axe_energy");
                int range = 3+2*energy;
                for (int dx = -range;dx<=range;dx++) {
                    for (int dy = -range;dy<=range;dy++) {
                        for (int dz = -range; dz <= range; dz++) {
                            Location nl = new Location(block.getWorld(), block.getX()+dx,block.getY()+dy,block.getZ()+dz);
                            if (logs.contains(block.getWorld().getBlockAt(nl).getType()) || leaves.contains(block.getWorld().getBlockAt(nl).getType())) {
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
