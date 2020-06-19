package io.github.xf8b.morefeatures.config;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreFeaturesConfig {
    public static final ServerConfig SERVER;
    public static final ForgeConfigSpec SERVER_SPEC;

    static {
        final Pair<ServerConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ServerConfig::new);
        SERVER_SPEC = specPair.getRight();
        SERVER = specPair.getLeft();
    }

    //Generation Settings
    public static boolean isFeatureGenerationEnabled;
    public static boolean isOreGenerationEnabled;
    public static boolean isTreeGenerationEnabled;

    //Enchantment Settings
    public static int savingGraceChanceIncrease;
    public static int soulsRequiredForSharpnessLevelUp;
    //Curses
    public static int slownessCurseSlownessLevel;
    public static double harmingCurseDamageGiven;

    //Effect Settings
    public static double asbestosisDamageGiven;

    //Armor Settings
    public static int lapisArmorExperienceGiven;

    //Tool Settings
    public static int corruptedToolAttackDamageMax;
    public static double corruptedToolAttackSpeedMax;

    @SubscribeEvent
    public static void onModConfigEvent(final ModConfig.ModConfigEvent configEvent) {
        if (configEvent.getConfig().getSpec() == MoreFeaturesConfig.SERVER_SPEC) {
            bakeConfig();
        }
    }

    public static void bakeConfig() {
        isFeatureGenerationEnabled = SERVER.isFeatureGenerationEnabled.get();
        isOreGenerationEnabled = SERVER.isOreGenerationEnabled.get();
        isTreeGenerationEnabled = SERVER.isTreeGenerationEnabled.get();
        savingGraceChanceIncrease = SERVER.savingGraceChanceIncrease.get();
        soulsRequiredForSharpnessLevelUp = SERVER.soulsRequiredForSharpnessLevelUp.get();
        slownessCurseSlownessLevel = SERVER.slownessCurseSlownessLevel.get();
        harmingCurseDamageGiven = SERVER.harmingCurseDamageGiven.get();
        asbestosisDamageGiven = SERVER.asbestosisDamageGiven.get();
        lapisArmorExperienceGiven = SERVER.lapisArmorExperienceGiven.get();
        corruptedToolAttackDamageMax = SERVER.corruptedToolAttackDamageMax.get();
        corruptedToolAttackSpeedMax = SERVER.corruptedToolAttackSpeedMax.get();
    }
}
