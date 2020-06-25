package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.Tags;

public class ItemTagsDataGen extends ItemTagsProvider {
    public ItemTagsDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void registerTags() {
        //Forge Tags
        Tag<Item> GEMS_SAPPHIRE = tag("gems/sapphire");
        Tag<Item> ORES_SAPPHIRE = tag("ores/sapphire");
        Tag<Item> CROPS_CORN = tag("crops/corn");
        getBuilder(GEMS_SAPPHIRE).add(MoreFeaturesRegistries.SAPPHIRE.get());
        getBuilder(ORES_SAPPHIRE).add(MoreFeaturesRegistries.SAPPHIRE_ORE.get().asItem());
        getBuilder(CROPS_CORN).add(MoreFeaturesRegistries.CORN.get());
        getBuilder(Tags.Items.FENCES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE.get().asItem(), MoreFeaturesRegistries.ORANGE_FENCE.get().asItem());
        getBuilder(Tags.Items.FENCE_GATES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE_GATE.get().asItem(), MoreFeaturesRegistries.ORANGE_FENCE_GATE.get().asItem());
        getBuilder(Tags.Items.GLASS_COLORLESS).add(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get().asItem());
        getBuilder(Tags.Items.GEMS).add(GEMS_SAPPHIRE);
        getBuilder(Tags.Items.ORES).add(ORES_SAPPHIRE);
        getBuilder(Tags.Items.CROPS).add(CROPS_CORN);

        //Minecraft Tags
        getBuilder(ItemTags.LEAVES).add(MoreFeaturesRegistries.LEMON_LEAVES.get().asItem(), MoreFeaturesRegistries.ORANGE_LEAVES.get().asItem());
        getBuilder(ItemTags.LOGS).add(MoreFeaturesRegistries.LEMON_LOG.get().asItem(), MoreFeaturesRegistries.ORANGE_LOG.get().asItem());
        getBuilder(ItemTags.PLANKS).add(MoreFeaturesRegistries.LEMON_PLANKS.get().asItem(), MoreFeaturesRegistries.ORANGE_PLANKS.get().asItem());
        getBuilder(ItemTags.SAPLINGS).add(MoreFeaturesRegistries.LEMON_SAPLING.get().asItem(), MoreFeaturesRegistries.ORANGE_SAPLING.get().asItem());
        getBuilder(ItemTags.WOODEN_BUTTONS).add(MoreFeaturesRegistries.LEMON_BUTTON.get().asItem(), MoreFeaturesRegistries.ORANGE_BUTTON.get().asItem());
        getBuilder(ItemTags.WOODEN_DOORS).add(MoreFeaturesRegistries.LEMON_DOOR.get().asItem(), MoreFeaturesRegistries.ORANGE_DOOR.get().asItem());
        getBuilder(ItemTags.WOODEN_FENCES).add(MoreFeaturesRegistries.LEMON_FENCE.get().asItem(), MoreFeaturesRegistries.ORANGE_FENCE.get().asItem());
        getBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE.get().asItem(), MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE.get().asItem());
        getBuilder(ItemTags.WOODEN_SLABS).add(MoreFeaturesRegistries.LEMON_SLAB.get().asItem(), MoreFeaturesRegistries.ORANGE_SLAB.get().asItem());
        getBuilder(ItemTags.WOODEN_STAIRS).add(MoreFeaturesRegistries.LEMON_STAIRS.get().asItem(), MoreFeaturesRegistries.ORANGE_STAIRS.get().asItem());
    }

    @Override
    public String getName() {
        return "MoreFeatures Item Tags";
    }

    private static Tag<Item> tag(String name) {
        return new ItemTags.Wrapper(new ResourceLocation("forge", name));
    }
}
