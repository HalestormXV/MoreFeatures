package io.github.xf8b.morefeatures.items.food;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Corn extends Item {
    public Corn() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
                .food(new Food.Builder()
                        .hunger(5)
                        .saturation(0.4f)
                        .build()
                )
        );
    }
}
