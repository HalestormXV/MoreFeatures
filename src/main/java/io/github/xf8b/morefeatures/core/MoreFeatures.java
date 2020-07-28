package io.github.xf8b.morefeatures.core;

import io.github.xf8b.morefeatures.blocks.CornCrop;
import io.github.xf8b.morefeatures.commands.HungerCommand;
import io.github.xf8b.morefeatures.commands.InformationCommand;
import io.github.xf8b.morefeatures.config.MoreFeaturesConfig;
import io.github.xf8b.morefeatures.core.registries.ItemRegistries;
import io.github.xf8b.morefeatures.world.gen.MoreFeaturesGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class MoreFeatures implements ModInitializer {
    //TODO: fix the config
    //TODO: fix the effects
    public static final String MOD_ID = "morefeatures";
    public static final ItemGroup ITEM_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MoreFeatures.MOD_ID, "all"),
            () -> new ItemStack(MoreFeaturesRegistries.SAPPHIRE)
    );

    public MoreFeatures() {
        final IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        MinecraftForge.EVENT_BUS.register(this);

        //Register deferred registries
        MoreFeaturesRegistries.ENCHANTMENTS.register(modEventBus);
        MoreFeaturesRegistries.ITEMS.register(modEventBus);
        MoreFeaturesRegistries.BLOCKS.register(modEventBus);
        MoreFeaturesRegistries.TILE_ENTITY_TYPES.register(modEventBus);
        MoreFeaturesRegistries.CONTAINER_TYPES.register(modEventBus);
        MoreFeaturesRegistries.EFFECTS.register(modEventBus);
        MoreFeaturesRegistries.BIOMES.register(modEventBus);

        //Register config
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, MoreFeaturesConfig.COMMON_SPEC);
    }

    @Override
    public void onInitialize() {
        CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
            HungerCommand.register(dispatcher);
            InformationCommand.register(dispatcher);
        });
        BlockRegistries.BLOCKS.registerAll();
        ItemRegistries.ITEMS.registerAll();
        registerBlocksAutomatically();
        addBiomes();
        MoreFeaturesSetupFunctions.setupFlammabilityAndCompostability();
        MoreFeaturesGeneration.generateFeatures();
    }

    private static void registerBlocksAutomatically() {
        Registry<Block> registry = Registry.BLOCK;
        MoreFeaturesRegistries.BLOCKS.getEntries().stream().filter(block -> !(block instanceof CornCrop)).forEach(block -> {
            final Item.Settings properties = new Item.Settings().group(MoreFeatures.ITEM_GROUP);
            final BlockItem blockItem = new BlockItem(block, properties);
            Registry.register(Registry.ITEM, new Identifier(MOD_ID, registry.getId(block).getPath()), blockItem);
        });
    }

    private static void addBiomes() {
    }

    //todo: make these generate
    @SubscribeEvent
    public static void onBiomeRegistry(final RegistryEvent.Register<Biome> event) {
        registerBiome(MoreFeaturesRegistries.LEMON_TREE_PLAINS.get(), 5, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
        registerBiome(MoreFeaturesRegistries.ORANGE_TREE_PLAINS.get(), 5, BiomeDictionary.Type.PLAINS, BiomeDictionary.Type.OVERWORLD);
    }

    private static void registerBiome(Biome biome, int weight, BiomeDictionary.Type... types) {
        BiomeManager.addBiome(BiomeManager.BiomeType.WARM, new BiomeManager.BiomeEntry(biome, weight));
        BiomeDictionary.addTypes(biome, types);
        BiomeManager.addSpawnBiome(biome);
    }
}
