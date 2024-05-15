package de3BDJMH.PluginE.Event.Items.Shears;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Material;
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
import java.util.Random;

public class Shears_Shear implements Listener {
    static FileConfiguration data;
    private static final Random random = new Random();

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {//潜行是充能
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK|| e.getAction()== Action.RIGHT_CLICK_AIR) {
            if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质剪刀") || player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质剪刀"))) {
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".shears_energy");
                int range = 10 + 4 * energy;
                for (Entity entity : player.getNearbyEntities(range, range, range)) {
                    if (entity.getType() == EntityType.SHEEP && !((Sheep) entity).isSheared()) {
                        ((Sheep) entity).setSheared(true);
                        int n = random.nextInt(3) + 1;
                        player.getInventory().addItem(new ItemStack(Material.getMaterial(((Sheep) entity).getColor().toString() + "_WOOL"), n));
                    }
                }
            }
        }
    }
}
