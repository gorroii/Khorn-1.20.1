package com.dot.khorn.Effects;

import com.dot.khorn.Effects.CombatEffects.AdrenalineEffect;
import com.dot.khorn.Effects.CombatEffects.OpenWoundEffect;
import com.dot.khorn.Effects.LivingEffect.CourageEffect;
import com.dot.khorn.Effects.LivingEffect.FearEffect;
import com.dot.khorn.KhornMod;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class KhornEffects {
    public static final DeferredRegister<MobEffect> EFFECTS =
            DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, KhornMod.MOD_ID);

    public static final RegistryObject<MobEffect> OPEN_WOUND =
            EFFECTS.register("open_wound", OpenWoundEffect::new);

    public static final RegistryObject<MobEffect> FEAR =
            EFFECTS.register("fear", FearEffect::new);

    public static final RegistryObject<MobEffect> COURAGE =
            EFFECTS.register("courage", CourageEffect::new);

    public static final RegistryObject<MobEffect> ADRENALINE =
            EFFECTS.register("adrenaline", AdrenalineEffect::new);
}