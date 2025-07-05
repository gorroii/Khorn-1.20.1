package com.dot.khorn.world.capabilities.item;

import net.minecraft.world.item.Item;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCategory;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class WeaponCategoryMapper {
    private static final Map<KhornWeaponCategories, WeaponCategory> categoryMap = new HashMap<>();

    static {
        categoryMap.put(KhornWeaponCategories.GREATAXE, CapabilityItem.WeaponCategories.SWORD);

        categoryMap.put(KhornWeaponCategories.RANKATAN, CapabilityItem.WeaponCategories.SWORD);

    }

    public static CapabilityItem.Builder apply(Item item, KhornWeaponCategories category) {
        WeaponCategory mappedCategory = categoryMap.getOrDefault(category, category);
        try {
            Method applyMethod = mappedCategory.getClass().getMethod("apply", Item.class);
            return (CapabilityItem.Builder) applyMethod.invoke(mappedCategory, item);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
