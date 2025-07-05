package com.dot.khorn.Damage;

import com.dot.khorn.KhornMod;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.*;

import static com.dot.khorn.Utils.AttributeRegistry.*;
@Mod.EventBusSubscriber(modid = KhornMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SimpleDamageTypeHandler {
    private static final ResourceLocation CUTTING_ITEMS_TAG = new ResourceLocation(KhornMod.MOD_ID, "cutting_items");
    private static final ResourceLocation CHOPPING_ITEMS_TAG = new ResourceLocation(KhornMod.MOD_ID, "chopping_items");
    private static final ResourceLocation THRUSTING_ITEMS_TAG = new ResourceLocation(KhornMod.MOD_ID, "thrusting_items");
    private static final ResourceLocation CRUSHING_ITEMS_TAG = new ResourceLocation(KhornMod.MOD_ID, "crushing_items");
    static List<ResourceLocation> TAGS = new ArrayList<>(List.of(CHOPPING_ITEMS_TAG, CUTTING_ITEMS_TAG, THRUSTING_ITEMS_TAG, CRUSHING_ITEMS_TAG));
    public static final Map<ResourceLocation, RegistryObject<Attribute>> TAG_TO_ATTRIBUTE = Map.of(
            CHOPPING_ITEMS_TAG, CHOPPING_RESISTANCE,
            CUTTING_ITEMS_TAG, CUTTING_RESISTANCE,
            THRUSTING_ITEMS_TAG, THRUSTING_RESISTANCE,
            CRUSHING_ITEMS_TAG, CRUSHING_RESISTANCE
    );

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        Entity attacker = event.getSource().getEntity();
        LivingEntity target = event.getEntity();

        if (!(attacker instanceof LivingEntity livingAttacker)) {
            return;
        }

        ItemStack weapon = livingAttacker.getMainHandItem();
        double crush = target.getAttributeValue(CRUSHING_RESISTANCE.get());
        double chop = target.getAttributeValue(CHOPPING_RESISTANCE.get());
        double cut = target.getAttributeValue(CUTTING_RESISTANCE.get());
        double thrust = target.getAttributeValue(THRUSTING_RESISTANCE.get());
        if (!weapon.isEmpty() && weapon.is(ItemTags.create(CRUSHING_ITEMS_TAG))){
            if(target.getAttributeValue(CRUSHING_RESISTANCE.get())> 0.3 && crush <1){
                event.setAmount((int) (event.getAmount() * (1- target.getAttributeValue(CRUSHING_RESISTANCE.get()))));
        }
            if(crush < 0.3 && crush >= 0){
                event.setAmount((int) (event.getAmount() * 1.5-crush) );
            }
            if(crush < 0){
                event.setAmount((int) (event.getAmount() * (1 + crush * -1)));
            }
    }
        if (!weapon.isEmpty() && weapon.is(ItemTags.create(CHOPPING_ITEMS_TAG))){
            if(chop > 0.3 && chop <1){
                event.setAmount((int) (event.getAmount() * (1- chop)));
            }
            if(chop < 0.3 && chop >= 0){
                event.setAmount((int) (event.getAmount() * 1.5-chop));
            }
            if(chop < 0){
                event.setAmount((int) (event.getAmount() * (1 + chop * -1)));
            }
        }
        if (!weapon.isEmpty() && weapon.is(ItemTags.create(CUTTING_ITEMS_TAG))){
            if(cut > 0.3 && cut <1){
                event.setAmount((int) (event.getAmount() * (1- cut)));
            }
            if(cut < 0.3 && cut >= 0){
                event.setAmount((int) (event.getAmount() * 1.5-chop));
            }
            if(cut < 0){
                event.setAmount((int) (event.getAmount() * (1.5 + cut * -1)));
            }
        }
        if (!weapon.isEmpty() && weapon.is(ItemTags.create(THRUSTING_ITEMS_TAG))){
            if(thrust > 0.3 && thrust <1){
                event.setAmount((int) (event.getAmount() * (1- thrust)));
            }
            if(thrust < 0.3 && thrust >= 0){
                event.setAmount((int) (event.getAmount() * 1.5-thrust));
            }
            if(thrust < 0){
                event.setAmount((int) (event.getAmount() * (1 + thrust * -1)));
            }
        }
    }

}
