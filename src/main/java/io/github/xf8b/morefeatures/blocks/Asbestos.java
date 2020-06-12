package io.github.xf8b.morefeatures.blocks;

import io.github.xf8b.morefeatures.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

public class Asbestos extends Block {
    public Asbestos() {
        super(Block.Properties.create(Material.MISCELLANEOUS, MaterialColor.GRAY)
                .hardnessAndResistance(0.5f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
        );
    }

    @Override
    public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
        return false;
    }

    @Override
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        ItemStack itemOnHead = player.getItemStackFromSlot(EquipmentSlotType.HEAD);
        if (itemOnHead.getItem() != MoreFeaturesRegistries.MASK.get() && !player.isCreative()) {
            player.addPotionEffect(new EffectInstance(MoreFeaturesRegistries.ASBESTOSIS.get(), 2400, 0));
        }
        worldIn.playEvent(player, 2001, pos, getStateId(state));
    }
}
