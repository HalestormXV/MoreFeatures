package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.xf8b.morefeatures.MoreFeatures;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;

public class InformationCommand {
    public static void register(CommandDispatcher<CommandSource> dispatcher) {
        dispatcher.register(Commands.literal("information")
                .requires(source -> source.hasPermissionLevel(3))
                .then(Commands.argument("player", EntityArgument.player())
                        .executes(context -> getInformation(context.getSource(),
                                EntityArgument.getPlayer(context, "player"))))
        );
    }

    public static int getInformation(CommandSource source, ServerPlayerEntity playerEntity) {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            String playerUUID = playerEntity.getUniqueID().toString();
            String username = playerEntity.getScoreboardName();
            double playerPosX = playerEntity.getPosX();
            double playerPosY = playerEntity.getPosY();
            double playerPosZ = playerEntity.getPosZ();
            source.sendFeedback(new TranslationTextComponent("command." + MoreFeatures.MOD_ID + ".information.success", username, playerUUID, playerPosX, playerPosY, playerPosZ), true);
        }
        return 1;
    }
}
