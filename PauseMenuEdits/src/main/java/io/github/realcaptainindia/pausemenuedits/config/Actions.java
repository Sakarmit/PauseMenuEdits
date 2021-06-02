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

public class Actions {
	static Button.IPressable output;

	public static IPressable JsontoAction(String action, String value) {
		Minecraft game = Minecraft.getInstance();
		Screen currentScreen = game.currentScreen;

		if (action.equals("opengui")) {
			switch (value) {
			case "Advancement":
				output = (button) -> {
					game.displayGuiScreen(new AdvancementsScreen(game.player.connection.getAdvancementManager()));
				};
				break;

			case "Statistics":
				output = (button) -> {
					game.displayGuiScreen(new StatsScreen(currentScreen, game.player.getStats()));
				};
				break;

			case "Options":
				output = (button) -> {
					game.displayGuiScreen(new OptionsScreen(currentScreen, game.gameSettings));
				};
				break;

			case "Mods List":
				output = (button) -> {
					game.displayGuiScreen(new net.minecraftforge.fml.client.gui.screen.ModListScreen(currentScreen));
				};
				break;

			case "Lan":
				output = (button) -> {
					if (game.isSingleplayer() && !game.getIntegratedServer().getPublic()) {
						game.displayGuiScreen(new ShareToLanScreen(currentScreen));
					}
				};
				break;

			case "Quit":
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

			default:
				output = (button) -> {
					game.displayGuiScreen((Screen) null);
				};
				break;

			}

		} else if (action.equals("openurl")) {
			output = (button) -> {
				game.displayGuiScreen(new ConfirmOpenLinkScreen((open) -> {
					if (open) {
						Util.getOSType().openURI(value);
					}
					game.displayGuiScreen(currentScreen);
				}, value, true));
			};
		} else {
			PauseMenuEdits.LOGGER.warn("\"" + action + "\" is invaild coverting to unpause button");
			output = (button) -> {
				game.displayGuiScreen((Screen) null);
			};
		}
		return output;
	}
}
