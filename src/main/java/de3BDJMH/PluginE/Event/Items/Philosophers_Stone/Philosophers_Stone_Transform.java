package de3BDJMH.PluginE.Event.Items.Philosophers_Stone;

import de3BDJMH.PluginE.Functions.PlayerEMCInfo;
import de3BDJMH.PluginE.Items.Philosophers_Stone;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Philosophers_Stone_Transform implements Listener {
    static Random random = new Random();
    public static List<EntityType> animals = Arrays.asList(
            EntityType.ALLAY,
            EntityType.BAT,
            EntityType.CAMEL,
            EntityType.CHICKEN,
            EntityType.COD,
            EntityType.COW,
            EntityType.DONKEY,
            EntityType.GLOW_SQUID,
            EntityType.HORSE,
            EntityType.MUSHROOM_COW,
            EntityType.MULE,
            EntityType.PARROT,
            EntityType.PIG,
            EntityType.RABBIT,
            EntityType.SALMON,
            EntityType.SHEEP,
            EntityType.SKELETON_HORSE,
            EntityType.SNIFFER,
            EntityType.SQUID,
            EntityType.STRIDER,
            EntityType.TADPOLE,
            EntityType.TROPICAL_FISH,
            EntityType.TURTLE,
            EntityType.WANDERING_TRADER,
            EntityType.VILLAGER,
            EntityType.PUFFERFISH,
            EntityType.GOAT,
            EntityType.AXOLOTL,
            EntityType.CAT,
            EntityType.FROG,
            EntityType.OCELOT,
            EntityType.SNOWMAN,
            EntityType.BEE,
            EntityType.DOLPHIN,
            EntityType.FOX,
            EntityType.IRON_GOLEM,
            EntityType.LLAMA,
            EntityType.WOLF,
            EntityType.PANDA,
            EntityType.POLAR_BEAR
    );
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
            EntityType.ZOMBIFIED_PIGLIN
    );
    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e) {
        Player player = e.getPlayer();
        if (e.getRightClicked().getType()== EntityType.PLAYER) {
            return;
        }
        if (e.getHand()== EquipmentSlot.HAND && player.getInventory().getItemInMainHand().equals(Philosophers_Stone.get())) {
            e.setCancelled(true);
            Entity entity = e.getRightClicked();
            if (mobs.contains(entity.getType()) || animals.contains(entity.getType())) {
                if (PlayerEMCInfo.getEMC(player.getName())>=384) {
                    PlayerEMCInfo.pickout(player.getName(),384);
                    Location location = entity.getLocation();
                    entity.teleport(new Location(entity.getWorld(), 0, -10000, 0));
                    if (mobs.contains(entity.getType())) {
                        entity.getWorld().spawnEntity(location, mobs.get(random.nextInt(mobs.size())));
                    } else if (animals.contains(entity.getType())) {
                        entity.getWorld().spawnEntity(location, animals.get(random.nextInt(animals.size())));
                    }
                }
            }
        }
    }
}
