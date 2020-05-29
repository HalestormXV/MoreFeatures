package io.github.xf8b.morefeatures.config;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreFeaturesConfig {
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    //Generation Settings
    public static boolean isOreGenerationEnabled;

    //Enchantment Settings
    public static int savingGraceActivationChance;
    public static int soulsRequiredForSharpnessLevelUp;
    //Curses
    public static int slownessCurseSlownessLevel;
    public static double harmingCurseDamageGiven;

    //Effect Settings
    public static double asbestosisDamageGiven;

    //Armor Settings
    public static int lapisArmorExperienceGiven;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == MoreFeaturesConfig.CLIENT_SPEC) {
            bakeConfig();
        }
    }

    public static void bakeConfig() {
        isOreGenerationEnabled = CLIENT.isOreGenerationEnabled.get();
        savingGraceActivationChance = CLIENT.savingGraceActivationChance.get();
        soulsRequiredForSharpnessLevelUp = CLIENT.soulsRequiredForSharpnessLevelUp.get();
        slownessCurseSlownessLevel = CLIENT.slownessCurseSlownessLevel.get();
        harmingCurseDamageGiven = CLIENT.harmingCurseDamageGiven.get();
        asbestosisDamageGiven = CLIENT.asbestosisDamageGiven.get();
        lapisArmorExperienceGiven = CLIENT.lapisArmorExperienceGiven.get();
    }
}
