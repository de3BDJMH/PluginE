package de3BDJMH.PluginE.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TabComplete implements TabCompleter {
    @Override
    @ParametersAreNonnullByDefault
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return null;
        }
        if (args.length==1) {
            return Collections.singletonList("give");
        }else if (args.length==2 && args[0].equals("give")) {
            return Arrays.asList("贤者之石","炼金煤炭","莫比乌斯燃料","永恒燃料","暗物质","红物质",
                                 "炼金煤炭块","莫比乌斯燃料块","永恒燃料块","暗物质块","红物质块",
                                 "转化桌","暗物质头盔","暗物质胸甲","暗物质护腿","暗物质靴子",
                                 "红物质头盔","红物质胸甲","红物质护腿","红物质靴子",
                                 "暗物质镐","红物质镐","暗物质斧","红物质斧","暗物质锹","红物质锹",
                                 "暗物质锄","红物质锄","暗物质剪刀","红物质剪刀","暗物质锤","红物质锤",
                                 "红物质钉头锤","暗物质剑","红物质剑","红物质拳剑","铁指环","潮汐护符","熔岩护符");
        }
        return null;
    }
}
