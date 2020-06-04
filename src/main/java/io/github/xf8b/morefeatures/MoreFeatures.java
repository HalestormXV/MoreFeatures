package io.github.xf8b.morefeatures;

import io.github.xf8b.morefeatures.blocks.CornCrop;
import io.github.xf8b.morefeatures.commands.HungerCommand;
import io.github.xf8b.morefeatures.commands.InformationCommand;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.world.gen.MoreFeaturesOreGeneration;
import net.minecraft.block.ComposterBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod("morefeatures")
public class MoreFeatures {
    public static final String MOD_ID = "morefeatures";
    private static final Logger LOGGER = LogManager.getLogger();
    public static MoreFeaturesItemGroup instance = new MoreFeaturesItemGroup();

    public MoreFeatures() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);
        MinecraftForge.EVENT_BUS.register(this);

        //Register deferred registries
        MoreFeaturesRegistries.ENCHANTMENTS.register(modEventBus);
        MoreFeaturesRegistries.ITEMS.register(modEventBus);
        MoreFeaturesRegistries.BLOCKS.register(modEventBus);
        MoreFeaturesRegistries.EFFECTS.register(modEventBus);

        //Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, MoreFeaturesConfig.CLIENT_SPEC);
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.LEMON_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.ORANGE_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.CORN_SEEDS.get().asItem(), 0.3f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.LEMON.get().asItem(), 0.65f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.ORANGE.get().asItem(), 0.65f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.CORN.get().asItem(), 0.65f);
        });
        DeferredWorkQueue.runLater(MoreFeaturesOreGeneration::generateOre);
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
    }

    private void enqueueIMC(final InterModEnqueueEvent event) {
    }

    private void processIMC(final InterModProcessEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        InformationCommand.register(event.getCommandDispatcher());
        HungerCommand.register(event.getCommandDispatcher());
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            final IForgeRegistry<Item> registry = event.getRegistry();
            MoreFeaturesRegistries.BLOCKS.getEntries()
                    .stream()
                    .filter(block -> !(block.get() instanceof CornCrop))
                    .map(RegistryObject::get).forEach(block -> {
                final Item.Properties properties = new Item.Properties().group(MoreFeatures.instance.itemGroup);
                final BlockItem blockItem = new BlockItem(block, properties);
                blockItem.setRegistryName(block.getRegistryName());
                registry.register(blockItem);
            });
        }
    }
}
