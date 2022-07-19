package net.eman3600.requiem_lifeline.items;

import com.google.common.base.Suppliers;
import ladysnake.requiem.api.v1.RequiemApi;
import ladysnake.requiem.api.v1.RequiemPlugin;
import ladysnake.requiem.api.v1.remnant.AttritionFocus;
import ladysnake.requiem.common.entity.effect.AttritionStatusEffect;
import ladysnake.requiem.common.entity.effect.RequiemStatusEffects;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsage;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraft.util.Identifier;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.UseAction;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.awt.font.NumericShaper;
import java.util.List;
import java.util.function.Supplier;

public class AttritionCureItem extends Item {
	private static final int MAX_USE_TIME = 20;

	private int maxLevel;

	public AttritionCureItem(Settings settings, int maxLevel) {
		super(settings);
		this.maxLevel = maxLevel;
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
		if (player == null || getAttrition(player) < maxLevel) {
			return stack;
		}

		AttritionStatusEffect.reduce(player, 1);
		stack.decrement(1);

		return stack;
	}

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {
		if (getAttrition(user) >= maxLevel)
			return ItemUsage.consumeHeldItem(world, user, hand);
		return TypedActionResult.fail(user.getStackInHand(hand));
	}

	private int getAttrition(LivingEntity player) {
		if (player.hasStatusEffect(RequiemStatusEffects.ATTRITION)) {
			return player.getStatusEffect(RequiemStatusEffects.ATTRITION).getAmplifier();
		} else {
			return -1;
		}
	}

	@Override
	public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
		tooltip.add(Text.translatable("item.requiem_lifeline.tooltip.redstone_gold", Text.translatable("potion.potency." + (maxLevel))));
	}
}
