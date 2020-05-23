package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.ShovelItem;

public class SapphireShovel extends ShovelItem {
    public SapphireShovel() {
        super(MoreFeaturesItemTier.SAPPHIRE, -3f, -3f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
