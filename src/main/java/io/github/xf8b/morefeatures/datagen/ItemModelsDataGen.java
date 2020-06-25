package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.CornSeeds;
import net.minecraft.block.BushBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.FenceBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.fml.RegistryObject;

public class ItemModelsDataGen extends ItemModelProvider {
    public ItemModelsDataGen(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper) {
        super(generator, modid, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        MoreFeaturesRegistries.ITEMS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(item -> {
                    String name;
                    if (item instanceof CornSeeds) {
                        name = item.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "").replace("crop", "seeds");
                    } else {
                        name = item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "");
                    }
                    getBuilder(name).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + name));
                });

        MoreFeaturesRegistries.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(block -> !(block instanceof CropsBlock))
                .forEach(block -> {
                    String name = block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "");
                    if (block instanceof BushBlock) {
                        getBuilder(name).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("block/" + name));
                    } else if (block instanceof FenceBlock) {
                        getBuilder(name).parent(new ModelFile.UncheckedModelFile(MoreFeatures.MOD_ID + ":block/" + name + "_inventory"));
                    } else if (block instanceof DoorBlock) {
                        getBuilder(name).parent(new ModelFile.UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/" + name));
                    } else {
                        getBuilder(name).parent(new ModelFile.UncheckedModelFile(MoreFeatures.MOD_ID + ":block/" + name));
                    }
                });
    }

    @Override
    public String getName() {
        return "MoreFeatures Item Models";
    }
}
