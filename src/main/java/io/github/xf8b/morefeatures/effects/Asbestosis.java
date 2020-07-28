package io.github.xf8b.morefeatures.effects;

import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.util.handler.TickHandler;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffectType;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Asbestosis extends StatusEffect {
    public Asbestosis() {
        super(StatusEffectType.HARMFUL, 16056319);
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return TickHandler.serverTicksPassed % 30 == 0;
    }

    @Override
    public void applyUpdateEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        DamageSource asbestosDisease = new DamageSource("morefeatures.asbestosis");
        entityLivingBaseIn.damage(asbestosDisease, MoreFeaturesConfig.COMMON.asbestosisDamageGiven.get().floatValue());
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            if (!event.player.getEntityWorld().isClient) {
                Map<StatusEffect, StatusEffectInstance> effects = event.player.getActiveStatusEffects();
                if (effects.containsKey(MoreFeaturesRegistries.ASBESTOSIS.get()) && TickHandler.serverTicksPassed % 30 == 0) {
                    DamageSource asbestosDisease = new DamageSource("morefeatures.asbestosis");
                    event.player.damage(asbestosDisease, MoreFeaturesConfig.COMMON.asbestosisDamageGiven.get().floatValue());
                }
            }
        }
    }
}
