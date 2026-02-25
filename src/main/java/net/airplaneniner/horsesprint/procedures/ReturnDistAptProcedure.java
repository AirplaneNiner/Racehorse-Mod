package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionHand;
import net.minecraft.network.chat.Component;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class ReturnDistAptProcedure {
    @SubscribeEvent
    public static void onRightClickEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getHand() != InteractionHand.MAIN_HAND)
            return;
        execute(event, event.getTarget(), event.getEntity());
    }

    public static void execute(Entity entity, Entity sourceentity) {
        execute(null, entity, sourceentity);
    }

    private static void execute(@Nullable Event event, Entity entity, Entity sourceentity) {
        if (entity == null || sourceentity == null)
            return;
        if (entity instanceof HorseGeneticEntity livingEntity3 && (sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.PAPER) {
            if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.TRACK_APT.get())
                    ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.TRACK_APT.get())).getBaseValue()
                    : 0) == 1) {
                if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                        ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                        : 0) < 600) {
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Sprint distances on Dirt")), false);
                } else {
                    if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                            ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                            : 0) >= 600 && (livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                            ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                            : 0) < 800) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Mile distances on Dirt")), false);
                    } else {
                        if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                : 0) >= 800 && (livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                : 0) < 1000) {
                            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Medium distances on Dirt")), false);
                        } else {
                            if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                    ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                    : 0) >= 1000) {
                                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Long distances on Dirt")), false);
                            }
                        }
                    }
                }
            } else {
                if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                        ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                        : 0) < 600) {
                    if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                        _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Sprint distances on Turf")), false);
                } else {
                    if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                            ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                            : 0) >= 600 && (livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                            ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                            : 0) < 800) {
                        if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                            _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Mile distances on Turf")), false);
                    } else {
                        if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                : 0) >= 800 && (livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                : 0) < 1000) {
                            if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Medium distances on Turf")), false);
                        } else {
                            if ((livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_APT.get())
                                    ? Objects.requireNonNull(livingEntity3.getAttribute(HorseSprintModAttributes.DIST_APT.get())).getBaseValue()
                                    : 0) >= 1000) {
                                if (sourceentity instanceof Player _player && !_player.level().isClientSide())
                                    _player.displayClientMessage(Component.literal((entity.getDisplayName().getString() + " is best suited for Long distances on Turf")), false);
                            }
                        }
                    }
                }
            }
        }
    }
}