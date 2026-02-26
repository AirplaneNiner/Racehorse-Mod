package net.airplaneniner.horsesprint.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.airplaneniner.horsesprint.procedures.ReturnSpeedProcedure;

public class SpeedTimerItem extends Item {
	public SpeedTimerItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public int getUseDuration(ItemStack itemstack) {
		return 5;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		ReturnSpeedProcedure.execute(entity);
		return ar;
	}
}