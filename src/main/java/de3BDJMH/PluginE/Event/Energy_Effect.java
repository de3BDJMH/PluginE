package de3BDJMH.PluginE.Event;

import de3BDJMH.PluginE.PluginE;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Energy_Effect implements Listener {
    static FileConfiguration data;
    private static final List<String> tools = Arrays.asList("暗物质镐","红物质镐","暗物质斧","红物质斧","暗物质锹","红物质锹","暗物质锤","红物质锤");

    @EventHandler
    public void onHeld(PlayerItemHeldEvent e) {
        if (e.getPlayer().getInventory().getItem(e.getNewSlot())==null) {
            return;
        }
        if (e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().hasLocalizedName()&&tools.contains(e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLocalizedName())) {
            File PI = new File(PluginE.instance.getDataFolder(), "PlayerInfo.yml");
            data = YamlConfiguration.loadConfiguration(PI);
            int pickaxe_energy = data.getInt(e.getPlayer().getName() + ".pickaxe_energy");
            int axe_energy = data.getInt(e.getPlayer().getName() + ".axe_energy");
            int shovel_energy = data.getInt(e.getPlayer().getName() + ".shovel_energy");
            int hammer_energy = data.getInt(e.getPlayer().getName() + ".hammer_energy");
            int morningstar_energy = data.getInt(e.getPlayer().getName() + ".morningstar_energy");
            int max_energy = Collections.max(Arrays.asList(pickaxe_energy,axe_energy,shovel_energy,hammer_energy,morningstar_energy));
            if (max_energy==0) {
                e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                return;
            }
            if (e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLocalizedName().contains("镐")) {
                if (pickaxe_energy==0) {
                    e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                }else {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, pickaxe_energy - 1);
                    e.getPlayer().addPotionEffect(potionEffect);
                }
            }else if (e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLocalizedName().contains("斧")) {
                if (axe_energy==0) {
                    e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                }else {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, axe_energy - 1);
                    e.getPlayer().addPotionEffect(potionEffect);
                }
            }else if (e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLocalizedName().contains("锹")) {
                if (shovel_energy==0) {
                    e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                }else {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, shovel_energy - 1);
                    e.getPlayer().addPotionEffect(potionEffect);
                }
            }else if (e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLocalizedName().contains("物质锤")) {
                if (hammer_energy==0) {
                    e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                }else {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, hammer_energy - 1);
                    e.getPlayer().addPotionEffect(potionEffect);
                }
            }else if (e.getPlayer().getInventory().getItem(e.getNewSlot()).getItemMeta().getLocalizedName().contains("钉头锤")) {
                if (morningstar_energy==0) {
                    e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
                }else {
                    PotionEffect potionEffect = new PotionEffect(PotionEffectType.FAST_DIGGING, Integer.MAX_VALUE, morningstar_energy - 1);
                    e.getPlayer().addPotionEffect(potionEffect);
                }
            }
        }else {
            e.getPlayer().removePotionEffect(PotionEffectType.FAST_DIGGING);
        }
    }
}
