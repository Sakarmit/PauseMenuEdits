package io.github.realcaptainindia.pausemenuedits.config;

import io.github.realcaptainindia.pausemenuedits.PauseMenuEdits;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.advancements.AdvancementsScreen;
import net.minecraft.client.gui.screen.ConfirmOpenLinkScreen;
import net.minecraft.client.gui.screen.DirtMessageScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.OptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ShareToLanScreen;
import net.minecraft.client.gui.screen.StatsScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.util.Util;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.fml.loading.FMLPaths;

public class Actions {
	static Button.IPressable output;

	public static IPressable JsontoAction(String value) {
		Minecraft game = Minecraft.getInstance();
		Screen currentScreen = game.currentScreen;
		
		if (value.startsWith("h") || value.startsWith("w")) {
			output = (button) -> {
				game.displayGuiScreen(new ConfirmOpenLinkScreen((open) -> {
					if (open) {
						Util.getOSType().openURI(value);
					}
					game.displayGuiScreen(currentScreen);
				}, value, true));
			};
		}else if(value.isBlank() || value.equals(null)) {
			output = (button) -> {};
		} else {
			switch (value.substring(0, 1).toLowerCase()) {
			case "u":
				// unpause
				output = (button) -> {
					game.displayGuiScreen((Screen) null);
				};
				break;

			case "a":
				// advancement
				output = (button) -> {
					game.displayGuiScreen(new AdvancementsScreen(game.player.connection.getAdvancementManager()));
				};
				break;

			case "s":
				// stats
				output = (button) -> {
					game.displayGuiScreen(new StatsScreen(currentScreen, game.player.getStats()));
				};
				break;

			case "o":
				// options
				output = (button) -> {
					game.displayGuiScreen(new OptionsScreen(currentScreen, game.gameSettings));
				};
				break;

			case "m":
				// mods option
				output = (button) -> {
					game.displayGuiScreen(new net.minecraftforge.fml.client.gui.screen.ModListScreen(currentScreen));
				};
				break;

			case "l":
				// lan
				output = (button) -> {
					if (game.isSingleplayer() && !game.getIntegratedServer().getPublic()) {
						game.displayGuiScreen(new ShareToLanScreen(currentScreen));
					}
				};
				break;

			case "q":
				// quit
				output = (button) -> {
					boolean flag = game.isIntegratedServerRunning();
					button.active = false;
					game.world.sendQuittingDisconnectingPacket();
					if (flag) {
						game.unloadWorld(new DirtMessageScreen(new TranslationTextComponent("menu.savingLevel")));
						game.displayGuiScreen(new MainMenuScreen());
					} else {
						game.unloadWorld();
						game.displayGuiScreen(new MultiplayerScreen(new MainMenuScreen()));
					}
				};
				break;
			case "e":
				//error button
				output = (button) -> {
							Util.getOSType().openFile(FMLPaths.CONFIGDIR.get().resolve("pausemenuedits").toFile());
						};
				break;
				
			default:
				PauseMenuEdits.LOGGER.warn("\"" + value + "\" is an invaild action coverting to unpause button");
				output = (button) -> {
					game.displayGuiScreen((Screen) null);
				};
				break;
			}
		}
		return output;
	}
}
