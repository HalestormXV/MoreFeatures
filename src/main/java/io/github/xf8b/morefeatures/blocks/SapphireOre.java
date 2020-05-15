package io.github.xf8b.morefeatures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class SapphireOre extends Block {
    public SapphireOre() {
        super(Properties.create(Material.IRON)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .hardnessAndResistance(3f)
        );
    }
}
