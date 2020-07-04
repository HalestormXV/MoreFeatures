package io.github.xf8b.morefeatures.items.tools.corrupted;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.AxeItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CorruptedAxe extends AxeItem {
    public CorruptedAxe() {
        super(MoreFeaturesItemTier.CORRUPTED, 0, 0, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardChecker.isHoldingShift()) {
            tooltip.add(new TranslationTextComponent("tooltip." + MoreFeatures.MOD_ID + ".corrupted_tools.line.one"));
            tooltip.add(new TranslationTextComponent("tooltip." + MoreFeatures.MOD_ID + ".corrupted_tools.line.two"));
            tooltip.add(new TranslationTextComponent("tooltip." + MoreFeatures.MOD_ID + ".corrupted_tools.line.three"));
        } else {
            tooltip.add(new TranslationTextComponent("tooltip." + MoreFeatures.MOD_ID + ".hold_shift"));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlotType.MAINHAND) {
            multimap.put(SharedMonsterAttributes.ATTACK_DAMAGE.getName(), new AttributeModifier(
                    ATTACK_DAMAGE_MODIFIER,
                    "Weapon modifier",
                    getRandomAttackDamage(),
                    AttributeModifier.Operation.byId(0))
            );
            multimap.put(SharedMonsterAttributes.ATTACK_SPEED.getName(), new AttributeModifier(
                    ATTACK_SPEED_MODIFIER,
                    "Weapon modifier",
                    getRandomAttackSpeed(),
                    AttributeModifier.Operation.byId(0))
            );
        }
        return multimap;
    }

    private static int getRandomAttackDamage() {
        return ThreadLocalRandom.current().nextInt(0, MoreFeaturesConfig.COMMON.corruptedToolAttackDamageMax.get() + 1);
    }

    private static float getRandomAttackSpeed() {
        return (float) ThreadLocalRandom.current().nextDouble(0, MoreFeaturesConfig.COMMON.corruptedToolAttackSpeedMax.get() + 1);
    }
}
