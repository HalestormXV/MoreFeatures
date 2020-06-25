package io.github.xf8b.morefeatures.blocks.button;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodButtonBlock;

public class OrangeButton extends WoodButtonBlock implements IWoodenBlock {
    public OrangeButton() {
        super(Block.Properties.from(Blocks.OAK_BUTTON));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
