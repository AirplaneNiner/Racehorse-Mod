package net.airplaneniner.horsesprint.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.client.Minecraft;

import net.airplaneniner.horsesprint.procedures.SprintBarShowBarProcedure;
import net.airplaneniner.horsesprint.procedures.SprintBarDisplayValueProcedure;
import net.airplaneniner.horsesprint.procedures.SprintBarDisplaySpeedProcedure;
import net.airplaneniner.horsesprint.procedures.SprintBarDisplayOverlayIngameProcedure;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class SprintBarOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getWindow().getGuiScaledWidth();
		int h = event.getWindow().getGuiScaledHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (SprintBarDisplayOverlayIngameProcedure.execute(entity)) {
			if (SprintBarDisplayOverlayIngameProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						SprintBarDisplayValueProcedure.execute(entity), w / 2 + 93, h / 2 + 96, -1, false);
			if (SprintBarShowBarProcedure.execute(world))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.horse_sprint.sprint_bar.label_empty"), w / 2 + 93, h / 2 + 84, -1, false);
			if (SprintBarDisplayOverlayIngameProcedure.execute(entity))
				event.getGuiGraphics().drawString(Minecraft.getInstance().font,

						SprintBarDisplaySpeedProcedure.execute(entity), w / 2 + 93, h / 2 + 108, -1, false);
		}
	}
}