package net.eman3600.requiem_lifeline.items;

import ladysnake.requiem.common.entity.effect.AttritionStatusEffect;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SelfWeaknessItem extends Item {
	private final static int MAX_USE_TIME = 20;

	private int duration;
	private int amplifier;

	public SelfWeaknessItem(Settings settings, int duration, int amplifier) {
		super(settings);
		this.duration = duration;
		this.amplifier = amplifier;
	}

	@Override
	public int getMaxUseTime(ItemStack stack) {
		return MAX_USE_TIME;
	}

	@Override
	public UseAction getUseAction(ItemStack stack) {
		return UseAction.BOW;
	}

	@Override
	public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
		PlayerEntity player = user instanceof PlayerEntity ? (PlayerEntity)user : null;
		if (player == null) {
			return stack;
		}

		player.addStatusEffect(new StatusEffectInstance(StatusEffects.WEAKNESS, duration, amplifier), player);
		stack.decrement(1);

		return stack;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (!user.hasStatusEffect(StatusEffects.WEAKNESS))
			return ItemUsage.consumeHeldItem(world, user, hand);
		return TypedActionResult.fail(user.getStackInHand(hand));
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("item.requiem_lifeline.tooltip.weakness"));
	}
}
