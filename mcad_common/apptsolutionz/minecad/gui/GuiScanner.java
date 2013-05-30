package apptsolutionz.minecad.gui;

import org.lwjgl.opengl.GL11;

import apptsolutionz.minecad.container.ContainerScanner;
import apptsolutionz.minecad.lib.Reference;
import apptsolutionz.minecad.tiles.ScannerTile;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;

public class GuiScanner extends GuiContainer {

    public GuiScanner(InventoryPlayer player,
            ScannerTile tileEntity) {
        super(new ContainerScanner(player, tileEntity));
    }
    
    @Override
    protected void drawGuiContainerForegroundLayer(int par1, int par2) {
        super.drawGuiContainerForegroundLayer(par1, par2);
    }
    
    @Override
    protected void drawGuiContainerBackgroundLayer(float var1, int var2,
            int var3) {
        int texture = mc.renderEngine.getTexture(Reference.SCANNERGUI_TEXTURE_FILE);
        GL11.glColor4f(1.0f, 1.0f,1.0f,1.0f);
        this.mc.renderEngine.bindTexture(texture);
        int x = (width - xSize)/2;
        int y = (height - ySize)/2;
        this.drawTexturedModalRect(x, y, 0, 0, xSize, ySize);
        
    }

}
