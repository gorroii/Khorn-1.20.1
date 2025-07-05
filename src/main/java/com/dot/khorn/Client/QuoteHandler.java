package com.dot.khorn.Client;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGuiEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(value = Dist.CLIENT)
public class QuoteHandler {
    public static final QuoteHandler INSTANCE = new QuoteHandler();

    private Quote currentQuote = null;
    private long startTime = -1;
    private int delayTicks = 0;

    private static final RandomSource RANDOM = RandomSource.create();

    public void playQuote(Quote quote, int delayTicks) {
        if (currentQuote == null) {
            this.currentQuote = quote;
            this.delayTicks = delayTicks;
        }
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (event.player != player || INSTANCE.currentQuote == null)
            return;

        if (INSTANCE.delayTicks > 0) {
            INSTANCE.delayTicks--;
            if (INSTANCE.delayTicks == 0) {
                Minecraft.getInstance().getSoundManager().play(
                        new SimpleSoundInstance(INSTANCE.currentQuote.getSound().getLocation(),
                                SoundSource.VOICE, 0.8F, 1.0F, RANDOM,
                                false, 0, SoundInstance.Attenuation.NONE,
                                0, 0, 0, true)
                );
                INSTANCE.startTime = System.currentTimeMillis();
            }
        }
    }

    @SubscribeEvent
    public static void onRender(RenderGuiEvent.Post event) {
        if (INSTANCE.currentQuote == null || INSTANCE.delayTicks > 0)
            return;

        double playTime = (System.currentTimeMillis() - INSTANCE.startTime) / 1000D;
        if (playTime >= INSTANCE.currentQuote.getSubtitles().getDuration()) {
            INSTANCE.currentQuote = null;
            INSTANCE.startTime = -1;
            return;
        }

        String line = INSTANCE.currentQuote.getSubtitles().getLine(playTime);
        if (line == null || line.isEmpty())
            return;

        GuiGraphics graphics = event.getGuiGraphics();
        Font font = Minecraft.getInstance().font;
        PoseStack pose = graphics.pose();

        int screenWidth = Minecraft.getInstance().getWindow().getGuiScaledWidth();
        int screenHeight = Minecraft.getInstance().getWindow().getGuiScaledHeight();

        int x = screenWidth / 2 - font.width(line) / 2;
        int y = screenHeight - 60;

        int alpha = 255;

        if (playTime < 0.5) {
            alpha = (int)(playTime * 2 * 255);
        } else if (INSTANCE.currentQuote.getSubtitles().getDuration() - playTime < 0.5) {
            alpha = (int)((INSTANCE.currentQuote.getSubtitles().getDuration() - playTime) * 2 * 255);
        }

        int color = (alpha << 24) | 0xFFFF00;
        graphics.drawString(font, line, x, y, color, true);
    }
}
