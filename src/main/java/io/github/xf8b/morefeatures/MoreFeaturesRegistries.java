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
    public static final RegistryObject<Sapphire> SAPPHIRE = ITEMS.register("sapphire", () -> new Sapphire());
    public static final RegistryObject<CorruptedItem> CORRUPTED_ITEM = ITEMS.register("corrupted_item", () -> new CorruptedItem());

    //Seeds
    public static final RegistryObject<CornSeeds> CORN_SEEDS = ITEMS.register("corn_seeds", () -> new CornSeeds());

    //Foods
    public static final RegistryObject<IronApple> IRON_APPLE = ITEMS.register("iron_apple", () -> new IronApple());
    public static final RegistryObject<RedstoneApple> REDSTONE_APPLE = ITEMS.register("redstone_apple", () -> new RedstoneApple());
    public static final RegistryObject<Lemon> LEMON = ITEMS.register("lemon", () -> new Lemon());
    public static final RegistryObject<Orange> ORANGE = ITEMS.register("orange", () -> new Orange());
    public static final RegistryObject<Corn> CORN = ITEMS.register("corn", () -> new Corn());

    //Tools
    //Sapphire
    public static final RegistryObject<SapphireSword> SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", () -> new SapphireSword());
    public static final RegistryObject<SapphirePickaxe> SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", () -> new SapphirePickaxe());
    public static final RegistryObject<SapphireAxe> SAPPHIRE_AXE = ITEMS.register("sapphire_axe", () -> new SapphireAxe());
    public static final RegistryObject<SapphireShovel> SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", () -> new SapphireShovel());
    public static final RegistryObject<SapphireHoe> SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", () -> new SapphireHoe());
    //Corrupted
    public static final RegistryObject<CorruptedSword> CORRUPTED_SWORD = ITEMS.register("corrupted_sword", () -> new CorruptedSword());
    public static final RegistryObject<CorruptedPickaxe> CORRUPTED_PICKAXE = ITEMS.register("corrupted_pickaxe", () -> new CorruptedPickaxe());
    public static final RegistryObject<CorruptedAxe> CORRUPTED_AXE = ITEMS.register("corrupted_axe", () -> new CorruptedAxe());
    public static final RegistryObject<CorruptedShovel> CORRUPTED_SHOVEL = ITEMS.register("corrupted_shovel", () -> new CorruptedShovel());
    public static final RegistryObject<CorruptedHoe> CORRUPTED_HOE = ITEMS.register("corrupted_hoe", () -> new CorruptedHoe());

    //Armor
    //Mask
    public static final RegistryObject<Mask> MASK = ITEMS.register("mask", () -> new Mask());
    //Coal
    public static final RegistryObject<CoalHelmet> COAL_HELMET = ITEMS.register("coal_helmet", () -> new CoalHelmet());
    public static final RegistryObject<CoalChestplate> COAL_CHESTPLATE = ITEMS.register("coal_chestplate", () -> new CoalChestplate());
    public static final RegistryObject<CoalLeggings> COAL_LEGGINGS = ITEMS.register("coal_leggings", () -> new CoalLeggings());
    public static final RegistryObject<CoalBoots> COAL_BOOTS = ITEMS.register("coal_boots", () -> new CoalBoots());
    //Lapis
    public static final RegistryObject<LapisHelmet> LAPIS_HELMET = ITEMS.register("lapis_helmet", () -> new LapisHelmet());
    public static final RegistryObject<LapisChestplate> LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", () -> new LapisChestplate());
    public static final RegistryObject<LapisLeggings> LAPIS_LEGGINGS = ITEMS.register("lapis_leggings", () -> new LapisLeggings());
    public static final RegistryObject<LapisBoots> LAPIS_BOOTS = ITEMS.register("lapis_boots", () -> new LapisBoots());
    //Sapphire
    public static final RegistryObject<SapphireHelmet> SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", () -> new SapphireHelmet());
    public static final RegistryObject<SapphireChestplate> SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", () -> new SapphireChestplate());
    public static final RegistryObject<SapphireLeggings> SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", () -> new SapphireLeggings());
    public static final RegistryObject<SapphireBoots> SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", () -> new SapphireBoots());
    //Emerald
    public static final RegistryObject<EmeraldHelmet> EMERALD_HELMET = ITEMS.register("emerald_helmet", () -> new EmeraldHelmet());
    public static final RegistryObject<EmeraldChestplate> EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", () -> new EmeraldChestplate());
    public static final RegistryObject<EmeraldLeggings> EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", () -> new EmeraldLeggings());
    public static final RegistryObject<EmeraldBoots> EMERALD_BOOTS = ITEMS.register("emerald_boots", () -> new EmeraldBoots());
    //Obsidian
    public static final RegistryObject<ObsidianHelmet> OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", () -> new ObsidianHelmet());
    public static final RegistryObject<ObsidianChestplate> OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", () -> new ObsidianChestplate());
    public static final RegistryObject<ObsidianLeggings> OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", () -> new ObsidianLeggings());
    public static final RegistryObject<ObsidianBoots> OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", () -> new ObsidianBoots());

    //Blocks
    public static final RegistryObject<SapphireBlock> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new SapphireBlock());
    public static final RegistryObject<BlastProofGlass> BLAST_PROOF_GLASS = BLOCKS.register("blast_proof_glass", () -> new BlastProofGlass());
    public static final RegistryObject<Asbestos> ASBESTOS = BLOCKS.register("asbestos", () -> new Asbestos());

    //Saplings
    public static final RegistryObject<LemonSapling> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new LemonSapling());
    public static final RegistryObject<OrangeSapling> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new OrangeSapling());

    //Logs
    public static final RegistryObject<LemonLog> LEMON_LOG = BLOCKS.register("lemon_log", () -> new LemonLog());
    public static final RegistryObject<OrangeLog> ORANGE_LOG = BLOCKS.register("orange_log", () -> new OrangeLog());
    //Leaves
    public static final RegistryObject<LemonLeaves> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new LemonLeaves());
    public static final RegistryObject<OrangeLeaves> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new OrangeLeaves());

    //Planks
    public static final RegistryObject<LemonPlanks> LEMON_PLANKS = BLOCKS.register("lemon_planks", () -> new LemonPlanks());
    public static final RegistryObject<OrangePlanks> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> new OrangePlanks());

    //Crops
    public static final RegistryObject<CornCrop> CORN_CROP = BLOCKS.register("corn_crop", () -> new CornCrop());

    //Ores
    public static final RegistryObject<SapphireOre> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new SapphireOre());

    //Enchantments
    public static final RegistryObject<FireRetardant> FIRE_RETARDANT = ENCHANTMENTS.register("fire_retardant", () -> new FireRetardant());
    public static final RegistryObject<SoulHarvester> SOUL_HARVESTER = ENCHANTMENTS.register("soul_harvester", () -> new SoulHarvester());
    public static final RegistryObject<SavingGrace> SAVING_GRACE = ENCHANTMENTS.register("saving_grace", () -> new SavingGrace());
    //Curses
    public static final RegistryObject<SlownessCurse> SLOWNESS_CURSE = ENCHANTMENTS.register("slowness_curse", () -> new SlownessCurse());
    public static final RegistryObject<HarmingCurse> HARMING_CURSE = ENCHANTMENTS.register("harming_curse", () -> new HarmingCurse());
    public static final RegistryObject<WeightCurse> WEIGHT_CURSE = ENCHANTMENTS.register("weight_curse", () -> new WeightCurse());

    //Effects
    public static final RegistryObject<Asbestosis> ASBESTOSIS = EFFECTS.register("asbestosis", () -> new Asbestosis());
}
