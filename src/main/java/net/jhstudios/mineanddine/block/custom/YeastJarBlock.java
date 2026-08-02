package net.jhstudios.mineanddine.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;

public class YeastJarBlock extends Block {

    public static final MapCodec<YeastJarBlock> CODEC = createCodec(YeastJarBlock::new);

    public static final IntProperty AGE = Properties.AGE_3;
    public static final int MAX_AGE = 3;

    public YeastJarBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends Block> getCodec(){
        return CODEC;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder){
        builder.add(AGE);
    }

    @Override
    protected void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (state.get(AGE) < MAX_AGE){
            if (random.nextInt(5) == 0){
                int newAge = state.get(AGE) + 1;
                world.setBlockState(pos, state.with(AGE, newAge),
                        Block.NOTIFY_LISTENERS);
            }
        }
    }
}