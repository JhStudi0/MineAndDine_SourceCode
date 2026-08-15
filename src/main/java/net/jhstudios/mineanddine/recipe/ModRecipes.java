package net.jhstudios.mineanddine.recipe;

import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.recipe.custom.*;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModRecipes {

    public static final RecipeSerializer<CornGrinderRecipe> CORN_GRINDER_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MineAndDine.MOD_ID, "corn_grinder"), new CornGrinderRecipe.Serializer());

    public static final RecipeType<CornGrinderRecipe> CORN_GRINDER_TYPE = Registry.register(Registries.RECIPE_TYPE, Identifier.of(MineAndDine.MOD_ID, "corn_grinder"), new RecipeType<CornGrinderRecipe>() {
        @Override
        public String toString() {
            return "corn_grinder";
        }
    });

    public static final RecipeSerializer<CookingPotRecipe> COOKING_POT_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MineAndDine.MOD_ID, "cooking_pot"), new CookingPotRecipe.Serializer());

    public static final RecipeType<CookingPotRecipe> COOKING_POT_TYPE = Registry.register(Registries.RECIPE_TYPE, Identifier.of(MineAndDine.MOD_ID, "cooking_pot"), new RecipeType<CookingPotRecipe>() {
        @Override
        public String toString() {
            return "cooking_pot";
        }
    });

    public static final RecipeSerializer<PanRecipe> PAN_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MineAndDine.MOD_ID, "pan"), new PanRecipe.Serializer());

    public static final RecipeType<PanRecipe> PAN_TYPE = Registry.register(Registries.RECIPE_TYPE, Identifier.of(MineAndDine.MOD_ID, "pan"), new RecipeType<PanRecipe>() {
        @Override
        public String toString() {
            return "pan";
        }
    });

    public static final RecipeSerializer<MixerRecipe> MIXER_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MineAndDine.MOD_ID, "mixer"), new MixerRecipe.Serializer());

    public static final RecipeType<MixerRecipe> MIXER_TYPE = Registry.register(Registries.RECIPE_TYPE, Identifier.of(MineAndDine.MOD_ID, "pan"), new RecipeType<MixerRecipe>() {
        @Override
        public String toString() {
            return "pan";
        }
    });

    public static final RecipeSerializer<CuttingBoardRecipe> CUTTING_BOARD_SERIALIZER = Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MineAndDine.MOD_ID, "cutting_board"), new CuttingBoardRecipe.Serializer());

    public static final RecipeType<CuttingBoardRecipe> CUTTING_BOARD_TYPE = Registry.register(Registries.RECIPE_TYPE, Identifier.of(MineAndDine.MOD_ID, "cutting_board"), new RecipeType<CuttingBoardRecipe>() {
        @Override
        public String toString() {
            return "cutting_board";
        }
    });



    public static void RegisterRecipes(){
        MineAndDine.LOGGER.info("Registering Custom Recipes for " + MineAndDine.MOD_ID);
    }

}
