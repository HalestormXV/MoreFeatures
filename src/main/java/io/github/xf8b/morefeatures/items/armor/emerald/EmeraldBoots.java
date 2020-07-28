package io.github.xf8b.morefeatures.items.armor.emerald;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmeraldBoots extends ArmorItem {
    public EmeraldBoots() {
        super(MoreFeaturesArmorMaterial.EMERALD, EquipmentSlot.FEET, new Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.LUCK, 20, 0));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.HERO_OF_THE_VILLAGE, 20, 0));
    }
}
