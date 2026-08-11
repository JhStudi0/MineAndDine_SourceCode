package net.jhstudios.mineanddine.util;

import net.jhstudios.mineanddine.MineAndDineClient;
import net.jhstudios.mineanddine.MineAndDine;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import javax.swing.text.html.HTML;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> WARM_BLOCKS = createTag("warm_blocks");

        public static final TagKey<Block> NUTRITIONAL_BLOCKS = createTag("nutritional_blocks");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(MineAndDine.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, Identifier.of(MineAndDine.MOD_ID, name));
        }
    }
}
