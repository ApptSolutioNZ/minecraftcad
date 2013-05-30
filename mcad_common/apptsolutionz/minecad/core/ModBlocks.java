package apptsolutionz.minecad.core;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import apptsolutionz.minecad.blocks.CopperOre;
import apptsolutionz.minecad.blocks.ScannerBlock;
import apptsolutionz.minecad.lib.Reference;
import apptsolutionz.minecad.tiles.ScannerTile;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

    public static Block scannerBlock;
    public static Block testBlock;
    public static Block copperOre;

    public static void init() {
        registerBlock(scannerBlock = new ScannerBlock(
                Reference.SCANNER_BLOCKID, Material.iron),
                Reference.SCANNERBLOCK_NAME);
        GameRegistry.registerTileEntity(ScannerTile.class,
                Reference.SCANNERTILE_NAME);
        
        registerBlock(copperOre = new CopperOre(Reference.COPPERORE_BLOCKID,
                Material.rock), Reference.COPPERORE_NAME);
    }

    private static void registerBlock(Block block, String longname) {
        registerBlock(block, longname, Utilities.getShortName(longname));

    }

    private static void registerBlock(Block block, String longname,
            String shortname) {
        if(block instanceof BlockContainer) {
            LogHelper.log(Level.INFO, "This Block Contains a TileEntity ensure it is registered");
        }
        GameRegistry.registerBlock(block, shortname);

        LanguageRegistry.addName(block, longname);
    }

}
