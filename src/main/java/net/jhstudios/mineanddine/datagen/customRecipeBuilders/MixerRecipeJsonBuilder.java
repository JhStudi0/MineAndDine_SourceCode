package net.jhstudios.mineanddine.datagen.customRecipeBuilders;

import net.jhstudios.mineanddine.recipe.custom.CookingPotRecipe;
import net.jhstudios.mineanddine.recipe.custom.MixerRecipe;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.minecraft.util.collection.DefaultedList;

public class MixerRecipeJsonBuilder {
    private final Item output;
    private final DefaultedList<Ingredient> inputs = DefaultedList.of();
    private final int cook_time;

    private MixerRecipeJsonBuilder(Item output, int cook_time) {
        this.output = output;
        this.cook_time = cook_time;
    }

    public static MixerRecipeJsonBuilder create(Item output, int cook_time) {
        return new MixerRecipeJsonBuilder(output, cook_time);
    }

    public MixerRecipeJsonBuilder input(TagKey<Item> tag) {
        return this.input(Ingredient.fromTag(tag));
    }

    public MixerRecipeJsonBuilder input(ItemConvertible itemProvider) {
        return this.input((ItemConvertible)itemProvider, 1);
    }

    public MixerRecipeJsonBuilder input(ItemConvertible itemProvider, int size) {
        for(int i = 0; i < size; ++i) {
            this.input(Ingredient.ofItems(new ItemConvertible[]{itemProvider}));
        }

        return this;
    }

    public MixerRecipeJsonBuilder input(Ingredient ingredient) {
        return this.input((Ingredient)ingredient, 1);
    }

    public MixerRecipeJsonBuilder input(Ingredient ingredient, int size) {
        for(int i = 0; i < size; ++i) {
            this.inputs.add(ingredient);
        }

        return this;
    }

    public void offerTo(RecipeExporter exporter) {

        Identifier outputId = Registries.ITEM.getId(output);

        MixerRecipe recipe = new MixerRecipe(this.inputs, new ItemStack(output), this.cook_time);

        Identifier recipeId = Identifier.of(
                "mineanddine",
                outputId.getPath() + "_from_mixer"
        );

        exporter.accept(
                recipeId,
                recipe,
                null
        );
    }
}
