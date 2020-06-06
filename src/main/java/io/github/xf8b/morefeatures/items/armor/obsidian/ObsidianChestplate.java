package io.github.xf8b.morefeatures.items.armor.obsidian;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ObsidianChestplate extends ArmorItem {
    public ObsidianChestplate() {
        super(MoreFeaturesArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 3));
        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 1));
        player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, -6));
    }
}
