package net.airplaneniner.horsesprint.procedures;

import sekelsta.horse_colors.entity.HorseGeneticEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

import java.util.Objects;

public class ToggleHorseSprintOnKeyReleasedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
			if ((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && Objects.requireNonNull(_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:spurt"))) {
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
			}
		}
	}
}