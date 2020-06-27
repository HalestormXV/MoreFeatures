package io.github.xf8b.morefeatures.items.armor.lapis;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.util.handler.TickHandler;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class LapisBoots extends ArmorItem {
    public LapisBoots() {
        super(MoreFeaturesArmorMaterial.LAPIS, EquipmentSlotType.FEET, new Properties()
                .maxStackSize(1)
                .group(MoreFeatures.itemGroup)
        );
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!event.player.getEntityWorld().isRemote) {
                if (event.player.getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty()) {
                    return;
                }
                ItemStack itemOnFeet = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
                if (itemOnFeet.getItem() == MoreFeaturesRegistries.LAPIS_BOOTS.get() && TickHandler.serverTicksPassed % 2400 == 0) {
                    event.player.giveExperiencePoints(MoreFeaturesConfig.lapisArmorExperienceGiven);
                }
            }
        }
    }
}
