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
import net.minecraft.world.World;

public record CuttingBoardRecipe(Ingredient ingredient, Ingredient tool, ItemStack output) implements Recipe<CuttingBoardRecipeInput> {

    @Override
    public boolean matches(CuttingBoardRecipeInput input, World world) {
        return ingredient.test(input.ingredient()) && tool.test(input.tool());
    }

    @Override
    public ItemStack craft(CuttingBoardRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
        return output.copy();
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
        return output.copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.CUTTING_BOARD_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.CUTTING_BOARD_TYPE;
    }

    public static class Serializer implements RecipeSerializer<CuttingBoardRecipe> {

        public static final MapCodec<CuttingBoardRecipe> CODEC =
                RecordCodecBuilder.mapCodec(instance ->
                        instance.group(
                                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("ingredient").forGetter(CuttingBoardRecipe::ingredient),
                                Ingredient.DISALLOW_EMPTY_CODEC.fieldOf("tool").forGetter(CuttingBoardRecipe::tool),
                                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(CuttingBoardRecipe::output)
                        ).apply(instance, CuttingBoardRecipe::new));

        public static final PacketCodec<RegistryByteBuf, CuttingBoardRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC, CuttingBoardRecipe::ingredient,
                Ingredient.PACKET_CODEC, CuttingBoardRecipe::tool,
                ItemStack.PACKET_CODEC, CuttingBoardRecipe::output,
                CuttingBoardRecipe::new
        );

        @Override
        public MapCodec<CuttingBoardRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CuttingBoardRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
