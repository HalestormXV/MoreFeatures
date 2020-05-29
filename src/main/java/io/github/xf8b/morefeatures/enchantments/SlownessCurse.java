package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SlownessCurse extends Enchantment {
    public SlownessCurse() {
        super(Rarity.VERY_RARE, EnchantmentType.ARMOR, new EquipmentSlotType[] {
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

    @Override
    public boolean isTreasureEnchantment() {
        return true;
    }

    @Override
    public boolean isCurse() {
        return true;
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            if(event.player.getItemStackFromSlot(EquipmentSlotType.HEAD) == ItemStack.EMPTY &&
                    event.player.getItemStackFromSlot(EquipmentSlotType.CHEST) == ItemStack.EMPTY &&
                    event.player.getItemStackFromSlot(EquipmentSlotType.LEGS) == ItemStack.EMPTY &&
                    event.player.getItemStackFromSlot(EquipmentSlotType.FEET) == ItemStack.EMPTY) {
                return;
            }
            ItemStack itemOnHead = event.player.getItemStackFromSlot(EquipmentSlotType.HEAD);
            ItemStack itemOnChest = event.player.getItemStackFromSlot(EquipmentSlotType.CHEST);
            ItemStack itemOnLegs = event.player.getItemStackFromSlot(EquipmentSlotType.LEGS);
            ItemStack itemOnFeet = event.player.getItemStackFromSlot(EquipmentSlotType.FEET);
            Map<Enchantment, Integer> enchantmentsOnItemOnHead = EnchantmentHelper.getEnchantments(itemOnHead);
            Map<Enchantment, Integer> enchantmentsOnItemOnChest = EnchantmentHelper.getEnchantments(itemOnChest);
            Map<Enchantment, Integer> enchantmentsOnItemOnLegs = EnchantmentHelper.getEnchantments(itemOnLegs);
            Map<Enchantment, Integer> enchantmentsOnItemOnFeet = EnchantmentHelper.getEnchantments(itemOnFeet);
            if(enchantmentsOnItemOnHead.containsKey(MoreFeaturesRegistries.SLOWNESS_CURSE.get()) ||
                    enchantmentsOnItemOnChest.containsKey(MoreFeaturesRegistries.SLOWNESS_CURSE.get()) ||
                    enchantmentsOnItemOnLegs.containsKey(MoreFeaturesRegistries.SLOWNESS_CURSE.get()) ||
                    enchantmentsOnItemOnFeet.containsKey(MoreFeaturesRegistries.SLOWNESS_CURSE.get())) {
                event.player.addPotionEffect(new EffectInstance(Effects.SLOWNESS, 0, MoreFeaturesConfig.slownessCurseSlownessLevel));
            }
        }
    }
}