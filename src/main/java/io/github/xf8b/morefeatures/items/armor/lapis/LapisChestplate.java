package io.github.xf8b.morefeatures.items.armor.lapis;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LapisChestplate extends ArmorItem {
    public LapisChestplate() {
        super(MoreFeaturesArmorMaterial.LAPIS, EquipmentSlotType.CHEST, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player) {
        if(count == 2400) {
            player.giveExperiencePoints(MoreFeaturesConfig.lapisArmorExperienceGiven);
        }
    }

    public static int count = 0;

    @SubscribeEvent
    public static void tickCounter(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            count++;
            if(count > 2400) {
                count = 0;
            }
        }
    }
}
