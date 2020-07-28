package io.github.xf8b.morefeatures.items.armor;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MoreFeaturesArmorMaterial implements ArmorMaterial {
    CORRUPTED(MoreFeatures.MOD_ID + ":corrupted", 10, new int[] {0, 0, 0, 0}, 0, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, () -> {
        return Ingredient.ofItems(MoreFeaturesRegistries.CORRUPTED_ITEM.get());
    }),
    MASK(MoreFeatures.MOD_ID + ":mask", 2, new int[] {1, 1, 2, 1}, 5, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, () -> {
        return Ingredient.ofItems(Items.WHITE_WOOL);
    }),
    COAL(MoreFeatures.MOD_ID + ":coal", 3, new int[] {1, 1, 2, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, () -> {
        return Ingredient.ofItems(Items.COAL);
    }),
    LAPIS(MoreFeatures.MOD_ID + ":lapis", 20, new int[] {2, 4, 5, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, () -> {
        return Ingredient.ofItems(Items.LAPIS_LAZULI);
    }),
    EMERALD(MoreFeatures.MOD_ID + ":emerald", 24, new int[] {3, 5, 6, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.5f, () -> {
        return Ingredient.ofItems(Items.EMERALD);
    }),
    SAPPHIRE(MoreFeatures.MOD_ID + ":sapphire", 27, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0f, () -> {
        return Ingredient.ofItems(MoreFeaturesRegistries.SAPPHIRE.get());
    }),
    OBSIDIAN(MoreFeatures.MOD_ID + ":obsidian", 42, new int[] {6, 9, 11, 6}, 7, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, () -> {
        return Ingredient.ofItems(Items.OBSIDIAN);
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final Lazy<Ingredient> repairMaterial;

    MoreFeaturesArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new Lazy<>(repairMaterialIn);
    }

    @Override
    public int getDurability(EquipmentSlot slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getEntitySlotId()] * this.maxDamageFactor;
    }

    @Override
    public int getProtectionAmount(EquipmentSlot slotIn) {
        return this.damageReductionAmountArray[slotIn.getEntitySlotId()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getEquipSound() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

    @Environment(EnvType.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}