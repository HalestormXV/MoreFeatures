package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FireRetardant extends Enchantment {
    public FireRetardant() {
        super(Rarity.RARE, EnchantmentType.ARMOR, new EquipmentSlotType[] {
                EquipmentSlotType.HEAD,
                EquipmentSlotType.CHEST,
                EquipmentSlotType.LEGS,
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

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getSource().isFireDamage()) {
            if (event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD).isEmpty() &&
                    event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST).isEmpty() &&
                    event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS).isEmpty() &&
                    event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET).isEmpty()) {
                return;
            }
            ItemStack itemOnHead = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.HEAD);
            ItemStack itemOnChest = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.CHEST);
            ItemStack itemOnLegs = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.LEGS);
            ItemStack itemOnFeet = event.getEntityLiving().getItemStackFromSlot(EquipmentSlotType.FEET);
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
    protected boolean canApplyTogether(Enchantment enchantment) {
        return !(enchantment instanceof ProtectionEnchantment);
    }
}
