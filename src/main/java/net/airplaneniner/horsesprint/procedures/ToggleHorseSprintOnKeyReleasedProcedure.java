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
			if ((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && Objects.requireNonNull(_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:spurt"))) {
                // Remove sprint modifier from speed
                if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                    Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().forEach((_attribute) -> {
                        if (_attribute.getName().equals("horse_sprint:spurt"))
                            Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(_attribute);
                    });
                }
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = false;
                        capability.markSyncDirty();
                    });
                }
                ReplenishSpurtTimerProcedure.execute(entity);

                // Failsafe: check if horse speed is clean (no modifiers)
                if (((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
                        ? Objects.requireNonNull(_livingEntity7.getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue()
                        : 0) != ((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(_livingEntity9.getAttribute(Attributes.MOVEMENT_SPEED)).getValue() : 0)) {
                    {
                        entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                            capability.horseIsSprinting = false;
                            capability.markSyncDirty();
                        });
                    }
                }

                // Failsafe: check if spurt timer has hit zero
                if ((entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
                        ? Objects.requireNonNull(_livingEntity10.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())).getBaseValue()
                        : 0) == 0) {
                    {
                        entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                            capability.horseIsSprinting = false;
                            capability.markSyncDirty();
                        });
                    }
                }
            }
		}
	}
}