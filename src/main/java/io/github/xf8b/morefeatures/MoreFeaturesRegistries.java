package io.github.xf8b.morefeatures;

import io.github.xf8b.morefeatures.blocks.SapphireBlock;
import io.github.xf8b.morefeatures.blocks.SapphireOre;
import io.github.xf8b.morefeatures.items.Sapphire;
import io.github.xf8b.morefeatures.items.armor.*;
import io.github.xf8b.morefeatures.items.tools.*;
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
    //Sapphire
    public static RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSword());
    public static RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxe());
    public static RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxe());
    public static RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovel());
    public static RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoe());
    //Corrupted
    public static RegistryObject<CorruptedSword> CORRUPTED_SWORD = ITEMS.register("corrupted_sword", () -> new CorruptedSword());

    //Armor
    //Coal
    public static RegistryObject<CoalHelmet> COAL_HELMET = ITEMS.register("coal_helmet", () -> new CoalHelmet());
    public static RegistryObject<CoalChestplate> COAL_CHESTPLATE = ITEMS.register("coal_chestplate", () -> new CoalChestplate());
    public static RegistryObject<CoalLeggings> COAL_LEGGINGS = ITEMS.register("coal_leggings", () -> new CoalLeggings());
    public static RegistryObject<CoalBoots> COAL_BOOTS = ITEMS.register("coal_boots", () -> new CoalBoots());
    //Lapis
    public static RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", () -> new LapisHelmet());
    public static RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", () -> new LapisChestplate());
    public static RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings", () -> new LapisLeggings());
    public static RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", () -> new LapisBoots());
    //Sapphire
    public static RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new SapphireHelmet());
    public static RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new SapphireChestplate());
    public static RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new SapphireLeggings());
    public static RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new SapphireBoots());
    //Obsidian
    public static RegistryObject<ObsidianHelmet> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ObsidianHelmet());
    public static RegistryObject<ObsidianChestplate> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ObsidianChestplate());
    public static RegistryObject<ObsidianLeggings> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ObsidianLeggings());
    public static RegistryObject<ObsidianBoots> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ObsidianBoots());

    //Blocks
    public static RegistryObject<SapphireBlock> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new SapphireBlock());

    //Ores
    public static RegistryObject<SapphireOre> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new SapphireOre());
}