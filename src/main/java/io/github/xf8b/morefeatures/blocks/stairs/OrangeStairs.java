package io.github.xf8b.morefeatures.blocks.stairs;

import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;

public class OrangeStairs extends StairsBlock {
    public OrangeStairs() {
        super(() -> MoreFeaturesRegistries.ORANGE_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_PLANKS));
    }
}
