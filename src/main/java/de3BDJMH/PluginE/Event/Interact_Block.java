package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.Event.Blocks.Transmutation_Table.Transmutation_Table_Inventory;
import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;

public class Interact_Block implements Listener {
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Action action = event.getAction();

        if (event.getHand().toString().equals("OFF_HAND")) {
            return;
        }
        if (action == Action.RIGHT_CLICK_BLOCK) {
            Block clickedBlock = event.getClickedBlock();
            if (!clickedBlock.getMetadata("bname").isEmpty()) {
                if (clickedBlock.getMetadata("bname").get(0).asString().equals("null")) {
                    return;
                }
                //player.sendMessage("你右键点击了"+ ChatColor.GREEN + clickedBlock.getMetadata("bname").get(0).asString());
                //单独处理特殊方块事件
                if (clickedBlock.getMetadata("bname").get(0).asString().equals("转化桌")) {
                    event.setCancelled(true);
                    Transmutation_Table_Inventory.event(player);
                }
            }
        }
    }
}
