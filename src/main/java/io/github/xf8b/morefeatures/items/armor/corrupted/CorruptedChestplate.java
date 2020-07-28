package io.github.xf8b.morefeatures.items.armor.corrupted;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.items.armor.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CorruptedChestplate extends ArmorItem {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {
            UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
            UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
            UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
            UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")
    };

    public CorruptedChestplate() {
        super(MoreFeaturesArmorMaterial.CORRUPTED, EquipmentSlot.CHEST, new Item.Settings()
                .maxCount(1)
                .group(MoreFeatures.ITEM_GROUP)
        );
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, World worldIn, List<Text> tooltip, TooltipContext flagIn) {
        if (KeyboardChecker.isHoldingShift()) {
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".corrupted_armor.line.one"));
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".corrupted_armor.line.two"));
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".corrupted_armor.line.three"));
        } else {
            tooltip.add(new TranslatableText("tooltip." + MoreFeatures.MOD_ID + ".hold_shift"));
        }
        super.appendTooltip(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public Multimap<String, EntityAttributeModifier> getAttributeModifiers(EquipmentSlot equipmentSlot, ItemStack stack) {
        Multimap<String, EntityAttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlot.HEAD) {
            multimap.put(EntityAttributes.ARMOR.getId(), new EntityAttributeModifier(
                    ARMOR_MODIFIERS[equipmentSlot.getEntitySlotId()],
                    "Armor modifier",
                    getRandomArmorProtection(),
                    EntityAttributeModifier.Operation.fromId(0))
            );
            multimap.put(EntityAttributes.ARMOR_TOUGHNESS.getId(), new EntityAttributeModifier(
                    ARMOR_MODIFIERS[equipmentSlot.getEntitySlotId()],
                    "Armor toughness",
                    getRandomArmorToughness(),
                    EntityAttributeModifier.Operation.fromId(0))
            );
        }
        return multimap;
    }

    private static int getRandomArmorProtection() {
        return ThreadLocalRandom.current().nextInt(0, MoreFeaturesConfig.COMMON.corruptedArmorProtectionMax.get() + 1);
    }

    private static float getRandomArmorToughness() {
        return (float) ThreadLocalRandom.current().nextDouble(0, MoreFeaturesConfig.COMMON.corruptedArmorToughnessMax.get() + 1);
    }
}
