package net.jhstudios.mineanddine.block.entity.renderer;

import net.jhstudios.mineanddine.block.custom.CuttingBoardBlock;
import net.jhstudios.mineanddine.block.custom.PlateBlock;
import net.jhstudios.mineanddine.block.entity.custom.CuttingBoardBlockEntity;
import net.jhstudios.mineanddine.block.entity.custom.PlateBlockEntity;
import net.minecraft.MinecraftVersion;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.OverlayTexture;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

public class CuttingBoardRenderer implements BlockEntityRenderer<CuttingBoardBlockEntity> {
    public CuttingBoardRenderer(BlockEntityRendererFactory.Context context){

    }

    @Override
    public void render(CuttingBoardBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemStack stack = entity.getItem();
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();
        matrices.push();
        matrices.translate(0.5f, 0.15f, 0.5f);
        matrices.scale(0.5f, 0.5f, 0.5f);

        switch (entity.getCachedState().get(CuttingBoardBlock.FACING)) {
            case SOUTH -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(180));
            case WEST -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(90));
            case EAST -> matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-90));
            default -> {}
        }

        matrices.multiply(RotationAxis.POSITIVE_X.rotationDegrees(90));

        itemRenderer.renderItem(stack, ModelTransformationMode.FIXED, getLightLevel(entity.getWorld(), entity.getPos()), OverlayTexture.DEFAULT_UV, matrices, vertexConsumers, entity.getWorld(), 1);
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos){
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
