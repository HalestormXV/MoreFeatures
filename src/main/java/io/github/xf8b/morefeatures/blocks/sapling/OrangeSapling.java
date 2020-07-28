package io.github.xf8b.morefeatures.blocks.sapling;

import io.github.xf8b.morefeatures.world.feature.OrangeTree;
import net.minecraft.block.*;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

import java.util.Random;
import java.util.function.Supplier;

public class OrangeSapling extends PlantBlock implements Fertilizable {
    public static final IntProperty STAGE = Properties.STAGE;
    protected static final VoxelShape SHAPE = Block.createCuboidShape(2, 0, 2, 14, 12, 14);
    private final Supplier<SaplingGenerator> tree;

    public OrangeSapling() {
        super(Block.Settings.copy(Blocks.OAK_SAPLING));
        this.tree = () -> new OrangeTree();
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return SHAPE;
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        super.scheduledTick(state, worldIn, pos, rand);
        if (!worldIn.isRegionLoaded(pos, 1)) {
            return;
        }
        if (worldIn.getLightLevel(pos.up()) >= 9 && rand.nextInt(7) == 0) {
            this.grow(worldIn, pos, state, rand);
        }
    }

    public void grow(ServerWorld serverWorld, BlockPos pos, BlockState state, Random rand) {
        if (state.get(STAGE) == 0) {
            serverWorld.setBlockState(pos, state.cycle(STAGE), 4);
        } else {
            this.tree.get().generate(serverWorld, serverWorld.getChunkManager().getChunkGenerator(), pos, state, rand);
        }
    }

    @Override
    public void grow(ServerWorld serverWorld, Random rand, BlockPos pos, BlockState state) {
        this.grow(serverWorld, pos, state, rand);
    }

    @Override
    public boolean isFertilizable(BlockView worldIn, BlockPos pos, BlockState state, boolean isClient) {
        return true;
    }

    @Override
    public boolean canGrow(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double) worldIn.random.nextFloat() < 0.45D;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }
}
