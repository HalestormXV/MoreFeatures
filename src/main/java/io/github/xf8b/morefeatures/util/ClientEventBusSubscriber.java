package io.github.xf8b.morefeatures.util;

import io.github.xf8b.morefeatures.MoreFeatures;
import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.LEMON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.ORANGE_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get(), RenderType.getCutout());
    }
}
