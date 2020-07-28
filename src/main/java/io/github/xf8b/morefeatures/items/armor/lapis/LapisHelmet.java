package io.github.xf8b.morefeatures.items.armor.lapis;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.util.handler.TickHandler;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LapisHelmet extends ArmorItem {
    public LapisHelmet() {
        super(MoreFeaturesArmorMaterial.LAPIS, EquipmentSlot.HEAD, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!event.player.getEntityWorld().isClient) {
                if (event.player.getEquippedStack(EquipmentSlot.HEAD).isEmpty()) {
                    return;
                }
                ItemStack itemOnHead = event.player.getEquippedStack(EquipmentSlot.HEAD);
                if (itemOnHead.getItem() == MoreFeaturesRegistries.LAPIS_HELMET.get() && TickHandler.serverTicksPassed % 2400 == 0) {
                    event.player.addExperience(MoreFeaturesConfig.COMMON.lapisArmorExperienceGiven.get());
                }
            }
        }
    }
}
