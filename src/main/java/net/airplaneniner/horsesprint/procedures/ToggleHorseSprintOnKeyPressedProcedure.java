package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import net.airplaneniner.horsesprint.HorseSprintMod;

public class ToggleHorseSprintOnKeyPressedProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof Horse) {
			if (HorseSprintModVariables.MapVariables.get(world).horseCanSprint) {
				if ((entity.getVehicle()) instanceof LivingEntity _entity) {
					AttributeModifier modifier = new AttributeModifier("horse_sprint:spurt",
							((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())
									? _livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()).getBaseValue()
									: 0),
							AttributeModifier.Operation.ADDITION);
					if (_entity.getAttribute(Attributes.MOVEMENT_SPEED).getModifiers().stream().noneMatch((e) -> e.getName().equals(modifier.getName()))) {
						_entity.getAttribute(Attributes.MOVEMENT_SPEED).addPermanentModifier(modifier);
					}
				}
				HorseSprintMod.LOGGER.info(new java.text.DecimalFormat("##.##")
						.format((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity7.getAttribute(Attributes.MOVEMENT_SPEED).getValue() : 0));
				TickSpurtTimerProcedure.execute(world, entity);
			}
		}
	}
}