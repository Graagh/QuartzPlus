package robosphinx.mods.quartz.handler;

/**
 * @author robosphinx
 */

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;
import robosphinx.mods.quartz.init.QuartzPlusItems;
import robosphinx.mods.quartz.util.LogHelper;
import cpw.mods.fml.common.registry.GameRegistry;

public class RecipeHandler {
    
    private static ConfigHandler    config;
    private static LogHelper        log;
    private static QuartzPlusItems  items;
    private static QuartzPlusBlocks blocks;
    
    public static void initRecipes () {
        // Rose Quartz
        GameRegistry.addRecipe(new ItemStack(items.rose_quartz, 9), "x", 'x', blocks.rose_quartz_block);
        GameRegistry.addRecipe(new ItemStack(blocks.rose_quartz_block), "xxx", "xxx", "xxx", 'x', items.rose_quartz);
        // Pillars
        GameRegistry.addRecipe(new ItemStack(blocks.rose_quartz_block, 2, 2), "x", "x", 'x', blocks.rose_quartz_block);
        // Chiseled
        GameRegistry.addRecipe(new ItemStack(blocks.rose_quartz_block, 1, 1), "x", "x", 'x', new ItemStack(blocks.quartz_slab, 1, 1));
        // Slabs
        GameRegistry.addRecipe(new ItemStack(blocks.quartz_slab, 6, 1), "xxx", 'x', blocks.rose_quartz_block);
        // Stairs
        GameRegistry.addRecipe(new ItemStack(blocks.rose_quartz_stairs, 4), "  x", " xx", "xxx", 'x', blocks.rose_quartz_block);
        GameRegistry.addRecipe(new ItemStack(blocks.rose_quartz_stairs, 4), "x  ", "xx ", "xxx", 'x', blocks.rose_quartz_block);
        
        // Smoky Quartz
        GameRegistry.addRecipe(new ItemStack(items.smoky_quartz, 9), "x", 'x', blocks.smoky_quartz_block);
        GameRegistry.addRecipe(new ItemStack(blocks.smoky_quartz_block), "xxx", "xxx", "xxx", 'x', items.smoky_quartz);
        // Pillars
        GameRegistry.addRecipe(new ItemStack(blocks.smoky_quartz_block, 2, 2), "x", "x", 'x', blocks.smoky_quartz_block);
        // Chiseled
        GameRegistry.addRecipe(new ItemStack(blocks.smoky_quartz_block, 1, 1), "x", "x", 'x', new ItemStack(blocks.quartz_slab, 1, 0));
        // Slabs
        GameRegistry.addRecipe(new ItemStack(blocks.quartz_slab, 6, 0), "xxx", 'x', blocks.smoky_quartz_block);
        // Stairs
        GameRegistry.addRecipe(new ItemStack(blocks.smoky_quartz_stairs, 4), "  x", " xx", "xxx", 'x', blocks.smoky_quartz_block);
        GameRegistry.addRecipe(new ItemStack(blocks.smoky_quartz_stairs, 4), "x  ", "xx ", "xxx", 'x', blocks.smoky_quartz_block);
        
        // Comparators with alternate quartz.
        GameRegistry.addRecipe(new ItemStack(Items.comparator), " t ", "tqt", "sss", 't', Blocks.redstone_torch, 'q', items.smoky_quartz, 's', Blocks.stone);
        GameRegistry.addRecipe(new ItemStack(Items.comparator), " t ", "tqt", "sss", 't', Blocks.redstone_torch, 'q', items.rose_quartz, 's', Blocks.stone);
        
        // Tools
        if (config.enableTools) {
            ItemStack quartzStack = new ItemStack(Items.quartz);
            ItemStack stick = new ItemStack(Items.stick);
            
            // Add recipes to the registry for Quartz Tools.
            GameRegistry.addRecipe(new ItemStack(items.quartz_axe), "xx", "x#", " #", 'x', quartzStack, '#', stick);
            GameRegistry.addRecipe(new ItemStack(items.quartz_axe), "xx", "#x", "# ", 'x', quartzStack, '#', stick);
            GameRegistry.addRecipe(new ItemStack(items.quartz_hoe), "xx", " #", " #", 'x', quartzStack, '#', stick);
            GameRegistry.addRecipe(new ItemStack(items.quartz_hoe), "xx", "# ", "# ", 'x', quartzStack, '#', stick);
            GameRegistry.addRecipe(new ItemStack(items.quartz_pickaxe), "xxx", " # ", " # ", 'x', quartzStack, '#', stick);
            GameRegistry.addRecipe(new ItemStack(items.quartz_shovel), "x", "#", "#", 'x', quartzStack, '#', stick);
            GameRegistry.addRecipe(new ItemStack(items.quartz_sword), "x", "x", "#", 'x', quartzStack, '#', stick);
            
            // Log that tools are enabled.
            log.info("Tools enabled!");
        }
        log.info("Recipes initialized successfully!");
    }
    
    public static void initSmelting () {
        GameRegistry.addSmelting(blocks.white_quartz_ore, new ItemStack(Items.quartz), 0.5F);
        GameRegistry.addSmelting(blocks.smoky_quartz_ore, new ItemStack(items.smoky_quartz), 0.5F);
        GameRegistry.addSmelting(blocks.rose_quartz_ore, new ItemStack(items.rose_quartz), 0.5F);
    }
    
}
