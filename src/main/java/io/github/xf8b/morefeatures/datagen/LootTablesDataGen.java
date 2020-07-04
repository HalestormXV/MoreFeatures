/*
 * MIT License
 *
 * Copyright (c) 2019 McJty
 *
 * Based on https://github.com/McJty/YouTubeModding14/blob/master/src/main/java/com/mcjty/mytutorial/datagen/BaseLootTableProvider.java.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package io.github.xf8b.morefeatures.datagen;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.github.xf8b.morefeatures.blocks.DisplayCaseBlock;
import io.github.xf8b.morefeatures.blocks.IFoodDroppingCrop;
import io.github.xf8b.morefeatures.blocks.IFoodDroppingLeaves;
import io.github.xf8b.morefeatures.blocks.IGemDroppingOre;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.*;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.conditions.BlockStateProperty;
import net.minecraft.world.storage.loot.conditions.MatchTool;
import net.minecraft.world.storage.loot.conditions.SurvivesExplosion;
import net.minecraft.world.storage.loot.conditions.TableBonus;
import net.minecraft.world.storage.loot.functions.ApplyBonus;
import net.minecraft.world.storage.loot.functions.ExplosionDecay;
import net.minecraft.world.storage.loot.functions.SetCount;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LootTablesDataGen extends LootTableProvider {
    private static final Logger LOGGER = LogManager.getLogger();
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
    private final DataGenerator generator;

    public LootTablesDataGen(DataGenerator dataGeneratorIn) {
        super(dataGeneratorIn);
        generator = dataGeneratorIn;
    }

    protected void addTables() {
        MoreFeaturesRegistries.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    if (block instanceof GlassBlock || block instanceof DisplayCaseBlock) {
                        lootTables.put(block, glassTable(block));
                    } else if (block instanceof CropsBlock && block instanceof IFoodDroppingCrop) {
                        lootTables.put(block, cropTable(block));
                    } else if (block instanceof LeavesBlock && block instanceof IFoodDroppingLeaves) {
                        lootTables.put(block, leavesTable(block));
                    } else if (block instanceof IGemDroppingOre) {
                        lootTables.put(block, oreTable(block));
                    } else if (block instanceof SlabBlock) {
                        lootTables.put(block, slabTable(block));
                    } else if (block instanceof DoorBlock) {
                        lootTables.put(block, doorTable(block));
                    } else {
                        lootTables.put(block, regularTable(block));
                    }
                });
    }

    private LootTable.Builder regularTable(Block block) {
        LootPool.Builder builder = LootPool.builder()
                .rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(block))
                .acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(builder);
    }

    private LootTable.Builder glassTable(Block block) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(block))
                        .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))));
    }

    private LootTable.Builder cropTable(Block block) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .addEntry(ItemLootEntry.builder(((IFoodDroppingCrop) block).getFood())
                                .acceptCondition(BlockStateProperty.builder(block)
                                        .fromProperties(StatePropertiesPredicate.Builder.newBuilder()
                                                .withIntProp(CropsBlock.AGE, 7)))
                                .alternatively(ItemLootEntry.builder(((IFoodDroppingCrop) block).getSeeds()))))
                .addLootPool(LootPool.builder()
                        .acceptCondition(BlockStateProperty.builder(block)
                                .fromProperties(StatePropertiesPredicate.Builder.newBuilder()
                                        .withIntProp(CropsBlock.AGE, 7)))
                        .addEntry(ItemLootEntry.builder(((IFoodDroppingCrop) block).getSeeds())
                                .acceptFunction(ApplyBonus.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3))))
                .acceptFunction(ExplosionDecay.builder());
    }

    private LootTable.Builder oreTable(Block block) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(block)
                                .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
                                .alternatively(ItemLootEntry.builder(((IGemDroppingOre) block).getGem())
                                        .acceptFunction(ApplyBonus.oreDrops(Enchantments.FORTUNE))
                                        .acceptFunction(ExplosionDecay.builder()))));
    }

    private LootTable.Builder slabTable(Block block) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(block)
                                .acceptFunction(SetCount.builder(ConstantRange.of(2))
                                        .acceptCondition(BlockStateProperty.builder(block)
                                                .fromProperties(StatePropertiesPredicate.Builder.newBuilder()
                                                        .withProp(SlabBlock.TYPE, SlabType.DOUBLE))))
                                .acceptFunction(ExplosionDecay.builder())));
    }

    private LootTable.Builder doorTable(Block block) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(block)
                                .acceptCondition(BlockStateProperty.builder(block)
                                        .fromProperties(StatePropertiesPredicate.Builder.newBuilder()
                                                .withProp(DoorBlock.HALF, DoubleBlockHalf.LOWER))))
                        .acceptCondition(SurvivesExplosion.builder()));
    }

    private LootTable.Builder leavesTable(Block block) {
        return LootTable.builder()
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(block)
                                .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                                        .item(Items.SHEARS))
                                        .alternative(MatchTool.builder(ItemPredicate.Builder.create()
                                                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))))))
                                .alternatively(ItemLootEntry.builder(((IFoodDroppingLeaves) block).getSapling())
                                        .acceptCondition(SurvivesExplosion.builder())
                                        .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.05F, 0.0625F, 0.083333336F, 0.1F)))))
                .addLootPool(LootPool.builder().rolls(ConstantRange.of(1))
                        .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                                .item(Items.SHEARS))
                                .alternative(MatchTool.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
                                .inverted())
                        .addEntry(ItemLootEntry.builder(Items.STICK)
                                .acceptFunction(SetCount.builder(RandomValueRange.of(1.0F, 2.0F)))
                                .acceptFunction(ExplosionDecay.builder())
                                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))))
                .addLootPool(LootPool.builder()
                        .rolls(ConstantRange.of(1))
                        .acceptCondition(MatchTool.builder(ItemPredicate.Builder.create()
                                .item(Items.SHEARS))
                                .alternative(MatchTool.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1)))))
                                .inverted())
                        .addEntry(ItemLootEntry.builder(((IFoodDroppingLeaves) block).getDroppedFood()).acceptCondition(SurvivesExplosion.builder())
                                .acceptCondition(TableBonus.builder(Enchantments.FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    @Override
    public void act(DirectoryCache cache) {
        addTables();
        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParameterSet(LootParameterSets.BLOCK).build());
        }
        writeTables(cache, tables);
    }

    private void writeTables(DirectoryCache cache, Map<ResourceLocation, LootTable> tables) {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(lootTable), path);
            } catch (IOException exception) {
                LOGGER.error("Couldn't write loot table {}", path, exception);
            }
        });
    }


    @Override
    public String getName() {
        return "MoreFeatures Loot Tables";
    }
}
