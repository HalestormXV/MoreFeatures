package io.github.xf8b.morefeatures.core;

import io.github.xf8b.morefeatures.blockentities.DisplayCaseBlockEntity;
import io.github.xf8b.morefeatures.blocks.*;
import io.github.xf8b.morefeatures.blocks.button.LemonButton;
import io.github.xf8b.morefeatures.blocks.button.OrangeButton;
import io.github.xf8b.morefeatures.blocks.door.LemonDoor;
import io.github.xf8b.morefeatures.blocks.door.OrangeDoor;
import io.github.xf8b.morefeatures.blocks.fence.LemonFence;
import io.github.xf8b.morefeatures.blocks.fence.LemonFenceGate;
import io.github.xf8b.morefeatures.blocks.fence.OrangeFence;
import io.github.xf8b.morefeatures.blocks.fence.OrangeFenceGate;
import io.github.xf8b.morefeatures.blocks.leaves.LemonLeaves;
import io.github.xf8b.morefeatures.blocks.leaves.OrangeLeaves;
import io.github.xf8b.morefeatures.blocks.log.LemonLog;
import io.github.xf8b.morefeatures.blocks.log.OrangeLog;
import io.github.xf8b.morefeatures.blocks.planks.LemonPlanks;
import io.github.xf8b.morefeatures.blocks.planks.OrangePlanks;
import io.github.xf8b.morefeatures.blocks.pressureplate.LemonPressurePlate;
import io.github.xf8b.morefeatures.blocks.pressureplate.OrangePressurePlate;
import io.github.xf8b.morefeatures.blocks.sapling.LemonSapling;
import io.github.xf8b.morefeatures.blocks.sapling.OrangeSapling;
import io.github.xf8b.morefeatures.blocks.slab.LemonSlab;
import io.github.xf8b.morefeatures.blocks.slab.OrangeSlab;
import io.github.xf8b.morefeatures.blocks.stairs.LemonStairs;
import io.github.xf8b.morefeatures.blocks.stairs.OrangeStairs;
import io.github.xf8b.morefeatures.container.DisplayCaseScreenHandler;
import io.github.xf8b.morefeatures.core.registries.Register;
import io.github.xf8b.morefeatures.effects.Asbestosis;
import io.github.xf8b.morefeatures.enchantments.*;
import io.github.xf8b.morefeatures.world.biome.LemonTreePlains;
import io.github.xf8b.morefeatures.world.biome.OrangeTreePlains;
import net.minecraft.block.Block;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.container.ContainerType;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.item.Item;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;

public class MoreFeaturesRegistries {
    //Deferred Registries
    public static final Register<Item> ITEMS = new Register<>(Registry.ITEM, MoreFeatures.MOD_ID);
    public static final Register<Block> BLOCKS = new Register<>(Registry.BLOCK, MoreFeatures.MOD_ID);
    public static final Register<Enchantment> ENCHANTMENTS = new Register<>(Registry.ENCHANTMENT, MoreFeatures.MOD_ID);
    public static final Register<StatusEffect> EFFECTS = new Register<>(Registry.POTION, MoreFeatures.MOD_ID);
    public static final Register<Biome> BIOMES = new Register<>(Registry.BIOME, MoreFeatures.MOD_ID);
    public static final Register<ScreenHandlerType<?>> SCREEN_HANDLER_TYPES = new Register<>(Registry.SCREEN_HANDLER, MoreFeatures.MOD_ID);
    public static final Register<BlockEntityType<?>> BLOCK_ENTITY_TYPES = new Register<>(Registry.BLOCK_ENTITY_TYPE, MoreFeatures.MOD_ID);

    //Registry Objects
    //Blocks
    public static final RegistryObject<Block> SAPPHIRE_BLOCK = BLOCKS.register("sapphire_block", () -> new SapphireBlock());
    public static final RegistryObject<Block> BLAST_PROOF_GLASS = BLOCKS.register("blast_proof_glass", () -> new BlastProofGlass());
    public static final RegistryObject<Block> ASBESTOS = BLOCKS.register("asbestos", () -> new Asbestos());
    public static final RegistryObject<Block> DISPLAY_CASE = BLOCKS.register("display_case", () -> new DisplayCaseBlock());

    //Saplings
    public static final RegistryObject<Block> LEMON_SAPLING = BLOCKS.register("lemon_sapling", () -> new LemonSapling());
    public static final RegistryObject<Block> ORANGE_SAPLING = BLOCKS.register("orange_sapling", () -> new OrangeSapling());

    //Logs
    public static final RegistryObject<Block> LEMON_LOG = BLOCKS.register("lemon_log", () -> new LemonLog());
    public static final RegistryObject<Block> ORANGE_LOG = BLOCKS.register("orange_log", () -> new OrangeLog());

