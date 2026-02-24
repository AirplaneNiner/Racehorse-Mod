package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

public class SprintBarShowBarProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		return entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseIsSprinting;
	}
}