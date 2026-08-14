package net.jhstudios.mineanddine;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.block.entity.ModBlockEntities;
import net.jhstudios.mineanddine.block.entity.renderer.PlateBlockRenderer;
import net.jhstudios.mineanddine.entity.ModEntities;
import net.jhstudios.mineanddine.screen.ModScreenHandlers;
import net.jhstudios.mineanddine.screen.custom.CookingPotScreen;
import net.jhstudios.mineanddine.screen.custom.CornGrinderScreen;
import net.jhstudios.mineanddine.screen.custom.MixerScreen;
import net.jhstudios.mineanddine.screen.custom.PanScreen;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.client.render.entity.FlyingItemEntityRenderer;
import net.minecraft.util.Hand;

public class MineAndDineClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {

        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CORN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TOMATO_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.VANILLA_BEAN_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.RICE_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.ONION_CROP, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GARLIC_CROP, RenderLayer.getCutout());

        EntityRendererRegistry.register(ModEntities.ROCK, FlyingItemEntityRenderer::new);

        HandledScreens.register(ModScreenHandlers.COOKING_POT_SCREEN_HANDLER, CookingPotScreen::new);

        BlockEntityRendererFactories.register(ModBlockEntities.PLATE_BE, PlateBlockRenderer::new);

        HandledScreens.register(ModScreenHandlers.CORN_GRINDER_SCREEN_HANDLER, CornGrinderScreen::new);

        HandledScreens.register(ModScreenHandlers.PAN_SCREEN_HANDLER, PanScreen::new);

        HandledScreens.register(ModScreenHandlers.MIXER_SCREEN_HANLDER, MixerScreen::new);
    }
}