    //Leaves
    public static final RegistryObject<Block> LEMON_LEAVES = BLOCKS.register("lemon_leaves", () -> new LemonLeaves());
    public static final RegistryObject<Block> ORANGE_LEAVES = BLOCKS.register("orange_leaves", () -> new OrangeLeaves());

    //Planks
    public static final RegistryObject<Block> LEMON_PLANKS = BLOCKS.register("lemon_planks", () -> new LemonPlanks());
    public static final RegistryObject<Block> ORANGE_PLANKS = BLOCKS.register("orange_planks", () -> new OrangePlanks());

    //Slabs
    public static final RegistryObject<Block> LEMON_SLAB = BLOCKS.register("lemon_slab", () -> new LemonSlab());
    public static final RegistryObject<Block> ORANGE_SLAB = BLOCKS.register("orange_slab", () -> new OrangeSlab());

    //Stairs
    public static final RegistryObject<Block> LEMON_STAIRS = BLOCKS.register("lemon_stairs", () -> new LemonStairs());
    public static final RegistryObject<Block> ORANGE_STAIRS = BLOCKS.register("orange_stairs", () -> new OrangeStairs());

    //Fences
    public static final RegistryObject<Block> LEMON_FENCE = BLOCKS.register("lemon_fence", () -> new LemonFence());
    public static final RegistryObject<Block> ORANGE_FENCE = BLOCKS.register("orange_fence", () -> new OrangeFence());
    public static final RegistryObject<Block> LEMON_FENCE_GATE = BLOCKS.register("lemon_fence_gate", () -> new LemonFenceGate());
    public static final RegistryObject<Block> ORANGE_FENCE_GATE = BLOCKS.register("orange_fence_gate", () -> new OrangeFenceGate());

    //Buttons
    public static final RegistryObject<Block> LEMON_BUTTON = BLOCKS.register("lemon_button", () -> new LemonButton());
    public static final RegistryObject<Block> ORANGE_BUTTON = BLOCKS.register("orange_button", () -> new OrangeButton());

    //Pressure Plates
    public static final RegistryObject<Block> LEMON_PRESSURE_PLATE = BLOCKS.register("lemon_pressure_plate", () -> new LemonPressurePlate());
    public static final RegistryObject<Block> ORANGE_PRESSURE_PLATE = BLOCKS.register("orange_pressure_plate", () -> new OrangePressurePlate());

    //Doors
    public static final RegistryObject<Block> LEMON_DOOR = BLOCKS.register("lemon_door", () -> new LemonDoor());
    public static final RegistryObject<Block> ORANGE_DOOR = BLOCKS.register("orange_door", () -> new OrangeDoor());

    //Crops
    public static final RegistryObject<Block> CORN_CROP = BLOCKS.register("corn_crop", () -> new CornCrop());

    //Ores
    public static final RegistryObject<Block> SAPPHIRE_ORE = BLOCKS.register("sapphire_ore", () -> new SapphireOre());

    //Enchantments
    public static final RegistryObject<Enchantment> FIRE_RETARDANT = ENCHANTMENTS.register("fire_retardant", () -> new FireRetardant());
    public static final RegistryObject<Enchantment> SOUL_HARVESTER = ENCHANTMENTS.register("soul_harvester", () -> new SoulHarvester());
    public static final RegistryObject<Enchantment> SAVING_GRACE = ENCHANTMENTS.register("saving_grace", () -> new SavingGrace());

    //Curses
    public static final RegistryObject<Enchantment> SLOWNESS_CURSE = ENCHANTMENTS.register("slowness_curse", () -> new SlownessCurse());
    public static final RegistryObject<Enchantment> HARMING_CURSE = ENCHANTMENTS.register("harming_curse", () -> new HarmingCurse());
    public static final RegistryObject<Enchantment> WEIGHT_CURSE = ENCHANTMENTS.register("weight_curse", () -> new WeightCurse());

    //Effects
    public static final RegistryObject<StatusEffect> ASBESTOSIS = EFFECTS.register("asbestosis", () -> new Asbestosis());

    //Biomes
    public static final RegistryObject<Biome> LEMON_TREE_PLAINS = BIOMES.register("lemon_tree_plains", () -> new LemonTreePlains());
    public static final RegistryObject<Biome> ORANGE_TREE_PLAINS = BIOMES.register("orange_tree_plains", () -> new OrangeTreePlains());

    //Tile Entity Types
    public static final RegistryObject<BlockEntityType<DisplayCaseBlockEntity>> DISPLAY_CASE_TILE_ENTITY = TILE_ENTITY_TYPES.register(
            "display_case",
            () -> BlockEntityType.Builder.create(DisplayCaseBlockEntity::new, MoreFeaturesRegistries.DISPLAY_CASE.get())
                    .build(null));

    //Container Types
    public static final RegistryObject<ContainerType<DisplayCaseScreenHandler>> DISPLAY_CASE_CONTAINER = CONTAINER_TYPES.register(
            "display_case",
            () -> IForgeContainerType.create(DisplayCaseScreenHandler::new));
}
