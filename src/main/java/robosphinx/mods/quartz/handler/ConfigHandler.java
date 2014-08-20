package robosphinx.mods.quartz.handler;

/**
 * @author robosphinx
 */

import java.io.File;
import java.util.ArrayList;

import robosphinx.mods.quartz.reference.Reference;
import robosphinx.mods.quartz.util.LogHelper;
import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {
    
    public static Configuration config;
    
    public static boolean       dropItem        = false;
    public static boolean       enableTools     = false;
    public static double        spawnMultQuartz = 0.0;
    public static double        spawnMultRose   = 0.0;
    public static double        spawnMultSmoky  = 0.0;
    public static int           maxYQuartz      = 0;
    public static int           maxYRose        = 0;
    public static int           maxYSmoky       = 0;
    
    public static boolean       testBool        = false;
    
    /*
     * This loads the config file, adds/gets each value on the ArrayList, and saves the file. ".getBoolean(true)" specifies the default value for when
     * the file is created.
     */
    public static void init (File configFile) {
        
        // Create our config object from the given file.
        if (config == null) {
            config = new Configuration(configFile);
        }
        loadConfig();
    }
    
    @SubscribeEvent
    public void onConfigurationChangedEvent (ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.modID.equalsIgnoreCase(Reference.MOD_ID)) {
            loadConfig();
        }
    }
    
    public static void loadConfig () {
        // Load the config file.
        config.load();
        
        // Read in our values.
        dropItem = config.get(Configuration.CATEGORY_GENERAL, "Quartz Ore Drops Item", true, "Set true for quartz tor to drop quartz (Item), set false to drop the block. - Default true.").getBoolean(true);
        enableTools = config.get(Configuration.CATEGORY_GENERAL, "Quartz Tools Enabled", true, "Set true to enable quartz tools from QP, set false if you're using a mod such as AE or AE2 if you don't want a bajillion quartz tools. - Default true.").getBoolean(true);
        spawnMultQuartz = config.get(Configuration.CATEGORY_GENERAL, "Quartz Spawn Multiplier", 1.0, "MUST BE IN x.x FORMAT!! - This is the multiplier of how much quartz will be in each chunk (How many times the mod loops through the generation code). - Default 1.0.").getDouble(1.0);
        spawnMultRose = config.get(Configuration.CATEGORY_GENERAL, "Rose Quartz Multiplier", 1.0, "MUST BE IN x.x FORMAT!! - This is the multiplier of how much rose quartz will be in each chunk (How many times the mod loops through the generation code). - Default 1.0.").getDouble(1.0);
        spawnMultSmoky = config.get(Configuration.CATEGORY_GENERAL, "Smoky Quartz Multiplier", 1.0, "MUST BE IN x.x FORMAT!! - This is the multiplier of how much smoky quartz will be in each chunk (How many times the mod loops through the generation code). - Default 1.0.").getDouble(1.0);
        maxYQuartz = config.get(Configuration.CATEGORY_GENERAL, "Maximum Quartz Y-level", 50, "This is the highest level quartz will spawn at. This will only affect your world on first generation. Default 50.").getInt(50);
        maxYRose = config.get(Configuration.CATEGORY_GENERAL, "Rose Quartz max Y-level", 50, "This is the highest level rose quartz will spawn at. This will only affect your world on first generation. Default 50.").getInt(50);
        maxYSmoky = config.get(Configuration.CATEGORY_GENERAL, "Smoky Quartz max Y-level", 50, "This is the highest level smoky quartz will spawn at. This will only affect your world on first generation. Default 50.").getInt(50);
        
        // If the config file has changed, only THEN save it.
        if (config.hasChanged()) {
            config.save();
        }
    }
}
