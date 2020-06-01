package io.github.xf8b.morefeatures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SapphireBlock extends Block {
    public SapphireBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(4f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
