package de3BDJMH.PluginE.Event.Items.Shovel;

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

public class Shovel_Mine implements Listener {
    static FileConfiguration data;
    private static final List<Material> mineable = Arrays.asList(Material.DIRT,Material.GRASS_BLOCK,Material.SAND,Material.GRAVEL,Material.CLAY,Material.WATER,Material.LAVA);

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
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质锹") || player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质锹"))) {
                e.setCancelled(true);
                Block block = e.getClickedBlock();
                Location location = block.getLocation();
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".shovel_energy");
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
            }
        }
    }
}
