package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ApplyHorseStaminaProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Horse) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
				_livingEntity2.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.05875, 0.16875)));
			if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get()))
				_livingEntity4.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
						.setBaseValue((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity3.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0));
			if ((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity5.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) <= 0.2) {
				if (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
					_livingEntity8.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
							.setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
									? _livingEntity6.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
									: 0) * Mth.nextInt(RandomSource.create(), 15, 22)));
			} else if ((entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
					? _livingEntity9.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue()
					: 0) > 0.2 == ((entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity10.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) <= 0.25)) {
				if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
					_livingEntity13.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
							.setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
									? _livingEntity11.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
									: 0) * Mth.nextInt(RandomSource.create(), 9, 17)));
			} else if ((entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
					? _livingEntity14.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue()
					: 0) > 0.25 == ((entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity15.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) <= 0.3)) {
				if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
					_livingEntity18.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
							.setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
									? _livingEntity16.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
									: 0) * Mth.nextInt(RandomSource.create(), 5, 13)));
			} else if ((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity19.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.3) {
				if (entity instanceof LivingEntity _livingEntity22 && _livingEntity22.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
					_livingEntity22.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
							.setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
									? _livingEntity20.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
									: 0) * Mth.nextInt(RandomSource.create(), 3, 8)));
			}
			if (entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
				_livingEntity24.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
						.setBaseValue((entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
								? _livingEntity23.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()).getValue()
								: 0));
			HorseSprintModVariables.MapVariables.get(world).horseCanSprint = true;
			HorseSprintModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}