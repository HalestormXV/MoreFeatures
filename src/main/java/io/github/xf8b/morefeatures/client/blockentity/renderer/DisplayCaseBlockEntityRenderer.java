package io.github.xf8b.morefeatures.client.blockentity.renderer;

import io.github.xf8b.morefeatures.blockentities.DisplayCaseBlockEntity;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderDispatcher;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.item.ItemStack;
import net.minecraft.util.collection.DefaultedList;

@Environment(EnvType.CLIENT)
public class DisplayCaseBlockEntityRenderer extends BlockEntityRenderer<DisplayCaseBlockEntity> {
    private float angle;

    public DisplayCaseBlockEntityRenderer(BlockEntityRenderDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);
        angle = 0f;
    }

    @Override
    public void render(DisplayCaseBlockEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn, int combinedOverlayIn) {
        DefaultedList<ItemStack> items = tileEntityIn.getInvStackList();
        for (ItemStack stack : items) {
            if (!stack.isEmpty()) {
                matrixStackIn.push();
                matrixStackIn.translate(0.5d, 0.5d, 0.5d);
                matrixStackIn.scale(0.9f, 0.9f, 0.9f);
                angle = angle + 0.5f;
                if (angle > 360) {
                    angle = 0;
                }
                matrixStackIn.multiply(Vector3f.POSITIVE_Y.getDegreesQuaternion(angle));
                renderItem(stack, matrixStackIn, bufferIn, combinedLightIn);
                matrixStackIn.pop();
            }
        }
    }

    private void renderItem(ItemStack stack, MatrixStack matrixStackIn, VertexConsumerProvider bufferIn, int combinedLightIn) {
        MinecraftClient.getInstance().getItemRenderer().renderItem(stack, ModelTransformation.Mode.FIXED, combinedLightIn, OverlayTexture.DEFAULT_UV, matrixStackIn, bufferIn);
    }
}
