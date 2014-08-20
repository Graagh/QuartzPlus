package robosphinx.mods.quartz.item.base;

/**
 * @author robosphinx
 */

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class PickaxeQP extends ItemPickaxe {
    
    public PickaxeQP (ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabTools);
    }
    
}
