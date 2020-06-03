package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class HungerCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("hunger")
                .requires(source -> source.hasPermissionLevel(2))
                .then(Commands.argument("player", StringArgumentType.string())
                        .then(Commands.argument("type", StringArgumentType.string())
                                .executes(context -> queryHunger(context.getSource(),
                                        StringArgumentType.getString(context, "player"),
                                        StringArgumentType.getString(context, "type")))
                                .then(Commands.argument("typeToBeSet", StringArgumentType.string())
                                        .then(Commands.argument("amount", IntegerArgumentType.integer())
                                                .executes(context -> changeHunger(context.getSource(),
                                                        StringArgumentType.getString(context, "player"),
                                                        StringArgumentType.getString(context, "type"),
                                                        StringArgumentType.getString(context, "typeToBeSet"),
                                                        IntegerArgumentType.getInteger(context, "amount")))))))
        );
    }

    public static int changeHunger(CommandSource source, String inputPlayerUsername, String type, String typeToSet, int amount) {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            world.getPlayers().stream().forEach(playerEntity -> {
                if (playerEntity.getScoreboardName().equals(inputPlayerUsername)) {
                    if (type.equals("set")) {
                        if (typeToSet.equals("food")) {
                            playerEntity.getFoodStats().setFoodLevel(amount);
                        } else if (typeToSet.equals("saturation")) {
                            playerEntity.getFoodStats().setFoodSaturationLevel(amount);
                        } else {
                            source.sendErrorMessage(new TranslationTextComponent(MoreFeatures.MOD_ID + ".hunger_command_failed"));
                        }
                    } else {
                        source.sendErrorMessage(new TranslationTextComponent(MoreFeatures.MOD_ID + ".hunger_command_failed"));
                    }
                } else {
                    source.sendErrorMessage(new TranslationTextComponent(MoreFeatures.MOD_ID + ".hunger_command_failed"));
                }
            });
        }
        return 1;
    }

    public static int queryHunger(CommandSource source, String inputPlayerUsername, String type) {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            world.getPlayers().stream().forEach(playerEntity -> {
                if (playerEntity.getScoreboardName().equals(inputPlayerUsername)) {
                    if (type.equals("get")) {
                        String foodLevel = String.valueOf(playerEntity.getFoodStats().getFoodLevel());
                        String saturationLevel = String.valueOf(playerEntity.getFoodStats().getSaturationLevel());
                        source.sendFeedback(new StringTextComponent("Food Level: " + foodLevel + ", Saturation Level: " + saturationLevel), true);
                    } else {
                        source.sendErrorMessage(new TranslationTextComponent(MoreFeatures.MOD_ID + ".hunger_command_failed"));
                    }
                } else {
                    source.sendErrorMessage(new TranslationTextComponent(MoreFeatures.MOD_ID + ".hunger_command_failed"));
                }
            });
        }
        return 1;
    }
}
