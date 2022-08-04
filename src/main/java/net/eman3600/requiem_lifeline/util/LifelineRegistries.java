package net.eman3600.requiem_lifeline.util;

import net.eman3600.requiem_lifeline.RequiemLifelineMod;
import net.eman3600.requiem_lifeline.init.LifelineItems;
import net.fabricmc.fabric.api.registry.FuelRegistry;

public class LifelineRegistries {
	public static void register() {
		registerFuels();
	}

	private static void registerFuels() {
		RequiemLifelineMod.LOGGER.info("Registering fuels for " + RequiemLifelineMod.MODID);

		FuelRegistry registry = FuelRegistry.INSTANCE;

		registry.add(LifelineItems.BLAZE_CHUNK, 400);
	}
}
