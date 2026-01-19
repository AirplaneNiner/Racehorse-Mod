package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import sekelsta.horse_colors.entity.HorseGeneticEntity;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ApplyHorseStaminaProcedure {
	@SubscribeEvent
	public static void onEntitySpawned(EntityJoinLevelEvent event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof HorseGeneticEntity) {
            // Apply speed increase
            // This is based off the jump strength of the horse
            if ((entity instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity1.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) <= 0.55) {
                if (entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                    _livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.05875, 0.07)));
            } else if ((entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity4.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) > 0.55
                    && (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity5.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) <= 0.7) {
                if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                    _livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.07, 0.1)));
            } else if ((entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity8.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) > 0.7
                    && (entity instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity9.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) <= 0.875) {
                if (entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                    _livingEntity11.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.1, 0.125)));
            } else if ((entity instanceof LivingEntity _livingEntity12 && _livingEntity12.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? _livingEntity12.getAttribute(Attributes.JUMP_STRENGTH).getBaseValue() : 0) > 0.875) {
                if (entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                    _livingEntity14.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.125, 0.16875)));
            }

            // Apply spurt modifier
            // This is based off the HP of the horse
            if (entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get()))
                _livingEntity16.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                        .setBaseValue(((entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? _livingEntity15.getAttribute(Attributes.MAX_HEALTH).getBaseValue() : 0) / 40));

            // Apply spurt time
            // This is based off the base speed of the horse
            if ((entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity15.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) <= 0.2) {
                if (entity instanceof LivingEntity _livingEntity18 && _livingEntity18.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                    _livingEntity18.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                            .setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity16 && _livingEntity16.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                    ? _livingEntity16.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
                                    : 0) * Mth.nextInt(RandomSource.create(), 15, 22)));
            } else if ((entity instanceof LivingEntity _livingEntity19 && _livingEntity19.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity19.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.2
                    && (entity instanceof LivingEntity _livingEntity20 && _livingEntity20.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity20.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) <= 0.25) {
                if (entity instanceof LivingEntity _livingEntity23 && _livingEntity23.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                    _livingEntity23.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                            .setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity21 && _livingEntity21.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                    ? _livingEntity21.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
                                    : 0) * Mth.nextInt(RandomSource.create(), 9, 17)));
            } else if ((entity instanceof LivingEntity _livingEntity24 && _livingEntity24.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity24.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.25
                    && (entity instanceof LivingEntity _livingEntity25 && _livingEntity25.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity25.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) <= 0.3) {
                if (entity instanceof LivingEntity _livingEntity28 && _livingEntity28.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                    _livingEntity28.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                            .setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity26 && _livingEntity26.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                    ? _livingEntity26.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
                                    : 0) * Mth.nextInt(RandomSource.create(), 5, 13)));
            } else if ((entity instanceof LivingEntity _livingEntity29 && _livingEntity29.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? _livingEntity29.getAttribute(Attributes.MOVEMENT_SPEED).getBaseValue() : 0) > 0.3) {
                if (entity instanceof LivingEntity _livingEntity32 && _livingEntity32.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                    _livingEntity32.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                            .setBaseValue(Math.ceil((entity instanceof LivingEntity _livingEntity30 && _livingEntity30.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                    ? _livingEntity30.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()).getBaseValue()
                                    : 0) * Mth.nextInt(RandomSource.create(), 3, 8)));
            }

            // Fill up spurt timer
            if (entity instanceof LivingEntity _livingEntity34 && _livingEntity34.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
                _livingEntity34.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
                        .setBaseValue((entity instanceof LivingEntity _livingEntity33 && _livingEntity33.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                                ? _livingEntity33.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()).getValue()
                                : 0));
            {
                entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                    capability.horseCanSprint = true;
                    capability.markSyncDirty();
                });
            }
		}
	}
}