package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class SapphireHoe extends HoeItem {
    public SapphireHoe() {
        super(MoreFeaturesItemTier.SAPPHIRE, 0f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.itemGroup)
        );
    }
}
