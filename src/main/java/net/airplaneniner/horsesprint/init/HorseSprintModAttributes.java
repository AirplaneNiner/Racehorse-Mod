package net.airplaneniner.horsesprint.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EntityType;

import sekelsta.horse_colors.entity.ModEntities;
import sekelsta.horse_colors.world.*;

import net.airplaneniner.horsesprint.HorseSprintMod;

import java.util.stream.Collectors;
import java.util.List;
import java.util.stream.Stream;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HorseSprintModAttributes {
	public static final DeferredRegister<Attribute> REGISTRY = DeferredRegister
			.create(ForgeRegistries.ATTRIBUTES, HorseSprintMod.MODID);
	public static final RegistryObject<Attribute> HORSE_STAMINA = REGISTRY
			.register("horse_stamina", () -> new RangedAttribute("attribute.horse_sprint.horse_stamina", 0.05875, 0.05875, 0.16875).setSyncable(true));
	public static final RegistryObject<Attribute> HORSE_SPURT = REGISTRY
			.register("horse_spurt", () -> new RangedAttribute("attribute.horse_sprint.horse_spurt", 0.4, 0.4, 1).setSyncable(true));
	public static final RegistryObject<Attribute> HORSE_SPURT_TIMER = REGISTRY
			.register("horse_spurt_timer", () -> new RangedAttribute("attribute.horse_sprint.horse_spurt_timer", 0, 0, 99).setSyncable(true));
	public static final RegistryObject<Attribute> HORSE_MAX_SPURT_TIMER = REGISTRY
			.register("horse_max_spurt_timer", () -> new RangedAttribute("attribute.horse_sprint.horse_max_spurt_timer", 0, 0, 99).setSyncable(true));

	@SubscribeEvent
	public static void addAttributes(EntityAttributeModificationEvent event) {
		Stream.of(ModEntities.HORSE_GENETIC)
				.filter(DefaultAttributes::hasSupplier)
				.map(entityType -> (EntityType<? extends LivingEntity>) entityType)
				.toList()
				.forEach(entity -> event.add(entity, HORSE_STAMINA.get()));
		Stream.of(ModEntities.HORSE_GENETIC)
				.filter(DefaultAttributes::hasSupplier)
				.map(entityType -> (EntityType<? extends LivingEntity>) entityType)
				.toList().forEach(entity -> event.add(entity, HORSE_SPURT.get()));
		Stream.of(ModEntities.HORSE_GENETIC)
				.filter(DefaultAttributes::hasSupplier)
				.map(entityType -> (EntityType<? extends LivingEntity>) entityType)
				.toList().forEach(entity -> event.add(entity, HORSE_SPURT_TIMER.get()));
		Stream.of(ModEntities.HORSE_GENETIC)
				.filter(DefaultAttributes::hasSupplier)
				.map(entityType -> (EntityType<? extends LivingEntity>) entityType).toList()
				.forEach(entity -> event.add(entity, HORSE_MAX_SPURT_TIMER.get()));
	}
}