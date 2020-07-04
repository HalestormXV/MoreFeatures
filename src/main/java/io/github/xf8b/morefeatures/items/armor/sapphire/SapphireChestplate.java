package io.github.xf8b.morefeatures.items.armor.sapphire;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;

public class SapphireChestplate extends ArmorItem {
    public SapphireChestplate() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlotType.CHEST, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }
}
