package io.github.xf8b.morefeatures.world.gen;

import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.world.feature.LemonTree;
import io.github.xf8b.morefeatures.world.feature.OrangeTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreFeaturesGeneration {
    public static void generateFeatures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            ConfiguredPlacement sapphireOreConfig = Placement.COUNT_RANGE
                    .configure(new CountRangeConfig(1, 0, 0, 12));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MoreFeaturesRegistries.SAPPHIRE_ORE.get().getDefaultState(), 4))
                    .withPlacement(sapphireOreConfig));
            ConfiguredPlacement asbestosConfig = Placement.COUNT_RANGE
                    .configure(new CountRangeConfig(4, 0, 0, 40));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MoreFeaturesRegistries.ASBESTOS.get().getDefaultState(), 6))
                    .withPlacement(asbestosConfig));
            if (biome == Biomes.PLAINS) {
                ConfiguredPlacement lemonTreeConfig = Placement.COUNT_EXTRA_HEIGHTMAP
                        .configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE
                        .withConfiguration(LemonTree.LEMON_TREE_CONFIG)
                        .withPlacement(lemonTreeConfig));
                ConfiguredPlacement orangeTreeConfig = Placement.COUNT_EXTRA_HEIGHTMAP
                        .configure(new AtSurfaceWithExtraConfig(0, 0.05F, 1));
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE
                        .withConfiguration(OrangeTree.ORANGE_TREE_CONFIG)
                        .withPlacement(orangeTreeConfig));
            }
        }
    }
}