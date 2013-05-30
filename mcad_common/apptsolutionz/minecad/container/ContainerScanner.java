package apptsolutionz.minecad.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import apptsolutionz.minecad.tiles.ScannerTile;
import apptsolutionz.minecad.util.Coord;
import apptsolutionz.minecad.util.Util;
import apptsolutionz.minecad.util.Vector2d;

public class ContainerScanner extends Container {
    protected ScannerTile tileEntity;

    public ContainerScanner(InventoryPlayer player, ScannerTile tileEntity) {
        int slotId = 0;
        this.tileEntity = tileEntity;
        for (int i = 0; i < tileEntity.getSizeInventory(); i++) {
            Coord n = tileEntity.invLocations.get(i);
            addSlotToContainer(new Slot(tileEntity, slotId++, n.x, n.y));
        }
        Util.getInstance().bindPlayersInventory(this, player, true,
                new Vector2d(8, 84, 18, 18), new Vector2d(8, 142, 18, 0));
    }

    @Override
    public boolean canInteractWith(EntityPlayer player) {
        return tileEntity.isUseableByPlayer(player);
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer player, int slot) {
        ItemStack stack = null;
        Slot slotObject = (Slot) inventorySlots.get(slot);
        if (slotObject != null && slotObject.getHasStack()) {
            ItemStack stackInSlot = slotObject.getStack();
            stack = stackInSlot.copy();
            if (slot < tileEntity.getSizeInventory()) {
                if (!this.mergeItemStack(stackInSlot, 3, 39, true)) {
                    return null;
                }

            } else if (!this.mergeItemStack(stackInSlot, 0, 3, false)) {
                return null;
            }
            if (stackInSlot.stackSize == 0) {
                slotObject.putStack(null);

            } else {
                slotObject.onSlotChanged();
            }
            if (stackInSlot.stackSize == stack.stackSize) {
                return null;
            }
            slotObject.onPickupFromSlot(player, stackInSlot);

        }
        return stack;
    }
}
