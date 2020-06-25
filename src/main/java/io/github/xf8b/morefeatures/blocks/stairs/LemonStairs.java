package io.github.xf8b.morefeatures.blocks.stairs;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;

public class LemonStairs extends StairsBlock implements IWoodenBlock {
    public LemonStairs() {
        super(() -> MoreFeaturesRegistries.LEMON_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_PLANKS));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
