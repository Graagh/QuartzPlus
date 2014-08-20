package robosphinx.mods.quartz.block.base;

/**
 * @author robosphinx
 */

import java.util.List;
import java.util.Random;

import robosphinx.mods.quartz.Quartz;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.block.BlockStoneSlab;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public abstract class SlabQP extends BlockSlab {
    
    public SlabQP (boolean fullBlock, Material material) {
        super(fullBlock, material);
        setHardness(3.0F);
        setResistance(5.0F);
    }
    
    @SideOnly (Side.CLIENT)
    private static boolean func_150003_a (Block block) {
        return block == QuartzPlusBlocks.quartz_slab;
    }
    
    @Override
    public abstract String func_150002_b (int i);
}
