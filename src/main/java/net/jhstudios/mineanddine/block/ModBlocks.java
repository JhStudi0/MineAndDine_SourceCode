package net.jhstudios.mineanddine.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.block.custom.*;
import net.jhstudios.mineanddine.block.custom.CropBlocks.*;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.CakeBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block CORN_CROP = registerBlockWithoutBlockItem("corn_crop",
            new CornCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.YELLOW)));

    public static final Block TOMATO_CROP = registerBlockWithoutBlockItem("tomato_crop",
            new TomatoCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.RED)));

    public static final Block VANILLA_BEAN_CROP = registerBlockWithoutBlockItem("vanilla_bean_crop",
            new VanillaBeanCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.TERRACOTTA_BLACK)));

    public static final Block RICE_CROP = registerBlockWithoutBlockItem("rice_crop",
            new RiceCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.TERRACOTTA_YELLOW)));

    public static final Block ONION_CROP = registerBlockWithoutBlockItem("onion_crop",
            new OnionCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.BROWN)));

    public static final Block GARLIC_CROP = registerBlockWithoutBlockItem("garlic_crop",
            new GarlicCropBlock(AbstractBlock.Settings.create()
                    .noCollision()
                    .ticksRandomly()
                    .breakInstantly()
                    .sounds(BlockSoundGroup.CROP)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.WHITE_GRAY)));


    public static final Block YEAST_JAR = registerBlockWithoutBlockItem("yeast_jar",
            new YeastJarBlock(AbstractBlock.Settings.create()
                    .strength(0.3f)
                    .ticksRandomly()
                    .sounds(BlockSoundGroup.GLASS)
                    .pistonBehavior(PistonBehavior.DESTROY)
                    .mapColor(MapColor.OFF_WHITE)
                    .nonOpaque()));


    public static final Block CHOCOLATE_CAKE = registerBlockWithoutBlockItem("chocolate_cake",
            new CakeBlock(AbstractBlock.Settings.create()
                    .strength(0.5f)
                    .sounds(BlockSoundGroup.WOOL)
                    .mapColor(MapColor.BROWN)
                    .nonOpaque()));

    public static final Block COOKING_POT = registerBlock("cooking_pot",
            new CookingPotBlock(AbstractBlock.Settings.create()
                    .strength(2.5f)
                    .sounds(BlockSoundGroup.COPPER)
                    .mapColor(MapColor.STONE_GRAY)
                    .nonOpaque()));

    public static final Block PLATE = registerBlockWithoutBlockItem("plate",
            new PlateBlock(AbstractBlock.Settings.create()
                    .strength(1.25f)
                    .sounds(BlockSoundGroup.DECORATED_POT_SHATTER)
                    .mapColor(MapColor.WHITE)
                    .nonOpaque()));

    public static final Block CORN_GRINDER = registerBlock("corn_grinder",
            new CornGrinderBlock(AbstractBlock.Settings.create()
                    .strength(3.5f)
                    .sounds(BlockSoundGroup.STONE)
                    .mapColor(MapColor.STONE_GRAY)
                    .nonOpaque()));

    public static final Block STOVE = registerBlock("stove",
            new StoveBlock(AbstractBlock.Settings.create()
                    .strength(3.5f)
                    .sounds(BlockSoundGroup.TUFF_BRICKS)
                    .mapColor(MapColor.TERRACOTTA_GRAY)
                    .luminance(state -> 13)));


    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(MineAndDine.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(MineAndDine.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(MineAndDine.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        MineAndDine.LOGGER.info("Registering Mod Blocks for " + MineAndDine.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> {

        });
    }
}
