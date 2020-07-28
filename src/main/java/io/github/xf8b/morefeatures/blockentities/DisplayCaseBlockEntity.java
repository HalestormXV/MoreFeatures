package io.github.xf8b.morefeatures.blockentities;

import io.github.xf8b.morefeatures.container.DisplayCaseScreenHandler;
import io.github.xf8b.morefeatures.core.MoreFeatures;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.packet.s2c.play.BlockEntityUpdateS2CPacket;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

public class DisplayCaseBlockEntity extends LootableContainerBlockEntity {
    protected DefaultedList<ItemStack> items = DefaultedList.ofSize(1, ItemStack.EMPTY);

    public DisplayCaseBlockEntity(BlockEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public DisplayCaseBlockEntity() {
        this(MoreFeaturesRegistries.DISPLAY_CASE_TILE_ENTITY.get());
    }

    @Override
    public void fromTag(BlockState state, CompoundTag compound) {
        super.fromTag(state, compound);
        this.items = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        Inventories.fromTag(compound, this.items);
    }

    @Override
    public CompoundTag toTag(CompoundTag compound) {
        super.toTag(compound);
        Inventories.toTag(compound, this.items);
        return compound;
    }


    @Override
    public DefaultedList<ItemStack> getInvStackList() {
        return this.items;
    }

    @Override
    public void setInvStackList(DefaultedList<ItemStack> itemsIn) {
        this.items = itemsIn;
    }

    @Override
    public void markDirty() {
        super.markDirty();
        this.world.updateListeners(this.pos, this.getCachedState(), this.getCachedState(), 3);
    }


    @Override
    protected Text getContainerName() {
        return new TranslatableText("container." + MoreFeatures.MOD_ID + ".display_case");
    }

    @Override
    protected ScreenHandler createScreenHandler(int id, PlayerInventory player) {
        return new DisplayCaseScreenHandler(id, player, this);
    }

    @Override
    public int size() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getStack(int index) {
        return this.items.get(index);
    }

    @Override
    public ItemStack removeStack(int index, int count) {
        return Inventories.splitStack(this.items, index, count);
    }

    @Override
    public ItemStack removeStack(int index) {
        return Inventories.removeStack(this.items, index);
    }

    @Override
    public void setStack(int index, ItemStack stack) {
        ItemStack itemStack = this.items.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqualIgnoreDamage(itemStack) && ItemStack.areTagsEqual(stack, itemStack);
        this.items.set(index, stack);
        if (stack.getCount() > this.getMaxCountPerStack()) {
            stack.setCount(this.getMaxCountPerStack());
        }

        if (!flag) {
            this.markDirty();
        }
    }

    @Override
    public boolean canPlayerUse(PlayerEntity player) {
        if (this.world.getBlockEntity(pos) != this) {
            return false;
        } else {
            return player.squaredDistanceTo((double) this.pos.getX() + 0.5D, (double) this.pos.getY() + 0.5D, (double) this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    @Override
    public boolean isValid(int index, ItemStack stack) {
        return true;
    }

    @Override
    public void clear() {
        super.clear();
        this.items.clear();
    }


    @Override
    public BlockEntityUpdateS2CPacket toUpdatePacket() {
        CompoundTag nbt = new CompoundTag();
        this.toTag(nbt);

        return new BlockEntityUpdateS2CPacket(this.getPos(), 1, nbt);
    }

    @Override
    public CompoundTag toInitialChunkDataTag() {
        return this.toTag(new CompoundTag());
    }
}
