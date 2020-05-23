package io.github.xf8b.morefeatures.items.armor.emerald;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class EmeraldHelmet extends ArmorItem {
    public EmeraldHelmet() {
        super(MoreFeaturesArmorMaterial.EMERALD, EquipmentSlotType.HEAD, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
                .group(ItemGroup.COMBAT)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        player.addPotionEffect(new EffectInstance(Effects.LUCK, 0, 0));
        player.addPotionEffect(new EffectInstance(Effects.HERO_OF_THE_VILLAGE, 0, 0));
    }
}
