package net.airplaneniner.horsesprint.procedures;

import net.airplaneniner.horsesprint.init.HorseSprintModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.NonNullList;

import java.util.List;
import java.util.Objects;

public class SprintBarDisplaySpeedProcedure {
	public static String execute(Entity entity) {
//		if (entity == null)
//			return "";
//        // Display horse speed if player has a Speedometer
//        if (hasEntityInInventory(entity, new ItemStack(HorseSprintModItems.SPEEDOMETER.get()))) {
//			return "Speed: " + (new java.text.DecimalFormat("##.##")
//					.format(((entity.getVehicle()) instanceof LivingEntity _livingEntity2 && _livingEntity2.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED) ? Objects.requireNonNull(_livingEntity2.getAttribute(Attributes.MOVEMENT_SPEED)).getValue() : 0) * 43.17));
//		}
		return "";
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player) {
			Inventory inventory = player.getInventory();
			List<NonNullList<ItemStack>> compartments = com.google.common.collect.ImmutableList.of(inventory.items, inventory.armor, inventory.offhand);
			for (List<ItemStack> list : compartments) {
				for (ItemStack itemstack2 : list) {
					if (!itemstack2.isEmpty() && ItemStack.isSameItem(itemstack2, itemstack)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}