package apptsolutionz.minecad;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import apptsolutionz.minecad.core.ModBlock;
import apptsolutionz.minecad.lib.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION) 
public class MineCAD {
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event){
        //load configuration files
        //block init(register) - items init(register)
        //register sound handlers
        ModBlock.init();
        ModItems.init();
    }
    
    @Init
    public void init(FMLInitializationEvent event){
        //crafting recipies here
        ModRecipies.init();
        //register event handlers
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event){
        
    }
}
