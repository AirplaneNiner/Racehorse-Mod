package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class ReplenishSpurtTimerProcedure {
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
        if (!entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseIsSprinting) {
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity1 && _livingEntity1.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
                    ? Objects.requireNonNull(_livingEntity1.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())).getBaseValue()
                    : 0) < ((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())
                    ? Objects.requireNonNull(_livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_MAX_SPURT_TIMER.get())).getBaseValue()
                    : 0)) {
                if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).SecondTimer == 20) {
                    if ((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
                        Objects.requireNonNull(_livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get()))
                                .setBaseValue((((entity.getVehicle()) instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
                                        ? Objects.requireNonNull(_livingEntity5.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())).getBaseValue()
                                        : 0) + 0.5));
                }
            }
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())
                    ? Objects.requireNonNull(_livingEntity9.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).getBaseValue()
                    : 0) != 0) {
                if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).SecondTimer == 20) {
                    if ((entity.getVehicle()) instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                        Objects.requireNonNull(_livingEntity13.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                                .setBaseValue((((entity.getVehicle()) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())
                                        ? Objects.requireNonNull(_livingEntity11.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).getBaseValue()
                                        : 0) - 1));
                }
            }
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())
                    ? Objects.requireNonNull(_livingEntity15.getAttribute(HorseSprintModAttributes.HORSE_SPURT_TIMER.get())).getBaseValue()
                    : 0) > 0) {
                if (((entity.getVehicle()) instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())
                        ? Objects.requireNonNull(_livingEntity17.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).getBaseValue()
                        : 0) == 0) {
                    {
                        entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                            capability.horseCanSprint = true;
                            capability.markSyncDirty();

                        });
                    }
                }
            }
        }
    }
}