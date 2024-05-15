package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.Functions.Dump;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.HashMap;

public class Block_Place implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        String ln = e.getItemInHand().getItemMeta().getLocalizedName();
        if (ln.equals("炼金煤炭块")||ln.equals("莫比乌斯燃料块")||ln.equals("永恒燃料块")||ln.equals("红物质块")||ln.equals("暗物质块")
            ||ln.equals("转化桌")) {
            Block block = e.getBlockPlaced();
            block.setMetadata("bname", new FixedMetadataValue(PluginE.instance, ln));
            HashMap<String,String> meta = new HashMap<>();
            meta.put("bname", ln);
            Dump.Dump(meta,block.getWorld().getName()+"_"+block.getX()+"_"+block.getY()+"_"+block.getZ());
        }else {
            Block block = e.getBlockPlaced();
            block.setMetadata("bname",new FixedMetadataValue(PluginE.instance, "null"));
            Dump.Del(block.getWorld().getName()+"_"+block.getX()+"_"+block.getY()+"_"+block.getZ());
        }
    }
}
