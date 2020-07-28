package io.github.xf8b.morefeatures.items.tools.corrupted;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.tools.MoreFeaturesItemTier;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CorruptedPickaxe extends PickaxeItem {
    public CorruptedPickaxe() {
        super(MoreFeaturesItemTier.CORRUPTED, 0, 0, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        if (KeyboardChecker.isHoldingShift()) {
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".corrupted_tools.line.one"));
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".corrupted_tools.line.two"));
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".corrupted_tools.line.three"));
        } else {
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".hold_shift"));
        }
        super.appendTooltip(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public Multimap<EntityAttribute, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot slot) {
        Multimap<EntityAttribute, EntityAttributeModifier> multimap = HashMultimap.create();
        if (slot == EquipmentSlot.MAINHAND) {
            multimap.put(EntityAttributes.GENERIC_ATTACK_DAMAGE, new EntityAttributeModifier(
                    ATTACK_DAMAGE_MODIFIER_ID,
                    "Weapon modifier",
                    getRandomAttackDamage(),
                    EntityAttributeModifier.Operation.fromId(0))
            );
            multimap.put(EntityAttributes.GENERIC_ATTACK_SPEED, new EntityAttributeModifier(
                    ATTACK_SPEED_MODIFIER_ID,
                    "Weapon modifier",
                    getRandomAttackSpeed(),
                    EntityAttributeModifier.Operation.fromId(0))
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
