package io.github.xf8b.morefeatures.items;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Item;

public class CorruptedItem extends Item {
    public CorruptedItem() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
