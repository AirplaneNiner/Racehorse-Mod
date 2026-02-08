package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

public class ToggleIsSprintingProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity.getVehicle()) instanceof Horse) {
			if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseIsSprinting == true) {
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
						? _livingEntity4.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()).getBaseValue()
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