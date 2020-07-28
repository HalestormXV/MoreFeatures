package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class SapphireShovel extends ShovelItem {
    public SapphireShovel() {
        super(MoreFeaturesItemTier.SAPPHIRE, -3f, -3f, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }
}
