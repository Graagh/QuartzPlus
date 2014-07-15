package calisbeast.mods.quartz.block;

import java.util.List;
import java.util.Random;

import calisbeast.mods.quartz.Quartz;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class QuartzSlabTest extends BlockStoneSlab {
	
    @SideOnly(Side.CLIENT)
    private IIcon field_150007_M;

	public QuartzSlabTest(boolean p_i45431_1_) {
		super(p_i45431_1_);
        this.setCreativeTab(CreativeTabs.tabBlock);
	}
	
	/**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly(Side.CLIENT)
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {

        return Quartz.black_quartz_block.getBlockTextureFromSide(p_149691_1_);
    }
    
    public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
    {
        return Item.getItemFromBlock(Quartz.black_quartz_slab);
    }
    
    protected ItemStack createStackedBlock(int p_149644_1_)
    {
        return new ItemStack(Item.getItemFromBlock(Quartz.black_quartz_slab), 2, p_149644_1_ & 7);
    }
    
    @SideOnly(Side.CLIENT)
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_)
    {
        p_149666_3_.add(new ItemStack(p_149666_1_, 1));
               
    }

}
