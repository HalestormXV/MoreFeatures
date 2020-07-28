package io.github.xf8b.morefeatures.items.tools;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Lazy;

import java.util.function.Supplier;

public enum MoreFeaturesItemTier implements ToolMaterial {
    CORRUPTED(3, 125, 0.0f, 0, 0, () -> {
        return Ingredient.ofItems(MoreFeaturesRegistries.CORRUPTED_ITEM.get());
    }),
    SAPPHIRE(3, 905, 7.0f, 7, 12, () -> {
        return Ingredient.ofItems(MoreFeaturesRegistries.SAPPHIRE.get());
    });

    private final int harvestLevel;
    private final int maxUses;
    private final float efficiency;
    private final float attackDamage;
    private final int enchantability;
    private final Lazy<Ingredient> repairMaterial;

    MoreFeaturesItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new Lazy<>(repairMaterial);
    }

    @Override
    public int getDurability() {
        return this.maxUses;
    }

    @Override
    public float getMiningSpeed() {
        return this.efficiency;
    }

    @Override
    public float getAttackDamage() {
        return this.attackDamage;
    }

    @Override
    public int getMiningLevel() {
        return this.harvestLevel;
    }

    @Override
    public int getEnchantability() {
        return this.enchantability;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairMaterial.get();
    }

}