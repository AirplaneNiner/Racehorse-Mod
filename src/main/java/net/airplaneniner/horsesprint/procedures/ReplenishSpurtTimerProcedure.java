package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import net.airplaneniner.horsesprint.HorseSprintMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ReplenishSpurtTimerProcedure {
	@SubscribeEvent
	public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.player.level(), event.player);
		}
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!HorseSprintModVariables.MapVariables.get(world).horseIsSprinting) {
			if (((entity.getVehicle()) instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
					? _livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()).getBaseValue()
					: 0) < ((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
							? _livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()).getBaseValue()
							: 0)) {
				if (HorseSprintModVariables.MapVariables.get(world).SecondTimer == 20) {
					if ((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
						_livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
								.setBaseValue((((entity.getVehicle()) instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
										? _livingEntity5.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()).getBaseValue()
										: 0) + 0.5));
					HorseSprintMod.LOGGER.info(new java.text.DecimalFormat("##.##").format((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
							? _livingEntity9.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()).getBaseValue()
							: 0));
				}
			}
			if (((entity.getVehicle()) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
					? _livingEntity11.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()).getBaseValue()
					: 0) > 0) {
				HorseSprintModVariables.MapVariables.get(world).horseCanSprint = true;
				HorseSprintModVariables.MapVariables.get(world).markSyncDirty();
			}
		}
	}
}