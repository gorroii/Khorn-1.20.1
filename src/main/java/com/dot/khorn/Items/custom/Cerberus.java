package com.dot.khorn.Items.custom;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraftforge.common.ForgeMod;

import java.util.Random;

public class Cerberus extends SwordItem {
    private static final float FIRE_CHANCE = 0.22f;
    private static final Random RANDOM = new Random();

    public Cerberus(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // Check if target is on fire for critical damage
        if (target.isOnFire()) {

            // Apply extra critical damage
            target.hurt(attacker.damageSources().mobAttack(attacker),
                    getDamage() * 2.0f);
        }

        // Random chance to set target on fire
        if (attacker.getRandom().nextFloat() < FIRE_CHANCE * attacker.getAttributeValue(Attributes.LUCK)) {
            target.setSecondsOnFire(4); // 4 seconds of fire
        }

        return super.hurtEnemy(stack, target, attacker);
    }
}