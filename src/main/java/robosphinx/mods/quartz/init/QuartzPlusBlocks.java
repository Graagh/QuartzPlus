package robosphinx.mods.quartz.init;

/**
 * @author robosphinx
 */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import robosphinx.mods.quartz.block.QuartzItemBlock;
import robosphinx.mods.quartz.block.QuartzOre;
import robosphinx.mods.quartz.block.QuartzSlab;
import robosphinx.mods.quartz.block.RoseQuartzBlock;
import robosphinx.mods.quartz.block.RoseQuartzOre;
import robosphinx.mods.quartz.block.SlabItemBlock;
import robosphinx.mods.quartz.block.SmokyQuartzBlock;
import robosphinx.mods.quartz.block.SmokyQuartzOre;
import robosphinx.mods.quartz.block.base.StairsQP;
import robosphinx.mods.quartz.handler.ConfigHandler;
import cpw.mods.fml.common.registry.GameRegistry;

public class QuartzPlusBlocks {
    
    private static ConfigHandler config;
    
    public static final Block    white_quartz_ore    = new QuartzOre(Material.rock);
    public static final Block    smoky_quartz_ore    = new SmokyQuartzOre(Material.rock);
    public static final Block    rose_quartz_ore     = new RoseQuartzOre(Material.rock);
    public static final Block    smoky_quartz_block  = new SmokyQuartzBlock();
    public static final Block    rose_quartz_block   = new RoseQuartzBlock();
    
    public static final Block    smoky_quartz_stairs = new StairsQP(smoky_quartz_block, 0);
    public static final Block    rose_quartz_stairs  = new StairsQP(rose_quartz_block, 0);
    
    public static final Block    quartz_slab         = new QuartzSlab(false);
    public static final Block    double_quartz_slab  = new QuartzSlab(true);
    
    public static void init () {
        GameRegistry.registerBlock(white_quartz_ore, "oreQuartzPlus").setBlockName("oreQuartzPlus");
        GameRegistry.registerBlock(smoky_quartz_ore, "oreSmokyQuartz").setBlockName("oreSmokyQuartz");
        GameRegistry.registerBlock(rose_quartz_ore, "oreRoseQuartz").setBlockName("oreRoseQuartz");
        GameRegistry.registerBlock(smoky_quartz_block, QuartzItemBlock.class, "blockSmokyQuartz").setBlockName("blockSmokyQuartz");
        GameRegistry.registerBlock(rose_quartz_block, QuartzItemBlock.class, "blockRoseQuartz").setBlockName("blockRoseQuartz");
        
        GameRegistry.registerBlock(smoky_quartz_stairs, "stairsSmokyQuartz").setBlockName("stairsSmokyQuartz");
        GameRegistry.registerBlock(rose_quartz_stairs, "stairsRoseQuartz").setBlockName("stairsRoseQuartz");
        
        GameRegistry.registerBlock(quartz_slab, SlabItemBlock.class, "quartz_slab").setBlockName("quartzSlab");
        GameRegistry.registerBlock(double_quartz_slab, SlabItemBlock.class, "double_quartz_slab").setBlockName("quartzSlab");
    }
    
}
