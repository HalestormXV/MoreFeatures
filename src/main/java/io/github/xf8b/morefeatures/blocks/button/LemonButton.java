package io.github.xf8b.morefeatures.blocks.button;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodButtonBlock;

public class LemonButton extends WoodButtonBlock implements IWoodenBlock {
    public LemonButton() {
        super(Block.Properties.from(Blocks.OAK_BUTTON));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
