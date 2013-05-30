package apptsolutionz.minecad.core;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class ModOre extends Block {

    public ModOre(int par1, int par2, Material par3Material) {
        super(par1, par2, Material.rock);
        setCreativeTab(CreativeTabMineCAD.tabMineCAD);
    }
    
}
