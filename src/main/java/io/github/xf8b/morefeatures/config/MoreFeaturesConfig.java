package io.github.xf8b.morefeatures.config;

import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = MoreFeatures.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class MoreFeaturesConfig {
    //Common Config
    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_SPEC;

    static {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
    /*
     * //Enchantment Settings
     * public static int savingGraceChanceIncrease = COMMON.savingGraceChanceIncrease.get();
     * public static int soulsRequiredForSharpnessLevelUp = COMMON.soulsRequiredForSharpnessLevelUp.get();
     * //Curses
     * public static int slownessCurseSlownessLevel = COMMON.slownessCurseSlownessLevel.get();
     * public static double harmingCurseDamageGiven = COMMON.harmingCurseDamageGiven.get();
     *
     * //Effect Settings
     * public static double asbestosisDamageGiven = COMMON.asbestosisDamageGiven.get();
     *
     * //Armor Settings
     * public static int lapisArmorExperienceGiven = COMMON.lapisArmorExperienceGiven.get();
     * public static int corruptedArmorProtectionMax = COMMON.corruptedArmorProtectionMax.get();
     * public static double corruptedArmorToughnessMax = COMMON.corruptedArmorToughnessMax.get();
     *
     * //Tool Settings
     * public static int corruptedToolAttackDamageMax = COMMON.corruptedToolAttackDamageMax.get();
     * public static double corruptedToolAttackSpeedMax = COMMON.corruptedToolAttackSpeedMax.get();
     */
}
