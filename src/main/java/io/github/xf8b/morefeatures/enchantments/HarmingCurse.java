package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.util.handler.TickHandler;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HarmingCurse extends Enchantment {
    public HarmingCurse() {
        super(Weight.VERY_RARE, EnchantmentTarget.ARMOR, new EquipmentSlot[] {
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

    @Override
    public boolean isTreasure() {
        return true;
    }

    @Override
    public boolean isCursed() {
        return true;
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!event.player.getEntityWorld().isClient) {
                if (event.player.getEquippedStack(EquipmentSlot.HEAD).isEmpty() &&
                        event.player.getEquippedStack(EquipmentSlot.CHEST).isEmpty() &&
                        event.player.getEquippedStack(EquipmentSlot.LEGS).isEmpty() &&
                        event.player.getEquippedStack(EquipmentSlot.FEET).isEmpty()) {
                    return;
                }
                ItemStack itemOnHead = event.player.getEquippedStack(EquipmentSlot.HEAD);
                ItemStack itemOnChest = event.player.getEquippedStack(EquipmentSlot.CHEST);
                ItemStack itemOnLegs = event.player.getEquippedStack(EquipmentSlot.LEGS);
                ItemStack itemOnFeet = event.player.getEquippedStack(EquipmentSlot.FEET);
                Map<Enchantment, Integer> enchantmentsOnItemOnHead = EnchantmentHelper.getEnchantments(itemOnHead);
                Map<Enchantment, Integer> enchantmentsOnItemOnChest = EnchantmentHelper.getEnchantments(itemOnChest);
                Map<Enchantment, Integer> enchantmentsOnItemOnLegs = EnchantmentHelper.getEnchantments(itemOnLegs);
                Map<Enchantment, Integer> enchantmentsOnItemOnFeet = EnchantmentHelper.getEnchantments(itemOnFeet);
                if (enchantmentsOnItemOnHead.containsKey(MoreFeaturesRegistries.HARMING_CURSE.get()) ||
                        enchantmentsOnItemOnChest.containsKey(MoreFeaturesRegistries.HARMING_CURSE.get()) ||
                        enchantmentsOnItemOnLegs.containsKey(MoreFeaturesRegistries.HARMING_CURSE.get()) ||
                        enchantmentsOnItemOnFeet.containsKey(MoreFeaturesRegistries.HARMING_CURSE.get()) &&
                                TickHandler.serverTicksPassed % 20 == 0) {
                    DamageSource killedByArmor = new DamageSource(MoreFeatures.MOD_ID + ".killedByArmor");
                    event.player.damage(killedByArmor, MoreFeaturesConfig.COMMON.harmingCurseDamageGiven.get().floatValue());
                }
            }
        }
    }
}
