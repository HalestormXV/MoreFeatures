package com.github.xf8b.morefeatures.items.armor;

import com.github.xf8b.morefeatures.MoreFeatures;
import com.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class SapphireHelmet extends ArmorItem {
    public SapphireHelmet() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlotType.HEAD, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
