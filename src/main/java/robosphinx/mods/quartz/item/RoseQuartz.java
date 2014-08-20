package robosphinx.mods.quartz.item;

/**
 * @author robosphinx
 */

import net.minecraft.creativetab.CreativeTabs;
import robosphinx.mods.quartz.item.base.ItemQP;

public class RoseQuartz extends ItemQP {
    
    public RoseQuartz () {
        super();
        setCreativeTab(CreativeTabs.tabMaterials);
        setUnlocalizedName("roseQuartz");
        setTextureName("quartz:pink_quartz");
    }
}
