package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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
        return 1;
    }

    public static boolean willActivate = false;

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event) {
        if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET) == ItemStack.EMPTY) {
            return;
        }
        ItemStack itemOnFeet = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET);
        Map<Enchantment, Integer> enchantmentsOnItemOnFeet = EnchantmentHelper.getEnchantments(itemOnFeet);
        Random random = new Random();
        int randomInt = random.nextInt(100);
        if (randomInt <= 100 - MoreFeaturesConfig.savingGraceActivationChance) {
            willActivate = false;
        } else if (randomInt > 100 - MoreFeaturesConfig.savingGraceActivationChance) {
            willActivate = true;
        }
        if (itemOnFeet.getTag() == null) {
            return;
        }
        itemOnFeet.getTag().putBoolean(MoreFeatures.MOD_ID + ":saving_grace_will_activate", willActivate);
        if (enchantmentsOnItemOnFeet.containsKey(MoreFeaturesRegistries.SAVING_GRACE.get()) &&
                itemOnFeet.getTag().getBoolean(MoreFeatures.MOD_ID + ":saving_grace_will_activate")) {
            PlayerEntity playerEntity = (PlayerEntity) event.getEntityLiving();
            playerEntity.setHealth(1.0F);
            playerEntity.clearActivePotions();
            playerEntity.addPotionEffect(new EffectInstance(Effects.REGENERATION, 900, 1));
            playerEntity.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 100, 1));
            event.setCanceled(true);
        }
    }
}
