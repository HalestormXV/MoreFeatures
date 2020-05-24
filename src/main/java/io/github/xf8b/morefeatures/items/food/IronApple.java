package io.github.xf8b.morefeatures.items.food;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class IronApple extends Item {
    public IronApple() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)
                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .hunger(4)
                        .saturation(1.2f)
                        .effect(() -> new EffectInstance(Effects.STRENGTH, 200, 1), 1f)
                        .effect(() -> new EffectInstance(Effects.RESISTANCE, 2400, 0), 1f)
                        .build()
                )
        );
    }
}
