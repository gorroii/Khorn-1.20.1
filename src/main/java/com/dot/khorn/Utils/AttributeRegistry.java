package com.dot.khorn.Utils;

import com.dot.khorn.KhornMod;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.RangedAttribute;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(modid = KhornMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AttributeRegistry {
    public static final DeferredRegister<Attribute> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ATTRIBUTES, KhornMod.MOD_ID);

    public static final RegistryObject<Attribute> CUTTING_RESISTANCE = REGISTRY.register("cut_res",
            () -> new RangedAttribute("attribute.khorn.cut_res", 0.0, 0.0, 100.0).setSyncable(true));
    public static final RegistryObject<Attribute> THRUSTING_RESISTANCE = REGISTRY.register("thrust_res",
            () -> new RangedAttribute("attribute.khorn.thrust_res", 0.0, 0.0, 100.0).setSyncable(true));
    public static final RegistryObject<Attribute> CRUSHING_RESISTANCE = REGISTRY.register("crush_res",
            () -> new RangedAttribute("attribute.khorn.crush_res", 0.0, 0.0, 100.0).setSyncable(true));
    public static final RegistryObject<Attribute> CHOPPING_RESISTANCE = REGISTRY.register("chop_res",
            () -> new RangedAttribute("attribute.khorn.chop_res", 0.0, 0.0, 100.0).setSyncable(true));
    public static final RegistryObject<Attribute> KANTAR_PRAYER = REGISTRY.register("kantar_prayer",
            () -> new RangedAttribute("attribute.khorn.kantar_prayer", 0.0, 0.0, 100.0).setSyncable(true));
    public static final RegistryObject<Attribute> CINIR_PRAYER = REGISTRY.register("cinir_prayer",
            () -> new RangedAttribute("attribute.khorn.cinir_prayer", 0.0, 0.0, 100.0).setSyncable(true));

    public static void register(IEventBus bus) {
        REGISTRY.register(bus);
        System.out.println("Attributes registered!");
    }
    @SubscribeEvent
    public static void addAttributes(EntityAttributeModificationEvent event) {
        event.getTypes().forEach(entity -> event.add(entity, CUTTING_RESISTANCE.get()));
        event.getTypes().forEach(entity -> event.add(entity, CRUSHING_RESISTANCE.get()));
        event.getTypes().forEach(entity -> event.add(entity, CHOPPING_RESISTANCE.get()));
        event.getTypes().forEach(entity -> event.add(entity, THRUSTING_RESISTANCE.get()));
        event.add(EntityType.PLAYER, KANTAR_PRAYER.get());
        event.add(EntityType.PLAYER, CINIR_PRAYER.get());
    }

    @Mod.EventBusSubscriber
    public static class PlayerAttributesSync {
        @SubscribeEvent
        public static void playerClone(PlayerEvent.Clone event) {
            Player oldPlayer = event.getOriginal();
            Player newPlayer = event.getEntity();
            newPlayer.getAttribute(CUTTING_RESISTANCE.get()).setBaseValue(oldPlayer.getAttribute(CUTTING_RESISTANCE.get()).getBaseValue());
            newPlayer.getAttribute(CRUSHING_RESISTANCE.get()).setBaseValue(oldPlayer.getAttribute(CRUSHING_RESISTANCE.get()).getBaseValue());
            newPlayer.getAttribute(CHOPPING_RESISTANCE.get()).setBaseValue(oldPlayer.getAttribute(CHOPPING_RESISTANCE.get()).getBaseValue());
            newPlayer.getAttribute(THRUSTING_RESISTANCE.get()).setBaseValue(oldPlayer.getAttribute(THRUSTING_RESISTANCE.get()).getBaseValue());
            newPlayer.getAttribute(KANTAR_PRAYER.get()).setBaseValue(oldPlayer.getAttribute(KANTAR_PRAYER.get()).getBaseValue());
            newPlayer.getAttribute(CINIR_PRAYER.get()).setBaseValue(oldPlayer.getAttribute(CINIR_PRAYER.get()).getBaseValue());
        }
    }
}
