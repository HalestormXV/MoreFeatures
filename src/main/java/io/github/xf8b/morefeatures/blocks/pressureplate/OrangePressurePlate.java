package io.github.xf8b.morefeatures.blocks.pressureplate;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;

public class OrangePressurePlate extends PressurePlateBlock implements WoodenBlock {
    public OrangePressurePlate() {
        super(ActivationRule.EVERYTHING, Block.Settings.copy(Blocks.OAK_PRESSURE_PLATE));
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.ORANGE_PLANKS.get();
    }
}
