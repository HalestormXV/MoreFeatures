package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreFeaturesDataGen {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        if (event.includeClient()) {
            generator.addProvider(new BlockStatesDataGen(generator, MoreFeatures.MOD_ID, event.getExistingFileHelper()));
            generator.addProvider(new ItemModelsDataGen(generator, MoreFeatures.MOD_ID, event.getExistingFileHelper()));
            generator.addProvider(new LanguageFilesDataGen(generator, MoreFeatures.MOD_ID, "en_us"));
        }

        if (event.includeServer()) {
            generator.addProvider(new RecipesDataGen(generator));
            generator.addProvider(new LootTablesDataGen(generator));
            generator.addProvider(new ItemTagsDataGen(generator));
            generator.addProvider(new BlockTagsDataGen(generator));
        }
    }
}
