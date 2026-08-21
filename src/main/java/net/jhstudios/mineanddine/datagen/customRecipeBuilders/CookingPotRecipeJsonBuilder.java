package net.jhstudios.mineanddine.datagen.customRecipeBuilders;

import net.jhstudios.mineanddine.recipe.custom.CookingPotRecipe;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

import java.util.Optional;

public class CookingPotRecipeJsonBuilder {
    private final Item output;
    private final Optional<Ingredient> container;
    private final DefaultedList<Ingredient> inputs = DefaultedList.of();
    private final int cook_time;

    private CookingPotRecipeJsonBuilder(Optional<Ingredient> container, Item output, int cook_time) {
        this.output = output;
        this.container = container;
        this.cook_time = cook_time;
    }

    public static CookingPotRecipeJsonBuilder create(Ingredient container, Item output, int cook_time) {
        return new CookingPotRecipeJsonBuilder(Optional.of(container), output, cook_time);
    }

    public static CookingPotRecipeJsonBuilder create(Item output, int cook_time) {
        return new CookingPotRecipeJsonBuilder(Optional.empty(), output, cook_time);
    }

    public CookingPotRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.fromTag(tag));
    }

    public CookingPotRecipeJsonBuilder input(ItemConvertible itemProvider) {
        return this.input((ItemConvertible)itemProvider, 1);
    }

    public CookingPotRecipeJsonBuilder input(ItemConvertible itemProvider, int size) {
        for(int i = 0; i < size; ++i) {
            this.input(Ingredient.ofItems(new ItemConvertible[]{itemProvider}));
        }

        return this;
    }

    public CookingPotRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input((Ingredient)ingredient, 1);
    }

    public CookingPotRecipeJsonBuilder input(Ingredient ingredient, int size) {
        for(int i = 0; i < size; ++i) {
            this.inputs.add(ingredient);
        }

        return this;
    }

    public void offerTo(RecipeExporter exporter) {

        Identifier outputId = Registries.ITEM.getId(output);

        CookingPotRecipe recipe = new CookingPotRecipe(this.inputs, this.container, new ItemStack(output), this.cook_time);

        Identifier recipeId = Identifier.of(
                "mineanddine",
                outputId.getPath() + "_from_cooking_pot"
        );

        exporter.accept(
                recipeId,
                recipe,
                null
        );
    }
}
