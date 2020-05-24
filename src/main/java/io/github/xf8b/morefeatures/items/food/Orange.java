package io.github.xf8b.morefeatures.items.food;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Orange extends Item {
    public Orange() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
                .food(new Food.Builder()
                        .hunger(4)
                        .saturation(0.3f)
                        .build()
                )
        );
    }
}
