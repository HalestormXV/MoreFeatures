package io.github.xf8b.morefeatures.blocks.button;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodButtonBlock;

public class OrangeButton extends WoodButtonBlock implements WoodenBlock {
    public OrangeButton() {
        super(Block.Settings.copy(Blocks.OAK_BUTTON));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
