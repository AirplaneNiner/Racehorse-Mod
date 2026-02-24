package net.airplaneniner.horsesprint.procedures;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import java.util.Objects;

public class ApplyAptitudesProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof LivingEntity _livingEntity0 && _livingEntity0.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity0.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) < 0.6) {
			if (entity instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get()))
				Objects.requireNonNull(_livingEntity2.getAttribute(HorseSprintModAttributes.DIST_APT.get())).setBaseValue((200 / Mth.nextDouble(RandomSource.create(), 0.35, 0.5)));
		} else if ((entity instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity3.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) >= 0.6
				&& (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity4.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) < 0.7) {
			if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get()))
				Objects.requireNonNull(_livingEntity6.getAttribute(HorseSprintModAttributes.DIST_APT.get())).setBaseValue((200 / Mth.nextDouble(RandomSource.create(), 0.25, 0.4)));
		} else if ((entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity7.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) >= 0.7
				&& (entity instanceof LivingEntity _livingEntity8 && _livingEntity8.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity8.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) < 0.75) {
			if (entity instanceof LivingEntity _livingEntity10 && _livingEntity10.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get()))
				Objects.requireNonNull(_livingEntity10.getAttribute(HorseSprintModAttributes.DIST_APT.get())).setBaseValue((200 / Mth.nextDouble(RandomSource.create(), 0.2, 0.3)));
		} else if ((entity instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(Attributes.JUMP_STRENGTH) ? Objects.requireNonNull(_livingEntity11.getAttribute(Attributes.JUMP_STRENGTH)).getBaseValue() : 0) >= 0.75) {
			if (entity instanceof LivingEntity _livingEntity13 && _livingEntity13.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get()))
				Objects.requireNonNull(_livingEntity13.getAttribute(HorseSprintModAttributes.DIST_APT.get())).setBaseValue((200 / Mth.nextDouble(RandomSource.create(), 0.1, 0.25)));
		}
		if (entity instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get()))
			Objects.requireNonNull(_livingEntity15.getAttribute(HorseSprintModAttributes.DIST_APT.get())).setBaseValue(Math.round(
					entity instanceof LivingEntity _livingEntity14 && _livingEntity14.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get()) ? Objects.requireNonNull(_livingEntity14.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue() : 0));
		ResetDistProcedure.execute(entity);
	}
}