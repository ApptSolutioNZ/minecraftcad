package apptsolutionz.minecad.lib;

import net.minecraft.item.Item;
import apptsolutionz.minecad.core.ModItems;

public class Reference {

    public static final String MOD_ID = "mcad";
    public static final String MOD_NAME = "Minecraft CAD";
    public static final String MOD_SHORT_NAME = "minecraftcad";
    public static final String VERSION = "0.0.2b";

    static final String TEXTURES_BASE = "/mods/" + MOD_ID
            + "/textures/";
    static final String ITEM_TEXTURES = TEXTURES_BASE + MOD_SHORT_NAME
            + "_items.png";
    static final String BLOCK_TEXTURES = "/mods/" + MOD_ID
            + "/textures/" + MOD_SHORT_NAME + "_blocks.png";

    // blocks start at id 2000
    public static final int SCANNER_BLOCKID = 2000;
    public static final String SCANNERBLOCK_NAME = "CAD Scanner";
    public static final String SCANNERBLOCK_TEXTURE_FILE = BLOCK_TEXTURES;
    public static final int SCANNER_TEXTURE_INDEX = 0;
    public static final String SCANNERGUI_TEXTURE_FILE = TEXTURES_BASE
            + "scanner_gui.png";

    public static final Object[] SCANNERBLOCK_RECIPE = { "ISI", "SDS", "ISI",
            'I', Item.ingotIron, 'S', ModItems.stepper, 'D', Item.diamond };
    public static final String SCANNERTILE_NAME = "Scanner";

    public static final int COPPERORE_BLOCKID = 2001;
    public static final String COPPERORE_TEXTURE_FILE = BLOCK_TEXTURES;
    public static final int COPPERORE_TEXTURE_INDEX = 16;
    public static final String COPPERORE_NAME = "Copper Ore";

    // items start at id 15000
    public static final String WIRE_TEXTURE_NAME = ITEM_TEXTURES;
    public static final int WIRE_ITEMID = 15000;
    public static final String WIRE_NAME = "Copper Wire";
    public static final int WIRE_TEXTURE_INDEX = 0;

    public static final String COIL_TEXTURE_NAME = ITEM_TEXTURES;
    public static final int COIL_ITEMID = 15001;
    public static final String COIL_NAME = "Copper Coil";
    public static final int COIL_TEXTURE_INDEX = 1;

    public static final String STATOR_TEXTURE_NAME = ITEM_TEXTURES;
    public static final int STATOR_ITEMID = 15002;
    public static final String STATOR_NAME = "Stator";
    public static final int STATOR_TEXTURE_INDEX = 2;

    public static final String STEPPER_TEXTURE_NAME = ITEM_TEXTURES;
    public static final int STEPPER_TEXTURE_INDEX = 4;
    public static final int STEPPER_ITEMID = 15003;
    public static final String STEPPER_NAME = "Stepper Motor";

    public static final String COPPERINGOT_TEXTURE_NAME = ITEM_TEXTURES;
    public static final int COPPERINGOT_ITEMID = 15004;
    public static final int COPPERINGOT_TEXTURE_INDEX = 3;
    public static final String COPPERINGOT_NAME = "Copper Ingot";

}
