package io.github.xf8b.morefeatures.blocks.leaves;

import io.github.xf8b.morefeatures.blocks.FoodDroppingLeaves;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.item.Item;

public class OrangeLeaves extends LeavesBlock implements FoodDroppingLeaves {
    public OrangeLeaves() {
        super(Block.Settings.copy(Blocks.OAK_LEAVES));
    }

    @Override
    public Item getDroppedFood() {
        return MoreFeaturesRegistries.ORANGE.get();
    }

    @Override
    public Block getSapling() {
        return MoreFeaturesRegistries.ORANGE_SAPLING.get();
    }
}
