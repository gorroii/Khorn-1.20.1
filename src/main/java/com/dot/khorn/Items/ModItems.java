package com.dot.khorn.Items;

import com.dot.khorn.Items.custom.Cerberus;
import com.dot.khorn.Items.custom.Hawk;
import com.dot.khorn.Items.custom.Sasquatch;
import com.dot.khorn.KhornMod;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KhornMod.MOD_ID);
    public static final RegistryObject<Item> KHORNIUM = ITEMS.register("khornium",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> KHORNUM_SPEAR = ITEMS.register("khornium_spear",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> MAKI_SPEAR = ITEMS.register("maki_spear",
            () -> new SwordItem(Tiers.DIAMOND, 2, 1, new Item.Properties()));
    public static final RegistryObject<Item> CERBERUS = ITEMS.register("cerberus",
            () -> new Cerberus(Tiers.DIAMOND, 2, 1, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SASQUATCH = ITEMS.register("cerberus",
            () -> new Sasquatch(Tiers.DIAMOND, 3, 1, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item>  HAWK = ITEMS.register("cerberus",
            () -> new Hawk(Tiers.DIAMOND, 1, 1.2f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));

    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}

