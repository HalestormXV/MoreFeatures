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

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CoalBootsItem extends ArmorItem {
    public CoalBootsItem() {
        super(MoreFeaturesArmorMaterial.COAL, EquipmentSlot.FEET, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        DamageSource engulfedInFireWhileWearingCoal = new DamageSource("morefeatures.engulfedInFireWhileWearingCoal").setBypassesArmor();
        if (player.isOnFire() && !player.isCreative()) {
            List<ItemStack> armorWorn = new ArrayList<>();
            armorWorn.add(player.getEquippedStack(EquipmentSlot.HEAD));
            armorWorn.add(player.getEquippedStack(EquipmentSlot.CHEST));
            armorWorn.add(player.getEquippedStack(EquipmentSlot.LEGS));
            armorWorn.add(player.getEquippedStack(EquipmentSlot.FEET));
            player.damage(engulfedInFireWhileWearingCoal, player.getHealth() * 10);
        }
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 4800;
    }
}
