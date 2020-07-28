package io.github.xf8b.morefeatures.commands;

import com.mojang.brigadier.CommandDispatcher;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.TranslatableText;
import net.minecraft.world.World;

public class InformationCommand {
    public static void register(CommandDispatcher<ServerCommandSource> dispatcher) {
        dispatcher.register(CommandManager.literal("information")
                .requires(source -> source.hasPermissionLevel(3))
                .then(CommandManager.argument("player", EntityArgumentType.player())
                        .executes(context -> getInformation(context.getSource(),
                                EntityArgumentType.getPlayer(context, "player"))))
        );
    }

    public static int getInformation(ServerCommandSource source, ServerPlayerEntity playerEntity) {
        World world = source.getWorld();
        if (!world.getPlayers().isEmpty()) {
            String playerUUID = playerEntity.getUuid().toString();
            String username = playerEntity.getEntityName();
            double playerPosX = playerEntity.getX();
            double playerPosY = playerEntity.getY();
            double playerPosZ = playerEntity.getZ();
            source.sendFeedback(new TranslatableText("command." + MoreFeatures.MOD_ID + ".information.success", username, playerUUID, playerPosX, playerPosY, playerPosZ), true);
        }
        return 1;
    }
}
