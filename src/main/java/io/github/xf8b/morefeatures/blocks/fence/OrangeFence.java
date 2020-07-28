package io.github.xf8b.morefeatures.blocks.fence;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceBlock;

public class OrangeFence extends FenceBlock implements WoodenBlock {
    public OrangeFence() {
        super(Block.Settings.copy(Blocks.OAK_FENCE));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
