package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class SapphireSword extends SwordItem {
    public SapphireSword() {
        super(MoreFeaturesItemTier.SAPPHIRE, -1, -2.4f, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }
}
