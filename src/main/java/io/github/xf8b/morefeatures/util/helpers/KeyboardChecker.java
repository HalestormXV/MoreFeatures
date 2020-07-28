package io.github.xf8b.morefeatures.util.helpers;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class KeyboardChecker {
    private static final long WINDOW = MinecraftClient.getInstance().getWindow().getHandle();

    @Environment(EnvType.CLIENT)
    public static boolean isHoldingShift() {
        return InputUtil.isKeyPressed(WINDOW, GLFW.GLFW_KEY_LEFT_SHIFT) || InputUtil.isKeyPressed(WINDOW, GLFW.GLFW_KEY_RIGHT_SHIFT);
    }
}
