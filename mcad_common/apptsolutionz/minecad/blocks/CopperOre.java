package apptsolutionz.minecad.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import apptsolutionz.minecad.core.CreativeTabMineCAD;
import apptsolutionz.minecad.core.ModBlocks;
import apptsolutionz.minecad.core.Utilities;
import apptsolutionz.minecad.lib.Reference;

public class CopperOre extends Block {
   
    public CopperOre(int par1, Material par2)
    {
        super(par1, par2);
        this.blockIndexInTexture = Reference.COPPERINGOT_TEXTURE_INDEX;
        setBlockName(Utilities.getShortName(Reference.COPPERORE_NAME));
        setHardness(2.0F);
        setCreativeTab(CreativeTabMineCAD.tabMineCAD);
        setRequiresSelfNotify();
    }

    /**
     * Returns the ID of the items to drop on destruction.
     */
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return ModBlocks.copperOre.blockID;
    }

    @Override
    public String getTextureFile() {
        return Reference.COPPERORE_TEXTURE_FILE;
    }
    
    @Override
    public int getBlockTextureFromSide(int par1) {
        // TODO Auto-generated method stub
        return Reference.COPPERORE_TEXTURE_INDEX;
    }
}
