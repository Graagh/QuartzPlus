package robosphinx.mods.quartz.item.base;

/**
 * @author robosphinx
 */

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSpade;

public class SpadeQP extends ItemSpade {
    
    public SpadeQP (ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabTools);
    }
    
}
