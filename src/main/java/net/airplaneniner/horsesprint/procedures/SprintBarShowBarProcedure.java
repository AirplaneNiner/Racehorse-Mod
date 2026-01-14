package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

public class SprintBarShowBarProcedure {
	public static boolean execute(LevelAccessor world) {
		return HorseSprintModVariables.MapVariables.get(world).horseIsSprinting == true;
	}
}