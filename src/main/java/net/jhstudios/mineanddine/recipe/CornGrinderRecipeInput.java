package net.jhstudios.mineanddine.recipe;


import com.sun.jna.platform.unix.X11;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.input.RecipeInput;

public record CornGrinderRecipeInput(ItemStack input) implements RecipeInput {
    @Override
    public ItemStack getStackInSlot(int slot) {
        return input;
    }

    @Override
    public int getSize() {
        return 1;
    }
}
