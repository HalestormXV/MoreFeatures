package io.github.xf8b.morefeatures.blocks.planks;

import io.github.xf8b.morefeatures.blocks.IPlanksBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class LemonPlanks extends Block implements IPlanksBlock {
    public LemonPlanks() {
        super(Block.Properties.from(Blocks.OAK_PLANKS));
    }

    @Override
    public Block getButton() {
        return MoreFeaturesRegistries.LEMON_BUTTON.get();
    }
}
