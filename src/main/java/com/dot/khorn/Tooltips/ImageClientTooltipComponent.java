package com.dot.khorn.Tooltips;

import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;

public class ImageClientTooltipComponent implements ClientTooltipComponent {
    private final ImageTooltipComponent component;

    public ImageClientTooltipComponent(ImageTooltipComponent component) {
        this.component = component;
    }

    @Override
    public int getHeight() {
        return component.getHeight();
    }

    @Override
    public int getWidth(Font font) {
        return component.getWidth();
    }

    @Override
    public void renderImage(Font font, int x, int y, GuiGraphics guiGraphics) {
        // Рендерим изображение
        guiGraphics.blit(component.getTexture(),x, y, 0, 0, component.getWidth(), component.getHeight(), component.getWidth(), component.getHeight());
    }
}
