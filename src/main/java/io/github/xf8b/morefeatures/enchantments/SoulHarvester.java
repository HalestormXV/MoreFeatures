package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
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
        super(Rarity.VERY_RARE, EnchantmentType.WEAPON, new EquipmentSlotType[] {EquipmentSlotType.MAINHAND, EquipmentSlotType.OFFHAND});
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    public static int souls = 0;

    @SubscribeEvent
    public static void onDeath(LivingDeathEvent event) {
        if(event.getSource().getTrueSource() instanceof PlayerEntity) {
            souls++;
            PlayerEntity playerEntity = (PlayerEntity) event.getSource().getTrueSource();
            ItemStack heldItem = playerEntity.getHeldItem(Hand.MAIN_HAND);
            Map<Enchantment, Integer> enchantmentsOnHeldItem = EnchantmentHelper.getEnchantments(heldItem);
            heldItem.getTag().putInt(MoreFeatures.MOD_ID + ":souls", souls);
            if(enchantmentsOnHeldItem.containsKey(MoreFeaturesRegistries.SOUL_HARVESTER.get())) {
                if(heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") <= 250) {
                    int previousSharpnessLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.SHARPNESS, heldItem);
                    int newSharpnessLevel = 0;
                    boolean isSoulsHighEnough = false;
                    if(heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") % 50 == 0 && !(heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") == 0)) {
                        isSoulsHighEnough = true;
                    }
                    if(isSoulsHighEnough) {
                        if(previousSharpnessLevel < heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") / 50) {
                            enchantmentsOnHeldItem.remove(Enchantments.SHARPNESS);
                            EnchantmentHelper.setEnchantments(enchantmentsOnHeldItem, heldItem);
                            newSharpnessLevel = heldItem.getTag().getInt(MoreFeatures.MOD_ID + ":souls") / 50;
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
        if(enchantmentsOnItem.containsKey(MoreFeaturesRegistries.SOUL_HARVESTER.get())) {
            List<ITextComponent> tooltip = event.getToolTip();
            tooltip.add(new StringTextComponent("For every 50 souls, a Sharpness level is added."));
            tooltip.add(new StringTextComponent("The maximum level of Sharpness is 5."));
            tooltip.add(new StringTextComponent("Souls: " + itemStack.getTag().getInt(MoreFeatures.MOD_ID + ":souls")));
        }
    }
}
