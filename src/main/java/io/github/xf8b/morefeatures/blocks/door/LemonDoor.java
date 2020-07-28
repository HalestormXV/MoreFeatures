package io.github.xf8b.morefeatures.blocks.door;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;

public class LemonDoor extends DoorBlock implements WoodenBlock {
    public LemonDoor() {
        super(Block.Settings.copy(Blocks.OAK_DOOR));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
