package robosphinx.mods.quartz.item.base;

/**
 * @author robosphinx
 */

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.Item.ToolMaterial;

public class HoeQP extends ItemHoe {
    
    public HoeQP (ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabTools);
    }
    
}
