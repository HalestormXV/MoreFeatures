package io.github.xf8b.morefeatures.config;

import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    //Generation Settings
    public final ForgeConfigSpec.BooleanValue isOreGenerationEnabled;
    //Enchantment Settings
    public final ForgeConfigSpec.IntValue savingGraceActivationChance;
    public final ForgeConfigSpec.IntValue soulsRequiredForSharpnessLevelUp;

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
        builder.pop();
    }
}
