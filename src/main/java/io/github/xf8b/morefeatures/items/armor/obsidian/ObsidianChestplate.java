package io.github.xf8b.morefeatures.items.armor.obsidian;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ObsidianChestplate extends ArmorItem {
    public ObsidianChestplate() {
        super(MoreFeaturesArmorMaterial.OBSIDIAN, EquipmentSlotType.CHEST, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.COMBAT)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 0, 3));
        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 0, 1));
        player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 0, -6));
    }
}
