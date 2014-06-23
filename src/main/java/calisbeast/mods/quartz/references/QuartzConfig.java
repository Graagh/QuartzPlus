package calisbeast.mods.quartz.references;

/**
 * @author robosphinx, calisbeast
 */

import java.util.ArrayList;

import net.minecraftforge.common.config.Configuration;

public class QuartzConfig {
	
	public static void loadConfig(Configuration config) {
		config.load();
		bool.add(config.get("Block Options", "Quartz Ore Drops Item", true).getBoolean(true));
		bool.add(config.get("Tools Options", "Quartz Tools Enabled", true).getBoolean(true));
		config.save();
	}
	
	public static ArrayList<Boolean> bool = new ArrayList<Boolean>();

}
