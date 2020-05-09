package com.github.xf8b.morefeatures.items.tools;

import com.github.xf8b.morefeatures.MoreFeatures;
import com.github.xf8b.morefeatures.MoreFeaturesItemTier;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;

public class SapphirePickaxe extends PickaxeItem {
    public SapphirePickaxe() {
        super(MoreFeaturesItemTier.SAPPHIRE, -2, -2.8f, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
