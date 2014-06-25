package calisbeast.mods.quartz.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import calisbeast.mods.quartz.Quartz;
import calisbeast.mods.quartz.references.QuartzConfig;

/**
 * @author robosphinx, calisbeast
 */

public class PinkOre extends Block {
	
	private static QuartzConfig config;
	private Random random = new Random();

	/*
	 * Since this is for one specific block, we can set these variables right here.
	 */
	public PinkOre(Material par2Material) {
		super(par2Material);
		setHardness(3.0F);
		setResistance(5.0F);
		setStepSound(Block.soundTypeStone);
		setCreativeTab(CreativeTabs.tabBlock);
	}
    
    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus(int par1, Random par2Random)
    {
        return MathHelper.clamp_int(this.quantityDropped(par2Random) + par2Random.nextInt(par1 + 1), 1, 4);
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random par1Random)
    {
        return config.bool.get(0) ? 2 + par1Random.nextInt(4) : 1;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     * @return 
     */    
    public Item getItemDropped(int i, Random rand, int j) {
    	return config.bool.get(0) ? Item.getItemById(499) : Item.getItemFromBlock(Quartz.pink_quartz_ore);
    }

    /*
     * Returns the amount of XP to drop on destruction. This will drop anywhere from 2 to 5 XP points.
     */
    @Override
    public int getExpDrop(IBlockAccess access, int i, int j) {
    	int j1;
        j1 = MathHelper.getRandomIntegerInRange(random, 2, 5);
        return j1;
    }

}
