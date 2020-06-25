package io.github.xf8b.morefeatures.blocks.door;

import io.github.xf8b.morefeatures.blocks.IWoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;

public class LemonDoor extends DoorBlock implements IWoodenBlock {
    public LemonDoor() {
        super(Block.Properties.from(Blocks.OAK_DOOR));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
