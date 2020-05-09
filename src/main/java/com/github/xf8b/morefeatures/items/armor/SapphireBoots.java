package com.github.xf8b.morefeatures.items.armor;

import com.github.xf8b.morefeatures.MoreFeatures;
import com.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class SapphireBoots extends ArmorItem {
    public SapphireBoots() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }
}
