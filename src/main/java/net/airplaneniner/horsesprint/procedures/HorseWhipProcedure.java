package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.ItemStack;
import sekelsta.horse_colors.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.airplaneniner.horsesprint.init.HorseSprintModAttributes;
import net.airplaneniner.horsesprint.HorseSprintMod;

import javax.annotation.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class HorseWhipProcedure {
    @SubscribeEvent
    public static void onLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
        HorseSprintMod.PACKET_HANDLER.sendToServer(new HorseWhipMessage());
        execute(event.getLevel(), event.getEntity());
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class HorseWhipMessage {
        public HorseWhipMessage() {
        }

        public HorseWhipMessage(FriendlyByteBuf buffer) {
        }

        public static void buffer(HorseWhipMessage message, FriendlyByteBuf buffer) {
        }

        public static void handler(HorseWhipMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
            NetworkEvent.Context context = contextSupplier.get();
            context.enqueueWork(() -> {
                if (!Objects.requireNonNull(context.getSender()).level().hasChunkAt(context.getSender().blockPosition()))
                    return;
                execute(context.getSender().level(), context.getSender());
            });
            context.setPacketHandled(true);
        }

        @SubscribeEvent
        public static void registerMessage(FMLCommonSetupEvent event) {
            HorseSprintMod.addNetworkMessage(HorseWhipMessage.class, HorseWhipMessage::buffer, HorseWhipMessage::new, HorseWhipMessage::handler);
        }
    }

    public static void execute(LevelAccessor world, Entity entity) {
        execute(null, world, entity);
    }

    private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
        if (entity == null)
            return;
        if ((entity.getVehicle()) instanceof HorseGeneticEntity) {
            if (!((entity.getVehicle()) instanceof LivingEntity _livingEntity3 && Objects.requireNonNull(_livingEntity3.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().anyMatch((e) -> e.getName().equals("horse_sprint:whipspurt")))) {
                if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == Items.STICK) {
                    if (((entity.getVehicle()) instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
                            ? Objects.requireNonNull(_livingEntity7.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
                            : 0) > 0 == (((entity.getVehicle()) instanceof LivingEntity _livingEntity9 && _livingEntity9.getAttributes().hasAttribute(HorseSprintModAttributes.DIST_REMAINING.get())
                            ? Objects.requireNonNull(_livingEntity9.getAttribute(HorseSprintModAttributes.DIST_REMAINING.get())).getBaseValue()
                            : 0) <= 200)) {
                        if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                            AttributeModifier modifier = new AttributeModifier("horse_sprint:whipspurt",
                                    ((entity.getVehicle()) instanceof LivingEntity _livingEntity11 && _livingEntity11.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())
                                            ? Objects.requireNonNull(_livingEntity11.getAttribute(HorseSprintModAttributes.HORSE_STAMINA.get())).getBaseValue()
                                            : 0),
                                    AttributeModifier.Operation.ADDITION);
                            if (Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().stream().noneMatch((e) -> e.getName().equals(modifier.getName()))) {
                                Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).addPermanentModifier(modifier);
                            }
                        }
                        if ((entity.getVehicle()) instanceof LivingEntity _livingEntity17 && _livingEntity17.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get()))
                            Objects.requireNonNull(_livingEntity17.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get()))
                                    .setBaseValue((((entity.getVehicle()) instanceof LivingEntity _livingEntity15 && _livingEntity15.getAttributes().hasAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())
                                            ? Objects.requireNonNull(_livingEntity15.getAttribute(HorseSprintModAttributes.HORSE_WHIP_COUNT.get())).getBaseValue()
                                            : 0) + 1));
                        if (world instanceof Level _level) {
                            if (!_level.isClientSide()) {
                                _level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("horse_sprint:whip"))), SoundSource.NEUTRAL, 1, 1);
                            } else {
                                _level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), Objects.requireNonNull(ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("horse_sprint:whip"))), SoundSource.NEUTRAL, 1, 1, false);
                            }
                        }
                        HorseSprintMod.queueServerWork(Mth.nextInt(RandomSource.create(), 20, 200), () -> {
                            if ((entity.getVehicle()) instanceof LivingEntity _entity) {
                                Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).getModifiers().forEach((_attribute) -> {
                                    if (_attribute.getName().equals("horse_sprint:whipspurt"))
                                        Objects.requireNonNull(_entity.getAttribute(Attributes.MOVEMENT_SPEED)).removeModifier(_attribute);
                                });
                            }
                        });
                    }
                }
            }
        }
    }
}