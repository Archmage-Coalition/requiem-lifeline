package net.eman3600.requiem_lifeline.init;

import net.eman3600.requiem_lifeline.RequiemLifelineMod;
import net.eman3600.requiem_lifeline.mixin.BrewingRegistryMixin;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class LifelinePotions {






    public static Potion registerPotion(String name, StatusEffect effect, int duration, int amplifier) {
        return Registry.register(Registry.POTION, new Identifier(RequiemLifelineMod.MODID, name), new Potion(new StatusEffectInstance(effect, duration, amplifier)));
    }

    public static Potion registerPotion(String name, String baseName, StatusEffect effect, int duration, int amplifier) {
        return Registry.register(Registry.POTION, new Identifier(RequiemLifelineMod.MODID, name), new Potion(baseName, new StatusEffectInstance(effect, duration, amplifier)));
    }

    public static void registerPotions() {
        System.out.println("Registering potions for " + RequiemLifelineMod.MODID);

        registerPotionRecipes();
    }

    private static void registerPotionRecipes() {
        // Void Flow
        BrewingRegistryMixin.invokeRegisterPotionRecipe(Potions.AWKWARD, LifelineItems.BLAZE_WART, Potions.STRENGTH);
    }
}
