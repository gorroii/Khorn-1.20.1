package com.dot.khorn.Animations;

import com.dot.khorn.KhornMod;
import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import net.minecraft.resources.ResourceLocation;
import yesman.epicfight.api.collider.Collider;
import yesman.epicfight.api.collider.MultiOBBCollider;

public class KhornColliderPreset {


    private static final BiMap<ResourceLocation, Collider> PRESETS = HashBiMap.create();

    public static Collider registerCollider(ResourceLocation rl, Collider collider) {
        if (PRESETS.containsKey(rl)) {
            throw new IllegalStateException("Collider named " + rl + " already registered.");
        }
        PRESETS.put(rl, collider);

        return collider;
    }

    public static final Collider GREATAXE = registerCollider(ResourceLocation.fromNamespaceAndPath(KhornMod.MOD_ID, "greataxe"), new MultiOBBCollider(3, 0.42D, 0.42D, 1.16D, 0D, 0.1D, -1.0D));

    public static final Collider RANKATAN = registerCollider(ResourceLocation.fromNamespaceAndPath(KhornMod.MOD_ID, "rankatan"), new MultiOBBCollider(3, 0.42D, 0.42D, 1.16D, 0D, 0.1D, -1.0D));

}
