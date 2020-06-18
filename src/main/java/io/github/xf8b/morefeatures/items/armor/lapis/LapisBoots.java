package io.github.xf8b.morefeatures.items.armor.lapis;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.util.handler.TickHandler;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class LapisBoots extends ArmorItem {
    public LapisBoots() {
        super(MoreFeaturesArmorMaterial.LAPIS, EquipmentSlotType.FEET, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if (TickHandler.clientTicksPassed % 2400 == 0) {
            player.giveExperiencePoints(MoreFeaturesConfig.lapisArmorExperienceGiven);
        }
    }
}
