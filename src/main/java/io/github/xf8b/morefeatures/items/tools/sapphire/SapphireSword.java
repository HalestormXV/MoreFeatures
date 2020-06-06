package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.SwordItem;

public class SapphireSword extends SwordItem {
    public SapphireSword() {
        super(MoreFeaturesItemTier.SAPPHIRE, -1, -2.4f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
