package net.eman3600.requiem_lifeline;

import net.eman3600.requiem_lifeline.init.LifelineItems;
import net.eman3600.requiem_lifeline.init.LifelinePotions;
import net.eman3600.requiem_lifeline.util.LifelineRegistries;
import net.eman3600.requiem_lifeline.util.LootTableModifiers;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RequiemLifelineMod implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MODID = "requiem_lifeline";
	public static final Logger LOGGER = LoggerFactory.getLogger(MODID);

	@Override
	public void onInitialize(ModContainer mod) {
		LOGGER.info("Initializing ", mod.metadata().name());

		LifelineItems.registerItems();
		LifelinePotions.registerPotions();

		LootTableModifiers.modifyLootTables();
		LifelineRegistries.register();
	}
}
