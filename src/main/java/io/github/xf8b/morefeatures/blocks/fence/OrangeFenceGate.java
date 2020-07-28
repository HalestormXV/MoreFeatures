package io.github.xf8b.morefeatures.blocks.fence;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceGateBlock;

public class OrangeFenceGate extends FenceGateBlock implements WoodenBlock {
    public OrangeFenceGate() {
        super(Block.Settings.copy(Blocks.OAK_FENCE_GATE));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
