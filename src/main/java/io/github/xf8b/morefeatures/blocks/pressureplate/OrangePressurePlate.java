package io.github.xf8b.morefeatures.blocks.pressureplate;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;

public class OrangePressurePlate extends PressurePlateBlock {
    public OrangePressurePlate() {
        super(Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE));
    }
}
