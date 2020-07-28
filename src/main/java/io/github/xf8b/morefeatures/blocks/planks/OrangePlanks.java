package io.github.xf8b.morefeatures.blocks.planks;

import io.github.xf8b.morefeatures.blocks.PlanksBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

public class OrangePlanks extends Block implements PlanksBlock {
    public OrangePlanks() {
        super(Block.Settings.copy(Blocks.OAK_PLANKS));
    }

    @Override
    public Block getButton() {
        return MoreFeaturesRegistries.ORANGE_BUTTON.get();
    }
}
