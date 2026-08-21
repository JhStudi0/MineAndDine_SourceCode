package net.jhstudios.mineanddine.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jhstudios.mineanddine.recipe.ModRecipes;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public record CookingPotRecipe(DefaultedList<Ingredient> ingredients, Optional<Ingredient> container, ItemStack output, int cookTime) implements Recipe<CookingPotRecipeInput> {


    @Override
    public boolean matches(CookingPotRecipeInput input, World world) {
        List<ItemStack> remaining = new ArrayList<>();

        for (int i = 0; i < input.getSize(); i++) {
            ItemStack stack = input.getStackInSlot(i);

            if (!stack.isEmpty()) {
                remaining.add(stack.copy());
            }
        }

        if (remaining.size() != ingredients.size()) {
            return false;
        }

        for (Ingredient ingredient : ingredients) {
            boolean matched = false;

            Iterator<ItemStack> iterator = remaining.iterator();

            while (iterator.hasNext()){
                ItemStack stack = iterator.next();

                if (ingredient.test(stack)) {
                    iterator.remove();
                    matched = true;
                    break;
                }
            }
            if (!matched){
                return false;
            }
        }
        return remaining.isEmpty();
    }

    @Override
    public ItemStack craft(CookingPotRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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
        return ModRecipes.COOKING_POT_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.COOKING_POT_TYPE;
    }


    public static class Serializer implements RecipeSerializer<CookingPotRecipe> {

        public static final MapCodec<CookingPotRecipe> CODEC =
                RecordCodecBuilder.mapCodec(instance -> instance.group(
                        Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").forGetter(CookingPotRecipe::ingredients),
                        Ingredient.DISALLOW_EMPTY_CODEC.optionalFieldOf("container").forGetter(CookingPotRecipe::container),
                        ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(CookingPotRecipe::output),
                        com.mojang.serialization.Codec.INT.optionalFieldOf("cook_time", 200).forGetter(CookingPotRecipe::cookTime)
                ).apply(instance, (ingredients, container, result, cookTime) -> new CookingPotRecipe(DefaultedList.copyOf(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0])), container, result, cookTime)));



        public static final PacketCodec<RegistryByteBuf, CookingPotRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC.collect(PacketCodecs.toList()),
                recipe -> new ArrayList<>(recipe.ingredients()),
                PacketCodecs.optional(Ingredient.PACKET_CODEC), CookingPotRecipe::container,
                ItemStack.PACKET_CODEC, CookingPotRecipe::output,
                PacketCodecs.INTEGER, CookingPotRecipe::cookTime,
                ((ingredients,container, result, cookTime) -> new CookingPotRecipe(DefaultedList.copyOf(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0])), container, result, cookTime)));


        @Override
        public MapCodec<CookingPotRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, CookingPotRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}
