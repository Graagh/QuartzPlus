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

public class QuartzOre extends OreQP {
    
    private static ConfigHandler config;
    private QuartzPlusBlocks     blocks;
    private Random               random = new Random();
    
    public QuartzOre (Material material) {
        super(material);
        setBlockTextureName("quartz:quartz_ore");
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
        return config.dropItem ? Items.quartz : Item.getItemFromBlock(blocks.white_quartz_ore);
    }
    
}
