package robosphinx.mods.quartz.block;

/**
 * @author robosphinx
 */

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

public class SmokyItemBlock extends ItemBlock {
    
    /*
     * What are our sub-block variants?
     */
    private static final String[] subNames = { "default", "chiseled", "pillar" };
    
    /*
     * Tells the game that this block has sub-types.
     */
    public SmokyItemBlock (Block id) {
        super(id);
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
    
}
