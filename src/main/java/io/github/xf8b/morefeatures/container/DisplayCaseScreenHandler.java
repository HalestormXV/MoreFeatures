package io.github.xf8b.morefeatures.container;

import io.github.xf8b.morefeatures.blockentities.DisplayCaseBlockEntity;
import io.github.xf8b.morefeatures.core.MoreFeaturesRegistries;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;

import java.util.Objects;

public class DisplayCaseScreenHandler extends ScreenHandler {
    public final DisplayCaseBlockEntity tileEntity;
    private final net.minecraft.screen.ScreenHandlerContext canInteractWithCallable;

    public DisplayCaseScreenHandler(final int windowId, final PlayerInventory playerInventory, final DisplayCaseBlockEntity tileEntity) {
        super(MoreFeaturesRegistries.DISPLAY_CASE_CONTAINER.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = ScreenHandlerContext.create(tileEntity.getWorld(), tileEntity.getPos());

        int startX = 80;
        int startY = 36;
        int slotSizePlusTwo = 18;
        this.addSlot(new Slot(tileEntity, 0, startX, startY));

        int startPlayerInventoryX = 8;
        int startPlayerInventoryY = 84;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startPlayerInventoryX + (column * slotSizePlusTwo), startPlayerInventoryY + (row * slotSizePlusTwo)));
            }
        }

        int hotbarY = 142;
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startPlayerInventoryX + (column * slotSizePlusTwo), hotbarY));
        }
    }

    public DisplayCaseScreenHandler(final int windowId, final PlayerInventory playerInv, final PacketByteBuf data) {
        this(windowId, playerInv, getTileEntity(playerInv, data));
    }

    private static DisplayCaseBlockEntity getTileEntity(final PlayerInventory playerInv, final PacketByteBuf data) {
        Objects.requireNonNull(playerInv, "playerInv cannot be null");
        Objects.requireNonNull(data, "data cannot be null");
        final BlockEntity tileAtPos = playerInv.player.world.getBlockEntity(data.readBlockPos());
        if (tileAtPos instanceof DisplayCaseBlockEntity) {
            return (DisplayCaseBlockEntity) tileAtPos;
        }
        throw new IllegalStateException("Tile Entity is not correct! " + tileAtPos);
    }

    @Override
    public boolean canUse(PlayerEntity playerIn) {
        return canUse(canInteractWithCallable, playerIn, MoreFeaturesRegistries.DISPLAY_CASE.get());
    }

    @Override
    public ItemStack transferSlot(PlayerEntity playerIn, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasStack()) {
            ItemStack itemStack1 = slot.getStack();
            itemStack = itemStack1.copy();
            if (index < 1) {
                if (!this.insertItem(itemStack1, 1, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.insertItem(itemStack1, 0, 1, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.setStack(ItemStack.EMPTY);
            } else {
                slot.markDirty();
            }
        }

        return itemStack;
    }
}
