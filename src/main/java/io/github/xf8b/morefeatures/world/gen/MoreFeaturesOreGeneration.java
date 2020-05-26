package io.github.xf8b.morefeatures.world.gen;

import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.ConfiguredPlacement;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreFeaturesOreGeneration {
    public static void generateOre() {
        for(Biome biome : ForgeRegistries.BIOMES) {
            if(MoreFeaturesConfig.isOreGenerationEnabled) {
                ConfiguredPlacement customConfig = Placement.COUNT_RANGE
                        .configure(new CountRangeConfig(1, 0, 0, 12));
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                        .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, MoreFeaturesRegistries.SAPPHIRE_ORE.get().getDefaultState(), 4))
                        .withPlacement(customConfig));
            }
        }
    }

}