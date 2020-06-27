package io.github.xf8b.morefeatures.blocks;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class SapphireOre extends Block implements IGemDroppingOre {
    public SapphireOre() {
        super(Block.Properties.create(Material.IRON)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .hardnessAndResistance(3f)
        );
    }

    @Override
    public Item getGem() {
        return MoreFeaturesRegistries.SAPPHIRE.get();
    }
}
