package apptsolutionz.minecad.gui;

import apptsolutionz.minecad.container.ContainerScanner;
import apptsolutionz.minecad.tiles.ScannerTile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof ScannerTile) {
            return new ContainerScanner(player.inventory, (ScannerTile) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world,
            int x, int y, int z) {
        TileEntity tileEntity = world.getBlockTileEntity(x, y, z);
        if(tileEntity instanceof ScannerTile) {
            return new GuiScanner(player.inventory,(ScannerTile) tileEntity);
        }
        return null;
    }

}
