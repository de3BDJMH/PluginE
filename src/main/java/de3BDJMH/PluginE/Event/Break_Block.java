package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.Blocks.*;
import de3BDJMH.PluginE.Functions.Dump;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.metadata.FixedMetadataValue;

public class Break_Block implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Block block = e.getBlock();
        Player player = e.getPlayer();
        if (!block.getMetadata("bname").isEmpty()) {
            if (block.getMetadata("bname").get(0).asString().equals("null")) {
                return;
            }
            if (block.getMetadata("bname").get(0).asString().equals("炼金煤炭块")) {
                e.setDropItems(false);
                player.getInventory().addItem(Alchemical_Coal_Block.get());
            }else if (block.getMetadata("bname").get(0).asString().equals("莫比乌斯燃料块")) {
                e.setDropItems(false);
                player.getInventory().addItem(Mobius_Fuel_Block.get());
            }else if (block.getMetadata("bname").get(0).asString().equals("永恒燃料块")) {
                e.setDropItems(false);
                player.getInventory().addItem(Aeternalis_Fuel_Block.get());
            }else if (block.getMetadata("bname").get(0).asString().equals("暗物质块")) {
                e.setDropItems(false);
                player.getInventory().addItem(Dark_Matter_Block.get());
            }else if (block.getMetadata("bname").get(0).asString().equals("红物质块")) {
                e.setDropItems(false);
                player.getInventory().addItem(Red_Matter_Block.get());
            }else if (block.getMetadata("bname").get(0).asString().equals("转化桌")) {
                e.setDropItems(false);
                player.getInventory().addItem(Transmutation_Table.get());
            }
            block.setMetadata("bname",new FixedMetadataValue(PluginE.instance, "null"));
            Dump.Del(block.getWorld().getName()+"_"+block.getX()+"_"+block.getY()+"_"+block.getZ());
        }
    }
}
