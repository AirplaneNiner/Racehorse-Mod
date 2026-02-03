package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import sekelsta.horse_colors.entity.HorseGeneticEntity;

import java.util.Objects;

public class ToggleIsSprintingProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseIsSprinting) {
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = false;
                        capability.markSyncDirty();
                    });
                }
                if ((entity.getVehicle()) instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                    Objects.requireNonNull(_livingEntity5.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                            .setBaseValue(Math.floor(((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())
                                    ? Objects.requireNonNull(_livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).getBaseValue()
                                    : 0) / 0.2));
            } else {
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = true;
                        capability.markSyncDirty();
                    });
                }
                if ((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                    Objects.requireNonNull(_livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).setBaseValue(0);
            }
        } else {
            return false;
        }
        return true;
    }
}