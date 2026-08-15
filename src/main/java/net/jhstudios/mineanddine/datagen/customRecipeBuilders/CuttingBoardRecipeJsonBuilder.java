package net.jhstudios.mineanddine.datagen.customRecipeBuilders;

import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.block.custom.CuttingBoardBlock;
import net.jhstudios.mineanddine.recipe.custom.CuttingBoardRecipe;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class CuttingBoardRecipeJsonBuilder {

    private final Ingredient ingredient;
    private Ingredient tool;
    private final ItemStack output;

    private CuttingBoardRecipeJsonBuilder(Ingredient ingredient, ItemStack output){
        this.ingredient = ingredient;
        this.output = output;

    }

    public static CuttingBoardRecipeJsonBuilder create(ItemConvertible ingredient, ItemConvertible output) {
        return new CuttingBoardRecipeJsonBuilder(Ingredient.ofItems(ingredient), new ItemStack(output));
    }

    public static CuttingBoardRecipeJsonBuilder create(Ingredient ingredient, ItemConvertible output) {
        return new CuttingBoardRecipeJsonBuilder(ingredient, new ItemStack(output));
    }

    public CuttingBoardRecipeJsonBuilder tool (TagKey<Item> tag) {
        this.tool = Ingredient.fromTag(tag);
        return this;
    }

    public CuttingBoardRecipeJsonBuilder tool (Item tool) {
        this.tool = Ingredient.ofItems(tool);
        return this;
    }

    public CuttingBoardRecipeJsonBuilder outputCount(int count) {
        this.output.setCount(count);
        return this;
    }

    public void offerTo(RecipeExporter exporter) {
        if (tool == null) {
            throw new IllegalStateException("Cutting Recipe is missing tool!");
        }

        Identifier outputId = Registries.ITEM.getId(output.getItem());
        CuttingBoardRecipe recipe = new CuttingBoardRecipe(ingredient, tool, output);

        Identifier recipeId = Identifier.of(MineAndDine.MOD_ID, outputId.getPath() + "_from_cutting_board");

        exporter.accept(recipeId, recipe, null);
    }
}
