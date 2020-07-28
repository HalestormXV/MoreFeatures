package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentTarget;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.text.LiteralText;
import net.minecraft.text.Text;
import net.minecraft.util.Hand;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SoulHarvester extends Enchantment {
    public SoulHarvester() {
        super(Weight.VERY_RARE, EnchantmentTarget.WEAPON, new EquipmentSlot[] {
                EquipmentSlot.MAINHAND
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
    public static void onDeath(LivingDeathEvent event) {
        if (event.getSource().getAttacker() instanceof PlayerEntity) {
            PlayerEntity playerEntity = (PlayerEntity) event.getSource().getAttacker();
            if (playerEntity.getStackInHand(Hand.MAIN_HAND).isEmpty()) {
                return;
            }
            ItemStack heldItem = playerEntity.getStackInHand(Hand.MAIN_HAND);
            Map<Enchantment, Integer> enchantmentsOnHeldItem = EnchantmentHelper.getEnchantments(heldItem);
            if (heldItem.getTag() == null) {
                return;
            }
            if (enchantmentsOnHeldItem.containsKey(MoreFeaturesRegistries.SOUL_HARVESTER.get())) {
                int newAmountOfSouls = heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") + 1;
                heldItem.getTag().putInt(MoreFeatures.MOD_ID + ":souls", newAmountOfSouls);
                if (heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") <= MoreFeaturesConfig.COMMON.soulsRequiredForSharpnessLevelUp.get() * 5) {
                    int previousSharpnessLevel = EnchantmentHelper.getLevel(Enchantments.SHARPNESS, heldItem);
                    int newSharpnessLevel;
                    if (heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") % MoreFeaturesConfig.COMMON.soulsRequiredForSharpnessLevelUp.get() == 0 &&
                            !(heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") == 0)) {
                        if (previousSharpnessLevel < heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") / MoreFeaturesConfig.COMMON.soulsRequiredForSharpnessLevelUp.get()) {
                            enchantmentsOnHeldItem.remove(Enchantments.SHARPNESS);
                            EnchantmentHelper.set(enchantmentsOnHeldItem, heldItem);
                            newSharpnessLevel = heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") / MoreFeaturesConfig.COMMON.soulsRequiredForSharpnessLevelUp.get();
                            heldItem.addEnchantment(Enchantments.SHARPNESS, newSharpnessLevel);
                        }
                    }
                }
            }
        }
    }

    @Environment(EnvType.CLIENT)
    @SubscribeEvent
    public static void onItemTooltip(ItemTooltipEvent event) {
        ItemStack itemStack = event.getItemStack();
        Map<Enchantment, Integer> enchantmentsOnItem = EnchantmentHelper.getEnchantments(itemStack);
        if (enchantmentsOnItem.containsKey(MoreFeaturesRegistries.SOUL_HARVESTER.get())
                && !(itemStack.getItem() instanceof EnchantedBookItem)) {
            List<Text> tooltip = event.getToolTip();
            tooltip.add(new LiteralText("For every " + MoreFeaturesConfig.COMMON.soulsRequiredForSharpnessLevelUp.get() + " souls, a Sharpness level is added."));
            tooltip.add(new LiteralText("The maximum level of Sharpness is 5."));
            tooltip.add(new LiteralText("Souls: " + itemStack.getTag().getInt(MoreFeatures.MOD_ID + ":souls")));
        }
    }
}
