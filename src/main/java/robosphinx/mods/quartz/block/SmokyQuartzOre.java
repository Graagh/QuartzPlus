package robosphinx.mods.quartz.block;

/**
 * @author robosphinx
 */

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;
import robosphinx.mods.quartz.block.base.OreQP;
import robosphinx.mods.quartz.handler.ConfigHandler;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;

public class SmokyQuartzOre extends OreQP {
    
    private static ConfigHandler config;
    private QuartzPlusBlocks     blocks;
    private Random               random = new Random();
    
    public SmokyQuartzOre (Material material) {
        super(material);
        setBlockTextureName("quartz:smoky_quartz_ore");
    }
    
    /**
     * Returns the usual quantity dropped by the block plus a bonus of 1 to 'i' (inclusive).
     */
    public int quantityDroppedWithBonus (int i, Random rand) {
        return MathHelper.clamp_int(this.quantityDropped(rand) + rand.nextInt(i + 1), 1, 4);
    }
    
    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped (Random rand) {
        return config.dropItem ? 2 + rand.nextInt(4) : 1;
    }
    
    /**
     * Returns the ID of the items to drop on destruction.
     * 
     * @return
     */
    public Item getItemDropped (int i, Random rand, int j) {
        return config.dropItem ? Items.quartz : Item.getItemFromBlock(blocks.smoky_quartz_ore);
    }
    
    /*
     * Returns the amount of XP to drop on destruction. This will drop anywhere from 2 to 5 XP points.
     */
    @Override
    public int getExpDrop (IBlockAccess access, int i, int j) {
        int j1;
        j1 = MathHelper.getRandomIntegerInRange(random, 2, 5);
        return j1;
    }
    
}
