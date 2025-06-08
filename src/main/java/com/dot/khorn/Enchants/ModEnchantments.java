package com.dot.khorn.Enchants;

import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEnchantments {

        public static final DeferredRegister<Enchantment> ENCHANTMENTS;
        public static final RegistryObject<Enchantment> MEGA_SHOT;
        public ModEnchantments() {
        }

        public static void register(IEventBus eventBus) {
            ENCHANTMENTS.register(eventBus);
        }

        static {
            ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, "khorn");
            MEGA_SHOT = ENCHANTMENTS.register("mega_shot", MegaShotEnchantment::new);
        }
    }