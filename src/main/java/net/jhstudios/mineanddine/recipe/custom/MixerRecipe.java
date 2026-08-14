package net.jhstudios.mineanddine.recipe.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.jhstudios.mineanddine.recipe.ModRecipes;
import net.jhstudios.mineanddine.recipe.custom.CookingPotRecipe;
import net.jhstudios.mineanddine.recipe.custom.CookingPotRecipeInput;
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

public record MixerRecipe(DefaultedList<Ingredient> ingredients, ItemStack output, int cookTime) implements Recipe<MixerRecipeInput> {

    @Override
    public boolean matches(MixerRecipeInput input, World world) {
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
    public ItemStack craft(MixerRecipeInput input, RegistryWrapper.WrapperLookup lookup) {
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
        return ModRecipes.MIXER_SERIALIZER;
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.MIXER_TYPE;
    }


    public static class Serializer implements RecipeSerializer<MixerRecipe> {

        public static final MapCodec<MixerRecipe> CODEC =
                RecordCodecBuilder.mapCodec(instance -> instance.group(
                        Ingredient.DISALLOW_EMPTY_CODEC.listOf().fieldOf("ingredients").forGetter(MixerRecipe::ingredients),
                        ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(MixerRecipe::output),
                        com.mojang.serialization.Codec.INT.optionalFieldOf("cook_time", 200).forGetter(MixerRecipe::cookTime)
                ).apply(instance, (ingredients, result, cookTime) -> new MixerRecipe(DefaultedList.copyOf(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0])), result, cookTime)));



        public static final PacketCodec<RegistryByteBuf, MixerRecipe> STREAM_CODEC = PacketCodec.tuple(
                Ingredient.PACKET_CODEC.collect(PacketCodecs.toList()),
                recipe -> new ArrayList<>(recipe.ingredients()),
                ItemStack.PACKET_CODEC, MixerRecipe::output,
                PacketCodecs.INTEGER, MixerRecipe::cookTime,
                ((ingredients, result, cookTime) -> new MixerRecipe(DefaultedList.copyOf(Ingredient.EMPTY, ingredients.toArray(new Ingredient[0])), result, cookTime)));


        @Override
        public MapCodec<MixerRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, MixerRecipe> packetCodec() {
            return STREAM_CODEC;
        }
    }
}

