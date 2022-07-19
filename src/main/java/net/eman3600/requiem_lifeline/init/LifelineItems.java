package net.eman3600.requiem_lifeline.init;

import net.eman3600.requiem_lifeline.RequiemLifelineMod;
import net.eman3600.requiem_lifeline.items.AttritionCureItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class LifelineItems {
	public static final Item REDSTONE_GOLD = registerItem("redstone_gold", new AttritionCureItem(new QuiltItemSettings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON), 3));



	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(RequiemLifelineMod.MODID, name), item);
	}

	public static void registerItems() {
		System.out.println("Registering items for " + RequiemLifelineMod.MODID);
	}
}
