package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FireRetardant extends Enchantment {
    public FireRetardant() {
        super(Weight.RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {
                EquipmentSlot.HEAD,
                EquipmentSlot.CHEST,
                EquipmentSlot.LEGS,
                EquipmentSlot.FEET
        });
    }

    @Override
    public int getMinimumLevel() {
        return 1;
    }

    @Override
    public int getMaximumLevel() {
        return 1;
    }

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().isFire()) {
            if (event.getEntityLiving().getEquippedStack(EquipmentSlot.HEAD).isEmpty() &&
                    event.getEntityLiving().getEquippedStack(EquipmentSlot.CHEST).isEmpty() &&
                    event.getEntityLiving().getEquippedStack(EquipmentSlot.LEGS).isEmpty() &&
                    event.getEntityLiving().getEquippedStack(EquipmentSlot.FEET).isEmpty()) {
                return;
            }
            ItemStack itemOnHead = event.getEntityLiving().getEquippedStack(EquipmentSlot.HEAD);
            ItemStack itemOnChest = event.getEntityLiving().getEquippedStack(EquipmentSlot.CHEST);
            ItemStack itemOnLegs = event.getEntityLiving().getEquippedStack(EquipmentSlot.LEGS);
            ItemStack itemOnFeet = event.getEntityLiving().getEquippedStack(EquipmentSlot.FEET);
            Map<Enchantment, Integer> enchantmentsOnItemOnHead = EnchantmentHelper.getEnchantments(itemOnHead);
            Map<Enchantment, Integer> enchantmentsOnItemOnChest = EnchantmentHelper.getEnchantments(itemOnChest);
            Map<Enchantment, Integer> enchantmentsOnItemOnLegs = EnchantmentHelper.getEnchantments(itemOnLegs);
            Map<Enchantment, Integer> enchantmentsOnItemOnFeet = EnchantmentHelper.getEnchantments(itemOnFeet);
            if (enchantmentsOnItemOnHead.containsKey(MoreFeaturesRegistries.FIRE_RETARDANT.get()) ||
                    enchantmentsOnItemOnChest.containsKey(MoreFeaturesRegistries.FIRE_RETARDANT.get()) ||
                    enchantmentsOnItemOnLegs.containsKey(MoreFeaturesRegistries.FIRE_RETARDANT.get()) ||
                    enchantmentsOnItemOnFeet.containsKey(MoreFeaturesRegistries.FIRE_RETARDANT.get())) {
                event.setCanceled(true);
            }
        }
    }

    @Override
    protected boolean differs(Enchantment enchantment) {
        return !(enchantment instanceof ProtectionEnchantment);
    }
}
