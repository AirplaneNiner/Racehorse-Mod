package net.airplaneniner.horsesprint.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;

import net.airplaneniner.horsesprint.procedures.ToggleHorseSprintOnKeyReleasedProcedure;
import net.airplaneniner.horsesprint.procedures.ToggleHorseSprintOnKeyPressedProcedure;
import net.airplaneniner.horsesprint.HorseSprintMod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ToggleHorseSprintMessage {
	int type, pressedms;

	public ToggleHorseSprintMessage(int type, int pressedms) {
		this.type = type;
		this.pressedms = pressedms;
	}

	public ToggleHorseSprintMessage(FriendlyByteBuf buffer) {
		this.type = buffer.readInt();
		this.pressedms = buffer.readInt();
	}

	public static void buffer(ToggleHorseSprintMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.type);
		buffer.writeInt(message.pressedms);
	}

	public static void handler(ToggleHorseSprintMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			pressAction(context.getSender(), message.type, message.pressedms);
		});
		context.setPacketHandled(true);
	}

	public static void pressAction(Player entity, int type, int pressedms) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(entity.blockPosition()))
			return;
		if (type == 0) {

			ToggleHorseSprintOnKeyPressedProcedure.execute(world, entity);
		}
		if (type == 1) {

			ToggleHorseSprintOnKeyReleasedProcedure.execute(world, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		HorseSprintMod.addNetworkMessage(ToggleHorseSprintMessage.class, ToggleHorseSprintMessage::buffer, ToggleHorseSprintMessage::new, ToggleHorseSprintMessage::handler);
	}
}