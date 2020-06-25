package io.github.xf8b.morefeatures.items.armor.obsidian;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ObsidianHelmet extends ArmorItem {
    public ObsidianHelmet() {
        super(MoreFeaturesArmorMaterial.OBSIDIAN, EquipmentSlotType.HEAD, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.itemGroup)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 20, 3));
        player.addPotionEffect(new EffectInstance(Effects.RESISTANCE, 20, 1));
        player.addPotionEffect(new EffectInstance(Effects.JUMP_BOOST, 20, -6));
    }
}

