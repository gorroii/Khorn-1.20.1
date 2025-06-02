package com.dot.khorn.Blocks;

import com.dot.khorn.Items.ModItems;
import com.dot.khorn.KhornMod;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, KhornMod.MOD_ID);

    public static final RegistryObject<Block> KHORNIUM_ORE = registerBlock("khornium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).sound(SoundType.STONE)));
    public static final RegistryObject<Block> DEEPSLATE_KHORNIUM_ORE = registerBlock("deepslate_khornium_ore",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE).sound(SoundType.STONE)));


    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block>RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));

    }
    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
