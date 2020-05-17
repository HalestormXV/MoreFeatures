package io.github.xf8b.morefeatures;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.function.Supplier;

public enum MoreFeaturesArmorMaterial implements IArmorMaterial {
    COAL(MoreFeatures.MOD_ID + ":coal", 3, new int[] {1, 1, 2, 1}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, () -> {
        return Ingredient.fromItems(Items.COAL);
    }),
    LAPIS(MoreFeatures.MOD_ID + ":lapis", 20, new int[] {2, 4, 5, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0f, () -> {
        return Ingredient.fromItems(Items.LAPIS_LAZULI);
    }),
    EMERALD(MoreFeatures.MOD_ID + ":emerald", 24, new int[] {3, 5, 6, 3}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0.5f, () -> {
        return Ingredient.fromItems(Items.EMERALD);
    }),
    SAPPHIRE(MoreFeatures.MOD_ID + ":sapphire", 27, new int[] {3, 6, 7, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 1.0f, () -> {
        return Ingredient.fromItems(MoreFeaturesRegistries.SAPPHIRE.get());
    }),
    OBSIDIAN(MoreFeatures.MOD_ID + ":obsidian", 42, new int[] {6, 9, 11, 6}, 7, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 4.0f, () -> {
        return Ingredient.fromItems(Items.OBSIDIAN);
    });

    private static final int[] MAX_DAMAGE_ARRAY = new int[] {13, 15, 16, 11};
    private final String name;
    private final int maxDamageFactor;
    private final int[] damageReductionAmountArray;
    private final int enchantability;
    private final SoundEvent soundEvent;
    private final float toughness;
    private final LazyValue<Ingredient> repairMaterial;

    private MoreFeaturesArmorMaterial(String nameIn, int maxDamageFactorIn, int[] damageReductionAmountIn, int enchantabilityIn, SoundEvent soundEventIn, float toughnessIn, Supplier<Ingredient> repairMaterialIn) {
        this.name = nameIn;
        this.maxDamageFactor = maxDamageFactorIn;
        this.damageReductionAmountArray = damageReductionAmountIn;
        this.enchantability = enchantabilityIn;
        this.soundEvent = soundEventIn;
        this.toughness = toughnessIn;
        this.repairMaterial = new LazyValue<>(repairMaterialIn);
    }

    @Override
    public int getDurability(EquipmentSlotType slotIn) {
        return MAX_DAMAGE_ARRAY[slotIn.getIndex()] * this.maxDamageFactor;
    }

    @Override
    public int getDamageReductionAmount(EquipmentSlotType slotIn) {
        return this.damageReductionAmountArray[slotIn.getIndex()];
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public SoundEvent getSoundEvent() {
        return this.soundEvent;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return this.repairMaterial.getValue();
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }
}