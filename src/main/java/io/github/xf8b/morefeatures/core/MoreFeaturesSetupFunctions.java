package io.github.xf8b.morefeatures.core;

import net.fabricmc.fabric.api.registry.FlammableBlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.ItemConvertible;

public class MoreFeaturesSetupFunctions {
    public static void setupFlammabilityAndCompostability() {
        //Register items to be compostable
        //Leaves
        registerCompostable(0.3f, MoreFeaturesRegistries.LEMON_LEAVES);
        registerCompostable(0.3f, MoreFeaturesRegistries.ORANGE_LEAVES);

        //Saplings
        registerCompostable(0.3f, MoreFeaturesRegistries.LEMON_SAPLING);
        registerCompostable(0.3f, MoreFeaturesRegistries.ORANGE_SAPLING);

        //Seeds
        registerCompostable(0.3f, MoreFeaturesRegistries.CORN_SEEDS);

        //Foods
        registerCompostable(0.65f, MoreFeaturesRegistries.LEMON);
        registerCompostable(0.65f, MoreFeaturesRegistries.ORANGE);
        registerCompostable(0.65f, MoreFeaturesRegistries.CORN);

        //Set flammable blocks to be flammable
        //Planks
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_PLANKS, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_PLANKS, 5, 20);

        //Slabs
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_SLAB, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_SLAB, 5, 20);

        //Logs
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_LOG, 5, 5);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_LOG, 5, 5);

        //Leaves
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_LEAVES, 30, 60);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_LEAVES, 30, 60);

        //Fences
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_FENCE, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_FENCE, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_FENCE_GATE, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_FENCE_GATE, 5, 20);

        //Stairs
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_STAIRS, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_STAIRS, 5, 20);

        //Buttons
        registerFlammableBlock(Blocks.OAK_BUTTON, 5, 20);
        registerFlammableBlock(Blocks.SPRUCE_BUTTON, 5, 20);
        registerFlammableBlock(Blocks.BIRCH_BUTTON, 5, 20);
        registerFlammableBlock(Blocks.JUNGLE_BUTTON, 5, 20);
        registerFlammableBlock(Blocks.ACACIA_BUTTON, 5, 20);
        registerFlammableBlock(Blocks.DARK_OAK_BUTTON, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_BUTTON, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_BUTTON, 5, 20);

        //Pressure Plates
        registerFlammableBlock(Blocks.OAK_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(Blocks.SPRUCE_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(Blocks.BIRCH_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(Blocks.JUNGLE_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(Blocks.ACACIA_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(Blocks.DARK_OAK_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE, 5, 20);

        //Doors
        registerFlammableBlock(Blocks.OAK_DOOR, 5, 20);
        registerFlammableBlock(Blocks.SPRUCE_DOOR, 5, 20);
        registerFlammableBlock(Blocks.BIRCH_DOOR, 5, 20);
        registerFlammableBlock(Blocks.JUNGLE_DOOR, 5, 20);
        registerFlammableBlock(Blocks.ACACIA_DOOR, 5, 20);
        registerFlammableBlock(Blocks.DARK_OAK_DOOR, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.LEMON_DOOR, 5, 20);
        registerFlammableBlock(MoreFeaturesRegistries.ORANGE_DOOR, 5, 20);

        //Beds
        registerFlammableBlock(Blocks.WHITE_BED, 60, 80);
        registerFlammableBlock(Blocks.ORANGE_BED, 60, 80);
        registerFlammableBlock(Blocks.MAGENTA_BED, 60, 80);
        registerFlammableBlock(Blocks.LIGHT_BLUE_BED, 60, 80);
        registerFlammableBlock(Blocks.YELLOW_BED, 60, 80);
        registerFlammableBlock(Blocks.LIME_BED, 60, 80);
        registerFlammableBlock(Blocks.PINK_BED, 60, 80);
        registerFlammableBlock(Blocks.GRAY_BED, 60, 80);
        registerFlammableBlock(Blocks.LIGHT_GRAY_BED, 60, 80);
        registerFlammableBlock(Blocks.CYAN_BED, 60, 80);
        registerFlammableBlock(Blocks.PURPLE_BED, 60, 80);
        registerFlammableBlock(Blocks.BLUE_BED, 60, 80);
        registerFlammableBlock(Blocks.BROWN_BED, 60, 80);
        registerFlammableBlock(Blocks.GREEN_BED, 60, 80);
        registerFlammableBlock(Blocks.RED_BED, 60, 80);
        registerFlammableBlock(Blocks.BLACK_BED, 60, 80);

        //Crops
        registerFlammableBlock(MoreFeaturesRegistries.CORN_CROP, 40, 60);
        registerFlammableBlock(Blocks.WHEAT, 70, 90);
    }

    private static void registerCompostable(float chance, ItemConvertible item) {
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(item.asItem(), chance);
    }

    private static void registerFlammableBlock(Block block, int burn, int spread) {
        FlammableBlockRegistry.getDefaultInstance().add(block, burn, spread);
    }
}
