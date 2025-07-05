package com.dot.khorn.Items.custom;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import yesman.epicfight.world.item.SpearItem;

public class ReyScythe extends SwordItem {

    public ReyScythe(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide()) {
            double luck = 0.0;
            if (attacker.getAttributes().hasAttribute(Attributes.LUCK)) {
                luck = attacker.getAttributeValue(Attributes.LUCK);
            }

            double baseChance = 0.45;
            double random = Math.random();

            if (random < baseChance) {
                if (Math.random() < 0.5) {
                    // 50% шанс отравить
                    target.addEffect(new MobEffectInstance(MobEffects.POISON, 80, 2)); // 4 секунд, уровень 2
                } else {
                    // 50% шанс поджечь
                    target.setSecondsOnFire(4); // 4 секунды горения
                }
            }
        }
        return super.hurtEnemy(stack, target, attacker);
    }
}