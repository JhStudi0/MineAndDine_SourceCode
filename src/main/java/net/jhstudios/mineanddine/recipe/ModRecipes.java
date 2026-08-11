package net.jhstudios.mineanddine.recipe;

import net.jhstudios.mineanddine.MineAndDine;
import net.minecraft.recipe.Recipe;
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


    public static void RegisterRecipes(){
        MineAndDine.LOGGER.info("Registering Custom Recipes for " + MineAndDine.MOD_ID);
    }

}
