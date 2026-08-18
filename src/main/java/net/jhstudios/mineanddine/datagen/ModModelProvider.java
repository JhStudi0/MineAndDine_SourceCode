package net.jhstudios.mineanddine.datagen;

import com.ibm.icu.text.Normalizer2;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.block.custom.CropBlocks.*;
import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.data.client.*;
import org.spongepowered.asm.util.asm.MarkerNode;

public class ModModelProvider extends FabricModelProvider {

    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerCrop(ModBlocks.CORN_CROP, CornCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerCrop(ModBlocks.VANILLA_BEAN_CROP, VanillaBeanCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerCrop(ModBlocks.TOMATO_CROP, TomatoCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerCrop(ModBlocks.RICE_CROP, RiceCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6, 7, 8);
        blockStateModelGenerator.registerCrop(ModBlocks.ONION_CROP, OnionCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
        blockStateModelGenerator.registerCrop(ModBlocks.GARLIC_CROP, GarlicCropBlock.AGE, 0, 1, 2, 3, 4, 5, 6);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.POPCORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO, Models.GENERATED);
        itemModelGenerator.register(ModItems.TOMATO_SAUCE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.SALT, Models.GENERATED);
        itemModelGenerator.register(ModItems.VANILLA_BEAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.HONEY_COOKIE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUTTER, Models.GENERATED);
        itemModelGenerator.register(ModItems.MILK_CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_CHOCOLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.MILK_CHOCOLATE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.DARK_CHOCOLATE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.WHITE_CHOCOLATE_APPLE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHOCOLATE_CAKE, Models.GENERATED);
        itemModelGenerator.register(ModItems.POPPY_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.FLOUR, Models.GENERATED);
        itemModelGenerator.register(ModItems.JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.YEAST_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.FERMENTED_YEAST_JAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.RICE_BOWL, Models.GENERATED);
        itemModelGenerator.register(ModItems.BREAD_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSHI_COD, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUSHI_SALMON, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONIGIRI, Models.GENERATED);
        itemModelGenerator.register(ModItems.CHICKEN_LEG, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRILLED_CORN, Models.GENERATED);
        itemModelGenerator.register(ModItems.CORN_STEM, Models.GENERATED);
        itemModelGenerator.register(ModItems.PLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARAMEL, Models.GENERATED);
        itemModelGenerator.register(ModItems.ONION, Models.GENERATED);
        itemModelGenerator.register(ModItems.CREAM, Models.GENERATED);
        itemModelGenerator.register(ModItems.VEGETABLE_STOCK, Models.GENERATED);
        itemModelGenerator.register(ModItems.GARLIC, Models.GENERATED);
        itemModelGenerator.register(ModItems.CARROT_SOUP, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNFLOWER_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.GROUND_SUNFLOWER_SEEDS, Models.GENERATED);
        itemModelGenerator.register(ModItems.SUNFLOWER_OIL, Models.GENERATED);
        itemModelGenerator.register(ModItems.KNIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUN, Models.GENERATED);
        itemModelGenerator.register(ModItems.BUN_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKIE_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.ROLLING_PIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_TORTILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.TORTILLA, Models.GENERATED);
        itemModelGenerator.register(ModItems.BREAD_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIE_DOUGH, Models.GENERATED);
        itemModelGenerator.register(ModItems.POWDERED_SUGAR, Models.GENERATED);
        itemModelGenerator.register(ModItems.PIE_BASE, Models.GENERATED);
        itemModelGenerator.register(ModItems.PUMPKIN_SLICE, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRILLED_PUMPKIN_SLICE, Models.GENERATED);
    }
}
