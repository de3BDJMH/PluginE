package de3BDJMH.PluginE.Event.Items.Evertide_Amulet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Evertide_Amulet_ClickBlock implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("潮汐护符")) {
                Block block = e.getClickedBlock();
                Location location = block.getLocation();
                BlockFace blockFace = e.getBlockFace();
                for (int dx = -4;dx<=4;dx++) {
                    for (int dz = -4;dz<=4;dz++) {
                        Location nl = new Location(block.getWorld(), location.getX() + dx, location.getY(), location.getZ() + dz);
                        if (block.getWorld().getBlockAt(nl).getType()== Material.LAVA) {
                            block.getWorld().getBlockAt(nl).setType(Material.OBSIDIAN);
                        }
                    }
                }
                block.getWorld().getBlockAt(new Location(block.getWorld(),location.getX()+blockFace.getModX(),location.getY()+blockFace.getModY(),location.getZ()+blockFace.getModZ())).setType(Material.WATER);
            }
        }
    }
}
