package com.dot.khorn.world.capabilities.item;

import com.dot.khorn.Animations.KhornAnims;
import com.dot.khorn.Animations.KhornColliderPreset;
import com.dot.khorn.KhornMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import yesman.epicfight.api.animation.LivingMotions;
import yesman.epicfight.api.forgeevent.WeaponCapabilityPresetRegistryEvent;
import yesman.epicfight.gameasset.Animations;
import yesman.epicfight.gameasset.EpicFightSounds;
import yesman.epicfight.world.capabilities.item.CapabilityItem;
import yesman.epicfight.world.capabilities.item.WeaponCapability;

import java.util.function.Function;

@Mod.EventBusSubscriber(modid = KhornMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class WeaponCapabilityPresets {
    public static final Function<Item, CapabilityItem.Builder> GREATAXE = (item)->{
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(KhornWeaponCategories.GREATAXE)
                .styleProvider((playerpatch) -> CapabilityItem.Styles.TWO_HAND)
                .collider(KhornColliderPreset.GREATAXE)
                .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .canBePlacedOffhand(false)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, KhornAnims.GREATAXE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, KhornAnims.GREATAXE_WALK)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_WALK_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, KhornAnims.GREATAXE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_KNEEL)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_SNEAK)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, KhornAnims.GREATAXE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.GREATSWORD_GUARD);

        return builder;

    };
    public static final Function<Item, CapabilityItem.Builder> RANKATAN = (item)->{
        WeaponCapability.Builder builder = WeaponCapability.builder()
                .category(KhornWeaponCategories.RANKATAN)
                .styleProvider((playerpatch) -> CapabilityItem.Styles.TWO_HAND)
                .collider(KhornColliderPreset.RANKATAN)
                .swingSound(EpicFightSounds.WHOOSH_BIG.get())
                .hitSound(EpicFightSounds.BLADE_HIT.get())
                .canBePlacedOffhand(false)
                .newStyleCombo(CapabilityItem.Styles.TWO_HAND, KhornAnims.RANKATAN_AUTO1)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.IDLE, KhornAnims.RANKATAN_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.WALK, KhornAnims.GREATAXE_WALK)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.CHASE, Animations.BIPED_WALK_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.RUN, Animations.BIPED_RUN_GREATSWORD)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.JUMP, KhornAnims.GREATAXE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.KNEEL, Animations.BIPED_KNEEL)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SNEAK, Animations.BIPED_SNEAK)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.SWIM, KhornAnims.GREATAXE_IDLE)
                .livingMotionModifier(CapabilityItem.Styles.TWO_HAND, LivingMotions.BLOCK, Animations.GREATSWORD_GUARD);



        return builder;
    };
    @SubscribeEvent
    public static void registerMovesets(WeaponCapabilityPresetRegistryEvent event) {
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(KhornMod.MOD_ID,"greataxe"), GREATAXE);
        event.getTypeEntry().put(ResourceLocation.fromNamespaceAndPath(KhornMod.MOD_ID,"rankatan"), RANKATAN);
       }
}
