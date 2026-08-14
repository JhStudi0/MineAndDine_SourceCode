package net.jhstudios.mineanddine.screen.custom;

import net.jhstudios.mineanddine.screen.ModScreenHandlers;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.ArrayPropertyDelegate;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.slot.Slot;
import net.minecraft.util.math.BlockPos;

public class MixerScreenHandler extends ScreenHandler {
    private final Inventory inventory;
    private final PropertyDelegate propertyDelegate;
    private static final int MACHINE_SLOT_COUNT = 10;
    private static final int OUTPUT_SLOT = 9;

    public MixerScreenHandler(int syncId, PlayerInventory inventory, BlockPos pos) {
        this(syncId, inventory, inventory.player.getWorld().getBlockEntity(pos), new ArrayPropertyDelegate(2));
    }


    public MixerScreenHandler(int syncId, PlayerInventory playerInventory, BlockEntity blockEntity, PropertyDelegate propertyDelegate) {
        super(ModScreenHandlers.MIXER_SCREEN_HANLDER, syncId);
        this.inventory = ((Inventory) blockEntity);
        this.propertyDelegate = propertyDelegate;

        this.addSlot(new Slot(inventory, 0, 24, 20));
        this.addSlot(new Slot(inventory, 1, 42, 20));
        this.addSlot(new Slot(inventory, 2, 60, 20));

        this.addSlot(new Slot(inventory, 3, 24, 38));
        this.addSlot(new Slot(inventory, 4, 42, 38));
        this.addSlot(new Slot(inventory, 5, 60, 38));

        this.addSlot(new Slot(inventory, 6, 24, 56));
        this.addSlot(new Slot(inventory, 7, 42, 56));
        this.addSlot(new Slot(inventory, 8, 60, 56));

        this.addSlot(new Slot(inventory, 9, 132, 38){
            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }
        });

        addProperties(propertyDelegate);
        addPlayerInventory(playerInventory);
        addPlayerHotbar(playerInventory);
    }

    public boolean isCrafting() {
        return propertyDelegate.get(0) > 0;
    }

    public int getScaledArrowProgress() {
        int progress = this.propertyDelegate.get(0);
        int maxProgress = this.propertyDelegate.get(1);
        int arrowPixelSize = 24;

        return maxProgress != 0 && progress != 0 ? progress * arrowPixelSize / maxProgress : 0;
    }


    @Override
    public ItemStack quickMove(PlayerEntity player, int invSlot) {
        ItemStack newStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(invSlot);

        if (slot != null && slot.hasStack()){
            ItemStack originalStack = slot.getStack();
            newStack = originalStack.copy();

            if (invSlot < MACHINE_SLOT_COUNT){
                if (!this.insertItem(originalStack, MACHINE_SLOT_COUNT, this.slots.size(), true)){
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(originalStack, 0, OUTPUT_SLOT, false)) {
                return ItemStack.EMPTY;
            }

            if (originalStack.isEmpty()){
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }

            if (originalStack.getCount() == newStack.getCount()){
                return ItemStack.EMPTY;
            }
        }
        return newStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return this.inventory.canPlayerUse(player);
    }

    private void addPlayerInventory(PlayerInventory playerInventory){
        for (int i = 0; i < 3; ++i){
            for (int l = 0; l < 9; ++l){
                this.addSlot(new Slot(playerInventory, l + i * 9 + 9, 8 + l * 18, 84 + i * 18));
            }
        }
    }

    private void addPlayerHotbar(PlayerInventory playerInventory){
        for (int i = 0; i < 9; ++i){
            this.addSlot(new Slot(playerInventory, i, 8 + i *18, 142));
        }
    }

}