package io.github.xf8b.morefeatures.blocks.log;

import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;

public class LemonLog extends LogBlock {
    public LemonLog() {
        super(MaterialColor.WOOD, Properties.from(Blocks.OAK_LOG));
    }
}
