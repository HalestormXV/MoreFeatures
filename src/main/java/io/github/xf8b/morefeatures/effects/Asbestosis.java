package io.github.xf8b.morefeatures.effects;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class Asbestosis extends Effect {
    public Asbestosis() {
        super(EffectType.HARMFUL, 16056319);
    }

    @Override
    public boolean isReady(int duration, int amplifier) {
        return count == 20;
    }

    @Override
    public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
        if(count > 30) {
            count = 0;
            DamageSource asbestosDisease = new DamageSource("morefeatures.asbestosis");
            entityLivingBaseIn.attackEntityFrom(asbestosDisease, (float) MoreFeaturesConfig.asbestosisDamageGiven);
        }
    }

    public static int count = 0;

    @SubscribeEvent
    public static void tickCounter(TickEvent.ClientTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
            count++;
        }
    }

    @SubscribeEvent
    public static void onTick(TickEvent.PlayerTickEvent event) {
        if(event.phase == TickEvent.Phase.END) {
           Map<Effect, EffectInstance> effects = event.player.getActivePotionMap();
           if(effects.containsKey(MoreFeaturesRegistries.ASBESTOSIS.get()) && count > 30) {
               count = 0;
               DamageSource asbestosDisease = new DamageSource("morefeatures.asbestosis");
               event.player.attackEntityFrom(asbestosDisease, (float) MoreFeaturesConfig.asbestosisDamageGiven);
           }
        }
    }
}
