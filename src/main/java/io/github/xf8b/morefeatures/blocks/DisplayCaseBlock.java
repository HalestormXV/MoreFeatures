package io.github.xf8b.morefeatures.blocks;

import io.github.xf8b.morefeatures.blockentities.DisplayCaseBlockEntity;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.ItemScatterer;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nullable;

public class DisplayCaseBlock extends Block {
    public DisplayCaseBlock() {
        super(Block.Settings.of(Material.GLASS)
                .strength(0.4f)
                .sounds(BlockSoundGroup.GLASS)
                .nonOpaque()
        );
    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public BlockEntity createTileEntity(BlockState state, BlockView world) {
        return MoreFeaturesRegistries.DISPLAY_CASE_TILE_ENTITY.get().instantiate();
    }

    @Override
    public ActionResult onUse(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockHitResult hit) {
        if (!worldIn.isClient) {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof DisplayCaseBlockEntity) {
                NetworkHooks.openGui((ServerPlayerEntity) player, (DisplayCaseBlockEntity) tileEntity, pos);
            }
        }
        return ActionResult.SUCCESS;
    }

    @Override
    public void onBlockRemoved(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        if (state.getBlock() != newState.getBlock()) {
            BlockEntity tileEntity = worldIn.getBlockEntity(pos);
            if (tileEntity instanceof DisplayCaseBlockEntity) {
                ItemScatterer.spawn(worldIn, pos, ((DisplayCaseBlockEntity) tileEntity).getInvStackList());
            }
        }
    }
}
