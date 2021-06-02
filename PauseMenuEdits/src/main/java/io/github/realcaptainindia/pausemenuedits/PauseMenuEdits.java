package io.github.realcaptainindia.pausemenuedits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.github.realcaptainindia.pausemenuedits.config.JsonConfig;
import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(PauseMenuEdits.MODID)
public class PauseMenuEdits {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "pausemenuedits";
	
	public PauseMenuEdits() {
		JsonConfig.init();
		MinecraftForge.EVENT_BUS.register(this);
	}

	// Detects when pause menu is launched and updates it to new setup
	@SubscribeEvent
	public void menuchanger(GuiOpenEvent event) {
    	if(event.getGui() instanceof IngameMenuScreen) {
   		 event.setGui(new PauseMenuCreator());
    	}
//		if (event.getGui() instanceof MainMenuScreen) {
//			event.setGui(new DefaultPauseMenu());
//		}
	}
}
