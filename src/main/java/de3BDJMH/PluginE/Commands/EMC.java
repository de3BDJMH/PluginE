package de3BDJMH.PluginE.Commands;

import de3BDJMH.PluginE.Functions.EMCOperations;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import javax.annotation.ParametersAreNonnullByDefault;

public class EMC implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        ItemStack itemStack = player.getInventory().getItemInMainHand();
        if (!EMCOperations.EMCs.containsKey(itemStack.getType().toString()) && !EMCOperations.PEEMCs.containsKey(itemStack.getItemMeta().getLocalizedName())) {
            player.sendMessage(ChatColor.RED+"这个物品没有EMC");
            return true;
        }
        if (itemStack.getItemMeta().hasLocalizedName()) {
            player.sendMessage(ChatColor.AQUA+"单件物品EMC为 "+ChatColor.GOLD + EMCOperations.PEEMCs.get(itemStack.getItemMeta().getLocalizedName()));
            player.sendMessage(ChatColor.AQUA+"总计 "+ChatColor.GOLD +EMCOperations.PEEMCs.get(itemStack.getItemMeta().getLocalizedName()) * itemStack.getAmount());
        }else {
            String name = itemStack.getType().toString();
            if (!name.contains("POTION")) {
                player.sendMessage(ChatColor.AQUA+"单件物品EMC为 "+ChatColor.GOLD + EMCOperations.EMCs.get(name));
                player.sendMessage(ChatColor.AQUA+"总计 "+ChatColor.GOLD + EMCOperations.EMCs.get(name)* itemStack.getAmount());
            }else {//药水需要单独处理，每一种都不一样

            }
        }
        return true;
    }
}
