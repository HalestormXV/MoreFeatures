package io.github.xf8b.morefeatures.items.armor.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class SapphireHelmet extends ArmorItem {
    public SapphireHelmet() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlot.HEAD, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }
}
