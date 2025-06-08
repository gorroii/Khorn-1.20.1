package com.dot.khorn.Enchants;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraft.world.item.enchantment.Enchantments;

public class MegaShotEnchantment extends Enchantment {
    protected MegaShotEnchantment() {
        super(Rarity.RARE, EnchantmentCategory.create("BOW_AND_CROSSBOW",
                        (item) -> item instanceof BowItem),
                new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int enchantmentLevel) {
        return 20;
    }

    @Override
    public int getMaxCost(int enchantmentLevel) {
        return 50;
    }

    @Override
    public int getMaxLevel() {
        return 7;
    }

    @Override
    public boolean checkCompatibility(Enchantment other) {
        return other == Enchantments.MULTISHOT ? false : super.checkCompatibility(other);
    }
}