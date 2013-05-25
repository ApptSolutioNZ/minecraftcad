package apptsolutionz.minecad.blocks;

import apptsolutionz.minecad.core.ModBlock;
import apptsolutionz.minecad.tiles.TilemCAD;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;

//import net.minecraft.client.renderer.texture.IconRegister;

public abstract class BlockmCAD extends ModBlock {

    public BlockmCAD(int id, Material material) {

        super(id, material);
    }

    // @Override
    // @SideOnly(Side.CLIENT)
    // public void registerIcons(IconRegister iconRegister) {
    //
    // blockIcon = iconRegister.registerIcon(Reference.MOD_ID.toLowerCase() +
    // ":" + this.getUnlocalizedName2());
    // }

    /**
     * Sets the direction of the block when placed
     */
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLiving entityLiving) {

        int direction = 0;
        int facing = MathHelper
                .floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;

        if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal();
        } else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal();
        } else if (facing == 2) {
            direction = ForgeDirection.SOUTH.ordinal();
        } else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal();
        }

        world.setBlockMetadataWithNotify(x, y, z, direction);

        ((TilemCAD) world.getBlockTileEntity(x, y, z))
                .setOrientation(direction);
    }
}
