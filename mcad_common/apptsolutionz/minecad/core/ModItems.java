package apptsolutionz.minecad.core;

import net.minecraft.item.Item;
import apptsolutionz.minecad.lib.Reference;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModItems {
    // Components
    public static Item wire;
    public static Item coil;
    public static Item stator;
    public static Item stepper;

    // Game Ore - Blocks
    public static Item copperIngot;

    public static void init() {
        wire = CreateItem(Reference.WIRE_ITEMID, Reference.STATOR_TEXTURE_NAME,
                Reference.WIRE_TEXTURE_INDEX, Reference.WIRE_NAME);
        coil = CreateItem(Reference.COIL_ITEMID, Reference.COIL_TEXTURE_NAME,
                Reference.COIL_TEXTURE_INDEX, Reference.COIL_NAME);
        stator = CreateItem(Reference.STATOR_ITEMID,
                Reference.STATOR_TEXTURE_NAME, Reference.STATOR_TEXTURE_INDEX,
                Reference.STATOR_NAME);
        copperIngot = CreateItem(Reference.COPPERINGOT_ITEMID,
                Reference.COPPERINGOT_TEXTURE_NAME,
                Reference.COPPERINGOT_TEXTURE_INDEX, Reference.COPPERINGOT_NAME);
        stepper = CreateItem(Reference.STEPPER_ITEMID,
                Reference.STEPPER_TEXTURE_NAME,
                Reference.STEPPER_TEXTURE_INDEX, Reference.STEPPER_NAME);

        wire.setCreativeTab(CreativeTabMineCAD.tabMineCAD);
        coil.setCreativeTab(CreativeTabMineCAD.tabMineCAD);
        stator.setCreativeTab(CreativeTabMineCAD.tabMineCAD);
        copperIngot.setCreativeTab(CreativeTabMineCAD.tabMineCAD);
        stepper.setCreativeTab(CreativeTabMineCAD.tabMineCAD);
    }

    private static Item CreateItem(int itemId, String textureFile,
            int textureId, String fullName) {
        Item item = new Item(itemId);
        item.setTextureFile(textureFile);
        item.setIconIndex(textureId);
        item.setItemName(Utilities.getShortName(fullName));
        LanguageRegistry.addName(item, fullName);
        return item;
    }
}
