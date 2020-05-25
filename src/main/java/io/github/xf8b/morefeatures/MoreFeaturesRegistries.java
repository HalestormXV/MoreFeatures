package io.github.xf8b.morefeatures;

import io.github.xf8b.morefeatures.blocks.SapphireBlock;
import io.github.xf8b.morefeatures.blocks.SapphireOre;
import io.github.xf8b.morefeatures.blocks.leaves.LemonLeaves;
import io.github.xf8b.morefeatures.blocks.leaves.OrangeLeaves;
import io.github.xf8b.morefeatures.blocks.log.LemonLog;
import io.github.xf8b.morefeatures.blocks.log.OrangeLog;
import io.github.xf8b.morefeatures.blocks.planks.LemonPlanks;
import io.github.xf8b.morefeatures.blocks.planks.OrangePlanks;
import io.github.xf8b.morefeatures.blocks.sapling.LemonSapling;
import io.github.xf8b.morefeatures.blocks.sapling.OrangeSapling;
import io.github.xf8b.morefeatures.enchantments.FireRetardant;
import io.github.xf8b.morefeatures.enchantments.SavingGrace;
import io.github.xf8b.morefeatures.enchantments.SoulHarvester;
import io.github.xf8b.morefeatures.items.Sapphire;
import io.github.xf8b.morefeatures.items.armor.coal.CoalBoots;
import io.github.xf8b.morefeatures.items.armor.coal.CoalChestplate;
import io.github.xf8b.morefeatures.items.armor.coal.CoalHelmet;
import io.github.xf8b.morefeatures.items.armor.coal.CoalLeggings;
import io.github.xf8b.morefeatures.items.armor.emerald.EmeraldBoots;
import io.github.xf8b.morefeatures.items.armor.emerald.EmeraldChestplate;
import io.github.xf8b.morefeatures.items.armor.emerald.EmeraldHelmet;
import io.github.xf8b.morefeatures.items.armor.emerald.EmeraldLeggings;
import io.github.xf8b.morefeatures.items.armor.lapis.LapisBoots;
import io.github.xf8b.morefeatures.items.armor.lapis.LapisChestplate;
import io.github.xf8b.morefeatures.items.armor.lapis.LapisHelmet;
import io.github.xf8b.morefeatures.items.armor.lapis.LapisLeggings;
import io.github.xf8b.morefeatures.items.armor.obsidian.ObsidianBoots;
import io.github.xf8b.morefeatures.items.armor.obsidian.ObsidianChestplate;
import io.github.xf8b.morefeatures.items.armor.obsidian.ObsidianHelmet;
import io.github.xf8b.morefeatures.items.armor.obsidian.ObsidianLeggings;
import io.github.xf8b.morefeatures.items.armor.sapphire.SapphireBoots;
import io.github.xf8b.morefeatures.items.armor.sapphire.SapphireChestplate;
import io.github.xf8b.morefeatures.items.armor.sapphire.SapphireHelmet;
import io.github.xf8b.morefeatures.items.armor.sapphire.SapphireLeggings;
import io.github.xf8b.morefeatures.items.food.IronApple;
import io.github.xf8b.morefeatures.items.food.Lemon;
import io.github.xf8b.morefeatures.items.food.Orange;
import io.github.xf8b.morefeatures.items.food.RedstoneApple;
import io.github.xf8b.morefeatures.items.tools.corrupted.CorruptedSword;
import io.github.xf8b.morefeatures.items.tools.sapphire.*;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreFeaturesRegistries {
    //Deferred Registries
    public static DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MoreFeatures.MOD_ID);
    public static DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreFeatures.MOD_ID);
    public static DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, MoreFeatures.MOD_ID);

    //Registry Objects
    //Enchantments
    public static RegistryObject<FireRetardant> FIRE_RETARDANT = ENCHANTMENTS.register("fire_retardant", () -> new FireRetardant());
    public static RegistryObject<SoulHarvester> SOUL_HARVESTER = ENCHANTMENTS.register("soul_harvester", () -> new SoulHarvester());
    public static RegistryObject<SavingGrace> SAVING_GRACE = ENCHANTMENTS.register("saving_grace", () -> new SavingGrace());

    //Items
    public static RegistryObject<Sapphire> SAPPHIRE = ITEMS.register("sapphire", () -> new Sapphire());

    //Foods
    public static RegistryObject<IronApple> IRON_APPLE = ITEMS.register("iron_apple", () -> new IronApple());
    public static RegistryObject<RedstoneApple> REDSTONE_APPLE = ITEMS.register("redstone_apple", () -> new RedstoneApple());
    public static RegistryObject<Lemon> LEMON = ITEMS.register("lemon", () -> new Lemon());
    public static RegistryObject<Orange> ORANGE = ITEMS.register("orange", () -> new Orange());

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
    //Emerald
    public static RegistryObject<EmeraldHelmet> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new EmeraldHelmet());
    public static RegistryObject<EmeraldChestplate> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new EmeraldChestplate());
    public static RegistryObject<EmeraldLeggings> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new EmeraldLeggings());
    public static RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new EmeraldBoots());
    //Obsidian
    public static RegistryObject<ObsidianHelmet> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ObsidianHelmet());
    public static RegistryObject<ObsidianChestplate> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ObsidianChestplate());
    public static RegistryObject<ObsidianLeggings> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ObsidianLeggings());
    public static RegistryObject<ObsidianBoots> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ObsidianBoots());

    //Blocks
    public static RegistryObject<SapphireBlock> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new SapphireBlock());

    //Saplings
    public static RegistryObject<LemonSapling> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new LemonSapling());
    public static RegistryObject<OrangeSapling> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new OrangeSapling());

    //Logs
    public static RegistryObject<LemonLog> LEMON_LOG = BLOCKS.register("lemon_log", () -> new LemonLog());
    public static RegistryObject<OrangeLog> ORANGE_LOG = BLOCKS.register("orange_log", () -> new OrangeLog());
    //Leaves
    public static RegistryObject<LemonLeaves> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new LemonLeaves());
    public static RegistryObject<OrangeLeaves> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new OrangeLeaves());

    //Planks
    public static RegistryObject<LemonPlanks> LEMON_PLANKS = BLOCKS.register("lemon_planks", () -> new LemonPlanks());
    public static RegistryObject<OrangePlanks> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> new OrangePlanks());

    //Ores
    public static RegistryObject<SapphireOre> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new SapphireOre());
}
