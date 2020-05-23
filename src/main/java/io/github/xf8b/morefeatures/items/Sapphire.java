package io.github.xf8b.morefeatures.items;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class Sapphire extends Item {
    public Sapphire() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.MISC)
        );
    }
}
