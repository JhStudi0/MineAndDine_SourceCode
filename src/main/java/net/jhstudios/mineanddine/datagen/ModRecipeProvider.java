package net.jhstudios.mineanddine.datagen;

import com.sun.jna.platform.unix.X11;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.datagen.customRecipeBuilders.*;
import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.command.argument.packrat.Cut;
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

import javax.sound.sampled.Mixer;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        List<ItemConvertible> POPCORN_SMELTABLES = List.of(ModItems.CORN_SEEDS);
        offerSmelting(exporter, POPCORN_SMELTABLES, RecipeCategory.FOOD, ModItems.POPCORN, 0.25f, 100, "popcorn");

        List<ItemConvertible> BREAD_DOUGH_SMELTABLES = List.of(ModItems.BREAD_DOUGH);
        offerSmelting(exporter, BREAD_DOUGH_SMELTABLES, RecipeCategory.FOOD, Items.BREAD, 0.25f, 400, "bread_dough");

        List<ItemConvertible> BUN_DOUGH_SMELTABLES = List.of(ModItems.BUN_DOUGH);
        offerSmelting(exporter, BUN_DOUGH_SMELTABLES, RecipeCategory.FOOD, ModItems.BUN, 0.25f, 400, "bun_dough");

        List<ItemConvertible> GRILLED_CORN_SMELTABLES = List.of(ModItems.CORN);
        offerSmelting(exporter, GRILLED_CORN_SMELTABLES, RecipeCategory.FOOD, ModItems.GRILLED_CORN, 0.25f, 300, "grilled_corn");

        List<ItemConvertible> COOKIE_DOUGH_SMELTABLES = List.of(ModItems.COOKIE_DOUGH);
        offerSmelting(exporter, COOKIE_DOUGH_SMELTABLES, RecipeCategory.FOOD, Items.COOKIE, 0.5f, 400, "cookie_dough");

        List<ItemConvertible> PUMPKIN_SLICE_SMELTABLES = List.of(ModItems.PUMPKIN_SLICE);
        offerSmelting(exporter, PUMPKIN_SLICE_SMELTABLES, RecipeCategory.FOOD, ModItems.GRILLED_PUMPKIN_SLICE, 0.25f, 300, "grilled_pumpkin_slice");

        List<ItemConvertible> PUMPKIN_PIE_SMELTABLES = List.of(ModItems.RAW_PUMPKIN_PIE);
        offerSmelting(exporter, PUMPKIN_PIE_SMELTABLES, RecipeCategory.FOOD, Items.PUMPKIN_PIE, 0.25f, 500, "pumpkin_pie");

        List<ItemConvertible> APPLE_PIE_SMELTABLES = List.of(ModItems.RAW_APPLE_PIE);
        offerSmelting(exporter, APPLE_PIE_SMELTABLES, RecipeCategory.FOOD, ModItems.APPLE_PIE, 0.25f, 500, "apple_pie");




        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.CORN_SEEDS, 2)
                .input(ModItems.CORN)
                .criterion(hasItem(ModItems.CORN), conditionsFromItem(ModItems.CORN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.TOMATO_SEEDS, 2)
                .input(ModItems.TOMATO)
                .criterion(hasItem(ModItems.TOMATO), conditionsFromItem(ModItems.TOMATO))
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

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.SUNFLOWER_OIL)
                .input(Items.GLASS_BOTTLE)
                .input(Items.POTION)
                .input(ModItems.GROUND_SUNFLOWER_SEEDS)
                .criterion(hasItem(ModItems.GROUND_SUNFLOWER_SEEDS), conditionsFromItem(ModItems.GROUND_SUNFLOWER_SEEDS))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_PUMPKIN_PIE)
                .input(ModItems.PIE_BASE)
                .input(ModItems.GRILLED_PUMPKIN_SLICE)
                .input(Items.EGG)
                .input(ModItems.CINNAMON_POWDER)
                .criterion(hasItem(Items.PUMPKIN), conditionsFromItem(Items.PUMPKIN))
                .offerTo(exporter);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_APPLE_PIE)
                .input(ModItems.APPLE_CHUNKS, 2)
                .input(ModItems.PIE_BASE)
                .input(ModItems.CINNAMON_POWDER)
                .input(Items.SUGAR)
                .criterion(hasItem(ModItems.PIE_BASE), conditionsFromItem(ModItems.PIE_BASE))
                .offerTo(exporter);




        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.POPPY_SEEDS, 4)
                .pattern("RR")
                .pattern("RR")
                .input('R', Items.POPPY)
                .criterion(hasItem(Items.POPPY), conditionsFromItem(Items.POPPY))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.SUNFLOWER_SEEDS, 4)
                .pattern("SS")
                .pattern("SS")
                .input('S', Items.SUNFLOWER)
                .criterion(hasItem(Items.SUNFLOWER), conditionsFromItem(Items.SUNFLOWER))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.BUILDING_BLOCKS, Items.COBBLESTONE)
                .pattern("RR")
                .pattern("RR")
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
                .input('S', Blocks.STONE_BRICKS)
                .input('G', Blocks.GRINDSTONE)
                .criterion(hasItem(Items.GRINDSTONE), conditionsFromItem(Items.GRINDSTONE))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.PLATE, 3)
                .pattern("BBB")
                .pattern(" W ")
                .input('B', Items.BRICK)
                .input('W', Items.WHITE_DYE)
                .criterion(hasItem(Items.BRICK), conditionsFromItem(Items.BRICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.COOKING_POT)
                .pattern("C C")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .criterion(hasItem(Items.COPPER_INGOT), conditionsFromItem(Items.COPPER_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.PAN)
                .pattern("N N")
                .pattern("CCC")
                .input('C', Items.COPPER_INGOT)
                .input('N', Items.IRON_NUGGET)
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
                .pattern("D")
                .pattern("B")
                .input('D', Blocks.POLISHED_DEEPSLATE_SLAB)
                .input('B', Blocks.BRICKS)
                .criterion(hasItem(Blocks.BRICKS), conditionsFromItem(Blocks.BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.CUTTING_BOARD)
                .pattern("SS")
                .input('S', ItemTags.WOODEN_SLABS)
                .criterion("has Wooden Slab", conditionsFromTag(ItemTags.WOODEN_SLABS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.KNIFE)
                .pattern("I")
                .pattern("S")
                .input('I', Items.IRON_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.IRON_INGOT), conditionsFromItem(Items.IRON_INGOT))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.ROLLING_PIN)
                .pattern("SPS")
                .input('S', Items.STICK)
                .input('P', ItemTags.PLANKS)
                .criterion("has Plank", conditionsFromTag(ItemTags.PLANKS))
                .offerTo(exporter);



        CornGrinderRecipeJsonBuilder.create(Items.WHEAT, ModItems.FLOUR).offerTo(exporter);

        CornGrinderRecipeJsonBuilder.create(Items.SUGAR_CANE, Items.SUGAR).offerTo(exporter);

        CornGrinderRecipeJsonBuilder.create(ModItems.SUNFLOWER_SEEDS, ModItems.GROUND_SUNFLOWER_SEEDS).offerTo(exporter);

        CornGrinderRecipeJsonBuilder.create(Items.COBBLESTONE, ModItems.ROCK, 4).offerTo(exporter);

        CornGrinderRecipeJsonBuilder.create(Items.SUGAR, ModItems.POWDERED_SUGAR).offerTo(exporter);

        CornGrinderRecipeJsonBuilder.create(ModItems.CINNAMON_STICK, ModItems.CINNAMON_POWDER).offerTo(exporter);



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


        PanRecipeJsonBuilder.create(Items.COOKED_BEEF, 300)
                .input(Items.BEEF)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(Items.COOKED_CHICKEN, 300)
                .input(Items.CHICKEN)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(Items.COOKED_PORKCHOP, 300)
                .input(Items.PORKCHOP)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(Items.COOKED_MUTTON, 300)
                .input(Items.MUTTON)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(Items.COOKED_RABBIT, 300)
                .input(Items.RABBIT)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(Items.COOKED_COD, 300)
                .input(Items.COD)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(Items.COOKED_SALMON, 300)
                .input(Items.SALMON)
                .offerTo(exporter);

        PanRecipeJsonBuilder.create(ModItems.TORTILLA, 100)
                .input(ModItems.RAW_TORTILLA)
                .offerTo(exporter);



        MixerRecipeJsonBuilder.create(ModItems.BREAD_DOUGH, 200)
                .input(ModItems.FLOUR)
                .input(ModItems.FERMENTED_YEAST_JAR)
                .input(Items.WATER_BUCKET)
                .input(ModItems.SALT)
                .offerTo(exporter);

        MixerRecipeJsonBuilder.create(ModItems.COOKIE_DOUGH,3,  200)
                .input(ModItems.BUTTER)
                .input(Items.SUGAR)
                .input(Items.EGG, 1)
                .input(ModItems.FLOUR)
                .input(ModItems.SALT)
                .input(ModItems.DARK_CHOCOLATE)
                .offerTo(exporter);

        MixerRecipeJsonBuilder.create(ModItems.CREAM, 500)
                .input(Items.MILK_BUCKET)
                .input(ModItems.BUTTER)
                .offerTo(exporter);

        MixerRecipeJsonBuilder.create(ModItems.TORTILLA_DOUGH, 200)
                .input(Items.WATER_BUCKET)
                .input(ModItems.FLOUR)
                .offerTo(exporter);

        MixerRecipeJsonBuilder.create(ModItems.PIE_DOUGH, 200)
                .input(ModItems.FLOUR)
                .input(ModItems.SALT)
                .input(ModItems.POWDERED_SUGAR)
                .input(ModItems.BUTTER)
                .input(Items.WATER_BUCKET)
                .offerTo(exporter);


        CuttingBoardRecipeJsonBuilder.create(Items.CHICKEN, ModItems.CHICKEN_LEG)
                .tool(ModItems.KNIFE)
                .outputCount(2)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(ModItems.BREAD_DOUGH, ModItems.BUN_DOUGH)
                .tool(ModItems.KNIFE)
                .outputCount(4)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(ModItems.TORTILLA_DOUGH, ModItems.RAW_TORTILLA)
                .tool(ModItems.ROLLING_PIN)
                .outputCount(3)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(Items.BREAD, ModItems.BREAD_SLICE)
                .tool(ModItems.KNIFE)
                .outputCount(4)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(ModItems.PIE_DOUGH, ModItems.PIE_BASE)
                .tool(ModItems.ROLLING_PIN)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(Items.PUMPKIN, ModItems.PUMPKIN_SLICE)
                .tool(ModItems.KNIFE)
                .outputCount(4)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(Items.JUNGLE_LOG, ModItems.CINNAMON_STICK)
                .tool(ModItems.KNIFE)
                .outputCount(4)
                .offerTo(exporter);

        CuttingBoardRecipeJsonBuilder.create(Items.APPLE, ModItems.APPLE_CHUNKS)
                .tool(ModItems.KNIFE)
                .offerTo(exporter);

    }

}
