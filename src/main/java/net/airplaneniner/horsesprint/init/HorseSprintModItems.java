/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airplaneniner.horsesprint.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.Item;

import net.airplaneniner.horsesprint.item.SpeedometerItem;
import net.airplaneniner.horsesprint.HorseSprintMod;

public class HorseSprintModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, HorseSprintMod.MODID);
	public static final RegistryObject<Item> SPEEDOMETER;
	static {
		SPEEDOMETER = REGISTRY.register("speedometer", SpeedometerItem::new);
	}
	// Start of user code block custom items
	// End of user code block custom items
}