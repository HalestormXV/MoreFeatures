package io.github.xf8b.morefeatures.items.armor;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class Mask extends ArmorItem {
    public Mask() {
        super(MoreFeaturesArmorMaterial.MASK, EquipmentSlotType.HEAD, new Item.Properties()
                .group(MoreFeatures.ITEM_GROUP)
                .maxStackSize(1)
        );
    }
}
