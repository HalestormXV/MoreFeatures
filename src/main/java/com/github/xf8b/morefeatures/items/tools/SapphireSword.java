package com.github.xf8b.morefeatures.items.tools;

import com.github.xf8b.morefeatures.MoreFeatures;
import com.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class SapphireSword extends SwordItem {
    public SapphireSword() {
        super(MoreFeaturesItemTier.SAPPHIRE, 0, -2.4f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
