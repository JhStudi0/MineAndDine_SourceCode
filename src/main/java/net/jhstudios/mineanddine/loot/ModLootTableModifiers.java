package net.jhstudios.mineanddine.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.InvertedLootCondition;
import net.minecraft.loot.condition.MatchToolLootCondition;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.network.packet.CustomPayload;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModLootTableModifiers {

    private static final RegistryKey<net.minecraft.loot.LootTable> SHORT_GRASS =
            RegistryKey.of(
                    RegistryKeys.LOOT_TABLE,
                    Identifier.of("minecraft", "blocks/short_grass")
            );

    private static final RegistryKey<net.minecraft.loot.LootTable> TALL_GRASS =
            RegistryKey.of(
                    RegistryKeys.LOOT_TABLE,
                    Identifier.of("minecraft", "blocks/tall_grass")
            );

    public static final RegistryKey<net.minecraft.loot.LootTable> SQUID =
            RegistryKey.of(
                    RegistryKeys.LOOT_TABLE,
                    Identifier.of("minecraft", "entities/squid")
            );

    public static final RegistryKey<net.minecraft.loot.LootTable> PIG =
            RegistryKey.of(
                    RegistryKeys.LOOT_TABLE,
                    Identifier.of("minecraft", "entities/pig")
            );

    private record SeedEntry(Item item, int weight) {
    }

    private static final SeedEntry[] GRASS_SEEDS = {
            new SeedEntry(ModItems.TOMATO_SEEDS, 5),
            new SeedEntry(ModItems.CORN_SEEDS, 5),
            new SeedEntry(ModItems.RICE_SEEDS, 5),
            new SeedEntry(ModItems.VANILLA_SEEDS, 2),
            new SeedEntry(ModItems.ONION_SEEDS, 5),
            new SeedEntry(ModItems.GARLIC_SEEDS, 3)
    };

    public static void register() {

        LootTableEvents.MODIFY.register((key, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) {
                return;
            }
            if (key.equals(SHORT_GRASS) && key.equals(TALL_GRASS)) {

                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.125f))
                        .conditionally(InvertedLootCondition.builder(MatchToolLootCondition.builder(ItemPredicate.Builder.create().items(Items.SHEARS))));


                for (SeedEntry seed : GRASS_SEEDS) {
                    pool.with(ItemEntry.builder(seed.item()).weight(seed.weight()));
                }

                tableBuilder.pool(pool);
            }

            if (key.equals(SQUID)) {
                LootPool.Builder pool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.SQUID));

                tableBuilder.pool(pool);
            }
            if (key.equals(PIG)){
                LootPool.Builder pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.25f))
                        .with(ItemEntry.builder(ModItems.PIG_INTESTINE));

                tableBuilder.pool(pool);
            }
        });
    }
}