package com.dot.khorn.Items.custom;

import com.dot.khorn.Effects.KhornEffects;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class ScimitarItem extends SwordItem {
    public ScimitarItem(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }
    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        int leveleffect = 0;
       if (target.getEffect(KhornEffects.OPEN_WOUND.get()) != null) {
            leveleffect = target.getEffect(KhornEffects.OPEN_WOUND.get()).getAmplifier() + 1;
       }
      if (!target.hasEffect(KhornEffects.OPEN_WOUND.get()))
            target.addEffect(new MobEffectInstance(
                    KhornEffects.OPEN_WOUND.get(),
                    200,  // Duration in ticks (10 seconds = 200 ticks)
                    0  ,    // Amplifier (0 = level I)
                    false, // Not ambient
                    false,// ,  // Show particles
                    true   // Show icon
            ));
      if (target.hasEffect(KhornEffects.OPEN_WOUND.get()) || (target.getEffect(KhornEffects.OPEN_WOUND.get()).getAmplifier() <= 5) ){
          target.addEffect(new MobEffectInstance(
                  KhornEffects.OPEN_WOUND.get(),
                  200,  // Duration in ticks (10 seconds = 200 ticks)
                  0 + leveleffect ,    // Amplifier (0 = level I)
                  false, // Not ambient
                  false,  // Show particles
                  true   // Show icon
          ));  
      }

        return super.hurtEnemy(stack, target, attacker);
    }
}
