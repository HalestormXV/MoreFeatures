package io.github.xf8b.morefeatures.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.eventbus.api.Cancelable;
import net.minecraftforge.eventbus.api.Event;

import java.util.List;

@Cancelable
public class EngulfedInFireWhileInCoalArmorEvent extends Event {
    public final PlayerEntity player;
    public final List<ItemStack> armorWorn;
    public final BlockPos pos;

    public EngulfedInFireWhileInCoalArmorEvent(PlayerEntity player, List<ItemStack> armorWorn, BlockPos pos) {
        this.player = player;
        this.armorWorn = armorWorn;
        this.pos = pos;
    }

    @Override
    public boolean isCancelable() {
        return true;
    }

    @Override
    public boolean hasResult() {
        return false;
    }
}
