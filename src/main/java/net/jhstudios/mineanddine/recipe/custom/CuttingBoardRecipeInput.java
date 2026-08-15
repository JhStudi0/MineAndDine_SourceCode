package net.jhstudios.mineanddine.recipe.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record CuttingBoardRecipeInput(ItemStack ingredient, ItemStack tool) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return switch (slot) {
            case 0 -> ingredient;
            case 1 -> tool;
            default -> ItemStack.EMPTY;
        };
    }

    @Override
    public int getSize() {
        return 2;
    }
}
