package calisbeast.mods.quartz.references;

/**
 * @author robosphinx, calisbeast
 */

import java.util.ArrayList;

import net.minecraftforge.common.config.Configuration;

public class QuartzConfig {
	
	/*
	 * This loads the config file, adds/gets each value on the ArrayList, and saves the file. ".getBoolean(true)" specifies the default value for when the file is created.
	 */
	public static void loadConfig(Configuration config) {
		config.load();
		bool.add(config.get("Block Options", "Quartz Ore Drops Item", true).getBoolean(true));
		bool.add(config.get("Tools Options", "Quartz Tools Enabled", true).getBoolean(true));
		doubles.add(config.get("Block Options", "Quartz Spawn Multiplier", 1.0).getDouble(1.0));
		doubles.add(config.get("Block Options", "Rose Quartz Multiplier", 1.0).getDouble(1.0));
		doubles.add(config.get("Block Options", "Smoky Quartz Multiplier", 1.0).getDouble(1.0));
		ints.add(config.get("BlockOptions", "Quartz maximum Y-level to spawn", 50).getInt(50));
		config.save();
	}
	
	public static ArrayList<Boolean> bool = new ArrayList<Boolean>();
	public static ArrayList<Double> doubles = new ArrayList<Double>();
	public static ArrayList<Integer> ints = new ArrayList<Integer>();

}
