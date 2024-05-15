package de3BDJMH.PluginE.Event.Items.Pickaxe;

import de3BDJMH.PluginE.PluginE;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;

public class Pickaxe_ModeChange implements Listener {
    static FileConfiguration data;
    private static final Map<Integer,String> modes = new HashMap<>();
    @EventHandler
    public void onChange(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (e.getHand().toString().equals("OFF_HAND")) {
            return;
        }
        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (player.isSneaking()) {//潜行是充能
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta()==null) {
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质镐")||player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质镐"))) {
                modes.put(0, ChatColor.GREEN+"普通模式");
                modes.put(1, ChatColor.GREEN+"3*竖直采集");
                modes.put(2, ChatColor.GREEN+"3*横向采集");
                modes.put(3, ChatColor.GREEN+"3*直线采集");
                modes.put(4, ChatColor.GREEN+"范围采集");
                File PI = new File(PluginE.instance.getDataFolder(),"PlayerInfo.yml");
                data= YamlConfiguration.loadConfiguration(PI);
                int mode = (data.getInt(player.getName()+".pickaxe_mode")+1)%5;
                data.set(player.getName()+".pickaxe_mode",mode);
                try {
                    data.save(PI);
                } catch (IOException event) {
                    PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
                    event.printStackTrace();
                }
                player.sendActionBar(modes.get(mode));
            }
        }
    }
}
