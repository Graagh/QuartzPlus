package robosphinx.mods.quartz;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.block.QuartzOre;
import robosphinx.mods.quartz.block.QuartzStairs;
import robosphinx.mods.quartz.block.RoseItemBlock;
import robosphinx.mods.quartz.block.RoseOre;
import robosphinx.mods.quartz.block.RoseQuartz;
import robosphinx.mods.quartz.block.SmokyItemBlock;
import robosphinx.mods.quartz.block.SmokyOre;
import robosphinx.mods.quartz.block.SmokyQuartz;
import robosphinx.mods.quartz.handler.ConfigHandler;
import robosphinx.mods.quartz.item.QuartzAxe;
import robosphinx.mods.quartz.item.QuartzPickaxe;
import robosphinx.mods.quartz.item.QuartzToolMaterial;
import robosphinx.mods.quartz.reference.Reference;
import robosphinx.mods.quartz.world.Generation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.registry.GameRegistry;

/*
 * What is our mod?
 */
@Mod (modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION/*, guiFactory = Reference.GUI_FACTORY_CLASS*/)
public class Quartz {
    
    /*
     * Makes this class accessible from other mods (makes addons and integration
     * possible).
     */
    @Instance (value = Reference.MOD_ID)
    public static Quartz  instance;
    
    private ConfigHandler config;
    
    // Items
    public static Item    smoky_quartz;
    public static Item    rose_quartz;
    
    // Tools
    public static Item    quartz_shovel;
    public static Item    quartz_pickaxe;
    public static Item    quartz_sword;
    public static Item    quartz_axe;
    public static Item    quartz_hoe;
    
    // Blocks
    public static Block   white_quartz_ore;
    public static Block   smoky_quartz_ore;
    public static Block   rose_quartz_ore;
    public static Block   smoky_quartz_block;
    public static Block   rose_quartz_block;
    
    // public static Block black_quartz_slab;
    // public static Block double_black_quartz_slab;
    public static Block   smoky_quartz_stairs;
    public static Block   rose_quartz_stairs;
    
    /*
     * Forge pre-initialization call, most of our loading stuff is here.
     */
    @SubscribeEvent
    public void PreInit (FMLPreInitializationEvent event) {
        
        // Gets the config file: if none exists, one is created.
        config.init(event.getSuggestedConfigurationFile());
        
        // Sets the previously empty block fields above, now the game knows what
        // they are/do.
        setBlocks();
        
        // Defines what rose and smoky quartz items are.
        smoky_quartz = new Item().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("black_quartz").setTextureName("quartz:black_quartz");
        rose_quartz = new Item().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("pink_quartz").setTextureName("quartz:pink_quartz");
        
        // If tools are enabled in the config, add them to the game with
        // crafting recipes.
        if (config.enableTools) {
            setTools();
            registerTools();
            registerToolRecipes();
            System.out.println("[INFO] Quartz Plus: Tools enabled.");
        }
        
        // Adds the items to the registry now that they are defines
        GameRegistry.registerItem(smoky_quartz, smoky_quartz.getUnlocalizedName());
        GameRegistry.registerItem(rose_quartz, rose_quartz.getUnlocalizedName());
        
        // Adds the blocks to the registry now that they are defined.
        GameRegistry.registerBlock(white_quartz_ore, "white_quartz_ore");
        GameRegistry.registerBlock(smoky_quartz_ore, "black_quartz_ore");
        GameRegistry.registerBlock(rose_quartz_ore, "pink_quartz_ore");
        GameRegistry.registerBlock(smoky_quartz_block, SmokyItemBlock.class, "black_quartz_block");
        GameRegistry.registerBlock(rose_quartz_block, RoseItemBlock.class, "pink_quartz_block");
        
        // GameRegistry.registerBlock(black_quartz_slab, "black_quartz_slab");
        // GameRegistry.registerBlock(double_black_quartz_slab,
        // "double_black_quartz_slab");
        GameRegistry.registerBlock(smoky_quartz_stairs, "black_quartz_stairs");
        GameRegistry.registerBlock(rose_quartz_stairs, "pink_quartz_stairs");
        
        // Register World Gen
        GameRegistry.registerWorldGenerator(new Generation(), 0);
        
        // Register Recipes
        registerRecipes();
    }
    
    /*
     * Forge initialization call, adds smelting to the registry.
     */
    @SubscribeEvent
    public void Init (FMLInitializationEvent event) {
        // Smelting
        GameRegistry.addSmelting(Quartz.white_quartz_ore, new ItemStack(Items.quartz), 0.5F);
        GameRegistry.addSmelting(Quartz.smoky_quartz_ore, new ItemStack(Quartz.smoky_quartz), 0.5F);
        GameRegistry.addSmelting(Quartz.rose_quartz_ore, new ItemStack(Quartz.rose_quartz), 0.5F);
    }
    
