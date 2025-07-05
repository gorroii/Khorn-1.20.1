package com.dot.khorn.Effects.CombatEffects;

import com.dot.khorn.Effects.KhornEffects;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class OpenWoundEffect extends MobEffect {
   public OpenWoundEffect(){super(MobEffectCategory.HARMFUL, 0xff80ff);
   }
   @Mod.EventBusSubscriber
   public static class EventHandler {

      @SubscribeEvent
      public static void onLivingHurt(LivingHurtEvent event) {
         LivingEntity entity = event.getEntity();

         if (entity.hasEffect(KhornEffects.OPEN_WOUND.get())) {
            int amplifier = entity.getEffect(KhornEffects.OPEN_WOUND.get()).getAmplifier();
            float damageMultiplier = 1.1f + (0.15f * (amplifier + 1)); // +1 because amplifier is 0-based

            // Increase the damage
            event.setAmount(event.getAmount() * damageMultiplier);
         }
      }

   }

}
