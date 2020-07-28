package io.github.xf8b.morefeatures.world.feature;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.BranchedTreeFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraftforge.common.IPlantable;

import javax.annotation.Nullable;
import java.util.Random;

public class OrangeTree extends SaplingGenerator {
    public static final BranchedTreeFeatureConfig ORANGE_TREE_CONFIG = new BranchedTreeFeatureConfig.Builder(
            new SimpleBlockStateProvider(MoreFeaturesRegistries.ORANGE_LOG.get().getDefaultState()),
            new SimpleBlockStateProvider(MoreFeaturesRegistries.ORANGE_LEAVES.get().getDefaultState()),
            new BlobFoliagePlacer(2, 0))
            .baseHeight(4)
            .heightRandA(2)
            .foliageHeight(3)
            .noVines()
            .setSapling((IPlantable) MoreFeaturesRegistries.ORANGE_SAPLING.get())
            .build();

    @Nullable
    @Override
    protected ConfiguredFeature<BranchedTreeFeatureConfig, ?> createTreeFeature(Random randomIn, boolean p_225546_2_) {
        return Feature.NORMAL_TREE.configure(ORANGE_TREE_CONFIG);
    }
}
