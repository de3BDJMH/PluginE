package de3BDJMH.PluginE.Event.Items.Volcanite_Amulet;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class Volcanite_Amulet_ClickBlock implements Listener {
    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
            return;
        }
        if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("熔岩护符")) {
                Block block = e.getClickedBlock();
                Location blockLocation = block.getLocation();
                Location playerLocation = player.getEyeLocation();
                BlockFace blockFace = e.getBlockFace();
                int vx=playerLocation.getBlockX()-blockLocation.getBlockX();
                int vy=playerLocation.getBlockY()-blockLocation.getBlockY();
                int vz=playerLocation.getBlockZ()-blockLocation.getBlockZ();
                double d = Math.pow(vx*vx+vy*vy+vz*vz,0.5);
                for (int dd = 0;dd<=d;dd++) {
                    int nx = (int) (vx*(dd/d)+blockLocation.getBlockX());
                    int ny = (int) (vy*(dd/d)+blockLocation.getBlockY());
                    int nz = (int) (vz*(dd/d)+blockLocation.getBlockZ());
                    if (block.getWorld().getBlockAt(nx,ny,nz).getType()==Material.WATER) {
                        block.getWorld().getBlockAt(nx,ny,nz).setType(Material.AIR);
                    }
                }
                block.getWorld().getBlockAt(new Location(block.getWorld(),blockLocation.getX()+blockFace.getModX(),blockLocation.getY()+blockFace.getModY(),blockLocation.getZ()+blockFace.getModZ())).setType(Material.LAVA);
            }
        }
    }
}
