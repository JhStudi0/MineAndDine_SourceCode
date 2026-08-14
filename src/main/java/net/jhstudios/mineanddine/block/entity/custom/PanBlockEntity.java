package net.jhstudios.mineanddine.block.entity.custom;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerFactory;
import net.jhstudios.mineanddine.block.entity.ImplementedInventory;
import net.jhstudios.mineanddine.block.entity.ModBlockEntities;
import net.jhstudios.mineanddine.recipe.custom.CookingPotRecipeInput;
import net.jhstudios.mineanddine.recipe.ModRecipes;
import net.jhstudios.mineanddine.recipe.custom.PanRecipe;
import net.jhstudios.mineanddine.screen.custom.PanScreenHandler;
import net.jhstudios.mineanddine.util.ModTags;
import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.screen.PropertyDelegate;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class PanBlockEntity extends BlockEntity implements ImplementedInventory, ExtendedScreenHandlerFactory<BlockPos> {
    public final DefaultedList<ItemStack> inventory = DefaultedList.ofSize(8, ItemStack.EMPTY);

    private static final int INPUT_SLOT1 = 0;
    private static final int INPUT_SLOT2 = 1;
    private static final int INPUT_SLOT3 = 2;
    private static final int INPUT_SLOT4 = 3;
    private static final int INPUT_SLOT5 = 4;
    private static final int INPUT_SLOT6 = 5;
    private static final int OUTPUT_SLOT = 6;
    private static final int CONTAINER_SLOT = 7;

    protected final PropertyDelegate propertyDelegate;
    private int progress = 0;
    private int maxProgress = 150;
    public PanBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.PAN_BE, pos, state);

        this.propertyDelegate = new PropertyDelegate() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> PanBlockEntity.this.progress;
                    case 1 -> PanBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0: PanBlockEntity.this.progress = value;
                    case 1: PanBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int size() {
                return 2;
            }
        };
    }

    @Override
    public BlockPos getScreenOpeningData(ServerPlayerEntity player) {
        return this.pos;
    }

    @Override
    public DefaultedList<ItemStack> getItems() {
        return inventory;
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("block.mineanddine.pan");
    }

    @Nullable
    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        return new PanScreenHandler(syncId, playerInventory, this, this.propertyDelegate);
    }

    @Override
    protected void writeNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        super.writeNbt(nbt, registryLookup);
        Inventories.writeNbt(nbt, inventory, registryLookup);
        nbt.putInt("pan.progress", progress);
        nbt.putInt("pan.max_progress", maxProgress);
    }

    @Override
    protected void readNbt(NbtCompound nbt, RegistryWrapper.WrapperLookup registryLookup) {
        Inventories.readNbt(nbt, inventory, registryLookup);
        progress = nbt.getInt("pan.progress");
        maxProgress = nbt.getInt("pan-.max_progress");
        super.readNbt(nbt, registryLookup);
    }

    public void tick(World world, BlockPos pos, BlockState state) {
        Optional<RecipeEntry<PanRecipe>> recipe = getCurrentRecipe();
        if (!hasFire()) {
            resetProgress();
            return;
        }

        if (hasRecipe()) {
            maxProgress = recipe.get().value().cookTime();
            increaseCraftingProgress();
            markDirty(world, pos, state);

            if (hasCraftingFinished()) {
                craftItem();
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private void craftItem() {
        Optional<RecipeEntry<PanRecipe>> recipe = getCurrentRecipe();

        if (recipe.isEmpty()){
            return;
        }

        PanRecipe panRecipe = recipe.get().value();

        for (int i = 0; i < 6; i++){
            consumeIngredients(i);
        }
        consumeIngredients(7);

        ItemStack output = recipe.get().value().output();

        this.setStack(OUTPUT_SLOT, new ItemStack(output.getItem(), this.getStack(OUTPUT_SLOT).getCount() + output.getCount()));
    }

    private void consumeIngredients(int slot) {
       ItemStack stack = getStack(slot);

       if (stack.isEmpty()) {
           return;
       }

       ItemStack remainder = stack.getRecipeRemainder();

       if (!remainder.isEmpty()){
           setStack(slot, remainder);
       } else {
           stack.decrement(1);

           if (stack.isEmpty()){
               setStack(slot, ItemStack.EMPTY);
           }
       }
    }

    private boolean hasCraftingFinished() {
        return this.progress >= maxProgress;
    }

    private void increaseCraftingProgress() {
        this.progress++;
    }

    private boolean hasRecipe() {
        Optional<RecipeEntry<PanRecipe>> recipe = getCurrentRecipe();
        if (recipe.isEmpty()){
            return false;
        }

        ItemStack output = recipe.get().value().output();
        Ingredient container = recipe.get().value().container().orElse(null);
        boolean containerValid = (container == null || container.test(getStack(CONTAINER_SLOT)));

        return containerValid
                && canInsertAmountIntoOutputSlot(output.getCount())
                && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(ItemStack output) {
        return this.getStack(OUTPUT_SLOT).isEmpty() || this.getStack(OUTPUT_SLOT).getItem() == output.getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = this.getStack(OUTPUT_SLOT).isEmpty() ? 64 : this.getStack(OUTPUT_SLOT).getMaxCount();
        int currentCount = this.getStack(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;

    }

    private Optional<RecipeEntry<PanRecipe>> getCurrentRecipe() {
        if (world == null){
            return Optional.empty();
        }
        DefaultedList<ItemStack> inputs = DefaultedList.ofSize(6, ItemStack.EMPTY);

        for (int i = 0; i < 6; i++){
            inputs.set(i, inventory.get(i));
        }

        CookingPotRecipeInput input = new CookingPotRecipeInput(inputs);

        return world.getRecipeManager().getFirstMatch(ModRecipes.PAN_TYPE, input, world);
    }

    private void resetProgress() {
        this.progress = 0;
    }

    private boolean hasFire() {
        BlockState below = world.getBlockState(getPos().down());

        return below.isIn(ModTags.Blocks.WARM_BLOCKS) || (below.isOf(Blocks.FURNACE) && below.get(AbstractFurnaceBlock.LIT)) || (below.isOf(Blocks.SMOKER) && below.get(AbstractFurnaceBlock.LIT)) || (below.isOf(Blocks.BLAST_FURNACE) && below.get(AbstractFurnaceBlock.LIT));
    }

    @Nullable
    @Override
    public Packet<ClientPlayPacketListener> toUpdatePacket() {
        return BlockEntityUpdateS2CPacket.create(this);
    }

    @Override
    public NbtCompound toInitialChunkDataNbt(RegistryWrapper.WrapperLookup registryLookup) {
        return createNbt(registryLookup);
    }

}
