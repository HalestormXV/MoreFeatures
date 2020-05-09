package com.github.xf8b.morefeatures.items.tools;

import com.github.xf8b.morefeatures.MoreFeatures;
import com.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;

public class SapphireHoe extends HoeItem {
    public SapphireHoe() {
        super(MoreFeaturesItemTier.SAPPHIRE, 0f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
