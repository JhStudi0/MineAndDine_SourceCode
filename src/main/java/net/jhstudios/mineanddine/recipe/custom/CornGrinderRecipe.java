package net.jhstudios.mineanddine.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jhstudios.mineanddine.recipe.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public record CornGrinderRecipe(Ingredient inputItem, ItemStack output) implements Recipe<CornGrinderRecipeInput> {

    @Override
    public DefaultedList<Ingredient> getIngredients() {
        DefaultedList<Ingredient> list = DefaultedList.of();
        list.add(this.inputItem);
        return list;
    }

    @Override
    public boolean matches(CornGrinderRecipeInput input, World world) {
        if (world.isClient()) {
            return false;
        }

        return inputItem.test(input.getStackInSlot(0));
    }

    @Override
    public ItemStack craft(CornGrinderRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CORN_GRINDER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CORN_GRINDER_TYPE;
    }



    public static class Serializer implements RecipeSerializer<CornGrinderRecipe> {

        public static final MapCodec<CornGrinderRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CornGrinderRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(CornGrinderRecipe::output)
        ).apply(inst, CornGrinderRecipe::new));
        public static final PacketCodec<RegistryByteBuf, CornGrinderRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC, CornGrinderRecipe::inputItem,
                ItemStack.PACKET_CODEC, CornGrinderRecipe::output,
                CornGrinderRecipe::new);

        @Override
        public MapCodec<CornGrinderRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CornGrinderRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
