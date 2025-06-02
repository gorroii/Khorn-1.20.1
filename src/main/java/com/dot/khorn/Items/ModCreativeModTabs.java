package com.dot.khorn.Items;

import com.dot.khorn.KhornMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModTabs {public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, KhornMod.MOD_ID);

    public static void register(IEventBus eventBus) {

        final RegistryObject<CreativeModeTab> KHORN_TAB = CREATIVE_MODE_TABS.register("khorn_beta",
                () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.KHORNIUM.get()))
                        .title(Component.translatable("creativetab.khorn_beta"))
                        .displayItems((itemDisplayParameters, output) -> {
                            output.accept(ModItems.KHORNIUM.get());
                        })
                        .build());
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
