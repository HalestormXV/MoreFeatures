package io.github.xf8b.morefeatures.items.armor.emerald;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class EmeraldLeggings extends ArmorItem {
    public EmeraldLeggings() {
        super(MoreFeaturesArmorMaterial.EMERALD, EquipmentSlotType.LEGS, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.LUCK, 20, 0));
        player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 20, 0));
    }
}
