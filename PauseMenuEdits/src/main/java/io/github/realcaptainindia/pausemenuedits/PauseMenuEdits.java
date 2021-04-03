package io.github.realcaptainindia.pausemenuedits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.electronwill.nightconfig.core.Config;

import io.github.realcaptainindia.pausemenuedits.config.ConfigBuilder;
import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.loading.FMLPaths;

@Mod(PauseMenuEdits.MODID)
public class PauseMenuEdits
{
	
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "pausemenuedits";
    
    public PauseMenuEdits() {
    	Config.setInsertionOrderPreserved(true);
  	
    	ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, ConfigBuilder.config, MODID + ".toml");
   	
    	ConfigBuilder.loadConfig(ConfigBuilder.config, FMLPaths.CONFIGDIR.get().resolve("pausemenuedits.toml").toString());
    	
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    
    //Detects when pause menu is launched and updates it to new setup
    @SubscribeEvent
    public void menuchanger(GuiOpenEvent event)
    {
//    	if(event.getGui() instanceof IngameMenuScreen) {
//   		 event.setGui(new DefaultPauseMenu());
//    	}
    	if(event.getGui() instanceof MainMenuScreen) {
    		 event.setGui(new DefaultPauseMenu());
    	}
    }
}
