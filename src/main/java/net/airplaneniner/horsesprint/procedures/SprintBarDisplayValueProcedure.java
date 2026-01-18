package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

public class SprintBarDisplayValueProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (new java.text.DecimalFormat("##").format(Math.floor((entity.getVehicle()) instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
				? _livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()).getBaseValue()
				: 0)))
				+ ""
				+ ("/" + (new java.text.DecimalFormat("##").format((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
						? _livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()).getBaseValue()
						: 0)));
	}
}