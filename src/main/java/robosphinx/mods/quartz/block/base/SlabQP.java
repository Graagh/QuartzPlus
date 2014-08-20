package robosphinx.mods.quartz.block;

/**
 * @author robosphinx
 */

import java.util.List;
import java.util.Random;

import robosphinx.mods.quartz.Quartz;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuartzSlab extends BlockStoneSlab {
    
    @SideOnly (Side.CLIENT)
    private IIcon               field_150007_M;
    private static final String __OBFID = "CL_00000320";
    
    public QuartzSlab (boolean p_i45431_1_) {
        // super(p_i45431_1_, Material.rock);
        super(p_i45431_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly (Side.CLIENT)
    public IIcon getIcon (int p_149691_1_, int p_149691_2_) {
        return Quartz.smoky_quartz_block.getBlockTextureFromSide(p_149691_1_);
    }
    
    @SideOnly (Side.CLIENT)
    public void registerBlockIcons (IIconRegister p_149651_1_) {
        this.blockIcon = p_149651_1_.registerIcon("stone_slab_top");
        this.field_150007_M = p_149651_1_.registerIcon("stone_slab_side");
    }
    
    /*
     * public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_) { return Item.getItemFromBlock(Quartz.black_quartz_slab); }
     */
    
    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage and is ignored for blocks which
     * do not support subtypes. Blocks which cannot be harvested should return null.
     */
    /*
     * protected ItemStack createStackedBlock(int p_149644_1_) { return new ItemStack(Item.getItemFromBlock(Quartz.black_quartz_slab), 2, p_149644_1_
     * & 7); }
     */
    
    public String func_150002_b (int p_150002_1_) {
        return super.getUnlocalizedName() + "." + "black";
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    /*
     * @SideOnly(Side.CLIENT) public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) { if (p_149666_1_ !=
     * Item.getItemFromBlock(Quartz.double_black_quartz_slab)) { for (int i = 0; i <= 2; ++i) { if (i != 2) { p_149666_3_.add(new
     * ItemStack(p_149666_1_, 1, i)); } } } }
     */
}
