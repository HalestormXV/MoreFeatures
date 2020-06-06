package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class InformationCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("information")
                .requires(source -> source.hasPermissionLevel(3))
                .then(Commands.argument("player", StringArgumentType.string())
                        .executes(context -> getInformation(context.getSource(), StringArgumentType.getString(context, "player"))))
        );
    }

    public static int getInformation(CommandSource source, String inputPlayerUsername) {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            world.getPlayers().stream().forEach(playerEntity -> {
                int amountOfPlayers = world.getPlayers().size();
                int amountOfTimesPlayerCouldNotBeFound = 0;
                if (playerEntity.getScoreboardName().equals(inputPlayerUsername)) {
                    String playerUUID = playerEntity.getUniqueID().toString();
                    double playerPosX = playerEntity.getPosX();
                    double playerPosY = playerEntity.getPosY();
                    double playerPosZ = playerEntity.getPosZ();
                    source.sendFeedback(new StringTextComponent("Username: " + inputPlayerUsername + ", UUID: " + playerUUID + ", Coordinates: " + playerPosX + " " + playerPosY + " " + playerPosZ), true);
                } else {
                    amountOfTimesPlayerCouldNotBeFound++;
                }
                if (amountOfTimesPlayerCouldNotBeFound == amountOfPlayers) {
                    source.sendErrorMessage(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".hunger.invalid_username"));
                }
            });
        }
        return 1;
    }
}
