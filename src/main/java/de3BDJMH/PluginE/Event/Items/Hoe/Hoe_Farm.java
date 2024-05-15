package de3BDJMH.PluginE.Event.Items.Hoe;

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

import java.io.File;

public class Hoe_Farm implements Listener {
    static FileConfiguration data;

    @EventHandler
    public void omFarm(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {//潜行是充能
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质锄") || player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质锄"))) {
                Block block = e.getClickedBlock();
                Location location = block.getLocation();
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".hoe_energy");
                int range = energy;
                for (int dx = -range; dx <= range; dx++) {
                    for (int dz = -range; dz <= range; dz++) {
                        Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY(), location.getZ() + dz);
                        if (block.getWorld().getBlockAt(nl).getType() == Material.DIRT||block.getWorld().getBlockAt(nl).getType()==Material.GRASS_BLOCK) {
                            block.getWorld().getBlockAt(nl).setType(Material.FARMLAND);
                        }
                    }
                }
            }
        }
    }
}
