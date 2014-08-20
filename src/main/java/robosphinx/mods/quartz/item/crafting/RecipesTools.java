package robosphinx.mods.quartz.item.crafting;

/**
 * @author robosphinx
 */

import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import robosphinx.mods.quartz.init.QuartzPlusItems;

public class RecipesTools {
    
    private QuartzPlusItems items;
    
    /*
     * Crafting patterns for each tool.
     */
    private String[][]      recipePatterns = new String[][]{ { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
    private Object[][]      recipeItems;
    
    /*
     * Sets each object in the recipeItems field, each one goes with each recipe (in order).
     */
    public RecipesTools () {
        this.recipeItems = new Object[][]{ { Items.quartz }, { items.quartz_pickaxe }, { items.quartz_shovel }, { items.quartz_axe }, { items.quartz_hoe } };
    }
    
    /**
     * Adds the tool recipes to the CraftingManager.
     */
    public void addRecipes (CraftingManager par1CraftingManager) {
        for (int i = 0; i < this.recipeItems[0].length; ++i) {
            Object object = this.recipeItems[0][i];
            
            for (int j = 0; j < this.recipeItems.length - 1; ++j) {
                Item item = (Item) this.recipeItems[j + 1][i];
                par1CraftingManager.addRecipe(new ItemStack(item), new Object[]{ this.recipePatterns[j], '#', Items.stick, 'X', object });
            }
        }
    }
}