    @SubscribeEvent
    public void PostInit (FMLPostInitializationEvent event) {
        // Stub method at this point - Here if we need it.
    }
    
    /*
     * Adds info to the blocks, tells the game what they are and what to do with
     * them.
     */
    public void setBlocks () {
        white_quartz_ore = new QuartzOre(Material.rock).setHardness(4.0F).setResistance(5.0F).setBlockName("oreQuartzPlus").setBlockTextureName("quartz:overworld_quartz_ore");
        smoky_quartz_ore = new SmokyOre(Material.rock).setHardness(4.0F).setResistance(5.0F).setBlockName("oreBlackQuartz").setBlockTextureName("quartz:black_quartz_ore");
        rose_quartz_ore = new RoseOre(Material.rock).setHardness(4.0F).setResistance(5.0F).setBlockName("orePinkQuartz").setBlockTextureName("quartz:pink_quartz_ore");
        smoky_quartz_block = new SmokyQuartz().setStepSound(Block.soundTypePiston).setBlockName("blockBlackQuartz").setBlockTextureName("quartz:black_quartz_block");
        rose_quartz_block = new RoseQuartz().setStepSound(Block.soundTypePiston).setBlockName("blockPinkQuartz").setBlockTextureName("quartz:pink_quartz_block");
        
        // double_black_quartz_slab = new
        // QuartzSlab(true).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setBlockName("blackQuartzSlab");
        // black_quartz_slab = new
        // QuartzSlab(false).setHardness(2.0F).setResistance(10.0F).setStepSound(Block.soundTypePiston).setBlockName("blackQuartzSlab");
        smoky_quartz_stairs = new QuartzStairs(smoky_quartz_block, 0).setBlockName("stairsBlackQuartz");
        rose_quartz_stairs = new QuartzStairs(rose_quartz_block, 0).setBlockName("stairsPinkQuartz");
    }
    
    /*
     * Adds recipes to the registry for all the quartz blocks and their variants
     * - Still non-functional).
     */
    public void registerRecipes () {
        // Commented out because of non-functionality.
        GameRegistry.addRecipe(new ItemStack(Quartz.rose_quartz), "x", 'x', Quartz.rose_quartz_block);
        GameRegistry.addRecipe(new ItemStack(Quartz.rose_quartz_block), "xxx", "xxx", "xxx", 'x', Quartz.rose_quartz);
    }
    
    /*
     * Sets previously undefined tools. We'll add them to the registry later.
     */
    public void setTools () {
        quartz_shovel = new ItemSpade(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_shovel").setTextureName("quartz:quartz_shovel");
        quartz_pickaxe = new QuartzPickaxe(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_pickaxe").setTextureName("quartz:quartz_pickaxe");
        quartz_sword = new ItemSword(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("quartz_sword").setTextureName("quartz:quartz_sword");
        quartz_axe = new QuartzAxe(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_axe").setTextureName("quartz:quartz_axe");
        quartz_hoe = new ItemHoe(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_hoe").setTextureName("quartz:quartz_hoe");
    }
    
    /*
     * Adds the tools we just defined to the registry.
     */
    public void registerTools () {
        GameRegistry.registerItem(quartz_shovel, quartz_shovel.getUnlocalizedName());
        GameRegistry.registerItem(quartz_pickaxe, quartz_pickaxe.getUnlocalizedName());
        GameRegistry.registerItem(quartz_sword, quartz_sword.getUnlocalizedName());
        GameRegistry.registerItem(quartz_axe, quartz_axe.getUnlocalizedName());
        GameRegistry.registerItem(quartz_hoe, quartz_hoe.getUnlocalizedName());
    }
    
    /*
     * Sets the recipes for our tools so we can craft them.
     */
    public void registerToolRecipes () {
        
        // Quartz used in crafting (just makes writing the recipes faster).
        ItemStack quartzStack = new ItemStack(Items.quartz);
        
        // Adds recipes to the registry for Quartz Tools.
        GameRegistry.addRecipe(new ItemStack(Quartz.quartz_axe), "xx", "x#", " #", 'x', quartzStack, '#', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Quartz.quartz_hoe), "xx", " #", " #", 'x', quartzStack, '#', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Quartz.quartz_pickaxe), "xxx", " # ", " # ", 'x', quartzStack, '#', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Quartz.quartz_shovel), "x", "#", "#", 'x', quartzStack, '#', Items.stick);
        GameRegistry.addRecipe(new ItemStack(Quartz.quartz_sword), "x", "x", "#", 'x', quartzStack, '#', Items.stick);
        
    }
}
