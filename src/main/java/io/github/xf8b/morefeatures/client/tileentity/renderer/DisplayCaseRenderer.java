package io.github.xf8b.morefeatures.client.tileentity.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import io.github.xf8b.morefeatures.tileentity.DisplayCaseTileEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class DisplayCaseRenderer extends TileEntityRenderer<DisplayCaseTileEntity> {
    private float angle;

    public DisplayCaseRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        angle = 0f;
    }

    @Override
    public void render(DisplayCaseTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        NonNullList<ItemStack> items = tileEntityIn.getItems();
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                matrixStackIn.push();
                matrixStackIn.translate(0.5d, 0.5d, 0.5d);
                matrixStackIn.scale(0.9f, 0.9f, 0.9f);
                //matrixStackIn.translate(0d, Math.sin(Math.PI) / 4d, 0d);
                angle = angle + 0.5f;
                matrixStackIn.rotate(Vector3f.YP.rotationDegrees(angle));
                renderItem(stack, matrixStackIn, bufferIn, combinedLightIn);
                matrixStackIn.pop();
            }
        }
    }

    private void renderItem(ItemStack stack, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn) {
        Minecraft.getInstance().getItemRenderer().renderItem(stack, ItemCameraTransforms.TransformType.FIXED, combinedLightIn, OverlayTexture.NO_OVERLAY, matrixStackIn, bufferIn);
    }
}
