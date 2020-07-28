package io.github.xf8b.morefeatures.world.gen;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.world.biome.LemonTreePlains;
import io.github.xf8b.morefeatures.world.biome.OrangeTreePlains;
import io.github.xf8b.morefeatures.world.feature.LemonTree;
import io.github.xf8b.morefeatures.world.feature.OrangeTree;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.decorator.ConfiguredDecorator;
import net.minecraft.world.gen.decorator.CountExtraChanceDecoratorConfig;
import net.minecraft.world.gen.decorator.Decorator;
import net.minecraft.world.gen.decorator.RangeDecoratorConfig;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraftforge.registries.ForgeRegistries;

public class MoreFeaturesGeneration {
    public static void generateFeatures() {
        for (Biome biome : ForgeRegistries.BIOMES) {
            if (biome.getCategory() == Biome.Category.NETHER || biome.getCategory() == Biome.Category.THEEND) {
                return;
            }

            //Ore Generation
            if (MoreFeaturesConfig.COMMON.isOreGenerationEnabled.get()) {
                ConfiguredDecorator<RangeDecoratorConfig> sapphireOreConfig = Decorator.COUNT_RANGE
                        .configure(new RangeDecoratorConfig(1, 0, 0, 12));
                biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE
                        .configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, MoreFeaturesRegistries.SAPPHIRE_ORE.get().getDefaultState(), 4))
                        .createDecoratedFeature(sapphireOreConfig));
                ConfiguredDecorator<RangeDecoratorConfig> asbestosConfig = Decorator.COUNT_RANGE
                        .configure(new RangeDecoratorConfig(4, 0, 0, 40));
                biome.addFeature(GenerationStep.Feature.UNDERGROUND_ORES, Feature.ORE
                        .configure(new OreFeatureConfig(OreFeatureConfig.Target.NATURAL_STONE, MoreFeaturesRegistries.ASBESTOS.get().getDefaultState(), 6))
                        .createDecoratedFeature(asbestosConfig));
            }

            //Tree Generation
            if (MoreFeaturesConfig.COMMON.isTreeGenerationEnabled.get()) {
                if (biome.getCategory() == Biome.Category.PLAINS) {
                    if (!(biome instanceof LemonTreePlains) && !(biome instanceof OrangeTreePlains)) {
                        ConfiguredDecorator<CountExtraChanceDecoratorConfig> lemonTreeConfig = Decorator.COUNT_EXTRA_HEIGHTMAP
                                .configure(new CountExtraChanceDecoratorConfig(0, 0.05F, 1));
                        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE
                                .configure(LemonTree.LEMON_TREE_CONFIG)
                                .createDecoratedFeature(lemonTreeConfig));
                        ConfiguredDecorator<CountExtraChanceDecoratorConfig> orangeTreeConfig = Decorator.COUNT_EXTRA_HEIGHTMAP
                                .configure(new CountExtraChanceDecoratorConfig(0, 0.05F, 1));
                        biome.addFeature(GenerationStep.Feature.VEGETAL_DECORATION, Feature.NORMAL_TREE
                                .configure(OrangeTree.ORANGE_TREE_CONFIG)
                                .createDecoratedFeature(orangeTreeConfig));
                    }
                }
            }
        }
    }
}