package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class SapphirePickaxe extends PickaxeItem {
    public SapphirePickaxe() {
        super(MoreFeaturesItemTier.SAPPHIRE, -3, -2.8f, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }
}
