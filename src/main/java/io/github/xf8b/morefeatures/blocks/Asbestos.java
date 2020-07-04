package io.github.xf8b.morefeatures.blocks;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Map;

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
        ItemStack itemInMainHand = player.getHeldItemMainhand();
        if (!itemInMainHand.isEmpty()) {
            Map<Enchantment, Integer> enchantmentsOnItemInMainHand = EnchantmentHelper.getEnchantments(itemInMainHand);
            if (!enchantmentsOnItemInMainHand.containsKey(Enchantments.SILK_TOUCH)) {
                if (itemOnHead.getItem() != MoreFeaturesRegistries.MASK.get() && !player.isCreative()) {
                    player.addPotionEffect(new EffectInstance(MoreFeaturesRegistries.ASBESTOSIS.get(), 2400, 0));
                }
            }
        } else {
            if (itemOnHead.getItem() != MoreFeaturesRegistries.MASK.get() && !player.isCreative()) {
                player.addPotionEffect(new EffectInstance(MoreFeaturesRegistries.ASBESTOSIS.get(), 2400, 0));
            }
        }
        worldIn.playEvent(player, 2001, pos, getStateId(state));
    }
}
