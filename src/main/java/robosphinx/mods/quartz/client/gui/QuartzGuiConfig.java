package robosphinx.mods.quartz.client.gui;

/**
 * @author robosphinx
 */

import robosphinx.mods.quartz.handler.ConfigHandler;
import robosphinx.mods.quartz.reference.Reference;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.client.config.GuiConfig;

public class QuartzGuiConfig extends GuiConfig {
    
    public QuartzGuiConfig (GuiScreen guiScreen) {
        super(guiScreen,
                new ConfigElement(ConfigHandler.config.getCategory(Configuration.CATEGORY_GENERAL)).getChildElements(),
                Reference.MOD_ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
    }
    
}
