package io.github.xf8b.morefeatures.core;

import io.github.xf8b.morefeatures.blocks.CornCrop;
import io.github.xf8b.morefeatures.commands.HungerCommand;
import io.github.xf8b.morefeatures.commands.InformationCommand;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.world.gen.MoreFeaturesGeneration;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(MoreFeatures.MOD_ID)
public class MoreFeatures {
    public static final String MOD_ID = "morefeatures";
    private static final Logger LOGGER = LogManager.getLogger();
    public static ItemGroup itemGroup = new ItemGroup(MOD_ID) {
        @OnlyIn(Dist.CLIENT)
        @Override
        public ItemStack createIcon() {
            return new ItemStack(MoreFeaturesRegistries.SAPPHIRE.get());
        }
    };

    public MoreFeatures() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        //Register deferred registries
        MoreFeaturesRegistries.ENCHANTMENTS.register(modEventBus);
        MoreFeaturesRegistries.ITEMS.register(modEventBus);
        MoreFeaturesRegistries.BLOCKS.register(modEventBus);
        MoreFeaturesRegistries.EFFECTS.register(modEventBus);
        MoreFeaturesRegistries.BIOMES.register(modEventBus);

        //Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.SERVER, MoreFeaturesConfig.SERVER_SPEC);
    }

    private void setup(final FMLCommonSetupEvent event) {
        //Sets flammability and compostability for MoreFeatures (and some vanilla) items and blocks
        DeferredWorkQueue.runLater(MoreFeaturesSetupFunctions::setupFlammabilityAndCompostability);
        //Generate features in the world
        DeferredWorkQueue.runLater(MoreFeaturesGeneration::generateFeatures);
    }

    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event) {
        //Register commands
        InformationCommand.register(event.getCommandDispatcher());
        HungerCommand.register(event.getCommandDispatcher());
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event) {
            //Automatically registers BlockItems for Blocks
            final IForgeRegistry<Item> registry = event.getRegistry();
            MoreFeaturesRegistries.BLOCKS.getEntries().stream()
                    .filter(block -> !(block.get() instanceof CornCrop))
                    .map(RegistryObject::get).forEach(block -> {
                final Item.Properties properties = new Item.Properties().group(MoreFeatures.itemGroup);
                final BlockItem blockItem = new BlockItem(block, properties);
                blockItem.setRegistryName(block.getRegistryName());
                registry.register(blockItem);
            });
        }

        @SubscribeEvent
        public static void onBiomeRegistry(final RegistryEvent.Register<Biome> event) {
            registerBiomes();
        }

        public static void registerBiomes() {
            registerBiome(MoreFeaturesRegistries.LEMON_TREE_PLAINS.get(), 5, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
            registerBiome(MoreFeaturesRegistries.ORANGE_TREE_PLAINS.get(), 5, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        }

        private static void registerBiome(Biome biome, int weight, BiomeDictionary.Type... types) {
            BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, weight));
            BiomeDictionary.addTypes(biome, types);
            BiomeManager.addSpawnBiome(biome);
        }
    }
}
