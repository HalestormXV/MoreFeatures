package io.github.xf8b.morefeatures.blocks.stairs;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.StairsBlock;

public class OrangeStairs extends StairsBlock implements WoodenBlock {
    public OrangeStairs() {
        super(() -> MoreFeaturesRegistries.ORANGE_PLANKS.get().getDefaultState(), Block.Settings.copy(Blocks.OAK_PLANKS));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
