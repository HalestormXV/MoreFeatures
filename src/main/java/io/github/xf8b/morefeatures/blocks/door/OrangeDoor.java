package io.github.xf8b.morefeatures.blocks.door;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.DoorBlock;

public class OrangeDoor extends DoorBlock implements WoodenBlock {
    public OrangeDoor() {
        super(Block.Settings.copy(Blocks.OAK_DOOR));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
