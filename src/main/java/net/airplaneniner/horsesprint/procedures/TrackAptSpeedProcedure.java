package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;

import javax.annotation.Nullable;
import java.util.Objects;

@Mod.EventBusSubscriber
public class TrackAptSpeedProcedure {
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            execute(event, event.player.level(), event.player);
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && _livingEntity3.getAttributes().hasAttribute(HorseSprintModAttributes.TRACK_APT.get())
                    ? Objects.requireNonNull(_livingEntity3.getAttribute(HorseSprintModAttributes.TRACK_APT.get())).getBaseValue()
                    : 0) == 1) {
                if (!((world.getBlockState(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ()))).getBlock() == Blocks.DIRT
                        || (world.getBlockState(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ()))).getBlock() == Blocks.SAND
                        || (world.getBlockState(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ()))).getBlock() == Blocks.COARSE_DIRT
                        || (world.getBlockState(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ()))).getBlock() == Blocks.SANDSTONE_SLAB)) {
                    if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                        AttributeModifier modifier = new AttributeModifier("horse_sprint:penalty", (-0.1), AttributeModifier.Operation.ADDITION);
                        if (Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().noneMatch((e) -> e.getName().equals(modifier.getName()))) {
                            Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
                        }
                    }
                } else {
                    if ((entity.getVehicle()) instanceof LivingEntity _livingEntity39 && Objects.requireNonNull(_livingEntity39.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:penalty"))) {
                        if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                            Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().forEach((_attribute) -> {
                                if (_attribute.getName().equals("horse_sprint:penalty"))
                                    Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(_attribute);
                            });
                        }
                    }
                }
            } else {
                if (!((world.getBlockState(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ()))).getBlock() == Blocks.GRASS_BLOCK
                        || (world.getBlockState(BlockPos.containing((entity.getVehicle()).getX(), (entity.getVehicle()).getY() - 1, (entity.getVehicle()).getZ()))).getBlock() == Blocks.SANDSTONE_SLAB)) {
                    if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                        AttributeModifier modifier = new AttributeModifier("horse_sprint:penalty", (-0.1), AttributeModifier.Operation.ADDITION);
                        if (Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().noneMatch((e) -> e.getName().equals(modifier.getName()))) {
                            Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
                        }
                    }
                } else {
                    if ((entity.getVehicle()) instanceof LivingEntity _livingEntity61 && Objects.requireNonNull(_livingEntity61.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:penalty"))) {
                        if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                            Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().forEach((_attribute) -> {
                                if (_attribute.getName().equals("horse_sprint:penalty"))
                                    Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(_attribute);
                            });
                        }
                    }
                }
            }
        }
    }
}