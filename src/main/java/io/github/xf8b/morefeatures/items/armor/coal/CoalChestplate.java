package io.github.xf8b.morefeatures.items.armor.coal;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.events.EngulfedInFireWhileInCoalArmorEvent;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class CoalChestplate extends ArmorItem {
    public CoalChestplate() {
        super(MoreFeaturesArmorMaterial.COAL, EquipmentSlotType.CHEST, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        DamageSource engulfedInFireWhileWearingCoal = new DamageSource("morefeatures.engulfedInFireWhileWearingCoal").setDamageBypassesArmor();
        if (player.isBurning() && !player.isCreative()) {
            List<ItemStack> armorWorn = new ArrayList<>();
            armorWorn.add(player.getItemStackFromSlot(EquipmentSlotType.HEAD));
            armorWorn.add(player.getItemStackFromSlot(EquipmentSlotType.CHEST));
            armorWorn.add(player.getItemStackFromSlot(EquipmentSlotType.LEGS));
            armorWorn.add(player.getItemStackFromSlot(EquipmentSlotType.FEET));
            if (!MinecraftForge.EVENT_BUS.post(new EngulfedInFireWhileInCoalArmorEvent(player, armorWorn, player.getPosition()))) {
                player.attackEntityFrom(engulfedInFireWhileWearingCoal, player.getHealth() * 10);
            }
        }
    }

    @Override
    public int getBurnTime(ItemStack itemStack) {
        return 8000;
    }
}
