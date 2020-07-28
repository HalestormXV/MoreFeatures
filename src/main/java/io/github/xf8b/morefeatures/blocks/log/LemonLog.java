package io.github.xf8b.morefeatures.blocks.log;

import io.github.xf8b.morefeatures.blocks.WoodenBlock;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.*;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.math.Direction;

public class LemonLog extends PillarBlock implements WoodenBlock {
    public LemonLog() {
        super(AbstractBlock.Settings.of(
                Material.WOOD,
                blockState -> blockState.get(PillarBlock.AXIS) == Direction.Axis.Y ? MaterialColor.WOOD : MaterialColor.SPRUCE)
                .strength(2.0F)
                .sounds(BlockSoundGroup.WOOD)
        );
    }

    @Override
    public Block getWood() {
        return MoreFeaturesRegistries.LEMON_PLANKS.get();
    }
}
