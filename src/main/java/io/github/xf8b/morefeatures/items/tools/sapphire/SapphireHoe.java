package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SapphireHoe extends HoeItem {
    public SapphireHoe() {
        super(MoreFeaturesItemTier.SAPPHIRE, 0f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.TOOLS)
        );
    }
}
