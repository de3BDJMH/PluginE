package de3BDJMH.PluginE.Event.Items.Sword;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class Sword_Damage implements Listener {
    public static List<EntityType> mobs = Arrays.asList(
            EntityType.BLAZE,
            EntityType.CREEPER,
            EntityType.DROWNED,
            EntityType.ELDER_GUARDIAN,
            EntityType.ENDERMITE,
            EntityType.EVOKER,
            EntityType.GHAST,
            EntityType.GUARDIAN,
            EntityType.HOGLIN,
            EntityType.HUSK,
            EntityType.MAGMA_CUBE,
            EntityType.PHANTOM,
            EntityType.PIGLIN_BRUTE,
            EntityType.PILLAGER,
            EntityType.RAVAGER,
            EntityType.SHULKER,
            EntityType.SILVERFISH,
            EntityType.SKELETON,
            EntityType.SLIME,
            EntityType.STRAY,
            EntityType.VEX,
            EntityType.VINDICATOR,
            EntityType.WITCH,
            EntityType.WITHER_SKELETON,
            EntityType.ZOGLIN,
            EntityType.ZOMBIE,
            EntityType.ZOMBIE_VILLAGER,
            EntityType.ENDERMAN,
            EntityType.PIGLIN,
            EntityType.SPIDER,
            EntityType.CAVE_SPIDER,
            EntityType.ZOMBIFIED_PIGLIN,
            EntityType.ENDER_DRAGON,
            EntityType.WITHER
    );
    static FileConfiguration data;

    @EventHandler
    public void onClick(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (e.getAction()== Action.RIGHT_CLICK_BLOCK) {
            if (!player.isSneaking()) {//主潜行才能放技能，副手潜行充能
                return;
            }
            if (player.getInventory().getItemInMainHand().getItemMeta()!=null && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("暗物质剑")) {
                float cooldown = player.getAttackCooldown();
                if (cooldown!=1.0) {//冷却完成才可以攻击
                    return;
                }
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".sword_energy");
                int damage = 12+energy;
                for (Entity entity: player.getNearbyEntities(5,5,5)) {
                    if (!(entity instanceof LivingEntity)){
                        continue;
                    }
                    if (mobs.contains(entity.getType())) {
                        double b = ((LivingEntity) entity).getHealth();
                        if (b<=damage) {
                            ((LivingEntity) entity).setHealth(0);
                        }else {
                            ((LivingEntity) entity).setHealth(b-damage);
                        }
                    }
                }
                player.resetCooldown();
            }else if (player.getInventory().getItemInMainHand().getItemMeta()!=null && player.getInventory().getItemInMainHand().getItemMeta().getLocalizedName().equals("红物质剑")) {
                float cooldown = player.getAttackCooldown();
                if (cooldown!=1.0) {//冷却完成才可以攻击
                    return;
                }
                File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
                data = YamlConfiguration.loadConfiguration(PI);
                int energy = data.getInt(player.getName() + ".sword_energy");
                int mode = data.getInt(player.getName() + ".sword_mode");
                int damage = 15+energy;
                if (mode==0) {
                    for (Entity entity: player.getNearbyEntities(6,6,6)) {
                        if (!(entity instanceof LivingEntity)){
                            continue;
                        }
                        if (mobs.contains(entity.getType())) {
                            double b = ((LivingEntity) entity).getHealth();
                            if (b<=damage) {
                                ((LivingEntity) entity).setHealth(0);
                            }else {
                                ((LivingEntity) entity).damage(0.0001);
                                ((LivingEntity) entity).setHealth(b-damage);
                            }
                        }
                    }
                }else {
                    for (Entity entity: player.getNearbyEntities(6,6,6)) {
                        if (!(entity instanceof LivingEntity)){
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
}
