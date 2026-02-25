/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.airplaneniner.horsesprint.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.resources.ResourceLocation;

import net.airplaneniner.horsesprint.HorseSprintMod;

public class HorseSprintModSounds {
	public static final DeferredRegister<SoundEvent> REGISTRY = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HorseSprintMod.MODID);
	public static final RegistryObject<SoundEvent> WHIP = REGISTRY.register("whip", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation("horse_sprint", "whip")));
}