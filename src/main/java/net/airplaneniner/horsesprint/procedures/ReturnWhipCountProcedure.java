package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import java.util.Objects;

public class ReturnWhipCountProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Whip: " + (new java.text.DecimalFormat("##").format((entity.getVehicle()) instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())
				? Objects.requireNonNull(_livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())).getBaseValue()
				: 0));
	}
}