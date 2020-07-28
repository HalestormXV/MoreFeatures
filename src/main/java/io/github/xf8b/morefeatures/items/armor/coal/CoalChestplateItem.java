package io.github.xf8b.morefeatures.items.armor.coal;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CoalChestplateItem extends ArmorItem {
    public CoalChestplateItem() {
        super(MoreFeaturesArmorMaterial.COAL, EquipmentSlot.CHEST, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        DamageSource engulfedInFireWhileWearingCoal = new DamageSource("morefeatures.engulfedInFireWhileWearingCoal").setBypassesArmor();
        if (player.isOnFire() && !player.isCreative()) {
            player.damage(engulfedInFireWhileWearingCoal, player.getHealth() * 10);
        }
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 8000;
    }
}
