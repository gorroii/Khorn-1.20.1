package com.dot.khorn.Tooltips;

import com.dot.khorn.KhornMod;
import net.minecraftforge.client.event.RegisterClientTooltipComponentFactoriesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = KhornMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class TooltipFactoryRegistry {

    @SubscribeEvent
    public static void onRegisterTooltipFactories(RegisterClientTooltipComponentFactoriesEvent event) {
        event.register(ImageTooltipComponent.class, ImageClientTooltipComponent::new);
    }
}