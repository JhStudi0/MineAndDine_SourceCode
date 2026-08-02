package net.jhstudios.mineanddine;

import net.fabricmc.api.ModInitializer;

import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.block.custom.CornGrinderBlock;
import net.jhstudios.mineanddine.block.entity.ModBlockEntities;
import net.jhstudios.mineanddine.entity.ModEntities;
import net.jhstudios.mineanddine.item.ModItemGroups;
import net.jhstudios.mineanddine.item.ModItems;
import net.jhstudios.mineanddine.loot.ModLootTableModifiers;
import net.jhstudios.mineanddine.recipe.ModRecipes;
import net.jhstudios.mineanddine.screen.ModScreenHandlers;
import net.minecraft.block.ComposterBlock;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MineAndDine implements ModInitializer {
    public static final String MOD_ID = "mineanddine";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModEntities.registerModEntities();
        ModBlockEntities.registerBlockEntities();
        ModScreenHandlers.registerScreenHandlers();

        ModRecipes.RegisterRecipes();

        ModLootTableModifiers.register();

        //Composting
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CORN_STEM, 0.4f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CORN, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.CORN_SEEDS, 0.25f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TOMATO, 0.5f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.TOMATO_SEEDS, 0.25f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.RICE_SEEDS, 0.25f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.VANILLA_BEAN, 0.3f);
        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.VANILLA_SEEDS, 0.25f);

        ComposterBlock.ITEM_TO_LEVEL_INCREASE_CHANCE.put(ModItems.POPPY_SEEDS, 0.25f);

    }
}
