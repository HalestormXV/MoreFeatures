package io.github.xf8b.morefeatures.items.armor;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class Mask extends ArmorItem {
    public Mask() {
        super(MoreFeaturesArmorMaterial.MASK, EquipmentSlot.HEAD, new Item.Settings()
                .group(MoreFeatures.ITEM_GROUP)
                .maxCount(1)
        );
    }
}
