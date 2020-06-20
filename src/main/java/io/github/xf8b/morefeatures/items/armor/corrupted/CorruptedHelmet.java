package io.github.xf8b.morefeatures.items.armor.corrupted;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Multimap;
import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesArmorMaterial;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.util.helpers.KeyboardChecker;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class CorruptedHelmet extends ArmorItem {
    private static final UUID[] ARMOR_MODIFIERS = new UUID[] {
            UUID.fromString("845DB27C-C624-495F-8C9F-6020A9A58B6B"),
            UUID.fromString("D8499B04-0E66-4726-AB29-64469D734E0D"),
            UUID.fromString("9F3D476D-C118-4544-8365-64846904B48E"),
            UUID.fromString("2AD3F246-FEE1-4E67-B886-69FD380BB150")
    };
    public CorruptedHelmet() {
        super(MoreFeaturesArmorMaterial.CORRUPTED, EquipmentSlotType.HEAD, new Item.Properties()
                .maxStackSize(1)
                .group(MoreFeatures.instance.itemGroup)
        );
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void addInformation(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        if (KeyboardChecker.isHoldingShift()) {
            tooltip.add(new StringTextComponent("This armor has been corrupted."));
            tooltip.add(new StringTextComponent("The protection and toughness will be random."));
            tooltip.add(new StringTextComponent("Good luck, and pray to the RNG gods."));
        } else {
            tooltip.add(new StringTextComponent("Hold " + "\u00A7e" + "SHIFT " + "\u00A7r" + "to see info."));
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot, ItemStack stack) {
        Multimap<String, AttributeModifier> multimap = HashMultimap.create();
        if (equipmentSlot == EquipmentSlotType.HEAD) {
            multimap.put(SharedMonsterAttributes.ARMOR.getName(), new AttributeModifier(
                    ARMOR_MODIFIERS[equipmentSlot.getIndex()],
                    "Armor modifier",
                    getRandomArmorProtection(),
                    AttributeModifier.Operation.byId(0))
            );
            multimap.put(SharedMonsterAttributes.ARMOR_TOUGHNESS.getName(), new AttributeModifier(
                    ARMOR_MODIFIERS[equipmentSlot.getIndex()],
                    "Armor toughness",
                    getRandomArmorToughness(),
                    AttributeModifier.Operation.byId(0))
            );
        }
        return multimap;
    }

    private static int getRandomArmorProtection() {
        return ThreadLocalRandom.current().nextInt(0, MoreFeaturesConfig.corruptedArmorProtectionMax + 1);
    }

    private static float getRandomArmorToughness() {
        return (float) ThreadLocalRandom.current().nextDouble(0, MoreFeaturesConfig.corruptedArmorToughnessMax + 1);
    }
}
