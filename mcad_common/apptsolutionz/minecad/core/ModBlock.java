package apptsolutionz.minecad.core;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import cpw.mods.fml.common.registry.GameRegistry;
import apptsolutionz.minecad.blocks.ScannerBlock;
import apptsolutionz.minecad.lib.Reference;

public abstract class ModBlock extends BlockContainer {


    protected ModBlock(int par1, Material par2Material) {
        super(par1, par2Material);
    }

    static Block scannerBlock;
    
    public static void init(){
        scannerBlock = new ScannerBlock(Reference.SCANNER_BLOCKID, Material.iron);
        GameRegistry.registerBlock(scannerBlock, "BlockScanner");
    }

}
