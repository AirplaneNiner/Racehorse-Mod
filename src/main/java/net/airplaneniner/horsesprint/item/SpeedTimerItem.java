package net.airplaneniner.horsesprint.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.airplaneniner.horsesprint.procedures.ReturnSpeedProcedure;
import org.jetbrains.annotations.NotNull;

public class SpeedTimerItem extends Item {
	public SpeedTimerItem() {
		super(new Item.Properties().stacksTo(1));
	}

	@Override
	public int getUseDuration(@NotNull ItemStack itemstack) {
		return 5;
	}

	@Override
	public @NotNull InteractionResultHolder<ItemStack> use(@NotNull Level world, @NotNull Player entity, @NotNull InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		entity.startUsingItem(hand);
		ReturnSpeedProcedure.execute(entity);
		return ar;
	}
}