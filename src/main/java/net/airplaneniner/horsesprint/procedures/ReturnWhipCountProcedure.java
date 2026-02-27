package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class ReturnWhipCountProcedure {
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
        double whipdist = 0;
        if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                    ? Objects.requireNonNull(_livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                    : 0) > 1200) {
                whipdist = 400;
            } else if (((entity.getVehicle()) instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                    ? Objects.requireNonNull(_livingEntity5.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                    : 0) > 900) {
                whipdist = 300;
            } else {
                whipdist = 200;
            }
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
                    ? Objects.requireNonNull(_livingEntity7.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
                    : 0) > whipdist) {
                return "Cannot whip yet!";
            }
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
                    ? Objects.requireNonNull(_livingEntity9.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
                    : 0) <= whipdist
                    && ((entity.getVehicle()) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
                    ? Objects.requireNonNull(_livingEntity11.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
                    : 0) > 0) {
                return "Left click to whip!";
            }
        }
        return "";
    }
}