package io.github.xf8b.morefeatures.items.food;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RedstoneApple extends Item {
    public RedstoneApple() {
        super(new Item.Properties()
                .group(MoreFeatures.instance.itemGroup)

                .food(new Food.Builder()
                        .setAlwaysEdible()
                        .hunger(4)
                        .saturation(1.2f)
                        .effect(() -> new EffectInstance(Effects.REGENERATION, 200, 1), 1f)
                        .effect(() -> new EffectInstance(Effects.ABSORPTION, 4800, 0), 1f)
                        .build()
                )
        );
    }
}
