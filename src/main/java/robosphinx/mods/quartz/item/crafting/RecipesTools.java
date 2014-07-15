package robosphinx.mods.quartz.item.crafting;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.Quartz;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;

public class RecipesTools {
    
    /*
     * Crafting patterns for each tool.
     */
    private String[][] recipePatterns = new String[][]{ { "XXX", " # ", " # " }, { "X", "#", "#" }, { "XX", "X#", " #" }, { "XX", " #", " #" } };
    private Object[][] recipeItems;
    
    /*
     * Sets each object in the recipeItems field, each one goes with each recipe
     * (in order).
     */
    public RecipesTools () {
        this.recipeItems = new Object[][]{ { Items.quartz }, { Quartz.quartz_pickaxe }, { Quartz.quartz_shovel }, { Quartz.quartz_axe }, { Quartz.quartz_hoe } };
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
