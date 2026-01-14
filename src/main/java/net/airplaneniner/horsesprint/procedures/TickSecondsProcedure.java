package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TickSecondsProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level());
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		if (HorseSprintModVariables.MapVariables.get(world).SecondTimer == 20) {
			HorseSprintModVariables.MapVariables.get(world).SecondTimer = 0;
			HorseSprintModVariables.MapVariables.get(world).markSyncDirty();
		} else {
			HorseSprintModVariables.MapVariables.get(world).SecondTimer = HorseSprintModVariables.MapVariables.get(world).SecondTimer + 1;
			HorseSprintModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}