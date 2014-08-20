package robosphinx.mods.quartz.block;

/**
 * @author robosphinx
 */

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import robosphinx.mods.quartz.init.QuartzPlusBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSlab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class SlabItemBlock extends ItemBlock {
    
    /*
     * What are our sub-block variants?
     */
    private static final String[] subNames = { "smoky", "rose" };
    
    private final boolean         fullBlock;
    private final BlockSlab       singleSlab;
    private final BlockSlab       doubleSlab;
    
    /*
     * Tells the game that this block has sub-types.
     */
    public SlabItemBlock (Block id) {
        super(id);
        this.singleSlab = (BlockSlab) QuartzPlusBlocks.quartz_slab;
        this.doubleSlab = (BlockSlab) QuartzPlusBlocks.double_quartz_slab;
        this.fullBlock = false;
        setHasSubtypes(true);
    }
    
    /*
     * Gets the damage value so we know which sub-block this is.
     */
    @Override
    public int getMetadata (int damageValue) {
        return damageValue;
    }
    
    /*
     * Allows us to set different names for each sub-block.
     */
    @Override
    public String getUnlocalizedName (ItemStack stack) {
        return getUnlocalizedName() + "." + subNames[stack.getItemDamage()];
    }
    
    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return True if something happen and
     * false if it don't. This is for ITEMS, not BLOCKS
     */
    public boolean onItemUse (ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i, float f1, float f2, float f3) {
        if (this.fullBlock) {
            return super.onItemUse(stack, player, world, x, y, z, i, f1, f2, f3);
        }
        else if (stack.stackSize == 0) {
            return false;
        }
        else if (!player.canPlayerEdit(x, y, z, i, stack)) {
            return false;
        }
        else {
            Block block = world.getBlock(x, y, z);
            int i1 = world.getBlockMetadata(x, y, z);
            int j1 = i1 & 7;
            boolean flag = (i1 & 8) != 0;
            
            if ((i == 1 && !flag || i == 0 && flag) && block == this.singleSlab && j1 == stack.getItemDamage()) {
                if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.doubleSlab, j1, 3)) {
                    world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this.doubleSlab.stepSound.func_150496_b(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getPitch() * 0.8F);
                    --stack.stackSize;
                }
                return true;
            }
            else {
                return this.func_150946_a(stack, player, world, x, y, z, i) ? true : super.onItemUse(stack, player, world, x, y, z, i, f1, f2, f3);
            }
        }
    }
    
    @SideOnly (Side.CLIENT)
    public boolean func_150936_a (World world, int x, int y, int z, int i, EntityPlayer player, ItemStack stack) {
        int i1 = x;
        int j1 = y;
        int k1 = z;
        Block block = world.getBlock(x, y, z);
        int l1 = world.getBlockMetadata(x, y, z);
        int i2 = l1 & 7;
        boolean flag = (l1 & 8) != 0;
        
        if ((i == 1 && !flag || i == 0 && flag) && block == this.singleSlab && i2 == stack.getItemDamage()) {
            return true;
        }
        else {
            if (i == 0) {
                --y;
            }
            if (i == 1) {
                ++y;
            }
            if (i == 2) {
                --z;
            }
            if (i == 3) {
                ++z;
            }
            if (i == 4) {
                --x;
            }
            if (i == 5) {
                ++x;
            }
            
            Block block1 = world.getBlock(x, y, z);
            int j2 = world.getBlockMetadata(x, y, z);
            i2 = j2 & 7;
            return block1 == this.singleSlab && i2 == stack.getItemDamage() ? true : super.func_150936_a(world, i1, j1, k1, i, player, stack);
        }
    }
    
    private boolean func_150946_a (ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int i) {
        if (i == 0) {
            --y;
        }
        if (i == 1) {
            ++y;
        }
        if (i == 2) {
            --z;
        }
        if (i == 3) {
            ++z;
        }
        if (i == 4) {
            --x;
        }
        if (i == 5) {
            ++x;
        }
        
        Block block = world.getBlock(x, y, z);
        int i1 = world.getBlockMetadata(x, y, z);
        int j1 = i1 & 7;
        
        if (block == this.singleSlab && j1 == stack.getItemDamage()) {
            if (world.checkNoEntityCollision(this.doubleSlab.getCollisionBoundingBoxFromPool(world, x, y, z)) && world.setBlock(x, y, z, this.doubleSlab, j1, 3)) {
                world.playSoundEffect((double) ((float) x + 0.5F), (double) ((float) y + 0.5F), (double) ((float) z + 0.5F), this.doubleSlab.stepSound.func_150496_b(), (this.doubleSlab.stepSound.getVolume() + 1.0F) / 2.0F, this.doubleSlab.stepSound.getPitch() * 0.8F);
                --stack.stackSize;
            }
            return true;
        }
        else {
            return false;
        }
    }
}
