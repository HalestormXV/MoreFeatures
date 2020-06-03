package io.github.xf8b.morefeatures.items.tools.corrupted;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesItemTier;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CorruptedSword extends SwordItem {
    private static int randomAttackDamage = ThreadLocalRandom.current().nextInt(
            0, MoreFeaturesConfig.corruptedToolAttackDamageMax + 1
    );
    private static float randomAttackSpeed = (float) ThreadLocalRandom.current().nextDouble(
            0, MoreFeaturesConfig.corruptedToolAttackSpeedMax + 1
    );

    public CorruptedSword() {
        super(MoreFeaturesItemTier.CORRUPTED, randomAttackDamage, randomAttackSpeed, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardChecker.isHoldingShift()) {
            tooltip.add(new StringTextComponent("This tool has been corrupted."));
            tooltip.add(new StringTextComponent("The attack damage and speed will be random."));
            tooltip.add(new StringTextComponent("Good luck, and pray to the RNG gods."));
        } else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT " + "\u00A77" + "to see info."));
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

    public static int getRandomAttackDamage() {
        return ThreadLocalRandom.current().nextInt(0, MoreFeaturesConfig.corruptedToolAttackDamageMax + 1);
    }

    public static float getRandomAttackSpeed() {
        return (float) ThreadLocalRandom.current().nextDouble(0, MoreFeaturesConfig.corruptedToolAttackSpeedMax + 1);
    }
}
