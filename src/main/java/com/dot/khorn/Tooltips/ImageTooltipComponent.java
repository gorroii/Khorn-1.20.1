package com.dot.khorn.Tooltips;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.inventory.tooltip.TooltipComponent;

public class ImageTooltipComponent implements TooltipComponent {
    private final ResourceLocation texture;
    private final int width;
    private final int height;

    public ImageTooltipComponent(ResourceLocation texture, int width, int height) {
        this.texture = texture;
        this.width = width;
        this.height = height;
    }

    public ResourceLocation getTexture() {
        return texture;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}