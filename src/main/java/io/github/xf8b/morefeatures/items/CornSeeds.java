package io.github.xf8b.morefeatures.items;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class CornSeeds extends BlockItem {
    public CornSeeds() {
        super(MoreFeaturesRegistries.CORN_CROP.get(), new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
