package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.ItemTagsProvider;
import net.minecraft.item.Item;
import net.minecraft.tag.ItemTags;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.Tags;

public class ItemTagsDataGen extends ItemTagsProvider {
    public ItemTagsDataGen(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    protected void configure() {
        //Forge Tags
        Tag<Item> GEMS_SAPPHIRE = tag("gems/sapphire");
        Tag<Item> ORES_SAPPHIRE = tag("ores/sapphire");
        Tag<Item> CROPS_CORN = tag("crops/corn");
        getOrCreateTagBuilder(GEMS_SAPPHIRE).add(MoreFeaturesRegistries.SAPPHIRE.get());
        getOrCreateTagBuilder(ORES_SAPPHIRE).add(MoreFeaturesRegistries.SAPPHIRE_ORE.get().asItem());
        getOrCreateTagBuilder(CROPS_CORN).add(MoreFeaturesRegistries.CORN.get());
        getOrCreateTagBuilder(Tags.Items.FENCES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE.get().asItem(), MoreFeaturesRegistries.ORANGE_FENCE.get().asItem());
        getOrCreateTagBuilder(Tags.Items.FENCE_GATES_WOODEN).add(MoreFeaturesRegistries.LEMON_FENCE_GATE.get().asItem(), MoreFeaturesRegistries.ORANGE_FENCE_GATE.get().asItem());
        getOrCreateTagBuilder(Tags.Items.GLASS_COLORLESS).add(MoreFeaturesRegistries.BLAST_PROOF_GLASS.get().asItem());
        getOrCreateTagBuilder(Tags.Items.GEMS).add(GEMS_SAPPHIRE);
        getOrCreateTagBuilder(Tags.Items.ORES).add(ORES_SAPPHIRE);
        getOrCreateTagBuilder(Tags.Items.CROPS).add(CROPS_CORN);

        //Minecraft Tags
        getOrCreateTagBuilder(ItemTags.LEAVES).add(MoreFeaturesRegistries.LEMON_LEAVES.get().asItem(), MoreFeaturesRegistries.ORANGE_LEAVES.get().asItem());
        getOrCreateTagBuilder(ItemTags.LOGS).add(MoreFeaturesRegistries.LEMON_LOG.get().asItem(), MoreFeaturesRegistries.ORANGE_LOG.get().asItem());
        getOrCreateTagBuilder(ItemTags.PLANKS).add(MoreFeaturesRegistries.LEMON_PLANKS.get().asItem(), MoreFeaturesRegistries.ORANGE_PLANKS.get().asItem());
        getOrCreateTagBuilder(ItemTags.SAPLINGS).add(MoreFeaturesRegistries.LEMON_SAPLING.get().asItem(), MoreFeaturesRegistries.ORANGE_SAPLING.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_BUTTONS).add(MoreFeaturesRegistries.LEMON_BUTTON.get().asItem(), MoreFeaturesRegistries.ORANGE_BUTTON.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_DOORS).add(MoreFeaturesRegistries.LEMON_DOOR.get().asItem(), MoreFeaturesRegistries.ORANGE_DOOR.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_FENCES).add(MoreFeaturesRegistries.LEMON_FENCE.get().asItem(), MoreFeaturesRegistries.ORANGE_FENCE.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_PRESSURE_PLATES).add(MoreFeaturesRegistries.LEMON_PRESSURE_PLATE.get().asItem(), MoreFeaturesRegistries.ORANGE_PRESSURE_PLATE.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_SLABS).add(MoreFeaturesRegistries.LEMON_SLAB.get().asItem(), MoreFeaturesRegistries.ORANGE_SLAB.get().asItem());
        getOrCreateTagBuilder(ItemTags.WOODEN_STAIRS).add(MoreFeaturesRegistries.LEMON_STAIRS.get().asItem(), MoreFeaturesRegistries.ORANGE_STAIRS.get().asItem());
    }

    @Override
    public String getName() {
        return "MoreFeatures Item Tags";
    }

    private static Tag<Item> tag(String name) {
        return new ItemTags.CachingTag(new Identifier("forge", name));
    }
}
