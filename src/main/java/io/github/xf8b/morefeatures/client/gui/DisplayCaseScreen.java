package io.github.xf8b.morefeatures.client.gui;

import com.mojang.blaze3d.systems.RenderSystem;
import io.github.xf8b.morefeatures.container.DisplayCaseScreenHandler;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class DisplayCaseScreen extends ContainerScreen<DisplayCaseScreenHandler> {
    private static final Identifier BACKGROUND_TEXTURE = new Identifier(MoreFeatures.MOD_ID, "textures/gui/display_case.png");

    public DisplayCaseScreen(DisplayCaseScreenHandler screenContainer, PlayerInventory inv, Text titleIn) {
        super(screenContainer, inv, titleIn);
        this.x = 0;
        this.y = 0;
        this.containerWidth = 175;
        this.containerHeight = 165;
    }

    @Override
    public void render(final int mouseX, final int mouseY, final float partialTicks) {
        this.renderBackground();
        super.render(mouseX, mouseY, partialTicks);
        this.drawMouseoverTooltip(mouseX, mouseY);
    }

    @Override
    protected void drawForeground(int mouseX, int mouseY) {
        super.drawForeground(mouseX, mouseY);
        this.font.draw(this.title.asFormattedString(), 8f, 6f, 4210752);
        this.font.draw(this.playerInventory.getDisplayName().asFormattedString(), 8f, 73f, 4210752);
    }

    @Override
    protected void drawBackground(float partialTicks, int mouseX, int mouseY) {
        RenderSystem.color4f(1f, 1f, 1f, 1f);
        this.minecraft.getTextureManager().bindTexture(BACKGROUND_TEXTURE);
        int x = (this.width - this.containerWidth) / 2;
        int y = (this.height - this.containerHeight) / 2;
        this.blit(x, y, 0, 0, this.containerWidth, this.containerHeight);
    }
}
