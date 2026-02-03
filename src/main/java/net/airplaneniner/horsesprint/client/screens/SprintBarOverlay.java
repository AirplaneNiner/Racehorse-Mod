package net.airplaneniner.horsesprint.client.screens;

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
import net.airplaneniner.horsesprint.procedures.SprintBarDisplayCooldownProcedure;

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

        if (

                SprintBarDisplayOverlayIngameProcedure.execute(entity)

        ) {

            if (

                    SprintBarDisplayOverlayIngameProcedure.execute(entity)

            )
                event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                        SprintBarDisplayValueProcedure.execute(entity), w / 2 + 94, h / 2 + 12, -1, false);
            if (

                    SprintBarShowBarProcedure.execute(entity)

            )
                event.getGuiGraphics().drawString(Minecraft.getInstance().font, Component.translatable("gui.horse_sprint.sprint_bar.label_empty"), w / 2 + 94, h / 2, -1, false);
            if (

                    SprintBarDisplayOverlayIngameProcedure.execute(entity)

            )
                event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                        SprintBarDisplaySpeedProcedure.execute(entity), w / 2 + 94, h / 2 + 25, -1, false);
            event.getGuiGraphics().drawString(Minecraft.getInstance().font,

                    SprintBarDisplayCooldownProcedure.execute(entity), w / 2 + 94, h / 2 + 38, -1, false);

        }

    }

}