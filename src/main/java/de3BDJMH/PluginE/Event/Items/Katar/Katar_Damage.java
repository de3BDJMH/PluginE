package de3BDJMH.PluginE.Event.Items.Katar;

import de3BDJMH.PluginE.Event.Items.Sword.Sword_Damage;
import de3BDJMH.PluginE.PluginE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;

public class Katar_Damage implements Listener {
    static FileConfiguration data;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (player.isSneaking()) {//潜行是切换模式
            return;
        }
        if (player.getInventory().getItemInMainHand().getItemMeta() != null && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质拳剑")) {
            float cooldown = player.getAttackCooldown();
            if (cooldown != 1.0) {//冷却完成才可以攻击
                return;
            }
            File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
            data = YamlConfiguration.loadConfiguration(PI);
            int mode = data.getInt(player.getName() + ".katar_mode");
            int damage = 1000;
            if (mode == 1) {
                for (Entity entity : player.getNearbyEntities(6, 6, 6)) {
                    if (!(entity instanceof LivingEntity)) {
                        continue;
                    }
                    if (Sword_Damage.mobs.contains(entity.getType())) {
                        double b = ((LivingEntity) entity).getHealth();
                        if (b <= damage) {
                            ((LivingEntity) entity).setHealth(0);
                        } else {
                            ((LivingEntity) entity).damage(0.0001);
                            ((LivingEntity) entity).setHealth(b - damage);
                        }
                    }
                }
            } else if (mode == 2) {
                for (Entity entity : player.getNearbyEntities(6, 6, 6)) {
                    if (!(entity instanceof LivingEntity)) {
                        continue;
                    }
                    double b = ((LivingEntity) entity).getHealth();
                    if (b <= damage) {
                        ((LivingEntity) entity).setHealth(0);
                    } else {
                        ((LivingEntity) entity).damage(0.0001);
                        ((LivingEntity) entity).setHealth(b - damage);
                    }
                }
            }
            player.resetCooldown();
        }
    }
}
