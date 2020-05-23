package io.github.xf8b.morefeatures.items.armor.lapis;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.events.TickCounter;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LapisLeggings extends ArmorItem {
    public LapisLeggings() {
        super(MoreFeaturesArmorMaterial.LAPIS, EquipmentSlotType.LEGS, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.COMBAT)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(TickCounter.count == 2400) {
            player.giveExperiencePoints(5);
        }
    }
}
