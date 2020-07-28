package io.github.xf8b.morefeatures.blocks.fence;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;

public class LemonFence extends FenceBlock implements WoodenBlock {
    public LemonFence() {
        super(Block.Settings.copy(Blocks.OAK_FENCE));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
