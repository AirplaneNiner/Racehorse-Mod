package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import sekelsta.horse_colors.entity.HorseGeneticEntity;

public class ToggleIsSprintingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            // Failing the failsafes in ToggleHorseSprintOnKeyReleased, a command is provided to force-toggle sprint on/off
            if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseIsSprinting) {
				{
					entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
						capability.horseIsSprinting = false;
						capability.markSyncDirty();
					});
				}
			} else {
				{
					entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
						capability.horseIsSprinting = true;
						capability.markSyncDirty();
					});
				}
			}
		} else {
			return false;
		}
		return true;
	}
}