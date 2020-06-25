package io.github.xf8b.morefeatures.blocks.fence;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;

public class OrangeFence extends FenceBlock implements IWoodenBlock {
    public OrangeFence() {
        super(Block.Properties.from(Blocks.OAK_FENCE));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
