package net.jhstudios.mineanddine.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {

    public static final FoodComponent CORN = new FoodComponent.Builder().nutrition(1).saturationModifier(0.5f)
            .usingConvertsTo(ModItems.CORN_STEM)
            .build();

    public static final FoodComponent GRILLED_CORN = new FoodComponent.Builder().nutrition(4).saturationModifier(1f)
            .usingConvertsTo(ModItems.CORN_STEM)
            .build();

    public static final FoodComponent TOMATO = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f)
            .build();

    public static final FoodComponent TOMATO_SAUCE = new FoodComponent.Builder().nutrition(4).saturationModifier(0.3f)
            .build();

    public static final FoodComponent HONEY_COOKIE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f)
            .build();

    public static final FoodComponent RICE_BOWL = new FoodComponent.Builder().nutrition(6).saturationModifier(5f)
            .build();

    public static final FoodComponent CHOCOLATE = new FoodComponent.Builder().nutrition(3).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1),1.0f)
            .build();

    public static final FoodComponent BUTTER = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1),1.0f)
            .build();

    public static final FoodComponent CHOCOLATE_APPLE = new FoodComponent.Builder().nutrition(4).saturationModifier(2.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1),1.0f)
            .build();

    public static final FoodComponent BREAD_DOUGH = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 100, 1),0.25f)
            .build();

    public static final FoodComponent TORTILLA = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3F).build();

    public static final FoodComponent COOKIE_DOUGH = new FoodComponent.Builder().nutrition(4).saturationModifier(0.4f).build();

    public static final FoodComponent SUSHI = new FoodComponent.Builder().nutrition(5).saturationModifier(2f)
            .build();

    public static final FoodComponent CHICKEN_LEG = new FoodComponent.Builder().nutrition(5).saturationModifier(2f)
            .statusEffect(new StatusEffectInstance(StatusEffects.POISON, 500, 1), 0.25f)
            .build();

    public static final FoodComponent CARAMEL = new FoodComponent.Builder().nutrition(2).saturationModifier(0.4f)
            .statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 100, 1),1.0f)
            .build();

    public static final FoodComponent ONION = new FoodComponent.Builder().nutrition(3).saturationModifier(0.5f)
            .build();

    public static final FoodComponent STOCK = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f)
            .build();

    public static final FoodComponent CREAM = new FoodComponent.Builder().nutrition(4).saturationModifier(0.5f)
            .build();

    public static final FoodComponent GARLIC = new FoodComponent.Builder().nutrition(1).saturationModifier(0.1f)
            .build();

    public static final FoodComponent EGG = new FoodComponent.Builder().nutrition(3).saturationModifier(0.3f)
            .build();
}
