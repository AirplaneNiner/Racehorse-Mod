package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;

public class ReturnSpeedProcedure {
    public static void execute(Entity entity) {
        if (entity == null)
            return;
        if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).TimerState == 1) {
            {
                entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                    capability.TimerState = 0;
                    capability.markSyncDirty();
                });
            }
            if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).timertime != 0) {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component
                                    .literal(("Timer stopped! Travelled " + new java.text.DecimalFormat("###").format(entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).timerdistance)
                                            + "m in " + new java.text.DecimalFormat("###").format(entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).timertime) + " sec at "
                                            + new java.text.DecimalFormat("##.##").format((entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).timerdistance
                                            / entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).timertime) * 3.6)
                                            + "km/h")),
                            false);
            } else {
                if (entity instanceof Player _player && !_player.level().isClientSide())
                    _player.displayClientMessage(Component.literal("Timer stopped!"), false);
            }
        } else {
            {
                entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                    capability.TimerState = 1;
                    capability.timerdistance = 0;
                    capability.timertime = 0;
                    capability.markSyncDirty();
                });
            }
            if (entity instanceof Player _player && !_player.level().isClientSide())
                _player.displayClientMessage(Component.literal("Timer started!"), false);
        }
    }
}