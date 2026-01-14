package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

public class ToggleHorseSprintOnKeyReleasedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof Horse) {
			if ((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:spurt"))) {
				if ((entity.getVehicle()) instanceof LivingEntity _entity) {
					_entity.getAttribute(Attributes.MOVEMENT_SPEED).getModifiers().forEach((_attribute) -> {
						if (_attribute.getName().equals("horse_sprint:spurt"))
							_entity.getAttribute(Attributes.MOVEMENT_SPEED).removeModifier(_attribute);
					});
				}
				HorseSprintModVariables.MapVariables.get(world).horseIsSprinting = false;
				HorseSprintModVariables.MapVariables.get(world).markSyncDirty();
				ReplenishSpurtTimerProcedure.execute(world, entity);
			}
		}
	}
}