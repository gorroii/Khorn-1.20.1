package com.dot.khorn.Items.custom;

import com.dot.khorn.Client.ModQuotes;
import com.dot.khorn.Client.QuoteHandler;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.Level;

import java.util.UUID;

public class Rankatan extends SwordItem {
    public Rankatan(Tier pTier, int pAttackDamageModifier, float pAttackSpeedModifier, Properties pProperties) {
        super(pTier, pAttackDamageModifier, pAttackSpeedModifier, pProperties);
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        if (!pLevel.isClientSide()) {
            ItemStack stack = pPlayer.getItemInHand(pUsedHand);


            UUID playerUUID = pPlayer.getUUID();
            String uuidKey = "bound_" + playerUUID.toString();


            CompoundTag tag = stack.getOrCreateTag();

            if (!tag.contains(uuidKey)) {

                tag.putInt(uuidKey, -5);
                QuoteHandler.INSTANCE.playQuote(ModQuotes.RANKATAN_QUOTE, 1);
            } else {

                int value = tag.getInt(uuidKey);
                pPlayer.sendSystemMessage(Component.literal("Привязка уже существует. Значение: " + value));
            }
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }
}