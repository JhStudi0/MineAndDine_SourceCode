package net.jhstudios.mineanddine.block.custom;

import com.mojang.serialization.MapCodec;
import net.jhstudios.mineanddine.block.entity.custom.CuttingBoardBlockEntity;
import net.jhstudios.mineanddine.recipe.ModRecipes;
import net.jhstudios.mineanddine.recipe.custom.CuttingBoardRecipe;
import net.jhstudios.mineanddine.recipe.custom.CuttingBoardRecipeInput;
import net.minecraft.block.*;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemActionResult;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class CuttingBoardBlock extends BlockWithEntity implements BlockEntityProvider {
    public static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape SHAPE =
            Block.createCuboidShape(1, 0, 1, 15, 2, 15);
    public static final MapCodec<CuttingBoardBlock> CODEC = CuttingBoardBlock.createCodec(CuttingBoardBlock::new);

    public CuttingBoardBlock(Settings settings) {
        super(settings);
        setDefaultState(getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    protected BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    protected MapCodec<? extends BlockWithEntity> getCodec() {
        return CODEC;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new CuttingBoardBlockEntity(pos, state);
    }

    @Override
    protected void onStateReplaced(BlockState state, World world, BlockPos pos, BlockState newState, boolean moved) {
        if (state.getBlock() != newState.getBlock()){
            BlockEntity blockEntity = world.getBlockEntity(pos);
            if (blockEntity instanceof CuttingBoardBlockEntity) {
                ItemScatterer.spawn(world, pos, (CuttingBoardBlockEntity) blockEntity);
                world.updateComparators(pos, this);
            }

            super.onStateReplaced(state, world, pos, newState, moved);
        }
    }

    @Override
    protected ItemActionResult onUseWithItem(ItemStack stack, BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {

        BlockEntity blockEntity = world.getBlockEntity(pos);

        if (!(blockEntity instanceof CuttingBoardBlockEntity board)) {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        ItemStack boardItem = board.getItem();

        if (!boardItem.isEmpty() && stack.isEmpty()) {
            if (!world.isClient) {
                ItemScatterer.spawn(world, pos.getX(), pos.getY() + 0.25, pos.getZ(), boardItem.copy());
                board.clearItem();
            }
            return ItemActionResult.SUCCESS;
        }

        if (boardItem.isEmpty()) {
            if (stack.isEmpty()) {
                return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
            }

            if (!world.isClient) {
                board.setItem(stack.copyWithCount(1));
                if (!player.isCreative()) {
                    stack.decrement(1);
                }
            }

            return ItemActionResult.SUCCESS;
        }

        Optional<CuttingBoardRecipe> recipe = getRecipe(world, boardItem, stack);
        if (recipe.isEmpty()) {
            return ItemActionResult.PASS_TO_DEFAULT_BLOCK_INTERACTION;
        }

        if (!world.isClient) {
            ItemStack output = recipe.get().output().copy();
            board.clearItem();

            if (!player.isCreative()) {
                if (stack.isDamageable()) {
                    stack.damage(1, player, hand == Hand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND);
                }
            }

            ItemScatterer.spawn(world, pos.getX(), pos.getY() + 0.25, pos.getZ(), output);

        }
        return ItemActionResult.SUCCESS;
    }

    private Optional<CuttingBoardRecipe> getRecipe(World world, ItemStack ingredient, ItemStack tool) {
        CuttingBoardRecipeInput input = new CuttingBoardRecipeInput(ingredient, tool);

        return world.getRecipeManager().getFirstMatch(ModRecipes.CUTTING_BOARD_TYPE, input, world).map(recipe -> recipe.value());
    }

    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
