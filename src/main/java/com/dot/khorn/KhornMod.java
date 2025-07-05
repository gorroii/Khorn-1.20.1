package com.dot.khorn;

import com.dot.khorn.Animations.KhornAnims;
import com.dot.khorn.Blocks.ModBlocks;
import com.dot.khorn.Client.QuoteHandler;
import com.dot.khorn.Effects.KhornEffects;
import com.dot.khorn.Enchants.ModEnchantments;
import com.dot.khorn.Items.ModCreativeModTabs;
import com.dot.khorn.Items.ModItems;
import com.dot.khorn.Sounds.ModSounds;
import com.dot.khorn.Utils.AttributeRegistry;
import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

@Mod(KhornMod.MOD_ID)
public class KhornMod
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "khorn";

    private static final Logger LOGGER = LogUtils.getLogger();
    public KhornMod(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        ModItems.register(modEventBus);
        ModCreativeModTabs.register(modEventBus);
        ModBlocks.register(modEventBus);
        modEventBus.addListener(this::addCreative);
        ModEnchantments.register(modEventBus);
        KhornEffects.EFFECTS.register(modEventBus);
        AttributeRegistry.register(modEventBus);
        modEventBus.addListener(KhornAnims::registerAnimations);
        ModSounds.register(modEventBus);
        MinecraftForge.EVENT_BUS.register(QuoteHandler.INSTANCE);



    }


    private void commonSetup(final FMLCommonSetupEvent event)
    {

    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {

        }
    }
}

