package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

public class SprintBarDisplaySpeedProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return "Speed: " + (new java.text.DecimalFormat("##.##")
				.format(((entity.getVehicle()) instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED).getValue() : 0) * 43.17));
	}
}