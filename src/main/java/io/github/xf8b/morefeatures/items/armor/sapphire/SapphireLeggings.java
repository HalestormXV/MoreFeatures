package io.github.xf8b.morefeatures.items.armor.sapphire;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SapphireLeggings extends ArmorItem {
    public SapphireLeggings() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlotType.LEGS, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.COMBAT)
        );
    }
}
