package io.github.xf8b.morefeatures.blocks;

import net.minecraft.block.GlassBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlastProofGlass extends GlassBlock {
    public BlastProofGlass() {
        super(Properties.create(Material.GLASS)
                .hardnessAndResistance(1f, 3600000.0F)
                .sound(SoundType.GLASS)
                .notSolid()
        );
    }
}
