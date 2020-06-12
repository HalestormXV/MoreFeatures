package io.github.xf8b.morefeatures;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class MoreFeaturesItemGroup {
    public ItemGroup itemGroup = new ItemGroup(MoreFeatures.MOD_ID) {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(MoreFeaturesRegistries.SAPPHIRE.get());
        }
    };
}
