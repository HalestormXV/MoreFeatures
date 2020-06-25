package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class BlockTagsDataGen extends BlockTagsProvider {
    public BlockTagsDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        //Forge Tags
        Tag<Block> ORES_SAPPHIRE = tag("ores/sapphire");
        getBuilder(Tags.Blocks.FENCES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE.get(), MoreFeaturesRegistries.ORANGE_FENCE.get());
        getBuilder(Tags.Blocks.FENCE_GATES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE_GATE.get(), MoreFeaturesRegistries.ORANGE_FENCE_GATE.get());
        getBuilder(Tags.Blocks.GLASS_COLORLESS).add(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get());
        getBuilder(ORES_SAPPHIRE).add(MoreFeaturesRegistries.SAPPHIRE_ORE.get());
        getBuilder(Tags.Blocks.ORES).add(ORES_SAPPHIRE);

        //Minecraft Tags
        getBuilder(BlockTags.CROPS).add(MoreFeaturesRegistries.CORN_CROP.get());
        getBuilder(BlockTags.IMPERMEABLE).add(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get());
        getBuilder(BlockTags.LEAVES).add(MoreFeaturesRegistries.LEMON_LEAVES.get(), MoreFeaturesRegistries.ORANGE_LEAVES.get());
        getBuilder(BlockTags.LOGS).add(MoreFeaturesRegistries.LEMON_LOG.get(), MoreFeaturesRegistries.ORANGE_LOG.get());
        getBuilder(BlockTags.PLANKS).add(MoreFeaturesRegistries.LEMON_PLANKS.get(), MoreFeaturesRegistries.ORANGE_PLANKS.get());
        getBuilder(BlockTags.SAPLINGS).add(MoreFeaturesRegistries.LEMON_SAPLING.get(), MoreFeaturesRegistries.ORANGE_SAPLING.get());
        getBuilder(BlockTags.WOODEN_BUTTONS).add(MoreFeaturesRegistries.LEMON_BUTTON.get(), MoreFeaturesRegistries.ORANGE_BUTTON.get());
        getBuilder(BlockTags.WOODEN_DOORS).add(MoreFeaturesRegistries.LEMON_DOOR.get(), MoreFeaturesRegistries.ORANGE_DOOR.get());
        getBuilder(BlockTags.WOODEN_FENCES).add(MoreFeaturesRegistries.LEMON_FENCE.get(), MoreFeaturesRegistries.ORANGE_FENCE.get());
        getBuilder(BlockTags.WOODEN_PRESSURE_PLATES).add(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE.get(), MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE.get());
        getBuilder(BlockTags.WOODEN_SLABS).add(MoreFeaturesRegistries.LEMON_SLAB.get(), MoreFeaturesRegistries.ORANGE_SLAB.get());
        getBuilder(BlockTags.WOODEN_STAIRS).add(MoreFeaturesRegistries.LEMON_STAIRS.get(), MoreFeaturesRegistries.ORANGE_STAIRS.get());
    }

    @Override
    public String getName() {
        return "MoreFeatures Block Tags";
    }

    private static Tag<Block> tag(String name) {
        return new BlockTags.Wrapper(new ResourceLocation("forge", name));
    }
}
