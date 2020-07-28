package io.github.xf8b.morefeatures.blocks.button;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.WoodButtonBlock;

public class LemonButton extends WoodButtonBlock implements WoodenBlock {
    public LemonButton() {
        super(Block.Settings.copy(Blocks.OAK_BUTTON));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
