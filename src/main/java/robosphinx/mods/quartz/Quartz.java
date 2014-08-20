package robosphinx.mods.quartz;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.handler.ConfigHandler;
import robosphinx.mods.quartz.handler.RecipeHandler;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;
import robosphinx.mods.quartz.init.QuartzPlusItems;
import robosphinx.mods.quartz.reference.Reference;
import robosphinx.mods.quartz.util.LogHelper;
import robosphinx.mods.quartz.world.Generation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/*
 * What is our mod?
 */
@Mod (modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, guiFactory = Reference.GUI_FACTORY_CLASS)
public class Quartz {
    
    /*
     * Makes this class accessible from other mods (makes addons and integration possible).
     */
    @Instance (value = Reference.MOD_ID)
    public static Quartz     instance;
    
    private ConfigHandler    config;
    private LogHelper        log;
    private RecipeHandler    recipes;
    private QuartzPlusItems  items;
    private QuartzPlusBlocks blocks;
    
    /*
     * Forge pre-initialization call, most of our loading stuff is here.
     */
    @Mod.EventHandler
    public void preInit (FMLPreInitializationEvent event) {
        
        // Gets the config file: if none exists, one is created.
        config.init(event.getSuggestedConfigurationFile());
        blocks.init();
        items.init();
        
        // Register World Gen
        GameRegistry.registerWorldGenerator(new Generation(), 0);
    }
    
    /*
     * Forge initialization call, adds smelting to the registry.
     */
    @Mod.EventHandler
    public void init (FMLInitializationEvent event) {
        recipes.initRecipes();
        recipes.initSmelting();
    }
    
    @Mod.EventHandler
    public void postInit (FMLPostInitializationEvent event) {
        // Stub method at this point - Here if we need it.
    }
}
