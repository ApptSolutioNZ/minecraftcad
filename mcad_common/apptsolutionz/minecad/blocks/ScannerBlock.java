package apptsolutionz.minecad.blocks;

import apptsolutionz.minecad.core.ModBlock;
import apptsolutionz.minecad.tiles.ScannerTile;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class ScannerBlock extends ModBlock {

    public ScannerBlock(int id, Material material) {
        super(id, material);
        // TODO Auto-generated constructor stub
    }

    @Override
    public TileEntity createNewTileEntity(World var1) {
        // TODO Auto-generated method stub
        return new ScannerTile();
    }
    
}
