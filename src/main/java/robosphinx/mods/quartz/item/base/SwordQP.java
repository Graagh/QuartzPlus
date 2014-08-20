package robosphinx.mods.quartz.item.base;

/**
 * @author robosphinx
 */

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;
import net.minecraft.item.Item.ToolMaterial;

public class SwordQP extends ItemSword {
    
    public SwordQP (ToolMaterial material) {
        super(material);
        setMaxStackSize(1);
        setCreativeTab(CreativeTabs.tabCombat);
    }
    
}
