package io.github.xf8b.morefeatures.items.armor.emerald;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class EmeraldChestplate extends ArmorItem {
    public EmeraldChestplate() {
        super(MoreFeaturesArmorMaterial.EMERALD, EquipmentSlotType.CHEST, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.LUCK, 20, 0));
        player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 20, 0));
    }
}
