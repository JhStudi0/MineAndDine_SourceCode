package net.jhstudios.mineanddine.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.jhstudios.mineanddine.MineAndDine;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.item.custom.*;
import net.jhstudios.mineanddine.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import java.security.PublicKey;
import java.security.spec.DSAPublicKeySpec;

public class ModItems {

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(MineAndDine.MOD_ID, name), item);
    }

    public static final Item CORN_STEM = registerItem("corn_stem", new Item(new Item.Settings()));

    public static final Item CORN = registerItem("corn", new Item(new Item.Settings()
            .food(ModFoodComponents.CORN)));

    public static final Item GRILLED_CORN = registerItem("grilled_corn", new Item(new Item.Settings()
            .food(ModFoodComponents.GRILLED_CORN)));

    public static final Item CORN_SEEDS = registerItem("corn_seeds",
            new AliasedBlockItem(ModBlocks.CORN_CROP, new Item.Settings()));

    public static final Item POPCORN = registerItem("popcorn", new Item(new Item.Settings()
            .food(ModFoodComponents.CORN)));

    public static final Item TOMATO = registerItem("tomato", new Item(new Item.Settings()
            .food(ModFoodComponents.TOMATO)));

    public static final Item TOMATO_SEEDS = registerItem("tomato_seeds",
            new AliasedBlockItem(ModBlocks.TOMATO_CROP, new Item.Settings()));

    public static final Item TOMATO_SAUCE = registerItem("tomato_sauce", new BowlFoodItem(new Item.Settings()
            .food(ModFoodComponents.TOMATO_SAUCE)
            .maxCount(1)));

    public static final Item VANILLA_BEAN = registerItem("vanilla_bean", new Item(new Item.Settings()));

    public static final Item VANILLA_SEEDS = registerItem("vanilla_seeds",
            new AliasedBlockItem(ModBlocks.VANILLA_BEAN_CROP, new Item.Settings()));

    public static final Item CHOCOLATE_CAKE = registerItem("chocolate_cake",
            new AliasedBlockItem(ModBlocks.CHOCOLATE_CAKE, new Item.Settings()));

    public static final Item POPPY_SEEDS = registerItem("poppy_seeds",
            new AliasedBlockItem(Blocks.POPPY, new Item.Settings()));

    public static final Item SUNFLOWER_SEEDS = registerItem("sunflower_seeds",
            new AliasedBlockItem(Blocks.SUNFLOWER, new Item.Settings()));

    public static final Item GROUND_SUNFLOWER_SEEDS = registerItem("ground_sunflower_seeds", new Item(new Item.Settings()));

    public static final Item SUNFLOWER_OIL = registerItem("sunflower_oil", new Item(new Item.Settings()
            .food(ModFoodComponents.BUTTER)));

    public static final Item HONEY_COOKIE = registerItem("honey_cookie", new Item(new Item.Settings()
            .food(ModFoodComponents.HONEY_COOKIE)));

    public static final Item BUTTER = registerItem("butter", new Item(new Item.Settings()
            .food(ModFoodComponents.BUTTER)));

    public static final Item MILK_CHOCOLATE = registerItem("milk_chocolate", new Item(new Item.Settings()
            .food(ModFoodComponents.CHOCOLATE)));

    public static final Item DARK_CHOCOLATE = registerItem("dark_chocolate", new Item(new Item.Settings()
            .food(ModFoodComponents.CHOCOLATE)));

    public static final Item WHITE_CHOCOLATE = registerItem("white_chocolate", new Item(new Item.Settings()
            .food(ModFoodComponents.CHOCOLATE)));

    public static final Item MILK_CHOCOLATE_APPLE = registerItem("milk_chocolate_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.CHOCOLATE_APPLE)));

    public static final Item DARK_CHOCOLATE_APPLE = registerItem("dark_chocolate_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.CHOCOLATE_APPLE)));

    public static final Item WHITE_CHOCOLATE_APPLE = registerItem("white_chocolate_apple", new Item(new Item.Settings()
            .food(ModFoodComponents.CHOCOLATE_APPLE)));

    public static final Item RICE_SEEDS = registerItem("rice_seeds", new AliasedBlockItem(ModBlocks.RICE_CROP, new Item.Settings()));

    public static final Item RICE_BOWL = registerItem("rice_bowl", new BowlFoodItem(new Item.Settings()
            .food(ModFoodComponents.RICE_BOWL)
            .maxCount(1)));

    public static final Item CARROT_SOUP = registerItem("carrot_soup", new BowlFoodItem(new Item.Settings()
            .food(FoodComponents.BEETROOT_SOUP)
            .maxCount(1)));

    public static final Item ONION_SEEDS = registerItem("onion_seeds", new AliasedBlockItem(ModBlocks.ONION_CROP, new Item.Settings()));

    public static final Item GARLIC_SEEDS = registerItem("garlic_seeds", new AliasedBlockItem(ModBlocks.GARLIC_CROP, new Item.Settings()));

    public static final Item ROCK = registerItem("rock", new RockItem(new Item.Settings()));

    public static final Item SALT = registerItem("salt", new Item(new Item.Settings()));

    public static final Item FLOUR = registerItem("flour", new Item(new Item.Settings()));

    public static final Item JAR = registerItem("jar", new Item(new Item.Settings()));

    public static final Item YEAST_JAR = registerItem("yeast_jar", new BlockItem(ModBlocks.YEAST_JAR, new Item.Settings()));

    public static final Item FERMENTED_YEAST_JAR = registerItem("fermented_yeast_jar", new JarFoodItem(new Item.Settings()
            .maxCount(1)));

    public static final Item BREAD_DOUGH = registerItem("bread_dough", new JarFoodItem(new Item.Settings()
            .food(ModFoodComponents.BREAD_DOUGH)));

    public static final Item BREAD_SLICE = registerItem("bread_slice", new Item(new Item.Settings()
            .food(ModFoodComponents.TORTILLA)));

    public static final Item BUN_DOUGH = registerItem("bun_dough", new Item(new Item.Settings()
            .food(ModFoodComponents.BREAD_DOUGH)));

    public static final Item COOKIE_DOUGH = registerItem("cookie_dough", new Item(new Item.Settings()
            .food(ModFoodComponents.COOKIE_DOUGH)));

    public static final Item PIE_DOUGH = registerItem("pie_dough", new Item(new Item.Settings()
            .food(ModFoodComponents.COOKIE_DOUGH)));

    public static final Item POWDERED_SUGAR = registerItem("powdered_sugar", new Item(new Item.Settings()));

    public static final Item PIE_BASE = registerItem("pie_base", new Item(new Item.Settings()
            .food(ModFoodComponents.COOKIE_DOUGH)));

    public static final Item SUSHI_COD = registerItem("sushi_cod", new Item(new Item.Settings()
            .food(ModFoodComponents.SUSHI)));

    public static final Item SUSHI_SALMON = registerItem("sushi_salmon", new Item(new Item.Settings()
            .food(ModFoodComponents.SUSHI)));

    public static final Item ONIGIRI = registerItem("onigiri", new Item(new Item.Settings()
            .food(ModFoodComponents.SUSHI)));

    public static final Item CHICKEN_LEG = registerItem("chicken_leg", new Item(new Item.Settings()
            .food(ModFoodComponents.CHICKEN_LEG)));

    public static final Item PLATE = registerItem("plate", new BlockItem(ModBlocks.PLATE, new Item.Settings()));

    public static final Item CARAMEL = registerItem("caramel", new Item(new Item.Settings()
            .food(ModFoodComponents.CARAMEL)));

    public static final Item ONION = registerItem("onion", new Item(new Item.Settings()
            .food(ModFoodComponents.ONION)));

    public static final Item VEGETABLE_STOCK = registerItem("vegetable_stock", new Item(new Item.Settings()
            .maxCount(1)
            .food(ModFoodComponents.STOCK)));

    public static final Item CREAM = registerItem("cream", new Item(new Item.Settings()
            .food(ModFoodComponents.CREAM)));

    public static final Item GARLIC = registerItem("garlic", new Item(new Item.Settings()
            .food(ModFoodComponents.GARLIC)));

    public static final Item BUN = registerItem("bun", new Item(new Item.Settings()
            .food(FoodComponents.BREAD)));

    public static final Item TORTILLA_DOUGH = registerItem("tortilla_dough", new Item(new Item.Settings()
            .food(ModFoodComponents.BREAD_DOUGH)));

    public static final Item RAW_TORTILLA = registerItem("raw_tortilla", new Item(new Item.Settings()
            .food(ModFoodComponents.BREAD_DOUGH)));

    public static final Item TORTILLA = registerItem("tortilla", new Item(new Item.Settings()
            .food(ModFoodComponents.TORTILLA)));

    public static final Item PUMPKIN_SLICE = registerItem("pumpkin_slice", new Item(new Item.Settings()
            .food(FoodComponents.MELON_SLICE)));

    public static final Item GRILLED_PUMPKIN_SLICE = registerItem("grilled_pumpkin_slice", new Item(new Item.Settings()
            .food(FoodComponents.MELON_SLICE)));

    public static final Item RAW_PUMPKIN_PIE = registerItem("raw_pumpkin_pie", new Item(new Item.Settings()
            .food(ModFoodComponents.COOKIE_DOUGH)));

    public static final Item CINNAMON_POWDER = registerItem("cinnamon_powder", new Item(new Item.Settings()));

    public static final Item CINNAMON_STICK = registerItem("cinnamon_stick", new Item(new Item.Settings()));

    public static final Item APPLE_CHUNKS = registerItem("apple_chunks", new Item(new Item.Settings()
            .food(FoodComponents.APPLE)));

    public static final Item RAW_APPLE_PIE = registerItem("raw_apple_pie", new Item(new Item.Settings()
            .food(ModFoodComponents.COOKIE_DOUGH)));

    public static final Item APPLE_PIE = registerItem("apple_pie", new Item(new Item.Settings()
            .food(FoodComponents.PUMPKIN_PIE)));

    public static final Item APPLE_SAUCE = registerItem("apple_sauce", new JarFoodItem(new Item.Settings()
            .food(FoodComponents.APPLE)));

    public static final Item SQUID = registerItem("squid", new Item(new Item.Settings()
            .food(FoodComponents.SALMON)));

    public static final Item PIG_INTESTINE = registerItem("pig_intestine", new Item(new Item.Settings()
            .food(FoodComponents.CHICKEN)));

    public static final Item FRENCH_TOAST = registerItem("french_toast", new Item(new Item.Settings()
            .food(FoodComponents.BREAD)));

    public static final Item BOILED_EGG = registerItem("boiled_egg", new Item(new Item.Settings()
            .food(ModFoodComponents.EGG)));

    public static final Item FRIED_EGG = registerItem("fried_egg", new Item(new Item.Settings()
            .food(ModFoodComponents.EGG)));

    public static final Item SCRAMBLED_EGGS = registerItem("scrambled_eggs", new Item(new Item.Settings()
            .food(ModFoodComponents.EGG)));


    public static final Item KNIFE = registerItem("knife", new KnifeItem(new Item.Settings()
            .maxCount(1)
            .maxDamage(250)));

    public static final Item ROLLING_PIN = registerItem("rolling_pin", new RollingPinItem(new Item.Settings()
            .maxCount(1)
            .maxDamage(300)));




    public static void registerModItems() {
        MineAndDine.LOGGER.info("Registering Mod Items for " + MineAndDine.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {

        });
    }
}
