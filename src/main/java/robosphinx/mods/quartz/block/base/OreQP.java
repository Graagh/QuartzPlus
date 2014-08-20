package robosphinx.mods.quartz.block.base;

/**
 * @author robosphinx
 */

import java.util.Random;

import robosphinx.mods.quartz.Quartz;
import robosphinx.mods.quartz.handler.ConfigHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.MathHelper;
import net.minecraft.world.IBlockAccess;

public class OreQP extends Block {
    
    public OreQP (Material material) {
        super(material);
        setHardness(3.0F);
        setResistance(5.0F);
        setStepSound(Block.soundTypeStone);
        setCreativeTab(CreativeTabs.tabBlock);
    }
    
}
