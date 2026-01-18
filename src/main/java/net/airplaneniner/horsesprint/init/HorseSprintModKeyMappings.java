/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.airplaneniner.horsesprint.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.airplaneniner.horsesprint.network.ToggleHorseSprintMessage;
import net.airplaneniner.horsesprint.HorseSprintMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class HorseSprintModKeyMappings {
	public static final KeyMapping TOGGLE_HORSE_SPRINT = new KeyMapping("key.horse_sprint.toggle_horse_sprint", GLFW.GLFW_KEY_LEFT_CONTROL, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				HorseSprintMod.PACKET_HANDLER.sendToServer(new ToggleHorseSprintMessage(0, 0));
				ToggleHorseSprintMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				TOGGLE_HORSE_SPRINT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - TOGGLE_HORSE_SPRINT_LASTPRESS);
				HorseSprintMod.PACKET_HANDLER.sendToServer(new ToggleHorseSprintMessage(1, dt));
				ToggleHorseSprintMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long TOGGLE_HORSE_SPRINT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(TOGGLE_HORSE_SPRINT);
	}

	@Mod.EventBusSubscriber(Dist.CLIENT)
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				TOGGLE_HORSE_SPRINT.consumeClick();
			}
		}
	}
}