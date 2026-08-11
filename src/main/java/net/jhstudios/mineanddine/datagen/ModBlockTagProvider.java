package net.jhstudios.mineanddine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LadderBlock;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {

    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup lookup) {
        getOrCreateTagBuilder(ModTags.Blocks.WARM_BLOCKS)
                .add(Blocks.MAGMA_BLOCK)
                .add(Blocks.LAVA)
                .add(Blocks.FIRE)
                .add(Blocks.CAMPFIRE)
                .add(Blocks.SOUL_CAMPFIRE)
                .add(Blocks.SOUL_FIRE)
                .add(ModBlocks.STOVE);

        getOrCreateTagBuilder(ModTags.Blocks.NUTRITIONAL_BLOCKS)
                .add(Blocks.FARMLAND)
                .add(Blocks.DIRT)
                .add(Blocks.GRASS_BLOCK)
                .add(Blocks.GRAVEL)
                .add(Blocks.SUSPICIOUS_GRAVEL)
                .add(Blocks.SAND)
                .add(Blocks.SUSPICIOUS_SAND)
                .add(Blocks.RED_SAND)
                .add(Blocks.COARSE_DIRT);

    }
}
