package robosphinx.mods.quartz.init;

/**
 * @author robosphinx
 */

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemSword;
import robosphinx.mods.quartz.handler.ConfigHandler;
import robosphinx.mods.quartz.item.QuartzAxe;
import robosphinx.mods.quartz.item.QuartzHoe;
import robosphinx.mods.quartz.item.QuartzPickaxe;
import robosphinx.mods.quartz.item.QuartzSpade;
import robosphinx.mods.quartz.item.QuartzSword;
import robosphinx.mods.quartz.item.RoseQuartz;
import robosphinx.mods.quartz.item.SmokyQuartz;
import robosphinx.mods.quartz.item.base.ItemQP;
import robosphinx.mods.quartz.item.base.QuartzToolMaterial;
import cpw.mods.fml.common.registry.GameRegistry;

public class QuartzPlusItems {
    
    private static ConfigHandler    config;
    
    public static final ItemQP      smoky_quartz   = new SmokyQuartz();
    public static final ItemQP      rose_quartz    = new RoseQuartz();
    
    public static final ItemSpade   quartz_shovel  = new QuartzSpade(QuartzToolMaterial.QUARTZ);
    public static final ItemPickaxe quartz_pickaxe = new QuartzPickaxe(QuartzToolMaterial.QUARTZ);
    public static final ItemSword   quartz_sword   = new QuartzSword(QuartzToolMaterial.QUARTZ);
    public static final ItemAxe     quartz_axe     = new QuartzAxe(QuartzToolMaterial.QUARTZ);
    public static final ItemHoe     quartz_hoe     = new QuartzHoe(QuartzToolMaterial.QUARTZ);
    
    public static void init () {
        GameRegistry.registerItem(smoky_quartz, smoky_quartz.getUnlocalizedName());
        GameRegistry.registerItem(rose_quartz, rose_quartz.getUnlocalizedName());
        
        if (config.enableTools) {
            GameRegistry.registerItem(quartz_shovel, quartz_shovel.getUnlocalizedName());
            GameRegistry.registerItem(quartz_pickaxe, quartz_pickaxe.getUnlocalizedName());
            GameRegistry.registerItem(quartz_sword, quartz_sword.getUnlocalizedName());
            GameRegistry.registerItem(quartz_axe, quartz_axe.getUnlocalizedName());
            GameRegistry.registerItem(quartz_hoe, quartz_hoe.getUnlocalizedName());
        }
    }
    
}
