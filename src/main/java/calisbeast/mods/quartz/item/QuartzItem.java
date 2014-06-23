package calisbeast.mods.quartz.item;

/**
 * @author robosphinx, calisbeast
 */

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class QuartzItem extends Item {

	public QuartzItem(int maxStackSize, CreativeTabs tab, int texture, String name) {
		setMaxStackSize(maxStackSize);
		setCreativeTab(tab);
		setUnlocalizedName(name);
	}
	
}
