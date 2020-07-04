package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.events.SavedEvent;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SavingGrace extends Enchantment {
    public SavingGrace() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR_FEET, new EquipmentSlotType[] {
                EquipmentSlotType.FEET
        });
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty()) {
            return;
        }
        ItemStack itemOnFeet = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET);
        Map<Enchantment, Integer> enchantmentsOnItemOnFeet = EnchantmentHelper.getEnchantments(itemOnFeet);
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (enchantmentsOnItemOnFeet.containsKey(MoreFeaturesRegistries.SAVING_GRACE.get())) {
            if (randomInt > 100 - (MoreFeaturesConfig.COMMON.savingGraceChanceIncrease.get() * enchantmentsOnItemOnFeet.get(MoreFeaturesRegistries.SAVING_GRACE.get()))) {
                int chanceOfBeingSaved = MoreFeaturesConfig.COMMON.savingGraceChanceIncrease.get() * enchantmentsOnItemOnFeet.get(MoreFeaturesRegistries.SAVING_GRACE.get());
                LivingEntity livingEntity = event.getEntityLiving();
                if (!MinecraftForge.EVENT_BUS.post(new SavedEvent(event.getSource(), chanceOfBeingSaved, livingEntity, itemOnFeet))) {
                    livingEntity.setHealth(1.0F);
                    livingEntity.clearActivePotions();
                    livingEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 900, 1));
                    livingEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100, 1));
                    event.setCanceled(true);
                }
            }
        }
    }
}
