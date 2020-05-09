package com.github.xf8b.morefeatures;

import com.github.xf8b.morefeatures.blocks.SapphireBlock;
import com.github.xf8b.morefeatures.items.Sapphire;
import com.github.xf8b.morefeatures.items.armor.SapphireBoots;
import com.github.xf8b.morefeatures.items.armor.SapphireChestplate;
import com.github.xf8b.morefeatures.items.armor.SapphireHelmet;
import com.github.xf8b.morefeatures.items.armor.SapphireLeggings;
import com.github.xf8b.morefeatures.items.tools.*;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreFeaturesRegistries {
    //Deferred Registries
    public static DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MoreFeatures.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreFeatures.MOD_ID);

    //Registry Objects
    //Items
    public static RegistryObject<Sapphire> SAPPHIRE = ITEMS.register("sapphire", () -> new Sapphire());

    //Tools
    public static RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSword());
    public static RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxe());
    public static RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxe());
    public static RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovel());
    public static RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoe());

    //Armor
    public static RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new SapphireHelmet());
    public static RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new SapphireChestplate());
    public static RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new SapphireLeggings());
    public static RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new SapphireBoots());

    //Blocks
    public static RegistryObject<SapphireBlock> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new SapphireBlock());
}
