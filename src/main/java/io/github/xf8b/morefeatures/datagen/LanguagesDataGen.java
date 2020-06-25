package io.github.xf8b.morefeatures.datagen;

import io.github.xf8b.morefeatures.blocks.CornCrop;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import io.github.xf8b.morefeatures.items.CornSeeds;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;
import org.apache.commons.lang3.text.WordUtils;

public class LanguagesDataGen extends LanguageProvider {
    public LanguagesDataGen(DataGenerator gen, String modid, String locale) {
        super(gen, modid, locale);
    }

    @Override
    protected void addTranslations() {
        MoreFeaturesRegistries.ITEMS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(item -> !(item instanceof CornSeeds))
                .forEach(item -> this.add(item, WordUtils.capitalizeFully(item.getTranslationKey().replace("item." + MoreFeatures.MOD_ID + ".", "").replace("_", " "))));
        MoreFeaturesRegistries.BLOCKS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .filter(block -> !(block instanceof CornCrop))
                .forEach(block -> this.add(block, WordUtils.capitalizeFully(block.getTranslationKey().replace("block." + MoreFeatures.MOD_ID + ".", "").replace("_", " "))));
        MoreFeaturesRegistries.ENCHANTMENTS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(enchantment -> this.add(enchantment, WordUtils.capitalizeFully(enchantment.getName().replace("enchantment." + MoreFeatures.MOD_ID + ".", "").replace("_", " "))));
        MoreFeaturesRegistries.EFFECTS.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(effect -> this.add(effect, WordUtils.capitalizeFully(effect.getName().replace("effect." + MoreFeatures.MOD_ID + ".", "").replace("_", " "))));
        MoreFeaturesRegistries.BIOMES.getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(biome -> this.add(biome, WordUtils.capitalizeFully(biome.getTranslationKey().replace("biome." + MoreFeatures.MOD_ID + ".", "").replace("_", " "))));
        this.add(MoreFeaturesRegistries.CORN_CROP.get(), "Corn Seeds");
        this.add("itemGroup." + MoreFeatures.MOD_ID, "MoreFeatures");
        this.add("command." + MoreFeatures.MOD_ID + ".information.success", "Username: %s, UUID: %s, Coordinates: %s %s %s");
        this.add("command." + MoreFeatures.MOD_ID + ".hunger.invalid_action", "The action %s does not exist.");
        this.add("command." + MoreFeatures.MOD_ID + ".hunger.invalid_stat", "The stat %s does not exist.");
        this.add("command." + MoreFeatures.MOD_ID + ".hunger.query_success", "Food Level: %s, Saturation Level: %s");
        this.add("command." + MoreFeatures.MOD_ID + ".hunger.set_food_success", "Old Food Level: %s, New Food Level: %s");
        this.add("command." + MoreFeatures.MOD_ID + ".hunger.set_saturation_success", "Old Saturation Level: %s, New Saturation Level: %s");
        this.add("death.attack." + MoreFeatures.MOD_ID + ".engulfedInFireWhileWearingCoal", "%1$s was engulfed in flames while wearing coal");
        this.add("death.attack." + MoreFeatures.MOD_ID + ".engulfedInFireWhileWearingCoal.player", "%1$s was engulfed in flames in coal armor while being attacked by %2$s");
        this.add("death.attack." + MoreFeatures.MOD_ID + ".asbestosis", "%1$s died from asbestosis");
        this.add("death.attack." + MoreFeatures.MOD_ID + ".asbestosis.player", "%1$s died from asbestosis while being attacked by %2$s");
        this.add("death.attack." + MoreFeatures.MOD_ID + ".killedByArmor", "%1$s was killed by their armor");
        this.add("death.attack." + MoreFeatures.MOD_ID + ".killedByArmor.player", "%1$s was killed by their armor while being attacked by %2$s");
    }

    @Override
    public String getName() {
        return "MoreFeatures Languages";
    }
}