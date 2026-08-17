package net.jhstudios.mineanddine.datagen.customRecipeBuilders;

import net.jhstudios.mineanddine.recipe.custom.CornGrinderRecipe;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

public class CornGrinderRecipeJsonBuilder {

    private final Item input;
    private final Item output;
    private final int count;



    private CornGrinderRecipeJsonBuilder(Item input, Item output, int count) {
        this.input = input;
        this.output = output;
        this.count = count;
    }

    public static CornGrinderRecipeJsonBuilder create(Item input, Item output, int count) {
        return new CornGrinderRecipeJsonBuilder(input, output, count);
    }

    public static CornGrinderRecipeJsonBuilder create(Item input, Item output) {
        return new CornGrinderRecipeJsonBuilder(input, output, 1);
    }


    public void offerTo(RecipeExporter exporter) {

        Identifier outputId = Registries.ITEM.getId(output);

        CornGrinderRecipe recipe = new CornGrinderRecipe(
                Ingredient.ofItems(input),
                new ItemStack(output, count)
        );

        Identifier recipeId = Identifier.of(
                "mineanddine",
                outputId.getPath() + "_from_corn_grinder"
        );

        exporter.accept(
                recipeId,
                recipe,
                null
        );
    }
}
