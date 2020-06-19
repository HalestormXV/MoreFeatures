package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.FoodStats;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class HungerCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("hunger")
                .requires(source -> source.hasPermissionLevel(2))
                .then(Commands.argument("type", StringArgumentType.string())
                        .then(Commands.argument("player", EntityArgument.player())
                                .executes(context -> queryHunger(context.getSource(),
                                        StringArgumentType.getString(context, "type"),
                                        EntityArgument.getPlayer(context, "player")))
                                .then(Commands.argument("typeToBeSet", StringArgumentType.string())
                                        .then(Commands.argument("amount", IntegerArgumentType.integer())
                                                .executes(context -> {
                                                    try {
                                                        return changeHunger(context.getSource(),
                                                                StringArgumentType.getString(context, "type"),
                                                                EntityArgument.getPlayer(context, "player"),
                                                                StringArgumentType.getString(context, "typeToBeSet"),
                                                                IntegerArgumentType.getInteger(context, "amount"));
                                                    } catch (IllegalAccessException e) {
                                                        e.printStackTrace();
                                                        return 0;
                                                    }
                                                })))))
        );
    }

    public static int queryHunger(CommandSource source, String type, ServerPlayerEntity playerEntity) {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            if (type.equals("get")) {
                String foodLevel = String.valueOf(playerEntity.getFoodStats().getFoodLevel());
                String saturationLevel = String.valueOf(playerEntity.getFoodStats().getSaturationLevel());
                source.sendFeedback(new StringTextComponent("Food Level: " + foodLevel + ", Saturation Level: " + saturationLevel), true);
            } else {
                source.sendErrorMessage(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.invalid_type"));
            }
        }
        return 1;
    }

    public static int changeHunger(CommandSource source, String type, ServerPlayerEntity playerEntity, String typeToSet, int amount) throws IllegalAccessException {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            if (type.equals("set")) {
                if (typeToSet.equals("food")) {
                    int oldFoodLevel = playerEntity.getFoodStats().getFoodLevel();
                    playerEntity.getFoodStats().setFoodLevel(amount);
                    int newFoodLevel = playerEntity.getFoodStats().getFoodLevel();
                    source.sendFeedback(new StringTextComponent("Old Food Level: " + oldFoodLevel + ", New Food Level: " + newFoodLevel), true);
                } else if (typeToSet.equals("saturation")) {
                    float oldSaturationLevel = playerEntity.getFoodStats().getSaturationLevel();
                    Field saturationLevel = ObfuscationReflectionHelper.findField(FoodStats.class, "field_75125_b");
                    saturationLevel.set(playerEntity.getFoodStats(), amount);
                    float newSaturationLevel = playerEntity.getFoodStats().getSaturationLevel();
                    source.sendFeedback(new StringTextComponent("Old Saturation Level: " + oldSaturationLevel + ", New Saturation Level: " + newSaturationLevel), true);
                } else {
                    source.sendErrorMessage(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.invalid_typeToBeSet"));
                }
            } else {
                source.sendErrorMessage(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.invalid_type"));
            }
        }
        return 1;
    }
}
