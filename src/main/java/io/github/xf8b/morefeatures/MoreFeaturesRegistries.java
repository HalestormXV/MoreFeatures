package io.github.xf8b.morefeatures;

import io.github.xf8b.morefeatures.blocks.*;
import io.github.xf8b.morefeatures.blocks.leaves.LemonLeaves;
import io.github.xf8b.morefeatures.blocks.leaves.OrangeLeaves;
import io.github.xf8b.morefeatures.blocks.log.LemonLog;
import io.github.xf8b.morefeatures.blocks.log.OrangeLog;
import io.github.xf8b.morefeatures.blocks.planks.LemonPlanks;
import io.github.xf8b.morefeatures.blocks.planks.OrangePlanks;
import io.github.xf8b.morefeatures.blocks.sapling.LemonSapling;
import io.github.xf8b.morefeatures.blocks.sapling.OrangeSapling;
import io.github.xf8b.morefeatures.effects.Asbestosis;
import io.github.xf8b.morefeatures.enchantments.*;
import io.github.xf8b.morefeatures.items.CornSeeds;
import io.github.xf8b.morefeatures.items.CorruptedItem;
import io.github.xf8b.morefeatures.items.Sapphire;
import io.github.xf8b.morefeatures.items.armor.Mask;
import io.github.xf8b.morefeatures.items.armor.coal.CoalBoots;
import io.github.xf8b.morefeatures.items.armor.coal.CoalChestplate;
import io.github.xf8b.morefeatures.items.armor.coal.CoalHelmet;
import io.github.xf8b.morefeatures.items.armor.coal.CoalLeggings;
import io.github.xf8b.morefeatures.items.armor.corrupted.CorruptedBoots;
import io.github.xf8b.morefeatures.items.armor.corrupted.CorruptedChestplate;
import io.github.xf8b.morefeatures.items.armor.corrupted.CorruptedHelmet;
import io.github.xf8b.morefeatures.items.armor.corrupted.CorruptedLeggings;
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
import io.github.xf8b.morefeatures.items.food.*;
import io.github.xf8b.morefeatures.items.tools.corrupted.*;
import io.github.xf8b.morefeatures.items.tools.sapphire.*;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreFeaturesRegistries {
    //Deferred Registries
    public static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MoreFeatures.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, MoreFeatures.MOD_ID);
    public static final DeferredRegister<Enchantment> ENCHANTMENTS = new DeferredRegister<>(ForgeRegistries.ENCHANTMENTS, MoreFeatures.MOD_ID);
    public static final DeferredRegister<Effect> EFFECTS = new DeferredRegister<>(ForgeRegistries.POTIONS, MoreFeatures.MOD_ID);

    //Registry Objects
    //Items
    public static final RegistryObject<Item> SAPPHIRE = ITEMS.register("sapphire", () -> new Sapphire());
    public static final RegistryObject<Item> CORRUPTED_ITEM = ITEMS.register("corrupted_item", () -> new CorruptedItem());

    //Seeds
    public static final RegistryObject<BlockItem> CORN_SEEDS = ITEMS.register("corn_seeds", () -> new CornSeeds());

    //Foods
    public static final RegistryObject<Item> IRON_APPLE = ITEMS.register("iron_apple", () -> new IronApple());
    public static final RegistryObject<Item> REDSTONE_APPLE = ITEMS.register("redstone_apple", () -> new RedstoneApple());
    public static final RegistryObject<Item> LEMON = ITEMS.register("lemon", () -> new Lemon());
    public static final RegistryObject<Item> ORANGE = ITEMS.register("orange", () -> new Orange());
    public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> new Corn());

    //Tools
    //Sapphire
    public static final RegistryObject<Item> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSword());
    public static final RegistryObject<Item> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxe());
    public static final RegistryObject<Item> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxe());
    public static final RegistryObject<Item> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovel());
    public static final RegistryObject<Item> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoe());
    //Corrupted
    public static final RegistryObject<Item> CORRUPTED_SWORD = ITEMS.register("corrupted_sword", () -> new CorruptedSword());
    public static final RegistryObject<Item> CORRUPTED_PICKAXE = ITEMS.register("corrupted_pickaxe", () -> new CorruptedPickaxe());
    public static final RegistryObject<Item> CORRUPTED_AXE = ITEMS.register("corrupted_axe", () -> new CorruptedAxe());
    public static final RegistryObject<Item> CORRUPTED_SHOVEL = ITEMS.register("corrupted_shovel", () -> new CorruptedShovel());
    public static final RegistryObject<Item> CORRUPTED_HOE = ITEMS.register("corrupted_hoe", () -> new CorruptedHoe());

    //Armor
    //Corrupted
    public static final RegistryObject<Item> CORRUPTED_HELMET = ITEMS.register("corrupted_helmet", () -> new CorruptedHelmet());
    public static final RegistryObject<Item> CORRUPTED_CHESTPLATE = ITEMS.register("corrupted_chestplate", () -> new CorruptedChestplate());
    public static final RegistryObject<Item> CORRUPTED_LEGGINGS = ITEMS.register("corrupted_leggings", () -> new CorruptedLeggings());
    public static final RegistryObject<Item> CORRUPTED_BOOTS = ITEMS.register("corrupted_boots", () -> new CorruptedBoots());
    //Mask
    public static final RegistryObject<Item> MASK = ITEMS.register("mask", () -> new Mask());
    //Coal
    public static final RegistryObject<Item> COAL_HELMET = ITEMS.register("coal_helmet", () -> new CoalHelmet());
    public static final RegistryObject<Item> COAL_CHESTPLATE = ITEMS.register("coal_chestplate", () -> new CoalChestplate());
    public static final RegistryObject<Item> COAL_LEGGINGS = ITEMS.register("coal_leggings", () -> new CoalLeggings());
    public static final RegistryObject<Item> COAL_BOOTS = ITEMS.register("coal_boots", () -> new CoalBoots());
    //Lapis
    public static final RegistryObject<Item> LAPIS_HELMET = ITEMS.register("lapis_helmet", () -> new LapisHelmet());
    public static final RegistryObject<Item> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", () -> new LapisChestplate());
    public static final RegistryObject<Item> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings", () -> new LapisLeggings());
    public static final RegistryObject<Item> LAPIS_BOOTS = ITEMS.register("lapis_boots", () -> new LapisBoots());
    //Sapphire
    public static final RegistryObject<Item> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new SapphireHelmet());
    public static final RegistryObject<Item> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new SapphireChestplate());
    public static final RegistryObject<Item> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new SapphireLeggings());
    public static final RegistryObject<Item> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new SapphireBoots());
    //Emerald
    public static final RegistryObject<Item> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new EmeraldHelmet());
    public static final RegistryObject<Item> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new EmeraldChestplate());
    public static final RegistryObject<Item> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new EmeraldLeggings());
    public static final RegistryObject<Item> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new EmeraldBoots());
    //Obsidian
    public static final RegistryObject<Item> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ObsidianHelmet());
    public static final RegistryObject<Item> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ObsidianChestplate());
    public static final RegistryObject<Item> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ObsidianLeggings());
    public static final RegistryObject<Item> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ObsidianBoots());

    //Blocks
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new SapphireBlock());
    public static final RegistryObject<Block> BLAST_PROOF_GLASS = BLOCKS.register("blast_proof_glass", () -> new BlastProofGlass());
    public static final RegistryObject<Block> ASBESTOS = BLOCKS.register("asbestos", () -> new Asbestos());

    //Saplings
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new LemonSapling());
    public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new OrangeSapling());

    //Logs
    public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", () -> new LemonLog());
    public static final RegistryObject<Block> ORANGE_LOG = BLOCKS.register("orange_log", () -> new OrangeLog());
    //Leaves
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new LemonLeaves());
    public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new OrangeLeaves());

    //Planks
    public static final RegistryObject<Block> LEMON_PLANKS = BLOCKS.register("lemon_planks", () -> new LemonPlanks());
    public static final RegistryObject<Block> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> new OrangePlanks());

    //Crops
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", () -> new CornCrop());

    //Ores
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new SapphireOre());

    //Enchantments
    public static final RegistryObject<Enchantment> FIRE_RETARDANT = ENCHANTMENTS.register("fire_retardant", () -> new FireRetardant());
    public static final RegistryObject<Enchantment> SOUL_HARVESTER = ENCHANTMENTS.register("soul_harvester", () -> new SoulHarvester());
    public static final RegistryObject<Enchantment> SAVING_GRACE = ENCHANTMENTS.register("saving_grace", () -> new SavingGrace());
    //Curses
    public static final RegistryObject<Enchantment> SLOWNESS_CURSE = ENCHANTMENTS.register("slowness_curse", () -> new SlownessCurse());
    public static final RegistryObject<Enchantment> HARMING_CURSE = ENCHANTMENTS.register("harming_curse", () -> new HarmingCurse());
    public static final RegistryObject<Enchantment> WEIGHT_CURSE = ENCHANTMENTS.register("weight_curse", () -> new WeightCurse());

    //Effects
    public static final RegistryObject<Effect> ASBESTOSIS = EFFECTS.register("asbestosis", () -> new Asbestosis());
}
