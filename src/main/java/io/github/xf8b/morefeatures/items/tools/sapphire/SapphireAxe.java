package io.github.xf8b.morefeatures.items.tools.sapphire;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SapphireAxe extends AxeItem {
    public SapphireAxe() {
        super(MoreFeaturesItemTier.SAPPHIRE, 1, -3f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.TOOLS)
        );
    }
}
