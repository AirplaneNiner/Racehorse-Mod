package net.airplaneniner.horsesprint.procedures;

import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.api.distmarker.Dist;

import net.airplaneniner.horsesprint.HorseSprintMod;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.DEDICATED_SERVER})
public class LogStartProcedure {
    @SubscribeEvent
    public static void init(FMLDedicatedServerSetupEvent event) {
        execute();
    }

    public static void execute() {
        execute(null);
    }

    private static void execute(@Nullable Event event) {
        if (ModList.get().isLoaded("horse_colors")) {
            HorseSprintMod.LOGGER.info("Racehorse Mod initialised!");
        } else {
            // Forge should auto-catch if RHG isn't loaded, but if it doesn't then throw an error
            HorseSprintMod.LOGGER.fatal("Racehorse Mod requires Realistic Horse Genetics version 13.5!");
        }
    }
}