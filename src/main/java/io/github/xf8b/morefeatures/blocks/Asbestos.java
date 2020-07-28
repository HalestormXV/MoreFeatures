package io.github.xf8b.morefeatures.blocks;

import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Material;
import net.minecraft.block.MaterialColor;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import java.util.Map;

public class Asbestos extends Block {
    public Asbestos() {
        super(Block.Settings.of(Material.SUPPORTED, MaterialColor.GRAY)
                .strength(0.5f)
                .harvestTool(ToolType.PICKAXE)
                .harvestLevel(2)
        );
    }

    @Override
    public boolean isFlammable(BlockState state, BlockView world, BlockPos pos, Direction face) {
        return false;
    }

    @Override
    public void onBreak(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        ItemStack itemOnHead = player.getEquippedStack(EquipmentSlot.HEAD);
        ItemStack itemInMainHand = player.getMainHandStack();
        if (!itemInMainHand.isEmpty()) {
            Map<Enchantment, Integer> enchantmentsOnItemInMainHand = EnchantmentHelper.getEnchantments(itemInMainHand);
            if (!enchantmentsOnItemInMainHand.containsKey(Enchantments.SILK_TOUCH)) {
                if (itemOnHead.getItem() != MoreFeaturesRegistries.MASK.get() && !player.isCreative()) {
                    player.addStatusEffect(new StatusEffectInstance(MoreFeaturesRegistries.ASBESTOSIS.get(), 2400, 0));
                }
            }
        } else {
            if (itemOnHead.getItem() != MoreFeaturesRegistries.MASK.get() && !player.isCreative()) {
                player.addStatusEffect(new StatusEffectInstance(MoreFeaturesRegistries.ASBESTOSIS.get(), 2400, 0));
            }
        }
        worldIn.playLevelEvent(player, 2001, pos, getRawIdFromState(state));
    }
}
