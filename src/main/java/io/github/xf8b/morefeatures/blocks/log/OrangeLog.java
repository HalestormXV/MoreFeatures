package io.github.xf8b.morefeatures.blocks.log;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;

public class OrangeLog extends LogBlock implements IWoodenBlock {
    public OrangeLog() {
        super(MaterialColor.WOOD, Block.Properties.from(Blocks.OAK_LOG));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
