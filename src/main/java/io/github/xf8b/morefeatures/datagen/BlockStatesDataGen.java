package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.*;
import net.minecraft.block.enums.WallMountLocation;
import net.minecraft.data.DataGenerator;
import net.minecraft.util.math.Direction;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class BlockStatesDataGen extends BlockStateProvider {
    public BlockStatesDataGen(DataGenerator gen, String modid, ExistingFileHelper exFileHelper) {
        super(gen, modid, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        MoreFeaturesRegistries.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    String name = block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "");
                    if (block instanceof DoorBlock) {
                        doorBlock((DoorBlock) block, modLoc("block/" + name + "_bottom"), modLoc("block/" + name + "_top"));
                    } else if (block instanceof FenceBlock) {
                        getMultipartBuilder(block).part()
                                .modelFile(models()
                                        .fenceInventory(name + "_inventory",
                                                modLoc("block/" + name.replace("fence", "planks"))))
                                .nextModel();
                        fenceBlock((FenceBlock) block, modLoc("block/" + name.replace("fence", "planks")));
                    } else if (block instanceof FenceGateBlock) {
                        fenceGateBlock((FenceGateBlock) block, modLoc("block/" + name.replace("fence_gate", "planks")));
                    } else if (block instanceof LogBlock) {
                        logBlock((LogBlock) block);
                    } else if (block instanceof PlantBlock && !(block instanceof CropBlock)) {
                        simpleBlock(block, models().cross(name, modLoc("block/" + name)));
                    } else if (block instanceof SlabBlock) {
                        slabBlock((SlabBlock) block, modLoc("block/" + name.replace("slab", "planks")), modLoc("block/" + name.replace("slab", "planks")));
                    } else if (block instanceof WoodButtonBlock) {
                        boolean hasAddedInventoryModel = false;
                        for (WallMountLocation face : WoodButtonBlock.FACE.getValues()) {
                            for (Direction facing : WoodButtonBlock.FACING.getValues()) {
                                for (Boolean powered : WoodButtonBlock.POWERED.getValues()) {
                                    int xRotation;
                                    int yRotation;
                                    if (facing == Direction.EAST) {
                                        yRotation = 90;
                                    } else if (facing == Direction.WEST) {
                                        yRotation = 270;
                                    } else if (facing == Direction.SOUTH) {
                                        yRotation = 180;
                                    } else if (facing == Direction.NORTH) {
                                        yRotation = 0;
                                    } else {
                                        yRotation = 0;
                                    }

                                    if (face == WallMountLocation.FLOOR) {
                                        xRotation = 0;
                                    } else if (face == WallMountLocation.WALL) {
                                        xRotation = 90;
                                    } else if (face == WallMountLocation.CEILING) {
                                        xRotation = 180;
                                    } else {
                                        xRotation = 0;
                                    }

                                    getVariantBuilder(block)
                                            .partialState()
                                            .with(WoodButtonBlock.FACE, face)
                                            .with(WoodButtonBlock.FACING, facing)
                                            .with(WoodButtonBlock.POWERED, powered)
                                            .modelForState()
                                            .modelFile(models().singleTexture(powered ? name + "_pressed" : name,
                                                    powered ? mcLoc("block/button_pressed") : mcLoc("block/button"),
                                                    modLoc("block/" + name.replace("button", "planks"))))
                                            .rotationX(xRotation)
                                            .rotationY(yRotation)
                                            .uvLock(face == WallMountLocation.WALL)
                                            .addModel();
                                    if (!hasAddedInventoryModel) {
                                        getVariantBuilder(block)
                                                .partialState()
                                                .modelForState()
                                                .modelFile(models().singleTexture(name + "_inventory",
                                                        mcLoc("block/button_inventory"),
                                                        modLoc("block/" + name.replace("button", "planks"))))
                                                .nextModel();
                                        hasAddedInventoryModel = true;
                                    }
                                }
                            }
                        }
                    } else if (block instanceof PressurePlateBlock) {
                        getVariantBuilder(block)
                                .partialState()
                                .with(PressurePlateBlock.POWERED, false)
                                .modelForState()
                                .modelFile(models().singleTexture(name,
                                        mcLoc("block/pressure_plate_up"),
                                        modLoc("block/" + name.replace("pressure_plate", "planks"))))
                                .addModel()
                                .partialState()
                                .with(PressurePlateBlock.POWERED, true)
                                .modelForState()
                                .modelFile(models().singleTexture(name + "_down",
                                        mcLoc("block/pressure_plate_down"),
                                        modLoc("block/" + name.replace("pressure_plate", "planks"))))
                                .addModel();
                    } else if (block instanceof StairsBlock) {
                        stairsBlock((StairsBlock) block, modLoc("block/" + name.replace("stairs", "planks")));
                    } else if (block instanceof CropBlock) {
                        for (int age : CropBlock.AGE.getValues()) {
                            getVariantBuilder(block).partialState()
                                    .with(CropBlock.AGE, age)
                                    .modelForState()
                                    .modelFile(models().cross(name + "_stage" + age, modLoc("block/" + name + "_stage" + age)))
                                    .addModel();
                        }
                    } else {
                        simpleBlock(block);
                    }
                });
    }

    @Override
    public String getName() {
        return "MoreFeatures Block States";
    }
}
