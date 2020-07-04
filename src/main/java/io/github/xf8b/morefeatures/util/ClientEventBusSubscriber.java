package io.github.xf8b.morefeatures.util;

import io.github.xf8b.morefeatures.client.gui.DisplayCaseScreen;
import io.github.xf8b.morefeatures.client.tileentity.renderer.DisplayCaseRenderer;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.client.gui.ScreenManager;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
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
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.DISPLAY_CASE.get(), RenderType.getCutout());

        //Saplings
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.LEMON_SAPLING.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.ORANGE_SAPLING.get(), RenderType.getCutout());

        //Crops
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.CORN_CROP.get(), RenderType.getCutout());

        //Doors
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.LEMON_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(MoreFeaturesRegistries.ORANGE_DOOR.get(), RenderType.getCutout());

        //Bind tile entity renderers
        ClientRegistry.bindTileEntityRenderer(MoreFeaturesRegistries.DISPLAY_CASE_TILE_ENTITY.get(), DisplayCaseRenderer::new);

        DeferredWorkQueue.runLater(() -> {
            //Register screen factories
            ScreenManager.registerFactory(MoreFeaturesRegistries.DISPLAY_CASE_CONTAINER.get(), DisplayCaseScreen::new);
        });
    }
}
