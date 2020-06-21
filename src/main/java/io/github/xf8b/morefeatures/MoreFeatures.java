package io.github.xf8b.morefeatures;

import io.github.xf8b.morefeatures.blocks.CornCrop;
import io.github.xf8b.morefeatures.commands.HungerCommand;
import io.github.xf8b.morefeatures.commands.InformationCommand;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.world.gen.MoreFeaturesGeneration;
import net.minecraft.block.Blocks;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.FireBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.world.biome.Biome;
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
    public static MoreFeaturesItemGroup instance = new MoreFeaturesItemGroup();

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
        //Register items to be compostable
        DeferredWorkQueue.runLater(() -> {
            //Leaves
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.LEMON_LEAVES.get().asItem(), 0.3f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.ORANGE_LEAVES.get().asItem(), 0.3f);

            //Saplings
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.LEMON_SAPLING.get().asItem(), 0.3f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.ORANGE_SAPLING.get().asItem(), 0.3f);

            //Seeds
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.CORN_SEEDS.get().asItem(), 0.3f);

            //Foods
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.LEMON.get().asItem(), 0.65f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.ORANGE.get().asItem(), 0.65f);
            ComposterBlock.CHANCES.put(MoreFeaturesRegistries.CORN.get().asItem(), 0.65f);
        });
        //Set flammable blocks to be flammable
        DeferredWorkQueue.runLater(() -> {
            //Planks
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_PLANKS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_PLANKS.get(), 5, 20);

            //Slabs
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_SLAB.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_SLAB.get(), 5, 20);

            //Logs
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_LOG.get(), 5, 5);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_LOG.get(), 5, 5);

            //Leaves
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_LEAVES.get(), 30, 60);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_LEAVES.get(), 30, 60);

            //Fences
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_FENCE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_FENCE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_FENCE_GATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_FENCE_GATE.get(), 5, 20);

            //Stairs
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_STAIRS.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_STAIRS.get(), 5, 20);

            //Buttons
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.OAK_BUTTON, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.SPRUCE_BUTTON, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.BIRCH_BUTTON, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.JUNGLE_BUTTON, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.ACACIA_BUTTON, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.DARK_OAK_BUTTON, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_BUTTON.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_BUTTON.get(), 5, 20);

            //Pressure Plates
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.OAK_PRESSURE_PLATE, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.SPRUCE_PRESSURE_PLATE, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.BIRCH_PRESSURE_PLATE, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.JUNGLE_PRESSURE_PLATE, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.ACACIA_PRESSURE_PLATE, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.DARK_OAK_PRESSURE_PLATE, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE.get(), 5, 20);

            //Doors
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.OAK_DOOR, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.SPRUCE_DOOR, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.BIRCH_DOOR, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.JUNGLE_DOOR, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.ACACIA_DOOR, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.DARK_OAK_DOOR, 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.LEMON_DOOR.get(), 5, 20);
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.ORANGE_DOOR.get(), 5, 20);

            //Beds
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.WHITE_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.ORANGE_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.MAGENTA_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.LIGHT_BLUE_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.YELLOW_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.LIME_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.PINK_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.GRAY_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.LIGHT_GRAY_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.CYAN_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.PURPLE_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.BLUE_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.BROWN_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.GREEN_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.RED_BED, 60, 80);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.BLACK_BED, 60, 80);

            //Crops
            ((FireBlock) Blocks.FIRE).setFireInfo(MoreFeaturesRegistries.CORN_CROP.get(), 40, 60);
            ((FireBlock) Blocks.FIRE).setFireInfo(Blocks.WHEAT, 70, 90);
        });
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
                final Item.Properties properties = new Item.Properties().group(MoreFeatures.instance.itemGroup);
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
