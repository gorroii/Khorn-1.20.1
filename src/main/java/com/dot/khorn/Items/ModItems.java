package com.dot.khorn.Items;

import com.dot.khorn.Items.custom.*;
import com.dot.khorn.KhornMod;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.*;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, KhornMod.MOD_ID);

    public static final Rarity KHORNUM_RARITY = Rarity.create("khornum", ChatFormatting.DARK_RED);

    public static final Rarity DESERT_TREASURE = Rarity.create("aksbira", ChatFormatting.GOLD);

    public static final Rarity ANCIENT = Rarity.create("ancient", ChatFormatting.DARK_RED);

    public static final Rarity BLOOMING = Rarity.create("blooming", ChatFormatting.LIGHT_PURPLE);


    public static final RegistryObject<Item> KHORNUM = ITEMS.register("khornum",
            () -> new Item(new Item.Properties().rarity(KHORNUM_RARITY)));
    public static final RegistryObject<Item> KHORNUM_SPEAR = ITEMS.register("khornum_spear",
            () -> new Item(new Item.Properties().rarity(KHORNUM_RARITY)));
    public static final RegistryObject<Item> MAKI_SPEAR = ITEMS.register("maki_spear",
            () -> new SwordItem(Tiers.DIAMOND, 2, -2, new Item.Properties()));
    public static final RegistryObject<Item> CERBERUS = ITEMS.register("cerberus",
            () -> new Cerberus(Tiers.DIAMOND, 2, -2.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item> SASQUATCH = ITEMS.register("sasquatch",
            () -> new Sasquatch(Tiers.DIAMOND, 3, 1, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item>  HAWK = ITEMS.register("hawk",
            () -> new Hawk(Tiers.DIAMOND, 1, -1.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item>  CONQUEST = ITEMS.register("conquest",
            () -> new Conquest(Tiers.DIAMOND, 1, -2.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item>  HAKAMORE = ITEMS.register("hakamore",
            () -> new Hakamore(Tiers.DIAMOND, 1, -2.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.EPIC)));
    public static final RegistryObject<Item>  IRON_SCIMITAR = ITEMS.register("iron_scimitar",
            () -> new ScimitarItem(Tiers.IRON, 1, -2.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(Rarity.COMMON)));
    public static final RegistryObject<Item>  SENDULUM = ITEMS.register("sendulum",
            () -> new AxeItem(Tiers.IRON, 1, -2.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(DESERT_TREASURE)));
    public static final RegistryObject<Item>  AKSBIRIAN_GREATAXE = ITEMS.register("aksbiranian_greataxe",
            () -> new aksbiranian_greataxe(Tiers.IRON, 5, -3.5f, new Item.Properties() .durability(2031) // Same as Netherite
                    .rarity(DESERT_TREASURE)));
    public static final RegistryObject<Item> RANKATAN  = ITEMS.register("rankatan",
            () -> new Rankatan(Tiers.NETHERITE, 5, -2.5f, new Item.Properties() .durability(6151) // Same as Netherite
                    .rarity(ANCIENT)));
    public static final RegistryObject<Item> REY_SCYTHE  = ITEMS.register("rey_scythe",
            () -> new ReyScythe(Tiers.NETHERITE, 4, -2, new Item.Properties().durability(12000).rarity(BLOOMING)));





    public static void register(IEventBus eventBus){ITEMS.register(eventBus);}
}
