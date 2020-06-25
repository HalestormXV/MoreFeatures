package io.github.xf8b.morefeatures.blocks.planks;

import io.github.xf8b.morefeatures.blocks.IPlanksBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class OrangePlanks extends Block implements IPlanksBlock {
    public OrangePlanks() {
        super(Block.Properties.from(Blocks.OAK_PLANKS));
    }

    @Override
    public Block getButton() {
        return MoreFeaturesRegistries.ORANGE_BUTTON.get();
    }
}
