package com.webthomas.horsesprint.init;

import com.webthomas.horsesprint.HorseSprint;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Attributes {

    public static final DeferredRegister<Attribute> REGISTERY = DeferredRegister.create(ForgeRegistries.ATTRIBUTES, HorseSprint.MODID);

    public static final RegistryObject<Attribute> HORSE_STAMINA = REGISTERY.register("horse_stamina",
            () -> new RangedAttribute("attribute.horse_sprint.horse_stamina", 0.05875, 0.05875, 0.16875).setSyncable(true));

    public static final RegistryObject<Attribute> HORSE_SPURT = REGISTERY.register("horse_spurt",
            () -> new RangedAttribute("attribute.horse_sprint.horse_spurt", 0.4, 0.4, 1).setSyncable(true));

    public static final RegistryObject<Attribute> HORSE_SPURT_TIMER = REGISTERY.register("horse_spurt_timer",
            () -> new RangedAttribute("attribute.horse_sprint.horse_spurt_timer", 0, 0, 99).setSyncable(true));

    public static final RegistryObject<Attribute> HORSE_MAX_SPURT_TIMER = REGISTERY.register("horse_max_spurt_timer",
            () -> new RangedAttribute("attribute.horse_sprint.horse_max_spurt_timer", 0, 0, 99).setSyncable(true));


    public static void addAttributes(EntityAttributeModificationEvent event) {
        Stream.of(EntityType.HORSE).filter(DefaultAttributes::hasSupplier)
                .map(entityType -> (EntityType<? extends LivingEntity>) entityType)
                .toList().forEach(entity -> event.add(entity, HORSE_STAMINA.get()));

        Stream.of(EntityType.HORSE).filter(DefaultAttributes::hasSupplier)
                .map(entityType -> (EntityType<? extends LivingEntity>) entityType)
                .toList().forEach(entity -> event.add(entity, HORSE_SPURT.get()));

        Stream.of(EntityType.HORSE).filter(DefaultAttributes::hasSupplier)
                .map(entityType -> (EntityType<? extends LivingEntity>) entityType)
                .toList().forEach(entity -> event.add(entity, HORSE_SPURT_TIMER.get()));

        Stream.of(EntityType.HORSE).filter(DefaultAttributes::hasSupplier)
                .map(entityType -> (EntityType<? extends LivingEntity>) entityType)
                .toList().forEach(entity -> event.add(entity, HORSE_MAX_SPURT_TIMER.get()));
    }


    public static void register(IEventBus bus){
        REGISTERY.register(bus);
    }

}
