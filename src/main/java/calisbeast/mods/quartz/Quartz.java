package calisbeast.mods.quartz;

/**
 * @author robosphinx, calisbeast
 */

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.config.Configuration;
import calisbeast.mods.quartz.block.BlackItemBlock;
import calisbeast.mods.quartz.block.BlackOre;
import calisbeast.mods.quartz.block.BlackQuartz;
import calisbeast.mods.quartz.block.PinkItemBlock;
import calisbeast.mods.quartz.block.PinkOre;
import calisbeast.mods.quartz.block.PinkQuartz;
import calisbeast.mods.quartz.block.QuartzOre;
import calisbeast.mods.quartz.item.QuartzAxe;
import calisbeast.mods.quartz.item.QuartzPickaxe;
import calisbeast.mods.quartz.item.QuartzToolMaterial;
import calisbeast.mods.quartz.references.QuartzConfig;
import calisbeast.mods.quartz.references.References;
import calisbeast.mods.quartz.world.Generation;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION + "." + References.BUILD)
public class Quartz {
	
	@Instance(value = References.MODID)
	public static Quartz instance;
	
	private static Block block;
	private QuartzConfig config;
	
	//Items
	public static Item black_quartz;
	public static Item pink_quartz;
	
	//Tools //Quartz Tools
	public static Item quartz_shovel;
	public static Item quartz_pickaxe;
	public static Item quartz_sword;
	public static Item quartz_axe;
	public static Item quartz_hoe;
	
	//Blocks
	public static Block white_quartz_ore;
	public static Block black_quartz_ore;
	public static Block pink_quartz_ore;
	public static Block black_quartz_block;
	public static Block pink_quartz_block;
	
	//PreInitialization (Loads Configs)
	@EventHandler
	public void PreInit(FMLPreInitializationEvent event) {
		QuartzConfig.loadConfig(new Configuration (event.getSuggestedConfigurationFile()));
		registerBlocks();
		//setBlocks();
		Item.itemRegistry.addObject(498, "black_quartz", new Item().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("black_quartz").setTextureName("quartz:black_quartz"));
		Item.itemRegistry.addObject(499, "pink_quartz", new Item().setCreativeTab(CreativeTabs.tabMaterials).setUnlocalizedName("pink_quartz").setTextureName("quartz:pink_quartz"));
		//Tools
		if (config.bool.get(1)) {
			registerTools();
			registerToolRecipes();
		}
		//Register Blocks
		GameRegistry.registerBlock(white_quartz_ore, "white_quartz_ore");
		GameRegistry.registerBlock(black_quartz_ore, "black_quartz_ore");
		GameRegistry.registerBlock(pink_quartz_ore, "pink_quartz_ore");
		GameRegistry.registerBlock(black_quartz_block, BlackItemBlock.class, "black_quartz_block");
		GameRegistry.registerBlock(pink_quartz_block, PinkItemBlock.class, "pink_quartz_block");
		//Register World Gen
		GameRegistry.registerWorldGenerator(new Generation(), 0);
		registerRecipes();
	}

	//Initialization
	@EventHandler
	public void Init(FMLInitializationEvent event) {		
		//Smelting
		GameRegistry.addSmelting(Quartz.white_quartz_ore, new ItemStack(Items.quartz), 0.5F);
		GameRegistry.addSmelting(Quartz.black_quartz_ore, new ItemStack(Quartz.black_quartz), 0.5F);
		GameRegistry.addSmelting(Quartz.pink_quartz_ore, new ItemStack(Quartz.pink_quartz), 0.5F);
	}
	
	public void registerBlocks() {
		//Set the previously declared blocks
		white_quartz_ore = new QuartzOre(Material.rock).setHardness(4.0F).setResistance(5.0F).setBlockName("white_quartz_ore_").setBlockTextureName("quartz:overworld_quartz_ore");
		black_quartz_ore = new BlackOre(Material.rock).setHardness(4.0F).setResistance(5.0F).setBlockName("black_quartz_ore").setBlockTextureName("quartz:black_quartz_ore");
		pink_quartz_ore = new PinkOre(Material.rock).setHardness(4.0F).setResistance(5.0F).setBlockName("pink_quartz_ore").setBlockTextureName("quartz:pink_quartz_ore");
		black_quartz_block = new BlackQuartz().setStepSound(Block.soundTypePiston).setBlockName("black_quartz_block").setBlockTextureName("quartz:black_quartz_block");
		pink_quartz_block = new PinkQuartz().setStepSound(Block.soundTypePiston).setBlockName("pink_quartz_block").setBlockTextureName("quartz:pink_quartz_block");
	}
	
	public void registerRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(Quartz.black_quartz, 4), new ItemStack(Item.getItemFromBlock(Quartz.black_quartz_block)));
	}
	
	public void registerTools() {
		Item.itemRegistry.addObject(500, "quartz_shovel", new ItemSpade(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_shovel").setTextureName("quartz:quartz_shovel"));
		Item.itemRegistry.addObject(501, "quartz_pickaxe", new QuartzPickaxe(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_pickaxe").setTextureName("quartz:quartz_pickaxe"));
		Item.itemRegistry.addObject(502, "quartz_sword", new ItemSword(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabCombat).setUnlocalizedName("quartz_sword").setTextureName("quartz:quartz_sword"));
		Item.itemRegistry.addObject(503, "quartz_axe", new QuartzAxe(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_axe").setTextureName("quartz:quartz_axe"));
		Item.itemRegistry.addObject(504, "quartz_hoe", new ItemHoe(QuartzToolMaterial.QUARTZ).setCreativeTab(CreativeTabs.tabTools).setUnlocalizedName("quartz_hoe").setTextureName("quartz:quartz_hoe"));
		System.out.println("[INFO] Quartz Plus: Tools enabled.");
	}
	
	private void registerToolRecipes() {
		//ItemStacks
		ItemStack quartzStack = new ItemStack(Items.quartz);
		//Tools //Quartz
		GameRegistry.addRecipe(new ItemStack(Quartz.quartz_axe), "xx", "x#", " #", 'x', quartzStack, '#', Items.stick);
		GameRegistry.addRecipe(new ItemStack(Quartz.quartz_hoe), "xx", " #", " #", 'x', quartzStack, '#', Items.stick);
		GameRegistry.addRecipe(new ItemStack(Quartz.quartz_pickaxe), "xxx", " # ", " # ", 'x', quartzStack, '#', Items.stick);
		GameRegistry.addRecipe(new ItemStack(Quartz.quartz_shovel), "x", "#", "#", 'x', quartzStack, '#', Items.stick);
		GameRegistry.addRecipe(new ItemStack(Quartz.quartz_sword), "x", "x", "#", 'x', quartzStack, '#', Items.stick);
				
	}
}
