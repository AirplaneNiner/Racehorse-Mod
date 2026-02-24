package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import net.airplaneniner.horsesprint.HorseSprintMod;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class HorseWhipProcedure {
	@SubscribeEvent
	public static void onRightClickItem(PlayerInteractEvent.RightClickItem event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getEntity());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
			if (!((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && Objects.requireNonNull(_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:whipspurt")))) {
				if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STICK
						&& ((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())
								? Objects.requireNonNull(_livingEntity7.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())).getBaseValue()
								: 0) < 3) {
					if (((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
							? Objects.requireNonNull(_livingEntity9.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
							: 0) > 0) {
						if ((entity.getVehicle()) instanceof LivingEntity _entity) {
							AttributeModifier modifier = new AttributeModifier("horse_sprint:whipspurt",
									((entity.getVehicle()) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())
											? Objects.requireNonNull(_livingEntity11.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())).getBaseValue()
											: 0),
									AttributeModifier.Operation.ADDITION);
							if (Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().noneMatch((e) -> e.getName().equals(modifier.getName()))) {
								Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
							}
						}
						if ((entity.getVehicle()) instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get()))
							Objects.requireNonNull(_livingEntity17.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get()))
									.setBaseValue((((entity.getVehicle()) instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())
											? Objects.requireNonNull(_livingEntity15.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())).getBaseValue()
											: 0) + 1));
						HorseSprintMod.queueServerWork(Mth.nextInt(RandomSource.create(), 20, 200), () -> {
							if ((entity.getVehicle()) instanceof LivingEntity _entity) {
								Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().forEach((_attribute) -> {
									if (_attribute.getName().equals("horse_sprint:whipspurt"))
										Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(_attribute);
								});
							}
						});
					}
				}
			}
		}
	}
}