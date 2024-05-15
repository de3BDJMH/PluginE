package de3BDJMH.PluginE.Event.Items.Katar;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Katar_Mine implements Listener {
    static FileConfiguration data;
    private static final Random random = new Random();
    List<Material> logs = Arrays.asList(Material.OAK_LOG, Material.SPRUCE_LOG, Material.BIRCH_LOG, Material.JUNGLE_LOG, Material.ACACIA_LOG, Material.DARK_OAK_LOG, Material.CHERRY_LOG);
    List<Material> leaves = Arrays.asList(Material.OAK_LEAVES, Material.SPRUCE_LEAVES, Material.BIRCH_LEAVES, Material.JUNGLE_LEAVES, Material.ACACIA_LEAVES, Material.DARK_OAK_LEAVES, Material.CHERRY_LEAVES);

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {//潜行是充能
            return;
        }
        File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
        data = YamlConfiguration.loadConfiguration(PI);
        int energy = data.getInt(player.getName() + ".katar_energy");
        int mode = data.getInt(player.getName() + "katar_mode");
        if (mode != 0) {
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta() == null) {
            return;
        }
        if (!(player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质拳剑"))) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            Block block = e.getClickedBlock();
            Location location = block.getLocation();
            //斧子功能
            int axe_range = 3 + 2 * energy;
            for (int dx = -axe_range; dx <= axe_range; dx++) {
                for (int dy = -axe_range; dy <= axe_range; dy++) {
                    for (int dz = -axe_range; dz <= axe_range; dz++) {
                        Location nl = new Location(block.getWorld(), block.getX() + dx, block.getY() + dy, block.getZ() + dz);
                        if (logs.contains(block.getWorld().getBlockAt(nl).getType()) || leaves.contains(block.getWorld().getBlockAt(nl).getType())) {
                            player.getInventory().addItem(block.getWorld().getBlockAt(nl).getDrops().toArray(new ItemStack[0]));
                            block.getWorld().getBlockAt(nl).setType(Material.AIR);
                        }
                    }
                }
            }
            //锄功能
            int hoe_range = energy;
            for (int dx = -hoe_range; dx <= hoe_range; dx++) {
                for (int dz = -hoe_range; dz <= hoe_range; dz++) {
                    Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY(), location.getZ() + dz);
                    if (block.getWorld().getBlockAt(nl).getType() == Material.DIRT || block.getWorld().getBlockAt(nl).getType() == Material.GRASS_BLOCK) {
                        block.getWorld().getBlockAt(nl).setType(Material.FARMLAND);
                    }
                }
            }
            //剪刀功能
            int shear_range = 10 + 4 * energy;
            for (Entity entity : player.getNearbyEntities(shear_range, shear_range, shear_range)) {
                if (entity.getType() == EntityType.SHEEP && !((Sheep) entity).isSheared()) {
                    ((Sheep) entity).setSheared(true);
                    int n = random.nextInt(3) + 1;
                    player.getInventory().addItem(new ItemStack(Material.getMaterial(((Sheep) entity).getColor().toString() + "_WOOL"), n));
                }
            }
        }
    }
}
