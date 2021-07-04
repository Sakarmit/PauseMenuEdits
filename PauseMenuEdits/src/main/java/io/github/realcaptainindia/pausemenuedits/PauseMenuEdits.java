package io.github.realcaptainindia.pausemenuedits;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import io.github.realcaptainindia.pausemenuedits.config.ConfigLoader;
import net.minecraft.client.gui.screen.IngameMenuScreen;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod(PauseMenuEdits.MODID)
public class PauseMenuEdits {

	public static final Logger LOGGER = LogManager.getLogger();
	public static final String MODID = "pausemenuedits";
	
	public static int errorCount = 0;
	
	public PauseMenuEdits() {
		new ConfigLoader();
		MinecraftForge.EVENT_BUS.register(this);
	}

	// Detects when pause menu is launched and updates it to custom menu
	@SubscribeEvent
	public void menuchanger(GuiOpenEvent event) {
		if (event.getGui() instanceof IngameMenuScreen) {
			event.setGui(new PauseMenuCreator());
		}
	}
}