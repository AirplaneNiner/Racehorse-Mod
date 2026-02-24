package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class ResetDistProcedure {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != InteractionHand.MAIN_HAND)
            return;
        execute(event, event.getTarget());
    }

    public static void execute(Entity entity) {
        execute(null, entity);
    }

    private static void execute(@Nullable Event event, Entity entity) {
        if (entity == null)
            return;
        if (entity instanceof HorseGeneticEntity livingEntity2) {
            if (livingEntity2.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())) {
                Objects.requireNonNull(livingEntity2.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get()))
                        .setBaseValue(livingEntity2.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                ? Objects.requireNonNull(livingEntity2.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                : 0);
            }
            if (livingEntity2.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get()))
                Objects.requireNonNull(livingEntity2.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())).setBaseValue(0);
            if (livingEntity2.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get()))
                Objects.requireNonNull(livingEntity2.getAttribute(HorseSprintModAttributes.HORSE_SPURT_COOLDOWN.get())).setBaseValue(0);
        }
    }
}