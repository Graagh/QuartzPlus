package calisbeast.mods.quartz.item;

/**
 * @author robosphinx, calisbeast
 */

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class QuartzItem extends Item {

	/*
	 * Simply sets the maximum stack size, which creative tab, the texture name, and the unlocalized name to what we define in Quartz.java/class
	 */
	public QuartzItem(int maxStackSize, CreativeTabs tab, int texture, String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
	}
	
}
