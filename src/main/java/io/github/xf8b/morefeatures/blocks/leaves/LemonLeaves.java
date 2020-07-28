package io.github.xf8b.morefeatures.blocks.leaves;

import io.github.xf8b.morefeatures.blocks.FoodDroppingLeaves;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.Item;

public class LemonLeaves extends LeavesBlock implements FoodDroppingLeaves {
    public LemonLeaves() {
        super(Block.Settings.copy(Blocks.OAK_LEAVES));
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
