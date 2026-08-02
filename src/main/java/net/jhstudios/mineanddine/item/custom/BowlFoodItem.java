package net.jhstudios.mineanddine.item.custom;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class BowlFoodItem extends Item {
    public BowlFoodItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {

        ItemStack result = super.finishUsing(stack, world, user);

        if (!world.isClient && user instanceof PlayerEntity player) {

            if (player.getAbilities().creativeMode) return result;
            ItemStack bowl = new ItemStack(Items.BOWL);

            stack.decrement(1);

            if (result.isEmpty()) {
                return bowl;
            }

            boolean inserted = false;

            inserted = player.getInventory().insertStack(bowl);

            if (!inserted) {
                player.dropItem(bowl, false);
            }

        }
        return result;
    }

}