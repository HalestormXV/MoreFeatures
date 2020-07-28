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
import io.github.xf8b.morefeatures.blocks.FoodDroppingCrop;
import io.github.xf8b.morefeatures.blocks.FoodDroppingLeaves;
import io.github.xf8b.morefeatures.blocks.GemDroppingOre;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.*;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.block.enums.SlabType;
import net.minecraft.data.DataCache;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.data.server.LootTablesProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.*;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.SurvivesExplosionLootCondition;
import net.minecraft.loot.condition.TableBonusLootCondition;
import net.minecraft.loot.context.LootContextTypes;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.ExplosionDecayLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.predicate.NumberRange;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.predicate.item.EnchantmentPredicate;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.util.Identifier;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.fml.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class LootTablesDataGen extends LootTablesProvider {
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
                    } else if (block instanceof CropBlock && block instanceof FoodDroppingCrop) {
                        lootTables.put(block, cropTable(block));
                    } else if (block instanceof LeavesBlock && block instanceof FoodDroppingLeaves) {
                        lootTables.put(block, leavesTable(block));
                    } else if (block instanceof GemDroppingOre) {
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
                .withRolls(ConstantLootTableRange.create(1))
                .withEntry(ItemEntry.builder(block))
                .withCondition(SurvivesExplosionLootCondition.builder());
        return LootTable.builder().withPool(builder);
    }

    private LootTable.Builder glassTable(Block block) {
        return LootTable.builder()
                .withPool(LootPool.builder()
                        .withRolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(block))
                        .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))))));
    }

    private LootTable.Builder cropTable(Block block) {
        return LootTable.builder()
                .withPool(LootPool.builder()
                        .withEntry(ItemEntry.builder(((FoodDroppingCrop) block).getFood())
                                .withCondition(BlockStatePropertyLootCondition.builder(block)
                                        .method_22584(StatePredicate.Builder.create()
                                                .exactMatch(CropBlock.AGE, 7)))
                                .withChild(ItemEntry.builder(((FoodDroppingCrop) block).getSeeds()))))
                .withPool(LootPool.builder()
                        .withCondition(BlockStatePropertyLootCondition.builder(block)
                                .method_22584(StatePredicate.Builder.create()
                                        .exactMatch(CropBlock.AGE, 7)))
                        .withEntry(ItemEntry.builder(((FoodDroppingCrop) block).getSeeds())
                                .withFunction(ApplyBonusLootFunction.binomialWithBonusCount(Enchantments.FORTUNE, 0.5714286F, 3))))
                .withFunction(ExplosionDecayLootFunction.builder());
    }

    private LootTable.Builder oreTable(Block block) {
        return LootTable.builder()
                .withPool(LootPool.builder()
                        .withRolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(block)
                                .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))))
                                .withChild(ItemEntry.builder(((GemDroppingOre) block).getGem())
                                        .withFunction(ApplyBonusLootFunction.oreDrops(Enchantments.FORTUNE))
                                        .withFunction(ExplosionDecayLootFunction.builder()))));
    }

    private LootTable.Builder slabTable(Block block) {
        return LootTable.builder()
                .withPool(LootPool.builder()
                        .withRolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(block)
                                .withFunction(SetCountLootFunction.builder(ConstantLootTableRange.create(2))
                                        .withCondition(BlockStatePropertyLootCondition.builder(block)
                                                .method_22584(StatePredicate.Builder.create()
                                                        .exactMatch(SlabBlock.TYPE, SlabType.DOUBLE))))
                                .withFunction(ExplosionDecayLootFunction.builder())));
    }

    private LootTable.Builder doorTable(Block block) {
        return LootTable.builder()
                .withPool(LootPool.builder()
                        .withRolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(block)
                                .withCondition(BlockStatePropertyLootCondition.builder(block)
                                        .method_22584(StatePredicate.Builder.create()
                                                .exactMatch(DoorBlock.HALF, DoubleBlockHalf.LOWER))))
                        .withCondition(SurvivesExplosionLootCondition.builder()));
    }

    private LootTable.Builder leavesTable(Block block) {
        return LootTable.builder()
                .withPool(LootPool.builder()
                        .withRolls(ConstantLootTableRange.create(1))
                        .withEntry(ItemEntry.builder(block)
                                .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .item(Items.SHEARS))
                                        .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                                .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1))))))
                                .withChild(ItemEntry.builder(((FoodDroppingLeaves) block).getSapling())
                                        .withCondition(SurvivesExplosionLootCondition.builder())
                                        .withCondition(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.05F, 0.0625F, 0.083333336F, 0.1F)))))
                .withPool(LootPool.builder().withRolls(ConstantLootTableRange.create(1))
                        .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                .item(Items.SHEARS))
                                .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))))
                                .invert())
                        .withEntry(ItemEntry.builder(Items.STICK)
                                .withFunction(SetCountLootFunction.builder(UniformLootTableRange.between(1.0F, 2.0F)))
                                .withFunction(ExplosionDecayLootFunction.builder())
                                .withCondition(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.02F, 0.022222223F, 0.025F, 0.033333335F, 0.1F))))
                .withPool(LootPool.builder()
                        .withRolls(ConstantLootTableRange.create(1))
                        .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                .item(Items.SHEARS))
                                .withCondition(MatchToolLootCondition.builder(ItemPredicate.Builder.create()
                                        .enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, NumberRange.IntRange.atLeast(1)))))
                                .invert())
                        .withEntry(ItemEntry.builder(((FoodDroppingLeaves) block).getDroppedFood()).withCondition(SurvivesExplosionLootCondition.builder())
                                .withCondition(TableBonusLootCondition.builder(Enchantments.FORTUNE, 0.005F, 0.0055555557F, 0.00625F, 0.008333334F, 0.025F))));
    }

    @Override
    public void run(DataCache cache) {
        addTables();
        Map<Identifier, LootTable> tables = new HashMap<>();
        for (Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet()) {
            tables.put(entry.getKey().getDropTableId(), entry.getValue().withType(LootContextTypes.BLOCK).create());
        }
        writeTables(cache, tables);
    }

    private void writeTables(DataCache cache, Map<Identifier, LootTable> tables) {
        Path outputFolder = this.generator.getOutput();
        tables.forEach((key, lootTable) -> {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try {
                DataProvider.writeToPath(GSON, cache, LootManager.toJson(lootTable), path);
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
