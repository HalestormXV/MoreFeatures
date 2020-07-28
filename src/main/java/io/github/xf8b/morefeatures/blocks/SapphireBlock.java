package io.github.xf8b.morefeatures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraftforge.common.ToolType;

public class SapphireBlock extends Block {
    public SapphireBlock() {
        super(Block.Settings.of(Material.METAL)
                .strength(4f)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
