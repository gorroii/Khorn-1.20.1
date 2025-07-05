package com.dot.khorn.Interface;

import com.dot.khorn.KhornMod;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public class ReligionMenu extends Screen {
    public static final Component TITLE = Component.translatable("gui" + KhornMod.MOD_ID + ".religion_menu_screen");


    public ReligionMenu() {
        super(TITLE);
    }
}
