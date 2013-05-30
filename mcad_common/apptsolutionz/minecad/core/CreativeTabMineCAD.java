package apptsolutionz.minecad.core;
import apptsolutionz.minecad.lib.Reference;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
public class CreativeTabMineCAD  extends CreativeTabs {
    


        public static final CreativeTabs tabMineCAD = new CreativeTabMineCAD(Reference.MOD_SHORT_NAME);
        
        public CreativeTabMineCAD(String label) {
            super(label);
        }

        @Override
        public ItemStack getIconItemStack() {
            return new ItemStack(ModItems.stator);
        }
        
        @Override
        public String getTranslatedTabLabel() {
            return Reference.MOD_NAME;
        }
    }


