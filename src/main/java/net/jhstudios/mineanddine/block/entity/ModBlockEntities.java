package net.jhstudios.mineanddine.block.entity;

import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.block.entity.custom.CookingPotBlockEntity;

import net.jhstudios.mineanddine.block.entity.custom.CornGrinderBlockEntity;
import net.jhstudios.mineanddine.block.entity.custom.PlateBlockEntity;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<CookingPotBlockEntity> COOKING_POT_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MineAndDine.MOD_ID, "cooking_pot_be"),
                    BlockEntityType.Builder.create(CookingPotBlockEntity::new, ModBlocks.COOKING_POT).build());

    public static final BlockEntityType<PlateBlockEntity> PLATE_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MineAndDine.MOD_ID, "plate_be"),
                    BlockEntityType.Builder.create(PlateBlockEntity::new, ModBlocks.PLATE).build());

    public static final BlockEntityType<CornGrinderBlockEntity> CORN_GRINDER_BE =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MineAndDine.MOD_ID, "corn_grinder_be"),
                    BlockEntityType.Builder.create(CornGrinderBlockEntity::new, ModBlocks.CORN_GRINDER).build());





    public static void registerBlockEntities(){
        MineAndDine.LOGGER.info("Registering Block Entities for" + MineAndDine.MOD_ID);
    }
}
