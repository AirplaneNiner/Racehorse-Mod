package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class GetSpeedProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player);
		}
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
			if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).SecondTimer == 20) {
				if (entity.getX() != entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).XOld
						|| entity.getZ() != entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).ZOld) {
					{
						entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
							capability.speed = Math.round(Math.sqrt(Math.pow(entity.getX() - entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).XOld, 2)
									+ Math.pow(entity.getZ() - entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).ZOld, 2)));
							capability.markSyncDirty();
						});
					}
				} else {
					{
						entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
							capability.speed = 0;
							capability.markSyncDirty();
						});
					}
				}
				{
					entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
						capability.XOld = entity.getX();
						capability.ZOld = entity.getZ();
						capability.markSyncDirty();
					});
				}
			}
		}
	}
}