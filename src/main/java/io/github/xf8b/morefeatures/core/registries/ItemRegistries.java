package io.github.xf8b.morefeatures.core.registries;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.armor.Mask;
import io.github.xf8b.morefeatures.items.armor.coal.CoalBootsItem;
import io.github.xf8b.morefeatures.items.armor.coal.CoalChestplateItem;
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
import io.github.xf8b.morefeatures.items.tools.corrupted.*;
import io.github.xf8b.morefeatures.items.tools.sapphire.*;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FoodComponent;
import net.minecraft.item.Item;
import net.minecraft.util.registry.Registry;

public class ItemRegistries {
    //Register
    public static final Register<Item> ITEMS = new Register<>(Registry.ITEM, MoreFeatures.MOD_ID);

    //Items
    public static final Item SAPPHIRE = ITEMS.register("sapphire", new Item(new Item.Settings().group(MoreFeatures.ITEM_GROUP)));
    public static final Item CORRUPTED_ITEM = ITEMS.register("corrupted_item", new Item(new Item.Settings().group(MoreFeatures.ITEM_GROUP)));

    //Seeds
    public static final BlockItem CORN_SEEDS = ITEMS.register("corn_seeds", new BlockItem(
            MoreFeaturesRegistries.CORN_CROP,
            new Item.Settings().group(MoreFeatures.ITEM_GROUP)
    ));

    //Foods
    public static final Item IRON_APPLE = ITEMS.register("iron_apple", new Item(new Item.Settings()
            .group(MoreFeatures.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .hunger(4)
                    .saturationModifier(1.2f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 200, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 2400, 0), 1f)
                    .build()))
    );
    public static final Item REDSTONE_APPLE = ITEMS.register("redstone_apple", new Item(new Item.Settings()
            .group(MoreFeatures.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .alwaysEdible()
                    .hunger(4)
                    .saturationModifier(1.2f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 1), 1f)
                    .statusEffect(new StatusEffectInstance(StatusEffects.ABSORPTION, 4800, 0), 1f)
                    .build()))
    );
    public static final Item LEMON = ITEMS.register("lemon", new Item(new Item.Settings()
            .group(MoreFeatures.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .hunger(3)
                    .saturationModifier(0.2f)
                    .build()))
    );
    public static final Item ORANGE = ITEMS.register("orange", new Item(new Item.Settings()
            .group(MoreFeatures.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .hunger(4)
                    .saturationModifier(0.3f)
                    .build()))
    );
    public static final Item CORN = ITEMS.register("corn", new Item(new Item.Settings()
            .group(MoreFeatures.ITEM_GROUP)
            .food(new FoodComponent.Builder()
                    .hunger(5)
                    .saturationModifier(0.4f)
                    .build()))
    );

    //Tools
    //Sapphire
    public static final Item SAPPHIRE_SWORD = ITEMS.register("sapphire_sword", new SapphireSword());
    public static final Item SAPPHIRE_PICKAXE = ITEMS.register("sapphire_pickaxe", new SapphirePickaxe());
    public static final Item SAPPHIRE_AXE = ITEMS.register("sapphire_axe", new SapphireAxe());
    public static final Item SAPPHIRE_SHOVEL = ITEMS.register("sapphire_shovel", new SapphireShovel());
    public static final Item SAPPHIRE_HOE = ITEMS.register("sapphire_hoe", new SapphireHoe());

    //Corrupted
    public static final Item CORRUPTED_SWORD = ITEMS.register("corrupted_sword", new CorruptedSword());
    public static final Item CORRUPTED_PICKAXE = ITEMS.register("corrupted_pickaxe", new CorruptedPickaxe());
    public static final Item CORRUPTED_AXE = ITEMS.register("corrupted_axe", new CorruptedAxe());
    public static final Item CORRUPTED_SHOVEL = ITEMS.register("corrupted_shovel", new CorruptedShovel());
    public static final Item CORRUPTED_HOE = ITEMS.register("corrupted_hoe", new CorruptedHoe());

    //Armor
    //Corrupted
    public static final Item CORRUPTED_HELMET = ITEMS.register("corrupted_helmet", new CorruptedHelmet());
    public static final Item CORRUPTED_CHESTPLATE = ITEMS.register("corrupted_chestplate", new CorruptedChestplate());
    public static final Item CORRUPTED_LEGGINGS = ITEMS.register("corrupted_leggings", new CorruptedLeggings());
    public static final Item CORRUPTED_BOOTS = ITEMS.register("corrupted_boots", new CorruptedBoots());

    //Mask
    public static final Item MASK = ITEMS.register("mask", new Mask());

    //Coal
    public static final Item COAL_HELMET = ITEMS.register("coal_helmet", new CoalHelmet());
    public static final Item COAL_CHESTPLATE = ITEMS.register("coal_chestplate", new CoalChestplateItem());
    public static final Item COAL_LEGGINGS = ITEMS.register("coal_leggings", new CoalLeggings());
    public static final Item COAL_BOOTS = ITEMS.register("coal_boots", new CoalBootsItem());

    //Lapis
    public static final Item LAPIS_HELMET = ITEMS.register("lapis_helmet", new LapisHelmet());
    public static final Item LAPIS_CHESTPLATE = ITEMS.register("lapis_chestplate", new LapisChestplate());
    public static final Item LAPIS_LEGGINGS = ITEMS.register("lapis_leggings", new LapisLeggings());
    public static final Item LAPIS_BOOTS = ITEMS.register("lapis_boots", new LapisBoots());

    //Sapphire
    public static final Item SAPPHIRE_HELMET = ITEMS.register("sapphire_helmet", new SapphireHelmet());
    public static final Item SAPPHIRE_CHESTPLATE = ITEMS.register("sapphire_chestplate", new SapphireChestplate());
    public static final Item SAPPHIRE_LEGGINGS = ITEMS.register("sapphire_leggings", new SapphireLeggings());
    public static final Item SAPPHIRE_BOOTS = ITEMS.register("sapphire_boots", new SapphireBoots());

    //Emerald
    public static final Item EMERALD_HELMET = ITEMS.register("emerald_helmet", new EmeraldHelmet());
    public static final Item EMERALD_CHESTPLATE = ITEMS.register("emerald_chestplate", new EmeraldChestplate());
    public static final Item EMERALD_LEGGINGS = ITEMS.register("emerald_leggings", new EmeraldLeggings());
    public static final Item EMERALD_BOOTS = ITEMS.register("emerald_boots", new EmeraldBoots());

    //Obsidian
    public static final Item OBSIDIAN_HELMET = ITEMS.register("obsidian_helmet", new ObsidianHelmet());
    public static final Item OBSIDIAN_CHESTPLATE = ITEMS.register("obsidian_chestplate", new ObsidianChestplate());
    public static final Item OBSIDIAN_LEGGINGS = ITEMS.register("obsidian_leggings", new ObsidianLeggings());
    public static final Item OBSIDIAN_BOOTS = ITEMS.register("obsidian_boots", new ObsidianBoots());

}
