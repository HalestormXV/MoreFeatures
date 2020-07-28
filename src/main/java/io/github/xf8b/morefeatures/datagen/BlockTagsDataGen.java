package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagsProvider;
import net.minecraft.tag.BlockTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.Tags;

public class BlockTagsDataGen extends BlockTagsProvider {
    public BlockTagsDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void configure() {
        //Forge Tags
        Tag<Block> ORES_SAPPHIRE = tag("ores/sapphire");
        getOrCreateTagBuilder(Tags.Blocks.FENCES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE.get(), MoreFeaturesRegistries.ORANGE_FENCE.get());
        getOrCreateTagBuilder(Tags.Blocks.FENCE_GATES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE_GATE.get(), MoreFeaturesRegistries.ORANGE_FENCE_GATE.get());
        getOrCreateTagBuilder(Tags.Blocks.GLASS_COLORLESS).add(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get());
        getOrCreateTagBuilder(ORES_SAPPHIRE).add(MoreFeaturesRegistries.SAPPHIRE_ORE.get());
        getOrCreateTagBuilder(Tags.Blocks.ORES).add(ORES_SAPPHIRE);

        //Minecraft Tags
        getOrCreateTagBuilder(BlockTags.CROPS).add(MoreFeaturesRegistries.CORN_CROP.get());
        getOrCreateTagBuilder(BlockTags.IMPERMEABLE).add(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get());
        getOrCreateTagBuilder(BlockTags.LEAVES).add(MoreFeaturesRegistries.LEMON_LEAVES.get(), MoreFeaturesRegistries.ORANGE_LEAVES.get());
        getOrCreateTagBuilder(BlockTags.LOGS).add(MoreFeaturesRegistries.LEMON_LOG.get(), MoreFeaturesRegistries.ORANGE_LOG.get());
        getOrCreateTagBuilder(BlockTags.PLANKS).add(MoreFeaturesRegistries.LEMON_PLANKS.get(), MoreFeaturesRegistries.ORANGE_PLANKS.get());
        getOrCreateTagBuilder(BlockTags.SAPLINGS).add(MoreFeaturesRegistries.LEMON_SAPLING.get(), MoreFeaturesRegistries.ORANGE_SAPLING.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_BUTTONS).add(MoreFeaturesRegistries.LEMON_BUTTON.get(), MoreFeaturesRegistries.ORANGE_BUTTON.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_DOORS).add(MoreFeaturesRegistries.LEMON_DOOR.get(), MoreFeaturesRegistries.ORANGE_DOOR.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_FENCES).add(MoreFeaturesRegistries.LEMON_FENCE.get(), MoreFeaturesRegistries.ORANGE_FENCE.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE.get(), MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_SLABS).add(MoreFeaturesRegistries.LEMON_SLAB.get(), MoreFeaturesRegistries.ORANGE_SLAB.get());
        getOrCreateTagBuilder(BlockTags.WOODEN_STAIRS).add(MoreFeaturesRegistries.LEMON_STAIRS.get(), MoreFeaturesRegistries.ORANGE_STAIRS.get());
    }

    @Override
    public String getName() {
        return "MoreFeatures Block Tags";
    }

    private static Tag<Block> tag(String name) {
        return new BlockTags.CachingTag(new Identifier("forge", name));
    }
}
