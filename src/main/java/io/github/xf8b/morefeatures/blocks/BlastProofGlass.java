package io.github.xf8b.morefeatures.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.GlassBlock;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;

public class BlastProofGlass extends GlassBlock {
    public BlastProofGlass() {
        super(Block.Settings.of(Material.GLASS)
                .strength(1f, 3600000.0F)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
        );
    }
}
