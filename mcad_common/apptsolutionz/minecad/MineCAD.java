package apptsolutionz.minecad;

import net.minecraftforge.client.MinecraftForgeClient;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import apptsolutionz.minecad.core.LogHelper;
import apptsolutionz.minecad.core.ModBlocks;
import apptsolutionz.minecad.core.ModConfig;
import apptsolutionz.minecad.core.ModItems;
import apptsolutionz.minecad.core.ModRecipies;
import apptsolutionz.minecad.gui.GuiHandler;
import apptsolutionz.minecad.lib.Reference;


@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION)
@NetworkMod(clientSideRequired=true, serverSideRequired=false)
public class MineCAD {

    @Instance("mcad")
    public static MineCAD instance;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // load configuration files
        ModConfig.load(Reference.MOD_NAME);
        // preload textures
        MinecraftForgeClient
                .preloadTexture(Reference.SCANNERBLOCK_TEXTURE_FILE);
        MinecraftForgeClient.preloadTexture(Reference.STATOR_TEXTURE_NAME);
        MinecraftForgeClient.preloadTexture(Reference.SCANNERGUI_TEXTURE_FILE);
        // block init(register) - items init(register)

        ModBlocks.init();
        ModItems.init();
        ModTextures.load();
        // register sound handlers
        
        
    }

    @Init
    public void init(FMLInitializationEvent event) {
        // crafting recipies here
        ModRecipies.init();
        LogHelper.init();
        // ModRegister.init();
        // register event handlers
        
        // Register GUI
        NetworkRegistry.instance().registerGuiHandler(this, new GuiHandler());
    }

    @PostInit
    public void postInit(FMLPostInitializationEvent event) {

    }
}
