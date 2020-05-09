package com.github.xf8b.morefeatures.items.tools;

import com.github.xf8b.morefeatures.MoreFeatures;
import com.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

public class SapphireAxe extends AxeItem {
    public SapphireAxe() {
        super(MoreFeaturesItemTier.SAPPHIRE, 1, -3f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
