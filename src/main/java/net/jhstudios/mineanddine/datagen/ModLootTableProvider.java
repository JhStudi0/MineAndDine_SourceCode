package net.jhstudios.mineanddine.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.jhstudios.mineanddine.block.ModBlocks;
import net.jhstudios.mineanddine.block.custom.*;
import net.jhstudios.mineanddine.block.custom.CropBlocks.*;
import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;


public class ModLootTableProvider extends FabricBlockLootTableProvider {

    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        BlockStatePropertyLootCondition.Builder builder = BlockStatePropertyLootCondition.builder(ModBlocks.CORN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(CornCropBlock.AGE, 8));
        addDrop(ModBlocks.CORN_CROP, cropDrops(ModBlocks.CORN_CROP, ModItems.CORN, ModItems.CORN_SEEDS, builder));

        BlockStatePropertyLootCondition.Builder builder1 = BlockStatePropertyLootCondition.builder(ModBlocks.TOMATO_CROP)
                .properties(StatePredicate.Builder.create()
                .exactMatch(TomatoCropBlock.AGE, TomatoCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.TOMATO_CROP, this.cropDrops(ModBlocks.TOMATO_CROP, ModItems.TOMATO, ModItems.TOMATO_SEEDS, builder1));

        BlockStatePropertyLootCondition.Builder builder2 = BlockStatePropertyLootCondition.builder(ModBlocks.VANILLA_BEAN_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(VanillaBeanCropBlock.AGE, 8));
        addDrop(ModBlocks.VANILLA_BEAN_CROP, cropDrops(ModBlocks.VANILLA_BEAN_CROP, ModItems.VANILLA_BEAN, ModItems.VANILLA_SEEDS, builder2));

        BlockStatePropertyLootCondition.Builder builder3 = BlockStatePropertyLootCondition.builder(ModBlocks.RICE_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(RiceCropBlock.AGE, 8));
        addDrop(ModBlocks.RICE_CROP, cropDrops(ModBlocks.RICE_CROP, ModItems.RICE_SEEDS, ModItems.RICE_SEEDS, builder3));

        BlockStatePropertyLootCondition.Builder builder4 = BlockStatePropertyLootCondition.builder(ModBlocks.ONION_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(OnionCropBlock.AGE, OnionCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.ONION_CROP, this.cropDrops(ModBlocks.ONION_CROP, ModItems.ONION, ModItems.ONION_SEEDS, builder4));

        BlockStatePropertyLootCondition.Builder builder5 = BlockStatePropertyLootCondition.builder(ModBlocks.GARLIC_CROP).properties(StatePredicate.Builder.create()
                .exactMatch(GarlicCropBlock.AGE, GarlicCropBlock.MAX_AGE));
        this.addDrop(ModBlocks.GARLIC_CROP, this.cropDrops(ModBlocks.GARLIC_CROP, ModItems.GARLIC, ModItems.GARLIC_SEEDS, builder5));


        this.addDrop(ModBlocks.YEAST_JAR, LootTable.builder().pool(LootPool.builder().with(ItemEntry.builder(ModItems.YEAST_JAR))));
        BlockStatePropertyLootCondition.Builder fermented = BlockStatePropertyLootCondition.builder(ModBlocks.YEAST_JAR).properties(StatePredicate.Builder.create()
                .exactMatch(YeastJarBlock.AGE, YeastJarBlock.MAX_AGE));

        BlockStatePropertyLootCondition.Builder age0 =
                BlockStatePropertyLootCondition.builder(ModBlocks.YEAST_JAR)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(YeastJarBlock.AGE, 0));

        BlockStatePropertyLootCondition.Builder age1 =
                BlockStatePropertyLootCondition.builder(ModBlocks.YEAST_JAR)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(YeastJarBlock.AGE, 1));

        BlockStatePropertyLootCondition.Builder age2 =
                BlockStatePropertyLootCondition.builder(ModBlocks.YEAST_JAR)
                        .properties(StatePredicate.Builder.create()
                                .exactMatch(YeastJarBlock.AGE, 2));
        this.addDrop(ModBlocks.YEAST_JAR, LootTable.builder()
                .pool(LootPool.builder().with(ItemEntry.builder(ModItems.YEAST_JAR).conditionally(age0)))
                .pool(LootPool.builder().with(ItemEntry.builder(ModItems.YEAST_JAR).conditionally(age1)))
                .pool(LootPool.builder().with(ItemEntry.builder(ModItems.YEAST_JAR).conditionally(age2)))
                .pool(LootPool.builder().with(ItemEntry.builder(ModItems.FERMENTED_YEAST_JAR).conditionally(fermented))));

        addDrop(ModBlocks.PLATE);

        addDrop(ModBlocks.COOKING_POT);

        addDrop(ModBlocks.CORN_GRINDER);






    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
