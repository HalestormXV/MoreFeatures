package io.github.xf8b.morefeatures.config;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    //Generation Settings
    public final ForgeConfigSpec.BooleanValue isOreGenerationEnabled;

    //Enchantment Settings
    public final ForgeConfigSpec.IntValue savingGraceActivationChance;
    public final ForgeConfigSpec.IntValue soulsRequiredForSharpnessLevelUp;
    //Curses
    public final ForgeConfigSpec.IntValue slownessCurseSlownessLevel;
    public final ForgeConfigSpec.DoubleValue harmingCurseDamageGiven;

    //Effect Settings
    public final ForgeConfigSpec.DoubleValue asbestosisDamageGiven;

    //Armor Settings
    public final ForgeConfigSpec.IntValue lapisArmorExperienceGiven;

    public ClientConfig(ForgeConfigSpec.Builder builder) {
        builder.push("Generation Settings");
        isOreGenerationEnabled = builder
                .comment("Turns ore generation on or off")
                .translation(MoreFeatures.MOD_ID + ".config." + "isOreGenerationEnabled")
                .define("isOreGenerationEnabled", true);
        builder.pop();

        builder.push("Enchantment Settings");
        savingGraceActivationChance = builder
                .comment("The chance of Saving Grace activating")
                .translation(MoreFeatures.MOD_ID + ".config." + "savingGraceActivationChance")
                .defineInRange("savingGraceActivationChance", 30, 0, 100);
        soulsRequiredForSharpnessLevelUp = builder
                .comment("The amount of souls required to increase the Sharpness level")
                .translation(MoreFeatures.MOD_ID + ".config." + "soulsRequiredForSharpnessLevelUp")
                .defineInRange("soulsRequiredForSharpnessLevelUp", 50, 0, 10000);
        builder.push("Curses");
        slownessCurseSlownessLevel = builder
                .comment("The level of the slowness effect applied when Slowness Curse is present")
                .translation(MoreFeatures.MOD_ID + ".config." + "slownessCurseSlownessLevel")
                .defineInRange("slownessCurseSlownessLevel", 4, 0, 255);
        harmingCurseDamageGiven = builder
                .comment("The level of the poison effect applied when Harming Curse is present")
                .translation(MoreFeatures.MOD_ID + ".config." + "harmingCursePoisonLevel")
                .defineInRange("harmingCursePoisonLevel", 0.5, 0, 20);
        builder.pop();
        builder.pop();

        builder.push("Effect Settings");
        asbestosisDamageGiven = builder
                .comment("The amount of damage given to the player if they have Asbestosis")
                .translation(MoreFeatures.MOD_ID + ".config." + "asbestosisDamageGiven")
                .defineInRange("asbestosisDamageGiven", 0.5, 0, 20);
        builder.pop();

        builder.push("Armor Settings");
        lapisArmorExperienceGiven = builder
                .comment("The amount of experience given every 2 minutes if Lapis Armor is worn")
                .translation(MoreFeatures.MOD_ID + ".config." + "lapisArmorExperienceGiven")
                .defineInRange("lapisArmorExperienceGiven", 5, 0, 2147483647);
        builder.pop();
    }
}
