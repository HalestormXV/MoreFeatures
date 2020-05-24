package io.github.xf8b.morefeatures.enchantments;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class FireRetardant extends Enchantment {
    public FireRetardant() {
        super(Rarity.RARE, EnchantmentType.ARMOR, new EquipmentSlotType[] {
                EquipmentSlotType.HEAD,
                EquipmentSlotType.CHEST,
                EquipmentSlotType.LEGS,
                EquipmentSlotType.FEET
        });
    }

    @Override
    public int getMinLevel() {
        return 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @SubscribeEvent
    public static void onFireDamage(LivingDamageEvent event) {
        if(event.getSource().isFireDamage()) {
            event.getEntityLiving().addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 0, 0));
        }
    }

    @Override
    protected boolean canApplyTogether(Enchantment ench) {
        return !(ench instanceof ProtectionEnchantment);
    }
}
