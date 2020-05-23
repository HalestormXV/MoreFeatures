package io.github.xf8b.morefeatures.items.armor.sapphire;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class SapphireBoots extends ArmorItem {
    public SapphireBoots() {
        super(MoreFeaturesArmorMaterial.SAPPHIRE, EquipmentSlotType.FEET, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.COMBAT)
        );
    }
}
