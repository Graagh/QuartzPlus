package robosphinx.mods.quartz.block.base;

/**
 * @author robosphinx
 */

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class StairsQP extends BlockStairs {
    
    public StairsQP (Block block, int i) {
        super(block, i);
        setHardness(3.0F);
        setResistance(5.0F);
    }
    
}
