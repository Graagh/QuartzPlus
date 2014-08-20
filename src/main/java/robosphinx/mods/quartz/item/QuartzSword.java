package robosphinx.mods.quartz.item;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.item.base.SwordQP;

public class QuartzSword extends SwordQP {
    
    public QuartzSword (ToolMaterial material) {
        super(material);
        setUnlocalizedName("swordQuartz");
        setTextureName("quartz:quartz_sword");
    }
    
}
