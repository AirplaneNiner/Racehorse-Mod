package net.airplaneniner.horsesprint.procedures;

import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import java.util.Objects;

public class ReturnDistRemainingProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
			return "Dist remaining: " + (new java.text.DecimalFormat("##.##").format((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
					? Objects.requireNonNull(_livingEntity3.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
					: 0));
		}
		return "";
	}
}