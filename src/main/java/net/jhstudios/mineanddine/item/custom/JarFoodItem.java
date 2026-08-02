package net.jhstudios.mineanddine.item.custom;

import net.jhstudios.mineanddine.item.ModItems;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class JarFoodItem extends Item {
    public JarFoodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        ItemStack result = super.finishUsing(stack, world, user);

        if (!world.isClient && user instanceof PlayerEntity player) {

            if (player.getAbilities().creativeMode) return result;
            ItemStack jar = new ItemStack(ModItems.JAR);

            stack.decrement(1);

            if (result.isEmpty()) {
                return jar;
            }

            boolean inserted = false;

            inserted = player.getInventory().insertStack(jar);

            if (!inserted) {
                player.dropItem(jar, false);
            }

        }
        return result;
    }

}