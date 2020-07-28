package io.github.xf8b.morefeatures.items.armor.lapis;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.util.handler.TickHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LapisLeggings extends ArmorItem {
    public LapisLeggings() {
        super(MoreFeaturesArmorMaterial.LAPIS, EquipmentSlot.LEGS, new Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!event.player.getEntityWorld().isClient) {
                if (event.player.getEquippedStack(EquipmentSlot.LEGS).isEmpty()) {
                    return;
                }
                ItemStack itemOnLegs = event.player.getEquippedStack(EquipmentSlot.LEGS);
                if (itemOnLegs.getItem() == MoreFeaturesRegistries.LAPIS_LEGGINGS.get() && TickHandler.serverTicksPassed % 2400 == 0) {
                    event.player.addExperience(MoreFeaturesConfig.COMMON.lapisArmorExperienceGiven.get());
                }
            }
        }
    }
}
