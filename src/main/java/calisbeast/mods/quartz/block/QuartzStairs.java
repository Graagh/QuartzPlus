package calisbeast.mods.quartz.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockStairs;
import net.minecraft.creativetab.CreativeTabs;

public class QuartzStairs extends BlockStairs {

	public QuartzStairs(Block p_i45428_1_, int p_i45428_2_) {
    	super(p_i45428_1_, p_i45428_2_);
        //this.field_150149_b = p_i45428_1_;
        //this.field_150151_M = p_i45428_2_;
        this.setHardness(4.0F);
        this.setResistance(5.0F / 3.0F);
        this.setStepSound(p_i45428_1_.stepSound);
        this.setLightOpacity(255);
        this.setCreativeTab(CreativeTabs.tabBlock);
	}

}
