package io.github.xf8b.morefeatures.core;

import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.util.IItemProvider;

public class MoreFeaturesSetupFunctions {
    public static void setupFlammabilityAndCompostability() {
        //Register items to be compostable
        //Leaves
        registerCompostable(0.3f, MoreFeaturesRegistries.LEMON_LEAVES.get());
        registerCompostable(0.3f, MoreFeaturesRegistries.ORANGE_LEAVES.get());

        //Saplings
        registerCompostable(0.3f, MoreFeaturesRegistries.LEMON_SAPLING.get());
        registerCompostable(0.3f, MoreFeaturesRegistries.ORANGE_SAPLING.get());

        //Seeds
        registerCompostable(0.3f, MoreFeaturesRegistries.CORN_SEEDS.get());

        //Foods
        registerCompostable(0.65f, MoreFeaturesRegistries.LEMON.get());
        registerCompostable(0.65f, MoreFeaturesRegistries.ORANGE.get());
        registerCompostable(0.65f, MoreFeaturesRegistries.CORN.get());

        //Set flammable blocks to be flammable
        FireBlock fire = (FireBlock) Blocks.FIRE;
        //Planks
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_PLANKS.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_PLANKS.get(), 5, 20);

        //Slabs
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_SLAB.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_SLAB.get(), 5, 20);

        //Logs
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_LOG.get(), 5, 5);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_LOG.get(), 5, 5);

        //Leaves
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_LEAVES.get(), 30, 60);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_LEAVES.get(), 30, 60);

        //Fences
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_FENCE.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_FENCE.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_FENCE_GATE.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_FENCE_GATE.get(), 5, 20);

        //Stairs
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_STAIRS.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_STAIRS.get(), 5, 20);

        //Buttons
        fire.setFireInfo(Blocks.OAK_BUTTON, 5, 20);
        fire.setFireInfo(Blocks.SPRUCE_BUTTON, 5, 20);
        fire.setFireInfo(Blocks.BIRCH_BUTTON, 5, 20);
        fire.setFireInfo(Blocks.JUNGLE_BUTTON, 5, 20);
        fire.setFireInfo(Blocks.ACACIA_BUTTON, 5, 20);
        fire.setFireInfo(Blocks.DARK_OAK_BUTTON, 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_BUTTON.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_BUTTON.get(), 5, 20);

        //Pressure Plates
        fire.setFireInfo(Blocks.OAK_PRESSURE_PLATE, 5, 20);
        fire.setFireInfo(Blocks.SPRUCE_PRESSURE_PLATE, 5, 20);
        fire.setFireInfo(Blocks.BIRCH_PRESSURE_PLATE, 5, 20);
        fire.setFireInfo(Blocks.JUNGLE_PRESSURE_PLATE, 5, 20);
        fire.setFireInfo(Blocks.ACACIA_PRESSURE_PLATE, 5, 20);
        fire.setFireInfo(Blocks.DARK_OAK_PRESSURE_PLATE, 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE.get(), 5, 20);

        //Doors
        fire.setFireInfo(Blocks.OAK_DOOR, 5, 20);
        fire.setFireInfo(Blocks.SPRUCE_DOOR, 5, 20);
        fire.setFireInfo(Blocks.BIRCH_DOOR, 5, 20);
        fire.setFireInfo(Blocks.JUNGLE_DOOR, 5, 20);
        fire.setFireInfo(Blocks.ACACIA_DOOR, 5, 20);
        fire.setFireInfo(Blocks.DARK_OAK_DOOR, 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.LEMON_DOOR.get(), 5, 20);
        fire.setFireInfo(MoreFeaturesRegistries.ORANGE_DOOR.get(), 5, 20);

        //Beds
        fire.setFireInfo(Blocks.WHITE_BED, 60, 80);
        fire.setFireInfo(Blocks.ORANGE_BED, 60, 80);
        fire.setFireInfo(Blocks.MAGENTA_BED, 60, 80);
        fire.setFireInfo(Blocks.LIGHT_BLUE_BED, 60, 80);
        fire.setFireInfo(Blocks.YELLOW_BED, 60, 80);
        fire.setFireInfo(Blocks.LIME_BED, 60, 80);
        fire.setFireInfo(Blocks.PINK_BED, 60, 80);
        fire.setFireInfo(Blocks.GRAY_BED, 60, 80);
        fire.setFireInfo(Blocks.LIGHT_GRAY_BED, 60, 80);
        fire.setFireInfo(Blocks.CYAN_BED, 60, 80);
        fire.setFireInfo(Blocks.PURPLE_BED, 60, 80);
        fire.setFireInfo(Blocks.BLUE_BED, 60, 80);
        fire.setFireInfo(Blocks.BROWN_BED, 60, 80);
        fire.setFireInfo(Blocks.GREEN_BED, 60, 80);
        fire.setFireInfo(Blocks.RED_BED, 60, 80);
        fire.setFireInfo(Blocks.BLACK_BED, 60, 80);

        //Crops
        fire.setFireInfo(MoreFeaturesRegistries.CORN_CROP.get(), 40, 60);
        fire.setFireInfo(Blocks.WHEAT, 70, 90);
    }

    public static void registerCompostable(float chance, IItemProvider item) {
        ComposterBlock.CHANCES.put(item.asItem(), chance);
    }
}
