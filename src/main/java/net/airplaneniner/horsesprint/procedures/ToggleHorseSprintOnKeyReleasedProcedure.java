package net.airplaneniner.horsesprint.procedures;

import sekelsta.horse_colors.entity.HorseGeneticEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import java.util.Objects;

public class ToggleHorseSprintOnKeyReleasedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
                    ? Objects.requireNonNull(_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue()
                    : 0) != ((entity.getVehicle()) instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(_livingEntity5.getAttribute(Attributes.MOVEMENT_SPEED)).getValue() : 0)) {
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = false;
                        capability.markSyncDirty();
                    });
                }
            }
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
                    ? Objects.requireNonNull(_livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())).getBaseValue()
                    : 0) == 0) {
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = false;
                        capability.markSyncDirty();
                    });
                }
            }
            if ((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && Objects.requireNonNull(_livingEntity9.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:spurt"))) {
                if ((entity.getVehicle()) instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                    Objects.requireNonNull(_livingEntity13.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).setBaseValue(Math.floor(
                            ((entity.getVehicle()) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity11.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) / 0.2));
                if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                    Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().forEach((_attribute) -> {
                        if (_attribute.getName().equals("horse_sprint:spurt"))
                            Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(_attribute);
                    });
                }
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = false;
                        capability.SecondTimer = 0;
                        capability.markSyncDirty();
                    });
                }
                ReplenishSpurtTimerProcedure.execute(entity);
            }
        }
    }
}