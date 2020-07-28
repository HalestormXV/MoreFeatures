package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.command.suggestion.SuggestionProviders;
import net.minecraft.entity.player.HungerManager;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.CommandSource;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class HungerCommand {
    private static final SuggestionProvider<ServerCommandSource> all_actions = SuggestionProviders.register(
            new Identifier(MoreFeatures.MOD_ID, "hunger_command_all_actions"),
            (context, builder) -> CommandSource.suggestMatching(new String[] {"get", "set"}, builder)
    );

    private static final SuggestionProvider<ServerCommandSource> all_stats = SuggestionProviders.register(
            new Identifier(MoreFeatures.MOD_ID, "hunger_command_all_stats"),
            (context, builder) -> CommandSource.suggestMatching(new String[] {"saturation", "food"}, builder)
    );

    private static final DynamicCommandExceptionType INVALID_ACTION_EXCEPTION = new DynamicCommandExceptionType(
            object -> new TranslatableText("command." + MoreFeatures.MOD_ID + ".hunger.invalid_action", object)
    );

    private static final DynamicCommandExceptionType INVALID_STAT_EXCEPTION = new DynamicCommandExceptionType(
            object -> new TranslatableText("command." + MoreFeatures.MOD_ID + ".hunger.invalid_stat", object)
    );

    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("hunger")
                .requires(source -> source.hasPermissionLevel(2))
                .then(CommandManager.argument("action", StringArgumentType.string())
                        .suggests(all_actions)
                        .then(CommandManager.argument("player", EntityArgumentType.player())
                                .executes(context -> queryHunger(context.getSource(),
                                        StringArgumentType.getString(context, "action"),
                                        EntityArgumentType.getPlayer(context, "player")))
                                .then(CommandManager.argument("stat", StringArgumentType.string())
                                        .suggests(all_stats)
                                        .then(CommandManager.argument("value", IntegerArgumentType.integer())
                                                .executes(context -> {
                                                    try {
                                                        return changeHunger(context.getSource(),
                                                                StringArgumentType.getString(context, "action"),
                                                                EntityArgumentType.getPlayer(context, "player"),
                                                                StringArgumentType.getString(context, "stat"),
                                                                IntegerArgumentType.getInteger(context, "value"));
                                                    } catch (IllegalAccessException exception) {
                                                        exception.printStackTrace();
                                                        return 0;
                                                    }
                                                })))))
        );
    }

    public static int queryHunger(ServerCommandSource source, String action, ServerPlayerEntity playerEntity) throws CommandSyntaxException {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            if (action.equals("get")) {
                String foodLevel = String.valueOf(playerEntity.getHungerManager().getFoodLevel());
                String saturationLevel = String.valueOf(playerEntity.getHungerManager().getSaturationLevel());
                source.sendFeedback(new TranslatableText("command." + MoreFeatures.MOD_ID + ".hunger.query_success", foodLevel, saturationLevel), true);
            } else {
                throw INVALID_ACTION_EXCEPTION.create(action);
            }
        }
        return 1;
    }

    public static int changeHunger(ServerCommandSource source, String action, ServerPlayerEntity playerEntity, String stat, int value) throws IllegalAccessException, CommandSyntaxException {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            if (action.equals("set")) {
                if (stat.equals("food")) {
                    int oldFoodLevel = playerEntity.getHungerManager().getFoodLevel();
                    playerEntity.getHungerManager().setFoodLevel(value);
                    int newFoodLevel = playerEntity.getHungerManager().getFoodLevel();
                    source.sendFeedback(new TranslatableText("command." + MoreFeatures.MOD_ID + ".hunger.set_food_success", oldFoodLevel, newFoodLevel), true);
                } else if (stat.equals("saturation")) {
                    float oldSaturationLevel = playerEntity.getHungerManager().getSaturationLevel();
                    Field saturationLevel = ObfuscationReflectionHelper.findField(HungerManager.class, "field_75125_b");
                    saturationLevel.set(playerEntity.getHungerManager(), value);
                    float newSaturationLevel = playerEntity.getHungerManager().getSaturationLevel();
                    source.sendFeedback(new TranslatableText("command." + MoreFeatures.MOD_ID + ".hunger.set_saturation_success", oldSaturationLevel, newSaturationLevel), true);
                } else {
                    throw INVALID_STAT_EXCEPTION.create(stat);
                }
            } else {
                throw INVALID_ACTION_EXCEPTION.create(action);
            }
        }
        return 1;
    }
}
