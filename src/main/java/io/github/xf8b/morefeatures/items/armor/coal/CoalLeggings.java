package io.github.xf8b.morefeatures.items.armor.coal;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class CoalLeggings extends ArmorItem {
    public CoalLeggings() {
        super(MoreFeaturesArmorMaterial.COAL, EquipmentSlotType.LEGS, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        DamageSource engulfedInFireWhileWearingCoal = new DamageSource("morefeatures.engulfedInFireWhileWearingCoal").setDamageBypassesArmor();
        if (player.isBurning() && !player.isCreative()) {
            player.attackEntityFrom(engulfedInFireWhileWearingCoal, 20f);
        }
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 6400;
    }
}
