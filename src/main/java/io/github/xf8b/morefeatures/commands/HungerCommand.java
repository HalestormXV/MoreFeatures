package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.suggestion.SuggestionProvider;
import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ISuggestionProvider;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.arguments.SuggestionProviders;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.FoodStats;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import java.lang.reflect.Field;

public class HungerCommand {
    private static final SuggestionProvider<CommandSource> all_actions = SuggestionProviders.register(
            new ResourceLocation("hunger", "all_actions"),
            (context, builder) -> ISuggestionProvider.suggest(new String[] {"get", "set"}, builder)
    );

    private static final SuggestionProvider<CommandSource> all_stats = SuggestionProviders.register(
            new ResourceLocation("hunger", "all_stats"),
            (context, builder) -> ISuggestionProvider.suggest(new String[] {"saturation", "food"}, builder)
    );

    private static final DynamicCommandExceptionType INVALID_ACTION_EXCEPTION = new DynamicCommandExceptionType(
            object -> new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.invalid_action", object)
    );

    private static final DynamicCommandExceptionType INVALID_STAT_EXCEPTION = new DynamicCommandExceptionType(
            object -> new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.invalid_stat", object)
    );

    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("hunger")
                .requires(source -> source.hasPermissionLevel(2))
                .then(Commands.argument("action", StringArgumentType.string())
                        .suggests(all_actions)
                        .then(Commands.argument("player", EntityArgument.player())
                                .executes(context -> queryHunger(context.getSource(),
                                        StringArgumentType.getString(context, "action"),
                                        EntityArgument.getPlayer(context, "player")))
                                .then(Commands.argument("stat", StringArgumentType.string())
                                        .suggests(all_stats)
                                        .then(Commands.argument("value", IntegerArgumentType.integer())
                                                .executes(context -> {
                                                    try {
                                                        return changeHunger(context.getSource(),
                                                                StringArgumentType.getString(context, "action"),
                                                                EntityArgument.getPlayer(context, "player"),
                                                                StringArgumentType.getString(context, "stat"),
                                                                IntegerArgumentType.getInteger(context, "value"));
                                                    } catch (IllegalAccessException exception) {
                                                        exception.printStackTrace();
                                                        return 0;
                                                    }
                                                })))))
        );
    }

    public static int queryHunger(CommandSource source, String action, ServerPlayerEntity playerEntity) throws CommandSyntaxException {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            if (action.equals("get")) {
                String foodLevel = String.valueOf(playerEntity.getFoodStats().getFoodLevel());
                String saturationLevel = String.valueOf(playerEntity.getFoodStats().getSaturationLevel());
                source.sendFeedback(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.query_success", foodLevel, saturationLevel), true);
            } else {
                throw INVALID_ACTION_EXCEPTION.create(action);
            }
        }
        return 1;
    }

    public static int changeHunger(CommandSource source, String action, ServerPlayerEntity playerEntity, String stat, int value) throws IllegalAccessException, CommandSyntaxException {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            if (action.equals("set")) {
                if (stat.equals("food")) {
                    int oldFoodLevel = playerEntity.getFoodStats().getFoodLevel();
                    playerEntity.getFoodStats().setFoodLevel(value);
                    int newFoodLevel = playerEntity.getFoodStats().getFoodLevel();
                    source.sendFeedback(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.set_food_success", oldFoodLevel, newFoodLevel), true);
                } else if (stat.equals("saturation")) {
                    float oldSaturationLevel = playerEntity.getFoodStats().getSaturationLevel();
                    Field saturationLevel = ObfuscationReflectionHelper.findField(FoodStats.class, "field_75125_b");
                    saturationLevel.set(playerEntity.getFoodStats(), value);
                    float newSaturationLevel = playerEntity.getFoodStats().getSaturationLevel();
                    source.sendFeedback(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.set_saturation_success", oldSaturationLevel, newSaturationLevel), true);
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
