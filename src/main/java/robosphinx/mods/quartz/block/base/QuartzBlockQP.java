package robosphinx.mods.quartz.block;

/**
 * @author robosphinx
 */

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class RoseQuartz extends Block {
    
    public static final String[]  blocktype = new String[]{ "default", "chiseled", "pillar" };
    private static final String[] sidetype  = new String[]{ "side", "chiseled", "pillar", null, null };
    @SideOnly (Side.CLIENT)
    private IIcon[]               icon1;
    @SideOnly (Side.CLIENT)
    private IIcon                 icon2;
    @SideOnly (Side.CLIENT)
    private IIcon                 icon3;
    @SideOnly (Side.CLIENT)
    private IIcon                 icon4;
    @SideOnly (Side.CLIENT)
    private IIcon                 icon5;
    private static final String   __OBFID   = "CL_00000292";
    
    public RoseQuartz () {
        super(Material.rock);
        this.setCreativeTab(CreativeTabs.tabBlock);
    }
    
    /**
     * Gets the block's texture. Args: side, meta
     */
    @SideOnly (Side.CLIENT)
    public IIcon getIcon (int j, int k) {
        if (k != 2 && k != 3 && k != 4) {
            if (j != 1 && (j != 0 || k != 1)) {
                if (j == 0) {
                    return this.icon5;
                }
                else {
                    if (k < 0 || k >= this.icon1.length) {
                        k = 0;
                    }
                    
                    return this.icon1[k];
                }
            }
            else {
                return k == 1 ? this.icon2 : this.icon4;
            }
        }
        else {
            return k == 2 && (j == 1 || j == 0) ? this.icon3 : (k == 3 && (j == 5 || j == 4) ? this.icon3 : (k == 4 && (j == 2 || j == 3) ? this.icon3 : this.icon1[k]));
        }
    }
    
    /**
     * Called when a block is placed using its ItemBlock. Args: World, X, Y, Z,
     * side, hitX, hitY, hitZ, block metadata
     */
    public int onBlockPlaced (World world, int i, int j, int k, int l, float f1, float f2, float f3, int f4) {
        if (f4 == 2) {
            switch (l) {
                case 0:
                case 1:
                    f4 = 2;
                    break;
                case 2:
                case 3:
                    f4 = 4;
                    break;
                case 4:
                case 5:
                    f4 = 3;
            }
        }
        
        return f4;
    }
    
    /**
     * Determines the damage on the item the block drops. Used in cloth and
     * wood.
     */
    public int damageDropped (int i) {
        return i != 3 && i != 4 ? i : 2;
    }
    
    /**
     * Returns an item stack containing a single instance of the current block
     * sidetype. 'i' is the block's subsidetype/damage and is ignored for blocks
     * which do not support subsidetypes. Blocks which cannot be harvested
     * should return null.
     */
    protected ItemStack createStackedBlock (int i) {
        return i != 3 && i != 4 ? super.createStackedBlock(i) : new ItemStack(Item.getItemFromBlock(this), 1, 2);
    }
    
    /**
     * The sidetype of render function that is called for this block
     */
    public int getRenderType () {
        return 39;
    }
    
    /**
     * returns a list of blocks with the same ID, but different meta (eg: wood
     * returns 4 blocks)
     */
    @SideOnly (Side.CLIENT)
    public void getSubBlocks (Item item, CreativeTabs tab, List list) {
        list.add(new ItemStack(item, 1, 0));
        list.add(new ItemStack(item, 1, 1));
        list.add(new ItemStack(item, 1, 2));
    }
    
    /*
     * Decides which icons (textures) to use on which faces (depends on metadata
     * and the direction the block faces).
     */
    @SideOnly (Side.CLIENT)
    public void registerBlockIcons (IIconRegister icon) {
        this.icon1 = new IIcon[sidetype.length];
        
        for (int i = 0; i < this.icon1.length; ++i) {
            if (sidetype[i] == null) {
                this.icon1[i] = this.icon1[i - 1];
            }
            else {
                this.icon1[i] = icon.registerIcon(this.getTextureName() + "_" + sidetype[i]);
            }
        }
        
        this.icon4 = icon.registerIcon(this.getTextureName() + "_" + "top");
        this.icon2 = icon.registerIcon(this.getTextureName() + "_" + "chiseled_top");
        this.icon3 = icon.registerIcon(this.getTextureName() + "_" + "pillar_top");
        this.icon5 = icon.registerIcon(this.getTextureName() + "_" + "bottom");
    }
}
