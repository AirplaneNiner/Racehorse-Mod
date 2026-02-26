package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

public class ReturnSpeedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).TimerState == 1) {
			{
				entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.TimerState = 0;
					capability.markSyncDirty();
				});
			}
			if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).distance != 0) {
				if (entity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(
							Component.literal(("Timer stopped! Travelled " + new java.text.DecimalFormat("###").format(entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).distance)
									+ "m in " + new java.text.DecimalFormat("###").format(entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).time) + " sec at "
									+ new java.text.DecimalFormat("##.##").format((entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).distance
											/ entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).time) * 3.6)
									+ "km/h")),
							false);
			}
		} else {
			{
				entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.TimerState = 1;
					capability.distance = 0;
					capability.time = 0;
					capability.markSyncDirty();
				});
			}
			if (entity instanceof Player _player && !_player.level().isClientSide())
				_player.displayClientMessage(Component.literal("Timer started!"), false);
		}
	}
}