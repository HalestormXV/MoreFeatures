package io.github.xf8b.morefeatures.util;

import io.github.xf8b.morefeatures.client.blockentity.renderer.DisplayCaseBlockEntityRenderer;
import io.github.xf8b.morefeatures.client.gui.DisplayCaseScreen;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.client.gui.screen.Screens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.RenderLayers;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEventBusSubscriber {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        //Set render types for blocks
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.DISPLAY_CASE.get(), RenderLayer.getCutout());

        //Saplings
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.LEMON_SAPLING.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.ORANGE_SAPLING.get(), RenderLayer.getCutout());

        //Crops
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.CORN_CROP.get(), RenderLayer.getCutout());

        //Doors
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.LEMON_DOOR.get(), RenderLayer.getCutout());
        RenderLayers.setRenderLayer(MoreFeaturesRegistries.ORANGE_DOOR.get(), RenderLayer.getCutout());

        //Bind tile entity renderers
        ClientRegistry.bindTileEntityRenderer(MoreFeaturesRegistries.DISPLAY_CASE_TILE_ENTITY.get(), DisplayCaseBlockEntityRenderer::new);

        DeferredWorkQueue.runLater(() -> {
            //Register screen factories
            Screens.register(MoreFeaturesRegistries.DISPLAY_CASE_CONTAINER.get(), DisplayCaseScreen::new);
        });
    }
}
