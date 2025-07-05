package com.dot.khorn.Animations;

import com.dot.khorn.KhornMod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import yesman.epicfight.api.animation.AnimationClip;
import yesman.epicfight.api.animation.AnimationManager;
import yesman.epicfight.api.animation.property.AnimationProperty;
import yesman.epicfight.api.animation.types.BasicAttackAnimation;
import yesman.epicfight.api.animation.types.DirectStaticAnimation;
import yesman.epicfight.api.animation.types.MovementAnimation;
import yesman.epicfight.api.animation.types.StaticAnimation;
import yesman.epicfight.gameasset.Armatures;

public class KhornAnims {
    DirectStaticAnimation EMPTY_ANIMATION = new DirectStaticAnimation(){
        @Override
        public void loadAnimation(){

        }
        @Override
        public AnimationClip getAnimationClip(){
            return AnimationClip.EMPTY_CLIP;
        }
    };
    public static AnimationManager.AnimationAccessor<StaticAnimation> GREATAXE_IDLE;
    public static AnimationManager.AnimationAccessor<MovementAnimation> GREATAXE_WALK;
    public static AnimationManager.AnimationAccessor<StaticAnimation> RANKATAN_IDLE;

    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> RANKATAN_AUTO1;



    public static AnimationManager.AnimationAccessor<BasicAttackAnimation> HEAVY_SWORD_THRUST;

    @SubscribeEvent
    public static void registerAnimations(AnimationManager.AnimationRegistryEvent event) {
        event.newBuilder(KhornMod.MOD_ID, KhornAnims::build);
    }
    public static void build(AnimationManager.AnimationBuilder builder){
        GREATAXE_IDLE = builder.nextAccessor("biped/living/greataxe_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));
        GREATAXE_WALK = builder.nextAccessor("biped/living/greataxe_walk", (accessor) -> new MovementAnimation(true, accessor, Armatures.BIPED));
        RANKATAN_IDLE = builder.nextAccessor("biped/living/rankatan_idle", (accessor) -> new StaticAnimation(true, accessor, Armatures.BIPED));

        RANKATAN_AUTO1 = builder.nextAccessor("biped/combat/rankatan_auto1", (accessor) ->
                new BasicAttackAnimation(0.12F, 0.3F, 0.5F, 0.92F, 0.40F, null, Armatures.BIPED.get().toolR, accessor, Armatures.BIPED)
                        .addProperty(AnimationProperty.AttackAnimationProperty.BASIS_ATTACK_SPEED, 1.0F)
                        .addProperty(AnimationProperty.ActionAnimationProperty.CANCELABLE_MOVE, true));
    }
}
