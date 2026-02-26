package net.airplaneniner.horsesprint.procedures;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import sekelsta.horse_colors.entity.HorseGeneticEntity;

import javax.annotation.Nullable;
import java.util.Objects;

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
		if (entity instanceof HorseGeneticEntity livingEntity1) {
            // Apply speed increase
            // This is based off the jump strength of the horse
            // In future, will use RHG attributes
            if ((livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) <= 0.55) {
                if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                    Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.05875, 0.07)));
            } else {
                if ((livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) > 0.55 && (livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) <= 0.7) {
                    if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                        Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.07, 0.1)));
                } else {
                    if ((livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) > 0.7 && (livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) <= 0.875) {
                        if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                            Objects.requireNonNull(Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.1, 0.125)));
                    } else {
                        if ((livingEntity1.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) > 0.875) {
                            if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))
                                Objects.requireNonNull(Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get()))).setBaseValue((Mth.nextDouble(RandomSource.create(), 0.125, 0.16875)));
                        }
                    }
                }
            }

            // Apply spurt modifier
            // This is based off the HP of the horse
            if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())) {
                Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()))
                        .setBaseValue((livingEntity1.getAttributes().hasAttribute(Attributes.MAX_HEALTH) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MAX_HEALTH)).getBaseValue() : 0) / 40);
            }

            // Apply spurt time
            // This is based off the base speed of the horse
            if ((livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() : 0) <= 0.2) {
                if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())) {
                    Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                            .setBaseValue(Math.ceil((livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                    ? Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get())).getBaseValue()
                                    : 0) * Mth.nextInt(RandomSource.create(), 15, 20)));
                }
            } else {
                if ((livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
                        ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue()
                        : 0) > 0.2 == (livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() : 0) <= 0.25) {
                    if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())) {
                        Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                                .setBaseValue(Math.ceil((livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                        ? Objects.requireNonNull(Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get()))).getBaseValue()
                                        : 0) * Mth.nextInt(RandomSource.create(), 12, 17)));
                    }
                } else {
                    if ((livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED)
                            ? Objects.requireNonNull(Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED))).getBaseValue()
                            : 0) > 0.25 == (livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED))).getBaseValue() : 0) <= 0.3) {
                        if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())) {
                            Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                                    .setBaseValue(Math.ceil((livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                            ? Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get())).getBaseValue()
                                            : 0) * Mth.nextInt(RandomSource.create(), 10, 15)));
                        }
                    } else {
                        if ((livingEntity1.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(livingEntity1.getAttribute(Attributes.MOVEMENT_SPEED)).getBaseValue() : 0) > 0.3) {
                            if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())) {
                                Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get()))
                                        .setBaseValue(Math.ceil((livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT.get())
                                                ? Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT.get())).getBaseValue()
                                                : 0) * Mth.nextInt(RandomSource.create(), 7, 12)));
                            }
                        }
                    }
                }
            }

            // Fill up spurt timer and set cooldown to 0
            if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())) {
                Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
                        .setBaseValue(livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                                ? Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())).getValue()
                                : 0);
            }
            if (livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                Objects.requireNonNull(livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).setBaseValue(0);
            {
                entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                    capability.horseCanSprint = true;
                    capability.markSyncDirty();
                });
            }
            ApplyAptitudesProcedure.execute(entity);
        }
	}
}