package apptsolutionz.minecad.blocks;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import apptsolutionz.minecad.MineCAD;
import apptsolutionz.minecad.core.CreativeTabMineCAD;
import apptsolutionz.minecad.core.ModBlocks;
import apptsolutionz.minecad.core.Utilities;
import apptsolutionz.minecad.lib.BlockSide;
import apptsolutionz.minecad.lib.Reference;
import apptsolutionz.minecad.tiles.ScannerTile;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ScannerBlock extends BlockContainer {

    private State state;
    @SuppressWarnings("unused")
    private boolean keepInventory = false;

    enum State {
        Off, On, Jammed
    }

    static int TOP = 2;
    static int BOTTOM = 0;
    static int FRONT = 5;
    static int BACK = 2;
    static int LEFT = 1;
    static int RIGHT = 2;

    static int[][] sidedef = { { 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0 },
            // ,, FRONT, BACK, RIGHT, LEFT
            { 0, 0, FRONT, BACK, RIGHT, LEFT }, // North Block
            // ,, BACK, FRONT, LEFT, RIGHT
            { 0, 0, BACK, FRONT, LEFT, RIGHT }, // South Block
            // ,,LEFT, RIGHT, FRONT, BACK
            { 0, 0, LEFT, RIGHT, FRONT, BACK }, // West Block
            // ,,RIGHT, LEFT, BACK, FRONT
            { 0, 0, RIGHT, LEFT, BACK, FRONT } }; // East Block

    public boolean isActive() {
        return this.state == State.On;
    }

    public ScannerBlock(int id, Material material) {
        super(id, material);
        this.state = State.Off;
        this.blockIndexInTexture = Reference.SCANNER_TEXTURE_INDEX;
        setBlockName(Utilities.getShortName(Reference.SCANNERBLOCK_NAME));
        setHardness(0.5F);
        setCreativeTab(CreativeTabMineCAD.tabMineCAD);
        setRequiresSelfNotify();
        // addMapping(this.getClass(), "scannertile");

    }

    @Override
    public int idDropped(int par1, Random par2Random, int par3) {
        return ModBlocks.scannerBlock.blockID;
    }

    @Override
    public void onBlockAdded(World par1World, int par2, int par3, int par4) {
        super.onBlockAdded(par1World, par2, par3, par4);
        this.setDefaultDirection(par1World, par2, par3, par4);
    }

    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z,
            EntityLiving entity) {
        int var6 = MathHelper
                .floor_double((double) (entity.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;

        if (var6 == 0) {
            world.setBlockMetadataWithNotify(x, y, z, 2);
        }

        if (var6 == 1) {
            world.setBlockMetadataWithNotify(x, y, z, 5);
        }

        if (var6 == 2) {
            world.setBlockMetadataWithNotify(x, y, z, 3);
        }

        if (var6 == 3) {
            world.setBlockMetadataWithNotify(x, y, z, 4);
        }
    }

    private void setDefaultDirection(World world, int x, int y, int z) {
        if (!world.isRemote) {
            int var5 = world.getBlockId(x, y, z - 1); // get index of item south
                                                      // of this block
            int var6 = world.getBlockId(x, y, z + 1); // get index of item north
                                                      // of this block
            int var7 = world.getBlockId(x - 1, y, z); // get index of item west
                                                      // of this block
            int var8 = world.getBlockId(x + 1, y, z); // get index of item east
                                                      // of this block
            byte var9 = 3; // default to south

            if (Block.opaqueCubeLookup[var5] && !Block.opaqueCubeLookup[var6]) // item
                                                                               // south
                                                                               // is
                                                                               // opaque
                                                                               // and
                                                                               // north
                                                                               // not
            {
                var9 = 3;
            }

            if (Block.opaqueCubeLookup[var6] && !Block.opaqueCubeLookup[var5]) // item
                                                                               // north
                                                                               // is
                                                                               // opaque
                                                                               // and
                                                                               // north
                                                                               // not
            {
                var9 = 2;
            }

            if (Block.opaqueCubeLookup[var7] && !Block.opaqueCubeLookup[var8]) {
                var9 = 5;
            }

            if (Block.opaqueCubeLookup[var8] && !Block.opaqueCubeLookup[var7]) {
                var9 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, var9);
        }
    }

    @Override
    public String getTextureFile() {
        return Reference.SCANNERBLOCK_TEXTURE_FILE;
    }

    @SideOnly(Side.CLIENT)
    public int getBlockTextureFromSide(int side) {
        switch (side) {
            case BlockSide.TOP:
                return this.blockIndexInTexture + ScannerBlock.TOP;
            case BlockSide.BOTTOM:
                return this.blockIndexInTexture + ScannerBlock.BOTTOM;
            case BlockSide.FRONT:
                return this.blockIndexInTexture + ScannerBlock.FRONT;
            case BlockSide.BACK:
                return this.blockIndexInTexture + ScannerBlock.BACK;
            case BlockSide.LEFT:
                return this.blockIndexInTexture + ScannerBlock.LEFT;
            case BlockSide.RIGHT:
                return this.blockIndexInTexture + ScannerBlock.RIGHT;
            default:

                return this.blockIndexInTexture;
        }
    }

    @Override
    public int getBlockTexture(IBlockAccess par1IBlockAccess, int x, int y,
            int z, int side) {

        switch (side) {
            case BlockSide.TOP:
                return this.blockIndexInTexture + ScannerBlock.TOP;
            case BlockSide.BOTTOM:
                return this.blockIndexInTexture + ScannerBlock.BOTTOM;
            default:
                int frontside = par1IBlockAccess.getBlockMetadata(x, y, z);
                if (frontside == side) {
                    if (this.state == State.Off)
                        return this.blockIndexInTexture + ScannerBlock.FRONT;
                    if (this.state == State.On)
                        return this.blockIndexInTexture + ScannerBlock.FRONT
                                + 1;
                    if (this.state == State.Jammed)
                        return this.blockIndexInTexture + ScannerBlock.FRONT
                                + 2;
                }
                return this.blockIndexInTexture
                        + ScannerBlock.sidedef[frontside][side];
        }
    }

    @Override
    public void breakBlock(World par1World, int par2, int par3, int par4,
            int par5, int par6) {
        super.breakBlock(par1World, par2, par3, par4, par5, par6);
    }

    @Override
    public TileEntity createNewTileEntity(World var1) {
        // TODO Auto-generated method stub
        return new ScannerTile();
    }

    @Override
    public boolean onBlockActivated(World world, int x, int y, int z,
            EntityPlayer player, int i, float a, float b, float c) {
        player.openGui(MineCAD.instance, 0, world, x, y, z);
        return true;

    }
}
