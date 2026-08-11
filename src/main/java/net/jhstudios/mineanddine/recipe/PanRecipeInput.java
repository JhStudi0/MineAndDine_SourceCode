package net.jhstudios.mineanddine.recipe;

import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;
import net.minecraft.util.collection.DefaultedList;

public record PanRecipeInput(DefaultedList<ItemStack> inventory) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return inventory.get(slot);
    }

    @Override
    public int getSize() {
        return 6;
    }
}
