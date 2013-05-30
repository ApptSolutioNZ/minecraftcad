package apptsolutionz.minecad.core;

import apptsolutionz.minecad.lib.Reference;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModRecipies {
    
    public static void init(){
        //crafting recipes
        GameRegistry.addRecipe(new ItemStack(ModItems.wire,3), new Object[] {"   ", "CCC","   ", 'C', ModItems.copperIngot});
        GameRegistry.addRecipe(new ItemStack(ModItems.coil,1),new Object[]{"WWW","W W","WWW",'W', ModItems.wire});
        GameRegistry.addRecipe(new ItemStack(ModItems.stator,1), new Object[]{" C ","CIC"," C ",'C',ModItems.coil,'I',Item.ingotIron});
        GameRegistry.addRecipe(new ItemStack(ModItems.stepper,1), new Object[]{"ICI","CSC","ICI",'I',Item.ingotIron,'C',ModItems.coil,'S',ModItems.stator});
        GameRegistry.addRecipe(new ItemStack(ModBlocks.scannerBlock,1), Reference.SCANNERBLOCK_RECIPE);
        //smelting recipes;
        GameRegistry.addSmelting(ModBlocks.copperOre.blockID, new ItemStack(ModItems.copperIngot), 0.1f);
    }
}
