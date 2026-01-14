package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.network.chat.Component;

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
				_livingEntity4.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.4, 1)));
			if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
				_livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
						.setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
								? _livingEntity5.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
								: 0) * Mth.nextInt(RandomSource.create(), 20, 40)));
			if (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
				_livingEntity9.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
						.setBaseValue((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
								? _livingEntity8.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()).getValue()
								: 0));
			entity.setCustomName(Component.literal((new java.text.DecimalFormat("##.##").format(entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
					? _livingEntity10.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()).getValue()
					: 0))));
			HorseSprintModVariables.MapVariables.get(world).horseCanSprint = true;
			HorseSprintModVariables.MapVariables.get(world).markSyncDirty();
		}
	}
}