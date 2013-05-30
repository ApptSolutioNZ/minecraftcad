package apptsolutionz.minecad.tiles;

import java.util.ArrayList;
import java.util.List;

import apptsolutionz.minecad.util.Coord;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.ForgeDirection;
import net.minecraftforge.common.ISidedInventory;

public class ScannerTile extends TileEntity implements IInventory,
        ISidedInventory {

    private ItemStack[] scannerItemStacks = new ItemStack[3];
    public List<Coord> invLocations = new ArrayList<Coord>();

    public ScannerTile() {
        super();
        invLocations.add(new Coord(26, 19)); // input paper slot
        invLocations.add(new Coord(26, 45)); // input leather slot
        invLocations.add(new Coord(93, 32)); // result bound plan

    }

    public void updateEntity() {
    }

    @Override
    public int getSizeInventory() {
        return this.scannerItemStacks.length;
    }

    /**
     * Returns the stack in slot i
     */
    public ItemStack getStackInSlot(int par1) {
        return this.scannerItemStacks[par1];
    }

    public int getInventoryStackLimit() {
        return 64;
    }

    public String getInvName() {
        return "container.scanner";
    }

    public void openChest() {
    }

    public void closeChest() {
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound) {
        super.writeToNBT(nbtTagCompound);
        NBTTagList var2 = new NBTTagList();

        for (int var3 = 0; var3 < this.scannerItemStacks.length; ++var3) {
            if (this.scannerItemStacks[var3] != null) {
                NBTTagCompound var4 = new NBTTagCompound();
                var4.setByte("Slot", (byte) var3);
                this.scannerItemStacks[var3].writeToNBT(var4);
                var2.appendTag(var4);
            }
        }

        nbtTagCompound.setTag("Items", var2);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound) {
        super.readFromNBT(nbtTagCompound);
        NBTTagList var2 = nbtTagCompound.getTagList("Items");
        this.scannerItemStacks = new ItemStack[this.getSizeInventory()];

        for (int var3 = 0; var3 < var2.tagCount(); ++var3) {
            NBTTagCompound var4 = (NBTTagCompound) var2.tagAt(var3);
            byte var5 = var4.getByte("Slot");

            if (var5 >= 0 && var5 < this.scannerItemStacks.length) {
                this.scannerItemStacks[var5] = ItemStack
                        .loadItemStackFromNBT(var4);
            }
        }
    }

    @Override
    public int getStartInventorySide(ForgeDirection side) {
        // TODO Setup method
        return 0;
    }

    @Override
    public int getSizeInventorySide(ForgeDirection side) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public ItemStack decrStackSize(int var1, int var2) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public ItemStack getStackInSlotOnClosing(int var1) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setInventorySlotContents(int var1, ItemStack var2) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getBlockTileEntity(xCoord, yCoord, zCoord) == this
                && player.getDistanceSq(xCoord + .5, yCoord + .5, zCoord + .5) < 64;
    }

}
