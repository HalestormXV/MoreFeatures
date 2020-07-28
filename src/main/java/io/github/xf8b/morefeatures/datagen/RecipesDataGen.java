package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.blocks.*;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.RecipesProvider;
import net.minecraft.data.server.recipe.CookingRecipeJsonFactory;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonFactory;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonFactory;
import net.minecraft.item.*;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Consumer;

public class RecipesDataGen extends RecipesProvider {
    public RecipesDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void generate(Consumer<RecipeJsonProvider> consumer) {
        MoreFeaturesRegistries.ITEMS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(item -> {
                    if (item instanceof SwordItem) {
                        swordRecipe(((SwordItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                    } else if (item instanceof PickaxeItem) {
                        pickaxeRecipe(((PickaxeItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                    } else if (item instanceof AxeItem) {
                        axeRecipe(((AxeItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                        flippedAxeRecipe(((AxeItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item)
                                .offerTo(consumer, new Identifier(MoreFeatures.MOD_ID, item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "") + "_flipped"));
                    } else if (item instanceof ShovelItem) {
                        shovelRecipe(((ShovelItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                    } else if (item instanceof HoeItem) {
                        hoeRecipe(((HoeItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                        flippedHoeRecipe(((HoeItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item)
                                .offerTo(consumer, new Identifier(MoreFeatures.MOD_ID, item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "") + "_flipped"));
                    } else if (item instanceof ArmorItem) {
                        String armorType = item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "").replace(((ArmorItem) item).getMaterial().getName().replace(MoreFeatures.MOD_ID + ":", ""), "").replace("_", "");
                        if (armorType.equals("helmet")) {
                            helmetRecipe(((ArmorItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                        } else if (armorType.equals("chestplate")) {
                            chestplateRecipe(((ArmorItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                        } else if (armorType.equals("leggings")) {
                            leggingsRecipe(((ArmorItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                        } else if (armorType.equals("boots")) {
                            bootsRecipe(((ArmorItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem(), item).offerTo(consumer);
                        } else if (item == MoreFeaturesRegistries.MASK.get()) {
                            ShapedRecipeJsonFactory.create(item)
                                    .pattern("xxx")
                                    .pattern("xxx")
                                    .input('x', ((ArmorItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem())
                                    .criterion("has_" + ((ArmorItem) item)
                                                    .getMaterial()
                                                    .getRepairIngredient()
                                                    .getMatchingStacksClient()[0]
                                                    .getItem()
                                                    .getTranslationKey()
                                                    .replace("block.minecraft.", ""),
                                            conditionsFromItem(((ArmorItem) item).getMaterial().getRepairIngredient().getMatchingStacksClient()[0].getItem()))
                                    .offerTo(consumer);
                        }
                    } else if (item.isFood()) {
                        if (item instanceof RedstoneApple) {
                            ShapedRecipeJsonFactory.create(item)
                                    .pattern("xxx")
                                    .pattern("xyx")
                                    .pattern("xxx")
                                    .input('x', Items.REDSTONE)
                                    .input('y', Items.APPLE)
                                    .criterion("has_" + Items.REDSTONE.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            conditionsFromItem(Items.REDSTONE))
                                    .criterion("has_" + Items.APPLE.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            conditionsFromItem(Items.APPLE))
                                    .offerTo(consumer);
                        } else if (item instanceof IronApple) {
                            ShapedRecipeJsonFactory.create(item)
                                    .pattern("xxx")
                                    .pattern("xyx")
                                    .pattern("xxx")
                                    .input('x', Items.IRON_INGOT)
                                    .input('y', Items.APPLE)
                                    .criterion("has_" + Items.IRON_INGOT.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            conditionsFromItem(Items.REDSTONE))
                                    .criterion("has_" + Items.APPLE.getTranslationKey()
                                                    .replace("item.minecraft.", ""),
                                            conditionsFromItem(Items.APPLE))
                                    .offerTo(consumer);
                        }
                    }
                });

        MoreFeaturesRegistries.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    if (block instanceof WoodenBlock) {
                        if (block instanceof StairsBlock) {
                            stairRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                            flippedStairRecipe(((WoodenBlock) block).getWood(), block)
                                    .offerTo(consumer, new Identifier(MoreFeatures.MOD_ID, block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "") + "_flipped"));
                        } else if (block instanceof WoodButtonBlock) {
                            buttonRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                        } else if (block instanceof DoorBlock) {
                            doorRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                        } else if (block instanceof FenceBlock) {
                            fenceRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                        } else if (block instanceof FenceGateBlock) {
                            fenceGateRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                        } else if (block instanceof LogBlock) {
                            planksRecipe(block, ((WoodenBlock) block).getWood()).offerTo(consumer);
                        } else if (block instanceof PressurePlateBlock) {
                            pressurePlateRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                        } else if (block instanceof SlabBlock) {
                            slabRecipe(((WoodenBlock) block).getWood(), block).offerTo(consumer);
                        }
                    } else if (block instanceof PlanksBlock &&
                            block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "").contains("planks")) {
                        buttonRecipe(block, ((PlanksBlock) block).getButton());
                    } else if (block instanceof BlastProofGlass) {
                        ShapedRecipeJsonFactory.create(block)
                                .pattern("xxx")
                                .pattern("xyx")
                                .pattern("xxx")
                                .input('x', Blocks.IRON_BLOCK)
                                .input('y', Blocks.GLASS)
                                .criterion("has_" + Blocks.IRON_BLOCK.getTranslationKey()
                                        .replace("block.minecraft.", ""), conditionsFromItem(Blocks.IRON_BLOCK))
                                .offerTo(consumer);
                    } else if (block instanceof DisplayCaseBlock) {
                        ShapedRecipeJsonFactory.create(block)
                                .pattern("xxx")
                                .pattern("x x")
                                .pattern("xxx")
                                .input('x', Blocks.GLASS)
                                .criterion("has_" + Blocks.GLASS.getTranslationKey()
                                        .replace("block.minecraft.", ""), conditionsFromItem(Blocks.GLASS))
                                .offerTo(consumer);
                    } else if (block instanceof GemDroppingOre) {
                        String charactersToReplace;
                        if (((GemDroppingOre) block).getGem().getTranslationKey().contains("minecraft")) {
                            charactersToReplace = "item.minecraft.";
                        } else {
                            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
                        }

                        String gemName = ((GemDroppingOre) block).getGem().getTranslationKey().replace(charactersToReplace, "");
                        oreSmelting(((GemDroppingOre) block).getGem(), block).offerTo(consumer, new Identifier(MoreFeatures.MOD_ID, gemName + "_from_smelting"));
                        oreBlasting(((GemDroppingOre) block).getGem(), block).offerTo(consumer, new Identifier(MoreFeatures.MOD_ID, gemName + "_from_blasting"));
                    }
                });
    }

    private ShapedRecipeJsonFactory swordRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("x")
                .pattern("x")
                .pattern("y")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory pickaxeRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xxx")
                .pattern(" y ")
                .pattern(" y ")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory axeRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xx")
                .pattern("xy")
                .pattern(" y")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory flippedAxeRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xx")
                .pattern("yx")
                .pattern("y ")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory shovelRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("x")
                .pattern("y")
                .pattern("y")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory hoeRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xx")
                .pattern(" y")
                .pattern(" y")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory flippedHoeRecipe(ItemConvertible material, ItemConvertible result) {
        String charactersToReplace;
        if (material.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "item.minecraft.";
        } else {
            charactersToReplace = "item." + MoreFeatures.MOD_ID + ".";
        }
        String name = material.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xx")
                .pattern("y ")
                .pattern("y ")
                .input('x', material)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory helmetRecipe(ItemConvertible material, ItemConvertible result) {
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
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xxx")
                .pattern("x x")
                .input('x', material)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory chestplateRecipe(ItemConvertible material, ItemConvertible result) {
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
        return ShapedRecipeJsonFactory.create(result)
                .pattern("x x")
                .pattern("xxx")
                .pattern("xxx")
                .input('x', material)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory leggingsRecipe(ItemConvertible material, ItemConvertible result) {
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
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xxx")
                .pattern("x x")
                .pattern("x x")
                .input('x', material)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory bootsRecipe(ItemConvertible material, ItemConvertible result) {
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
        return ShapedRecipeJsonFactory.create(result)
                .pattern("x x")
                .pattern("x x")
                .input('x', material)
                .criterion("has_" + name, conditionsFromItem(material));
    }

    private ShapedRecipeJsonFactory stairRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result, 4)
                .pattern("  x")
                .pattern(" xx")
                .pattern("xxx")
                .input('x', wood)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapedRecipeJsonFactory flippedStairRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result, 4)
                .pattern("x  ")
                .pattern("xx ")
                .pattern("xxx")
                .input('x', wood)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapelessRecipeJsonFactory buttonRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapelessRecipeJsonFactory.create(result)
                .input(wood)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapedRecipeJsonFactory doorRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result, 3)
                .pattern("xx")
                .pattern("xx")
                .pattern("xx")
                .input('x', wood)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapedRecipeJsonFactory fenceRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result, 3)
                .pattern("xyx")
                .pattern("xyx")
                .input('x', wood)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapedRecipeJsonFactory fenceGateRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("yxy")
                .pattern("yxy")
                .input('x', wood)
                .input('y', Items.STICK)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapelessRecipeJsonFactory planksRecipe(ItemConvertible log, ItemConvertible result) {
        String charactersToReplace;
        if (log.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = log.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapelessRecipeJsonFactory.create(result, 4)
                .input(log)
                .criterion("has_" + name, conditionsFromItem(log));
    }

    private ShapedRecipeJsonFactory pressurePlateRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result)
                .pattern("xx")
                .input('x', wood)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private ShapedRecipeJsonFactory slabRecipe(ItemConvertible wood, ItemConvertible result) {
        String charactersToReplace;
        if (wood.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }
        String name = wood.asItem().getTranslationKey().replace(charactersToReplace, "");
        return ShapedRecipeJsonFactory.create(result, 6)
                .pattern("xxx")
                .input('x', wood)
                .criterion("has_" + name, conditionsFromItem(wood));
    }

    private CookingRecipeJsonFactory oreSmelting(ItemConvertible gem, ItemConvertible ore) {
        String charactersToReplace;
        if (ore.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }

        String oreName = ore.asItem().getTranslationKey().replace(charactersToReplace, "");

        return CookingRecipeJsonFactory.createSmelting(Ingredient.ofItems(ore.asItem()), gem, 1.0F, 200)
                .criterion("has_" + oreName, conditionsFromItem(ore));
    }

    private CookingRecipeJsonFactory oreBlasting(ItemConvertible gem, ItemConvertible ore) {
        String charactersToReplace;
        if (ore.asItem().getTranslationKey().contains("minecraft")) {
            charactersToReplace = "block.minecraft.";
        } else {
            charactersToReplace = "block." + MoreFeatures.MOD_ID + ".";
        }

        String oreName = ore.asItem().getTranslationKey().replace(charactersToReplace, "");

        return CookingRecipeJsonFactory.createBlasting(Ingredient.ofItems(ore.asItem()), gem, 1.0F, 100)
                .criterion("has_" + oreName, conditionsFromItem(ore));
    }

    @Override
    public String getName() {
        return "MoreFeatures Recipes";
    }
}
