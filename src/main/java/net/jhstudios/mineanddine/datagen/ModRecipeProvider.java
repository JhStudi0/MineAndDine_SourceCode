package net.jhstudios.mineanddine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.datagen.customRecipeBuilders.CookingPotRecipeJsonBuilder;
import net.jhstudios.mineanddine.datagen.customRecipeBuilders.CornGrinderRecipeJsonBuilder;
import net.jhstudios.mineanddine.datagen.customRecipeBuilders.PanRecipeJsonBuilder;
import net.jhstudios.mineanddine.item.ModItems;
import net.jhstudios.mineanddine.recipe.PanRecipe;
import net.jhstudios.mineanddine.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> CORN_SMELTABLES = List.of(ModItems.CORN_SEEDS);
        offerSmelting(exporter, CORN_SMELTABLES, RecipeCategory.FOOD, ModItems.POPCORN, 0.25f, 100, "corn");

        List<ItemConvertible> BREAD_DOUGH = List.of(ModItems.BREAD_DOUGH);
        offerSmelting(exporter, BREAD_DOUGH, RecipeCategory.FOOD, Items.BREAD, 0.25f, 400, "bread_dough");

        List<ItemConvertible> GRILLED_CORN_SMELTABLES = List.of(ModItems.CORN);
        offerSmelting(exporter, GRILLED_CORN_SMELTABLES, RecipeCategory.FOOD, ModItems.GRILLED_CORN, 0.25f, 300, "grilled_corn");



        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CORN_SEEDS, 2)
                .input(ModItems.CORN)
                .criterion(hasItem(ModItems.CORN), conditionsFromItem(ModItems.CORN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS, 2)
                .input(ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
                .offerTo(exporter);


        ShapelessRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.ROCK, 4)
                .input(Items.COBBLESTONE)
                .criterion(hasItem(Items.COBBLESTONE), conditionsFromItem(Items.COBBLESTONE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.VANILLA_SEEDS, 1)
                .input(ModItems.VANILLA_BEAN)
                .criterion(hasItem(ModItems.VANILLA_BEAN), conditionsFromItem(ModItems.VANILLA_BEAN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.HONEY_COOKIE, 8)
                .input(ModItems.VANILLA_BEAN)
                .input(Items.HONEY_BOTTLE)
                .input(Items.WHEAT)
                .input(Items.EGG)
                .input(ModItems.SALT)
                .input(ModItems.BUTTER)
                .input(Items.SUGAR)
                .criterion(hasItem(Items.HONEY_BOTTLE), conditionsFromItem(Items.HONEY_BOTTLE))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.MILK_CHOCOLATE, 3)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.DARK_CHOCOLATE, 3)
                .input(Items.SUGAR)
                .input(Items.COCOA_BEANS)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.WHITE_CHOCOLATE, 3)
                .input(Items.SUGAR)
                .input(Items.MILK_BUCKET)
                .criterion(hasItem(Items.COCOA_BEANS), conditionsFromItem(Items.COCOA_BEANS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SUSHI_COD,4)
                .input(Items.DRIED_KELP)
                .input(ModItems.RICE_BOWL)
                .input(Items.COD)
                .criterion(hasItem(ModItems.RICE_BOWL), conditionsFromItem(ModItems.RICE_BOWL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SUSHI_SALMON, 4)
                .input(Items.DRIED_KELP)
                .input(ModItems.RICE_BOWL)
                .input(Items.SALMON)
                .criterion(hasItem(ModItems.RICE_BOWL), conditionsFromItem(ModItems.RICE_BOWL))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.ONIGIRI, 4)
                .input(Items.DRIED_KELP)
                .input(ModItems.RICE_BOWL)
                .criterion(hasItem(ModItems.RICE_BOWL), conditionsFromItem(ModItems.RICE_BOWL))
                .offerTo(exporter);



        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POPPY_SEEDS, 4)
                .pattern("RR ")
                .pattern("RR ")
                .pattern("   ")
                .input('R', Items.POPPY)
                .criterion(hasItem(Items.POPPY), conditionsFromItem(Items.POPPY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE)
                .pattern("RR ")
                .pattern("RR ")
                .pattern("   ")
                .input('R', ModItems.ROCK)
                .criterion(hasItem(ModItems.ROCK), conditionsFromItem(ModItems.ROCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CHOCOLATE_CAKE)
                .pattern("MMM")
                .pattern("SES")
                .pattern("WCW")
                .input('M', ModItems.MILK_CHOCOLATE)
                .input('S', Items.SUGAR)
                .input('E', Items.EGG)
                .input('W', Items.WHEAT)
                .input('C', Items.COCOA_BEANS)
                .criterion(hasItem(ModItems.MILK_CHOCOLATE), conditionsFromItem(ModItems.MILK_CHOCOLATE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.JAR, 3)
                .pattern(" B ")
                .pattern("G G")
                .pattern(" G ")
                .input('B', ItemTags.PLANKS)
                .input('G', Items.GLASS)
                .criterion(hasItem(Items.GLASS), conditionsFromItem(Items.GLASS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CORN_GRINDER)
                .pattern("SGS")
                .pattern("SGS")
                .pattern("   ")
                .input('S', Blocks.STONE_BRICKS)
                .input('G', Blocks.GRINDSTONE)
                .criterion(hasItem(Items.GRINDSTONE), conditionsFromItem(Items.GRINDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLATE, 3)
                .pattern("BBB")
                .pattern(" W ")
                .pattern("   ")
                .input('B', Items.BRICK)
                .input('W', Items.WHITE_DYE)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COOKING_POT)
                .pattern("   ")
                .pattern("C C")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.STOVE)
                .pattern("DDD")
                .pattern("BCB")
                .pattern("BBB")
                .input('B', Blocks.BRICKS)
                .input('C', Blocks.COAL_BLOCK)
                .input('D', Blocks.POLISHED_DEEPSLATE_SLAB)
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, ModBlocks.COUNTER)
                .pattern(" D ")
                .pattern(" B ")
                .pattern("   ")
                .input('D', Blocks.POLISHED_DEEPSLATE_SLAB)
                .input('B', Blocks.BRICKS)
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);




        CornGrinderRecipeJsonBuilder.create(Items.WHEAT, ModItems.FLOUR).offerTo(exporter);

        CornGrinderRecipeJsonBuilder.create(Items.SUGAR_CANE, Items.SUGAR).offerTo(exporter);



        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.BOWL), ModItems.RICE_BOWL, 400)
                .input(Items.WATER_BUCKET)
                .input(ModItems.RICE_SEEDS)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.BOWL), ModItems.TOMATO_SAUCE, 300)
                .input(ModItems.TOMATO, 2)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.BOWL), Items.BEETROOT_SOUP, 600)
                .input(Items.BEETROOT)
                .input(ModItems.ONION)
                .input(ModItems.VEGETABLE_STOCK)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.BOWL), Items.MUSHROOM_STEW, 600)
                .input(Items.BROWN_MUSHROOM, 2)
                .input(ModItems.CREAM)
                .input(ModItems.VEGETABLE_STOCK)
                .input(ModItems.BUTTER)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.BOWL), Items.RABBIT_STEW, 1200)
                .input(Items.RABBIT)
                .input(ModItems.ONION)
                .input(ModItems.CREAM)
                .input(Items.CARROT)
                .input(ModItems.GARLIC)
                .input(Items.POTATO)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.APPLE), ModItems.DARK_CHOCOLATE_APPLE, 300)
                .input(ModItems.DARK_CHOCOLATE)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.APPLE), ModItems.MILK_CHOCOLATE_APPLE, 300)
                .input(ModItems.MILK_CHOCOLATE)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.APPLE), ModItems.WHITE_CHOCOLATE_APPLE, 300)
                .input(ModItems.WHITE_CHOCOLATE)
                .offerTo(exporter);

        CookingPotRecipeJsonBuilder.create(Ingredient.ofItems(Items.BOWL), ModItems.CARROT_SOUP, 600)
                .input(ModItems.ONION)
                .input(Items.CARROT, 2)
                .input(Items.POTATO)
                .input(ModItems.CREAM)
                .input(ModItems.VEGETABLE_STOCK)
                .offerTo(exporter);


    }

}
