package de3BDJMH.PluginE.Commands;

import de3BDJMH.PluginE.Blocks.*;
import de3BDJMH.PluginE.Items.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;

public class Items implements CommandExecutor {
    @Override
    @ParametersAreNonnullByDefault
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return false;
        }
        Player player = (Player) sender;
        if (args[0].equals("give")) {
            switch (args[1]) {
                case "贤者之石":
                    player.getInventory().addItem(Philosophers_Stone.get());
                    return true;
                case "炼金煤炭":
                    player.getInventory().addItem(Alchemical_Coal.get());
                    return true;
                case "莫比乌斯燃料":
                    player.getInventory().addItem((Mobius_Fuel.get()));
                    return true;
                case "永恒燃料":
                    player.getInventory().addItem((Aeternalis_Fuel.get()));
                    return true;
                case "暗物质":
                    player.getInventory().addItem((Dark_Matter.get()));
                    return true;
                case "红物质":
                    player.getInventory().addItem(Red_Matter.get());
                    return true;
                case "炼金煤炭块":
                    player.getInventory().addItem(Alchemical_Coal_Block.get());
                    return true;
                case "莫比乌斯燃料块":
                    player.getInventory().addItem(Mobius_Fuel_Block.get());
                    return true;
                case "永恒燃料块":
                    player.getInventory().addItem(Aeternalis_Fuel_Block.get());
                    return true;
                case "暗物质块":
                    player.getInventory().addItem(Dark_Matter_Block.get());
                    return true;
                case "红物质块":
                    player.getInventory().addItem(Red_Matter_Block.get());
                    return true;
                case "转化桌":
                    player.getInventory().addItem(Transmutation_Table.get());
                    return true;
                case "暗物质头盔":
                    player.getInventory().addItem(Dark_Matter_Helmet.get());
                    return true;
                case "暗物质胸甲":
                    player.getInventory().addItem(Dark_Matter_Chestplate.get());
                    return true;
                case "暗物质护腿":
                    player.getInventory().addItem(Dark_Matter_Leggings.get());
                    return true;
                case "暗物质靴子":
                    player.getInventory().addItem(Dark_Matter_Boots.get());
                    return true;
                case "红物质头盔":
                    player.getInventory().addItem(Red_Matter_Helmet.get());
                    return true;
                case "红物质胸甲":
                    player.getInventory().addItem(Red_Matter_Chestplate.get());
                    return true;
                case "红物质护腿":
                    player.getInventory().addItem(Red_Matter_Leggings.get());
                    return true;
                case "红物质靴子":
                    player.getInventory().addItem(Red_Matter_Boots.get());
                    return true;
                case "暗物质镐":
                    player.getInventory().addItem(Dark_Matter_Pickaxe.get());
                    return true;
                case "红物质镐":
                    player.getInventory().addItem(Red_Matter_Pickaxe.get());
                    return true;
                case "暗物质斧":
                    player.getInventory().addItem(Dark_Matter_Axe.get());
                    return true;
                case "红物质斧":
                    player.getInventory().addItem(Red_Matter_Axe.get());
                    return true;
                case "暗物质锹":
                    player.getInventory().addItem(Dark_Matter_Shovel.get());
                    return true;
                case "红物质锹":
                    player.getInventory().addItem(Red_Matter_Shovel.get());
                    return true;
                case "暗物质锄":
                    player.getInventory().addItem(Dark_Matter_Hoe.get());
                    return true;
                case "红物质锄":
                    player.getInventory().addItem(Red_Matter_Hoe.get());
                    return true;
                case "暗物质剪刀":
                    player.getInventory().addItem(Dark_Matter_Shears.get());
                    return true;
                case "红物质剪刀":
                    player.getInventory().addItem(Red_Matter_Shears.get());
                    return true;
                case "暗物质锤":
                    player.getInventory().addItem(Dark_Matter_Hammer.get());
                    return true;
                case "红物质锤":
                    player.getInventory().addItem(Red_Matter_Hammer.get());
                    return true;
                case "红物质钉头锤":
                    player.getInventory().addItem(Red_Morningstar.get());
                    return true;
                case "暗物质剑":
                    player.getInventory().addItem(Dark_Matter_Sword.get());
                    return true;
                case "红物质剑":
                    player.getInventory().addItem(Red_Matter_Sword.get());
                    return true;
                case "红物质拳剑":
                    player.getInventory().addItem(Red_Katar.get());
                    return true;
                case "铁指环":
                    player.getInventory().addItem(Iron_Band.get());
                    return true;
                case "潮汐护符":
                    player.getInventory().addItem(Evertide_Amulet.get());
                    return true;
                case "熔岩护符":
                    player.getInventory().addItem(Volcanite_Amulet.get());
                    return true;
            }
        }
        return false;
    }
}
