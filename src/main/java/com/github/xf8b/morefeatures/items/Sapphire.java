package com.github.xf8b.morefeatures.items;

import com.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Item;

public class Sapphire extends Item {
    public Sapphire() {
        super(new Item.Properties()
                .maxStackSize(64)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
