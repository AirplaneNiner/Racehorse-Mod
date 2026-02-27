package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.NonNullList;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModItems;

import javax.annotation.Nullable;

import java.util.List;

@Mod.EventBusSubscriber
public class SprintBarDisplaySpeedProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player);
        }
    }

    public static String execute(Entity entity) {
        return execute(null, entity);
    }

    private static String execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return "";
        double estspeed = 0;
        if (hasEntityInInventory(entity, new ItemStack(HorseSprintModItems.SPEEDOMETER.get()))) {
            if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).SecondTimer == 20
                    && entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).speed != 0) {
                estspeed = Mth.nextDouble(RandomSource.create(), -0.5, 0.5);
            }
            return "Speed: " + new java.text.DecimalFormat("##.#").format(entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).speed * 3.6 + estspeed) + "km/h";
        }
        return "";
    }

    private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
        if (entity instanceof Player player) {
            Inventory inventory = player.getInventory();
            List<NonNullList<ItemStack>> compartments = com.google.common.collect.ImmutableList.of(inventory.items, inventory.armor, inventory.offhand);
            for (List<ItemStack> list : compartments) {
                for (ItemStack itemstack2 : list) {
                    if (!itemstack2.isEmpty() && ItemStack.isSameItem(itemstack2, itemstack)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}