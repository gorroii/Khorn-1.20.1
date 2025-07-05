package net.dot.khornbase.tooltips;

import com.dot.khorn.KhornMod;
import com.dot.khorn.Tooltips.ImageTooltipComponent;
import com.mojang.datafixers.util.Either;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.event.RenderTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid = KhornMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TooltipHandler {

    private static final Map<ResourceLocation, String> TAG_TEXTURES = new HashMap<>();
    static {
        TAG_TEXTURES.put(new ResourceLocation("khorn", "cutting_items"), "cutting");
        TAG_TEXTURES.put(new ResourceLocation("khorn", "chopping_items"), "chopping");
        TAG_TEXTURES.put(new ResourceLocation("khorn", "thrusting_items"), "thrusting");
        TAG_TEXTURES.put(new ResourceLocation("khorn", "crushing_items"), "crushing");
    }

    @SubscribeEvent
    public static void onGatherTooltipComponents(RenderTooltipEvent.GatherComponents event) {
        ItemStack stack = event.getItemStack();

        for (Map.Entry<ResourceLocation, String> entry : TAG_TEXTURES.entrySet()) {
            if (stack.is(ItemTags.create(entry.getKey()))) {
                // Подключаем текстуру и добавляем её в тултип
                ResourceLocation texture = new ResourceLocation("khorn", "textures/gui/" + entry.getValue() + ".png");
                ImageTooltipComponent imageComponent = new ImageTooltipComponent(texture, 25, 25);
                    event.getTooltipElements().add(Either.right(imageComponent));
            }
        }
    }
}