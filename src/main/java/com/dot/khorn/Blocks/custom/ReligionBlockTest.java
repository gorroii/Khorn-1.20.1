package com.dot.khorn.Blocks.custom;

import com.dot.khorn.Utils.AttributeRegistry;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class ReligionBlockTest extends Block {
    public ReligionBlockTest(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult use(BlockState pState, Level pLevel, BlockPos pPos, Player pPlayer, InteractionHand pHand, BlockHitResult pHit) {

        pPlayer.getAttribute(AttributeRegistry.KANTAR_PRAYER.get()).setBaseValue(1);

        return super.use(pState, pLevel, pPos, pPlayer, pHand, pHit);
    }
}
