package io.github.xf8b.morefeatures.blocks.slab;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;

public class OrangeSlab extends SlabBlock implements IWoodenBlock {
    public OrangeSlab() {
        super(Block.Properties.from(Blocks.OAK_SLAB));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
