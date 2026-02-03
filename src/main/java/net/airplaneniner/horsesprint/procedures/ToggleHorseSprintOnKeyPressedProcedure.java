package net.airplaneniner.horsesprint.procedures;

import sekelsta.horse_colors.entity.HorseGeneticEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.airplaneniner.horsesprint.network.HorseSprintModVariables;
import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import java.util.Objects;

public class ToggleHorseSprintOnKeyPressedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).orElseGet(HorseSprintModVariables.PlayerVariables::new).horseCanSprint
                    && ((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())
                    ? Objects.requireNonNull(_livingEntity3.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).getBaseValue()
                    : 0) == 0) {
                if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                    AttributeModifier modifier = new AttributeModifier("horse_sprint:spurt",
                            ((entity.getVehicle()) instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())
                                    ? Objects.requireNonNull(_livingEntity5.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())).getBaseValue()
                                    : 0),
                            AttributeModifier.Operation.ADDITION);
                    if (Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().noneMatch((e) -> e.getName().equals(modifier.getName()))) {
                        Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
                    }
                }
                {
                    entity.getCapability(HorseSprintModVariables.PLAYER_VARIABLES).ifPresent(capability -> {
                        capability.horseIsSprinting = true;
                        capability.SecondTimer = 0;
                        capability.markSyncDirty();
                    });
                }
                TickSpurtTimerProcedure.execute(entity);
			}
		}
	}
}