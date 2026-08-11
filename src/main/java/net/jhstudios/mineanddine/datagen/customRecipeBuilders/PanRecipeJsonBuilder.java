package net.jhstudios.mineanddine.datagen.customRecipeBuilders;

import net.jhstudios.mineanddine.recipe.PanRecipe;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.entity.ai.goal.BreakDoorGoal;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class PanRecipeJsonBuilder {
    private final Item output;
    private final Ingredient container;
    private final DefaultedList<Ingredient> inputs = DefaultedList.of();
    private final int cook_time;

    private PanRecipeJsonBuilder(Ingredient container, Item output, int cook_time) {
        this.output = output;
        this.container = container;
        this.cook_time = cook_time;
    }

    public static PanRecipeJsonBuilder create(Ingredient container, Item output, int cook_time) {
        return new PanRecipeJsonBuilder(container, output, cook_time);
    }

    public PanRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.fromTag(tag));
    }

    public PanRecipeJsonBuilder input(ItemConvertible itemProvider) {
        return this.input((ItemConvertible)itemProvider, 1);
    }

    public PanRecipeJsonBuilder input(ItemConvertible itemProvider, int size) {
        for(int i = 0; i < size; ++i) {
            this.input(Ingredient.ofItems(new ItemConvertible[]{itemProvider}));
        }

        return this;
    }

    public PanRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input((Ingredient)ingredient, 1);
    }

    public PanRecipeJsonBuilder input(Ingredient ingredient, int size) {
        for(int i = 0; i < size; ++i) {
            this.inputs.add(ingredient);
        }

        return this;
    }

    public void offerTo(RecipeExporter exporter) {

        Identifier outputId = Registries.ITEM.getId(output);

        PanRecipe recipe = new PanRecipe(this.inputs, this.container, new ItemStack(output), this.cook_time);

        Identifier recipeId = Identifier.of(
                "mineanddine",
                outputId.getPath() + "_from_pan"
        );

        exporter.accept(
                recipeId,
                recipe,
                null
        );
    }
}
