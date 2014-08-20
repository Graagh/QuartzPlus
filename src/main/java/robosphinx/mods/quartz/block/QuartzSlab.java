package robosphinx.mods.quartz.block;

/**
 * @author robosphinx
 */

import java.util.List;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import robosphinx.mods.quartz.Quartz;
import robosphinx.mods.quartz.block.base.SlabQP;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class QuartzSlab extends SlabQP {
    
    public static final String[]    subNames = new String[]{ "smoky", "rose" };
    
    private static QuartzPlusBlocks blocks;
    
    public QuartzSlab (boolean fullBlock) {
        super(fullBlock, Material.rock);
        setCreativeTab(CreativeTabs.tabBlock);
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly (Side.CLIENT)
    public IIcon getIcon (int i, int j) {
        int k = j & 1;
        
        if (this.field_150004_a && (j & 2) != 0) {
            i = 1;
        }
        return k == 0 ? blocks.smoky_quartz_block.getIcon(i, j) : (k == 1 ? blocks.rose_quartz_block.getIcon(i, j - 1) : this.blockIcon);
    }
    
    public Item getItemDropped (int i, Random rand, int j) {
        return Item.getItemFromBlock(blocks.quartz_slab);
    }
    
    /**
     * Returns an item stack containing a single instance of the current block type. 'i' is the block's subtype/damage and is ignored for blocks which
     * do not support subtypes. Blocks which cannot be harvested should return null.
     */
    protected ItemStack createStackedBlock (int i) {
        return new ItemStack(Item.getItemFromBlock(blocks.quartz_slab), 2, i);
    }
    
    @SideOnly (Side.CLIENT)
    private static boolean func_150003_a (Block block) {
        return block == blocks.quartz_slab;
    }
    
    public String func_150002_b (int i) {
        if (i < 0 || i >= subNames.length) {
            i = 0;
        }
        
        return super.getUnlocalizedName() + "." + subNames[i];
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood returns 4 blocks)
     */
    @SideOnly (Side.CLIENT)
    public void getSubBlocks (Item item, CreativeTabs tab, List list) {
        if (item != Item.getItemFromBlock(blocks.double_quartz_slab)) {
            for (int i = 0; i < subNames.length; ++i) {
                list.add(new ItemStack(item, 1, i));
            }
        }
    }
    
    @SideOnly (Side.CLIENT)
    public void registerBlockIcons (IIconRegister icon) {
    }
    
    /**
     * Gets an item for the block being called on. Args: world, x, y, z
     */
    @SideOnly (Side.CLIENT)
    public Item getItem (World world, int x, int y, int z) {
        return func_150003_a(this) ? Item.getItemFromBlock(this) : (this == blocks.double_quartz_slab ? Item.getItemFromBlock(blocks.quartz_slab) : Item.getItemFromBlock(blocks.quartz_slab));
    }
}
