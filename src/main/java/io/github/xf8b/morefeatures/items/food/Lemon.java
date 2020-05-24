package io.github.xf8b.morefeatures.items.food;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Food;
import net.minecraft.item.Item;

public class Lemon extends Item {
    public Lemon() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
                .food(new Food.Builder()
                        .hunger(3)
                        .saturation(0.2f)
                        .build()
                )
        );
    }
}
