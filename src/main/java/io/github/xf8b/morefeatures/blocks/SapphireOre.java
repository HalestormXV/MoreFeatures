package io.github.xf8b.morefeatures.blocks;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;

public class SapphireOre extends Block implements GemDroppingOre {
    public SapphireOre() {
        super(Block.Settings.of(Material.METAL)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
                .strength(3f)
        );
    }

    @Override
    public Item getGem() {
        return MoreFeaturesRegistries.SAPPHIRE.get();
    }
}
