package net.eman3600.requiem_lifeline.util;

import net.eman3600.requiem_lifeline.RequiemLifelineMod;
import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.util.Identifier;

public class LootTableModifiers {
	private static final Identifier BLAZE_ID = new Identifier("minecraft", "entities/blaze");

	public static void modifyLootTables() {
		LootTableEvents.MODIFY.register(((resourceManager, manager, id, supplier, source) -> {
			if (BLAZE_ID.equals(id)) {
				LootPool[] pools = manager.getTable(new Identifier(RequiemLifelineMod.MODID, "injections/blaze")).pools;

				if (pools != null)
					supplyPools(supplier, pools);
			}
		}));
	}

	private static void supplyPools(LootTable.Builder supplier, LootPool[] pools) {
		for (LootPool pool: pools) {
			supplier.pool(pool);
		}
	}
}
