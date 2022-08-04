package net.eman3600.requiem_lifeline.init;

import net.eman3600.requiem_lifeline.RequiemLifelineMod;
import net.eman3600.requiem_lifeline.items.AttritionCureItem;
import net.eman3600.requiem_lifeline.items.SelfWeaknessItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;
import org.quiltmc.qsl.item.setting.api.QuiltItemSettings;

public class LifelineItems {
	public static final Item REDSTONE_GOLD = registerItem("redstone_gold", new AttritionCureItem(new QuiltItemSettings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON), 3));
	public static final Item TOASTED_GOLD = registerItem("toasted_gold", new AttritionCureItem(new QuiltItemSettings().group(ItemGroup.MISC).rarity(Rarity.RARE), 2));

	public static final Item WART_QUARTZ = registerItem("wart_quartz", new SelfWeaknessItem(new QuiltItemSettings().group(ItemGroup.MISC).rarity(Rarity.UNCOMMON), 200, 0));

	public static final Item BLAZE_CHUNK = registerItem("blaze_chunk", new Item(new QuiltItemSettings().group(ItemGroup.MATERIALS)));
	public static final Item BLAZE_WART = registerItem("blaze_wart", new Item(new QuiltItemSettings().group(ItemGroup.MATERIALS)));



	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(RequiemLifelineMod.MODID, name), item);
	}

	public static void registerItems() {
		System.out.println("Registering items for " + RequiemLifelineMod.MODID);
	}
}
