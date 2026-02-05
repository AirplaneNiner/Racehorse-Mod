package net.airplaneniner.horsesprint.procedures;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import sekelsta.horse_colors.entity.HorseGeneticEntity;

import java.util.Objects;

public class ToggleIsSprintingProcedure {
    public static boolean execute(Entity entity) {
        if (entity == null)
            return false;
        if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseIsSprinting) {
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = false;
                        capability.markSyncDirty();
                    });
                }
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Sprint deactivated!"), false);
                ToggleHorseSprintOnKeyReleasedProcedure.execute(entity);
            } else {
                if (((entity.getVehicle()) instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())
                        ? Objects.requireNonNull(_livingEntity4.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).getBaseValue()
                        : 0) == 0) {
                    {
                        entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                            capability.horseIsSprinting = true;
                            capability.markSyncDirty();
                        });
                    }
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Sprint activated!"), false);
                    ToggleHorseSprintOnKeyPressedProcedure.execute(entity);
                } else {
                    if (entity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal("Cooldown must be 0 to activate sprint!"), false);
                }
            }
        } else {
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("You must be riding a horse to use this command!"), false);
            return false;
        }
        return true;
    }
}