package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TickSecondsProcedure {
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
		if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).SecondTimer == 20) {
			{
				entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.SecondTimer = 0;
					capability.markSyncDirty();
				});
			}
		} else {
			{
				entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
					capability.SecondTimer = entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).SecondTimer + 1;
					capability.markSyncDirty();
				});
			}
		}
	}
}