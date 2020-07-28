package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;

//todo: remove
public class SapphireAxe extends AxeItem {
    public SapphireAxe() {
        super(MoreFeaturesItemTier.SAPPHIRE, 1, -3f, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }
}
