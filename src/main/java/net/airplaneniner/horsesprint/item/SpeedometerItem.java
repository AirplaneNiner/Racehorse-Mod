package net.airplaneniner.horsesprint.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;

public class SpeedometerItem extends Item {
	public SpeedometerItem() {
		super(new Item.Properties());
	}

	@Override
	public boolean hasCraftingRemainingItem() {
		return true;
	}

	@Override
	public ItemStack getCraftingRemainingItem(ItemStack itemstack) {
		return new ItemStack(this);
	}
}