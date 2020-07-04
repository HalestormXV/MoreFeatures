package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.blocks.*;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.food.IronApple;
import io.github.xf8b.morefeatures.items.food.RedstoneApple;
import net.minecraft.block.*;
import net.minecraft.data.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

public class RecipesDataGen extends RecipeProvider {
    public RecipesDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
        MoreFeaturesRegistries.ITEMS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(item -> {
                    if (item instanceof SwordItem) {
                        swordRecipe(((SwordItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                    } else if (item instanceof PickaxeItem) {
                        pickaxeRecipe(((PickaxeItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                    } else if (item instanceof AxeItem) {
                        axeRecipe(((AxeItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                        flippedAxeRecipe(((AxeItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item)
                                .build(consumer, new ResourceLocation(MoreFeatures.MOD_ID, item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "") + "_flipped"));
                    } else if (item instanceof ShovelItem) {
                        shovelRecipe(((ShovelItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                    } else if (item instanceof HoeItem) {
                        hoeRecipe(((HoeItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                        flippedHoeRecipe(((HoeItem) item).getTier().getRepairMaterial().getMatchingStacks()[0].getItem(), item)
                                .build(consumer, new ResourceLocation(MoreFeatures.MOD_ID, item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "") + "_flipped"));
                    } else if (item instanceof ArmorItem) {
                        String armorType = item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "").replace(((ArmorItem) item).getArmorMaterial().getName().replace(MoreFeatures.MOD_ID + ":", ""), "").replace("_", "");
                        if (armorType.equals("helmet")) {
                            helmetRecipe(((ArmorItem) item).getArmorMaterial().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                        } else if (armorType.equals("chestplate")) {
                            chestplateRecipe(((ArmorItem) item).getArmorMaterial().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                        } else if (armorType.equals("leggings")) {
                            leggingsRecipe(((ArmorItem) item).getArmorMaterial().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                        } else if (armorType.equals("boots")) {
                            bootsRecipe(((ArmorItem) item).getArmorMaterial().getRepairMaterial().getMatchingStacks()[0].getItem(), item).build(consumer);
                        } else if (item == MoreFeaturesRegistries.MASK.get()) {
                            ShapedRecipeBuilder.shapedRecipe(item)
                                    .patternLine("xxx")
                                    .patternLine("xxx")
                                    .key('x', ((ArmorItem) item).getArmorMaterial().getRepairMaterial().getMatchingStacks()[0].getItem())
                                    .addCriterion("has_" + ((ArmorItem) item)
                                                    .getArmorMaterial()
                                                    .getRepairMaterial()
                                                    .getMatchingStacks()[0]
                                                    .getItem()
                                                    .getTranslationKey()
                                                    .replace("block.minecraft.", ""),
                                            hasItem(((ArmorItem) item).getArmorMaterial().getRepairMaterial().getMatchingStacks()[0].getItem()))
                                    .build(consumer);
                        }
                    } else if (item.isFood()) {
                        if (item instanceof RedstoneApple) {
                            ShapedRecipeBuilder.shapedRecipe(item)
                                    .patternLine("xxx")
                                    .patternLine("xyx")
                                    .patternLine("xxx")
                                    .key('x', Items.REDSTONE)
                                    .key('y', Items.APPLE)
                                    .addCriterion("has_" + Items.REDSTONE.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            hasItem(Items.REDSTONE))
                                    .addCriterion("has_" + Items.APPLE.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            hasItem(Items.APPLE))
                                    .build(consumer);
                        } else if (item instanceof IronApple) {
                            ShapedRecipeBuilder.shapedRecipe(item)
                                    .patternLine("xxx")
                                    .patternLine("xyx")
                                    .patternLine("xxx")
                                    .key('x', Items.IRON_INGOT)
                                    .key('y', Items.APPLE)
                                    .addCriterion("has_" + Items.IRON_INGOT.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            hasItem(Items.REDSTONE))
                                    .addCriterion("has_" + Items.APPLE.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            hasItem(Items.APPLE))
                                    .build(consumer);
                        }
                    }
                });

        MoreFeaturesRegistries.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    if (block instanceof IWoodenBlock) {
                        if (block instanceof StairsBlock) {
                            stairRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                            flippedStairRecipe(((IWoodenBlock) block).getWood(), block)
                                    .build(consumer, new ResourceLocation(MoreFeatures.MOD_ID, block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "") + "_flipped"));
                        } else if (block instanceof WoodButtonBlock) {
                            buttonRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                        } else if (block instanceof DoorBlock) {
                            doorRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                        } else if (block instanceof FenceBlock) {
                            fenceRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                        } else if (block instanceof FenceGateBlock) {
                            fenceGateRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                        } else if (block instanceof LogBlock) {
                            planksRecipe(block, ((IWoodenBlock) block).getWood()).build(consumer);
                        } else if (block instanceof PressurePlateBlock) {
                            pressurePlateRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                        } else if (block instanceof SlabBlock) {
                            slabRecipe(((IWoodenBlock) block).getWood(), block).build(consumer);
                        }
                    } else if (block instanceof IPlanksBlock &&
                            block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "").contains("planks")) {
                        buttonRecipe(block, ((IPlanksBlock) block).getButton());
                    } else if (block instanceof BlastProofGlass) {
                        ShapedRecipeBuilder.shapedRecipe(block)
                                .patternLine("xxx")
                                .patternLine("xyx")
                                .patternLine("xxx")
                                .key('x', Blocks.IRON_BLOCK)
                                .key('y', Blocks.GLASS)
                                .addCriterion("has_" + Blocks.IRON_BLOCK.getTranslationKey()
                                        .replace("block.minecraft.", ""), hasItem(Blocks.IRON_BLOCK))
                                .build(consumer);
                    } else if (block instanceof DisplayCaseBlock) {
                        ShapedRecipeBuilder.shapedRecipe(block)
                                .patternLine("xxx")
                                .patternLine("x x")
                                .patternLine("xxx")
                                .key('x', Blocks.GLASS)
                                .addCriterion("has_" + Blocks.GLASS.getTranslationKey()
                                        .replace("block.minecraft.", ""), hasItem(Blocks.GLASS))
                                .build(consumer);
                    } else if (block instanceof IGemDroppingOre) {
                        String charactersToReplace;
                        if (((IGemDroppingOre) block).getGem().getTranslationKey().contains("minecraft")) {
                            charactersToReplace = "item.minecraft.";
                        } else {
                            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
                        }

                        String gemName = ((IGemDroppingOre) block).getGem().getTranslationKey().replace(charactersToReplace, "");
                        oreSmelting(((IGemDroppingOre) block).getGem(), block).build(consumer, new ResourceLocation(MoreFeatures.MOD_ID, gemName + "_from_smelting"));
                        oreBlasting(((IGemDroppingOre) block).getGem(), block).build(consumer, new ResourceLocation(MoreFeatures.MOD_ID, gemName + "_from_blasting"));
                    }
                });
    }

    private ShapedRecipeBuilder swordRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("x")
                .patternLine("x")
                .patternLine("y")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder pickaxeRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xxx")
                .patternLine(" y ")
                .patternLine(" y ")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder axeRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xx")
                .patternLine("xy")
                .patternLine(" y")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder flippedAxeRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xx")
                .patternLine("yx")
                .patternLine("y ")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder shovelRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("x")
                .patternLine("y")
                .patternLine("y")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder hoeRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xx")
                .patternLine(" y")
                .patternLine(" y")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder flippedHoeRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xx")
                .patternLine("y ")
                .patternLine("y ")
                .key('x', material)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder helmetRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        String materialType;
        if (material instanceof BlockItem) {
            materialType = "block";
        } else {
            materialType = "item";
        }
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = materialType + ".minecraft.";
        } else {
            charactersToReplace = materialType + "." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xxx")
                .patternLine("x x")
                .key('x', material)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder chestplateRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        String materialType;
        if (material instanceof BlockItem) {
            materialType = "block";
        } else {
            materialType = "item";
        }
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = materialType + ".minecraft.";
        } else {
            charactersToReplace = materialType + "." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("x x")
                .patternLine("xxx")
                .patternLine("xxx")
                .key('x', material)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder leggingsRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        String materialType;
        if (material instanceof BlockItem) {
            materialType = "block";
        } else {
            materialType = "item";
        }
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = materialType + ".minecraft.";
        } else {
            charactersToReplace = materialType + "." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xxx")
                .patternLine("x x")
                .patternLine("x x")
                .key('x', material)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder bootsRecipe(IItemProvider material, IItemProvider result) {
        String charactersToReplace;
        String materialType;
        if (material instanceof BlockItem) {
            materialType = "block";
        } else {
            materialType = "item";
        }
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = materialType + ".minecraft.";
        } else {
            charactersToReplace = materialType + "." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("x x")
                .patternLine("x x")
                .key('x', material)
                .addCriterion("has_" + name, hasItem(material));
    }

    private ShapedRecipeBuilder stairRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result, 4)
                .patternLine("  x")
                .patternLine(" xx")
                .patternLine("xxx")
                .key('x', wood)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapedRecipeBuilder flippedStairRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result, 4)
                .patternLine("x  ")
                .patternLine("xx ")
                .patternLine("xxx")
                .key('x', wood)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapelessRecipeBuilder buttonRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapelessRecipeBuilder.shapelessRecipe(result)
                .addIngredient(wood)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapedRecipeBuilder doorRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result, 3)
                .patternLine("xx")
                .patternLine("xx")
                .patternLine("xx")
                .key('x', wood)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapedRecipeBuilder fenceRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result, 3)
                .patternLine("xyx")
                .patternLine("xyx")
                .key('x', wood)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapedRecipeBuilder fenceGateRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("yxy")
                .patternLine("yxy")
                .key('x', wood)
                .key('y', Items.STICK)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapelessRecipeBuilder planksRecipe(IItemProvider log, IItemProvider result) {
        String charactersToReplace;
        if (log.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = log.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapelessRecipeBuilder.shapelessRecipe(result, 4)
                .addIngredient(log)
                .addCriterion("has_" + name, hasItem(log));
    }

    private ShapedRecipeBuilder pressurePlateRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result)
                .patternLine("xx")
                .key('x', wood)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private ShapedRecipeBuilder slabRecipe(IItemProvider wood, IItemProvider result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeBuilder.shapedRecipe(result, 6)
                .patternLine("xxx")
                .key('x', wood)
                .addCriterion("has_" + name, hasItem(wood));
    }

    private CookingRecipeBuilder oreSmelting(IItemProvider gem, IItemProvider ore) {
        String charactersToReplace;
        if (ore.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }

        String oreName = ore.asItem().getTranslationKey().replace(charactersToReplace, "");

        return CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(ore.asItem()), gem, 1.0F, 200)
                .addCriterion("has_" + oreName, hasItem(ore));
    }

    private CookingRecipeBuilder oreBlasting(IItemProvider gem, IItemProvider ore) {
        String charactersToReplace;
        if (ore.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }

        String oreName = ore.asItem().getTranslationKey().replace(charactersToReplace, "");

        return CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(ore.asItem()), gem, 1.0F, 100)
                .addCriterion("has_" + oreName, hasItem(ore));
    }

    @Override
    public String getName() {
        return "MoreFeatures Recipes";
    }
}
