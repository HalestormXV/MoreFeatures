package io.github.xf8b.morefeatures.items.armor.obsidian;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ObsidianLeggings extends ArmorItem {
    public ObsidianLeggings() {
        super(MoreFeaturesArmorMaterial.OBSIDIAN, EquipmentSlot.LEGS, new Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 20, 3));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 20, 1));
        player.addStatusEffect(new StatusEffectInstance(StatusEffects.JUMP_BOOST, 20, -6));
    }
}
