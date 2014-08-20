package robosphinx.mods.quartz.item;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.item.base.SpadeQP;

public class QuartzSpade extends SpadeQP {
    
    public QuartzSpade (ToolMaterial material) {
        super(material);
        setUnlocalizedName("spadeQuartz");
        setTextureName("quartz:quartz_shovel");
    }
    
}
