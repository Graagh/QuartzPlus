package calisbeast.mods.quartz.item;

/**
 * @author robosphinx, calisbeast
 */

import net.minecraft.item.Item.ToolMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class QuartzToolMaterial {
	
	/*
	 * Adds a new tool material that we can now use for tools and weapons. This basically sets the durability and what you can use the tool on (mining level).
	 */
	public static ToolMaterial QUARTZ = EnumHelper.addToolMaterial("QUARTZ", 3, 200, 8.0F, 3.0F, 10); //Diamond mining level, just under iron durability.

}
