package robosphinx.mods.quartz.item;

/**
 * @author robosphinx
 */

import net.minecraft.creativetab.CreativeTabs;
import robosphinx.mods.quartz.item.base.ItemQP;

public class SmokyQuartz extends ItemQP {
    
    public SmokyQuartz () {
        super();
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("smokyQuartz");
        setTextureName("quartz:black_quartz");
    }
    
}
