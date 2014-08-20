package robosphinx.mods.quartz.item;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.item.base.PickaxeQP;

public class QuartzPickaxe extends PickaxeQP {
    
    public QuartzPickaxe (ToolMaterial material) {
        super(material);
        setUnlocalizedName("pickaxeQuartz");
        setTextureName("quartz:quartz_pickaxe");
    }
    
}
