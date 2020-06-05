package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SoulHarvester extends Enchantment {
    public SoulHarvester() {
        super(Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[] {
                EquipmentSlotType.MAINHAND,
                EquipmentSlotType.OFFHAND
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
    public static void onDeath(LivingDeathEvent event) {
        if (event.getSource().getTrueSource() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getSource().getTrueSource();
            if (playerEntity.getHeldItem(Hand.MAIN_HAND).isEmpty()) {
                return;
            }
            ItemStack heldItem = playerEntity.getHeldItem(Hand.MAIN_HAND);
            Map<Enchantment, Integer> enchantmentsOnHeldItem = EnchantmentHelper.getEnchantments(heldItem);
            if (heldItem.getTag() == null) {
                return;
            }
            if (enchantmentsOnHeldItem.containsKey(MoreFeaturesRegistries.SOUL_HARVESTER.get())) {
                int newAmountOfSouls = heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") + 1;
                heldItem.getTag().putInt(MoreFeatures.MOD_ID + ":souls", newAmountOfSouls);
                if (heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") <= MoreFeaturesConfig.soulsRequiredForSharpnessLevelUp * 5) {
                    int previousSharpnessLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, heldItem);
                    int newSharpnessLevel;
                    boolean isSoulsHighEnough = false;
                    if (heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") % MoreFeaturesConfig.soulsRequiredForSharpnessLevelUp == 0 &&
                            !(heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") == 0)) {
                        isSoulsHighEnough = true;
                    }
                    if (isSoulsHighEnough) {
                        if (previousSharpnessLevel < heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") / MoreFeaturesConfig.soulsRequiredForSharpnessLevelUp) {
                            enchantmentsOnHeldItem.remove(Enchantments.SHARPNESS);
                            EnchantmentHelper.setEnchantments(enchantmentsOnHeldItem, heldItem);
                            newSharpnessLevel = heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") / MoreFeaturesConfig.soulsRequiredForSharpnessLevelUp;
                            heldItem.addEnchantment(Enchantments.SHARPNESS, newSharpnessLevel);
                        }
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        Map<Enchantment, Integer> enchantmentsOnItem = EnchantmentHelper.getEnchantments(itemStack);
        if (enchantmentsOnItem.containsKey(MoreFeaturesRegistries.SOUL_HARVESTER.get())) {
            List<ITextComponent> tooltip = event.getToolTip();
            tooltip.add(new StringTextComponent("For every " + MoreFeaturesConfig.soulsRequiredForSharpnessLevelUp + " souls, a Sharpness level is added."));
            tooltip.add(new StringTextComponent("The maximum level of Sharpness is 5."));
            tooltip.add(new StringTextComponent("Souls: " + itemStack.getTag().getInt(MoreFeatures.MOD_ID + ":souls")));
        }
    }
}
