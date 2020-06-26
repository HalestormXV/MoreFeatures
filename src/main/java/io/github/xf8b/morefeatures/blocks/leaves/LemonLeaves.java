package io.github.xf8b.morefeatures.blocks.leaves;

import io.github.xf8b.morefeatures.blocks.IFoodDroppingLeaves;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.Item;

public class LemonLeaves extends LeavesBlock implements IFoodDroppingLeaves {
    public LemonLeaves() {
        super(Block.Properties.from(Blocks.OAK_LEAVES));
    }

    @Override
    public Item getDroppedFood() {
        return MoreFeaturesRegistries.LEMON.get();
    }

    @Override
    public Block getSapling() {
        return MoreFeaturesRegistries.LEMON_SAPLING.get();
    }
}
