package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.Functions.PlayerEMCInfo;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class Charge implements Listener {
    static FileConfiguration data;
    @EventHandler
    public void charge(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        Action action = e.getAction();

        if (e.getHand().toString().equals("OFF_HAND")) {//贤者之石,红物质钉头锤单独计算
            if (player.getInventory().getItemInOffHand().getItemMeta() == null) {
                return;
            }
            if (action == Action.RIGHT_CLICK_BLOCK|| e.getAction()== Action.RIGHT_CLICK_AIR) {
                if (player.isSneaking()) {//潜行右键才可充能
                    File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                    data = YamlConfiguration.loadConfiguration(PI);
                    if (player.getInventory().getItemInOffHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().equals("贤者之石")) {
                        data.set(player.getName() + ".stone_energy", (data.getInt(player.getName() + ".stone_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".stone_energy"));
                    }else if (player.getInventory().getItemInOffHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().equals("红物质钉头锤")) {
                        data.set(player.getName() + ".morningstar_energy", (data.getInt(player.getName() + ".morningstar_energy") + 1) % 5);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".morningstar_energy"));
                    }else if (player.getInventory().getItemInOffHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().contains("暗物质剑")) {
                        data.set(player.getName() + ".sword_energy", (data.getInt(player.getName() + ".sword_energy") + 1) % 3);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".sword_energy"));
                    }else if (player.getInventory().getItemInOffHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().contains("红物质剑")) {
                        data.set(player.getName() + ".sword_energy", (data.getInt(player.getName() + ".sword_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".sword_energy"));
                    }else if (player.getInventory().getItemInOffHand().getItemMeta().hasLocalizedName() && player.getInventory().getItemInOffHand().getItemMeta().getLocalizedName().contains("红物质拳剑")) {
                        data.set(player.getName() + ".katar_energy", (data.getInt(player.getName() + ".katar_energy") + 1) % 5);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".katar_energy"));
                    }
                    try {
                        data.save(PI);
                    } catch (IOException event) {
                        PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
                        event.printStackTrace();
                    }
                }
            }
            return;
        }
        if (action == Action.RIGHT_CLICK_BLOCK) {
            if (player.isSneaking()) {//潜行右键才可充能
                if (player.getInventory().getItemInMainHand().getItemMeta() == null) {
                    return;
                }
                List<String> chargeable = Arrays.asList("暗物质镐", "红物质镐", "暗物质斧", "红物质斧", "暗物质锹", "红物质锹", "暗物质锄", "红物质锄", "暗物质剪刀", "红物质剪刀", "暗物质锤", "红物质锤");
                if (player.getInventory().getItemInMainHand().getItemMeta().hasLocalizedName() && chargeable.contains(player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName())) {
                    File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                    data = YamlConfiguration.loadConfiguration(PI);
                    if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质镐")) {
                        data.set(player.getName() + ".pickaxe_energy", (data.getInt(player.getName() + ".pickaxe_energy") + 1) % 3);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".pickaxe_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质镐")) {
                        data.set(player.getName() + ".pickaxe_energy", (data.getInt(player.getName() + ".pickaxe_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".pickaxe_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质斧")) {
                        data.set(player.getName() + ".axe_energy", (data.getInt(player.getName() + ".axe_energy") + 1) % 3);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".axe_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质斧")) {
                        data.set(player.getName() + ".axe_energy", (data.getInt(player.getName() + ".axe_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".axe_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质锹")) {
                        data.set(player.getName() + ".shovel_energy", (data.getInt(player.getName() + ".shovel_energy") + 1) % 2);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".shovel_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质锹")) {
                        data.set(player.getName() + ".shovel_energy", (data.getInt(player.getName() + ".shovel_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".shovel_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质锄")) {
                        data.set(player.getName() + ".hoe_energy", (data.getInt(player.getName() + ".hoe_energy") + 1) % 3);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".hoe_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质锄")) {
                        data.set(player.getName() + ".hoe_energy", (data.getInt(player.getName() + ".hoe_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".hoe_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质剪刀")) {
                        data.set(player.getName() + ".shears_energy", (data.getInt(player.getName() + ".shears_energy") + 1) % 3);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".shears_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质剪刀")) {
                        data.set(player.getName() + ".shears_energy", (data.getInt(player.getName() + ".shears_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".shears_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质锤")) {
                        data.set(player.getName() + ".hammer_energy", (data.getInt(player.getName() + ".hammer_energy") + 1) % 3);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".hammer_energy"));
                    } else if (player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质锤")) {
                        data.set(player.getName() + ".hammer_energy", (data.getInt(player.getName() + ".hammer_energy") + 1) % 4);
                        player.sendActionBar(ChatColor.GOLD+"充能等级："+data.getInt(player.getName() + ".hammer_energy"));
                    }
                    try {
                        data.save(PI);
                    } catch (IOException event) {
                        PluginE.instance.getLogger().log(Level.WARNING, "配置数据未能保存，可能产生回档问题！");
                        event.printStackTrace();
                    }
                    Bukkit.getPluginManager().callEvent(new PlayerItemHeldEvent(player,0,player.getInventory().getHeldItemSlot()));//前一个位置被0代替，需要注意
                }
            }
        }
    }
}
