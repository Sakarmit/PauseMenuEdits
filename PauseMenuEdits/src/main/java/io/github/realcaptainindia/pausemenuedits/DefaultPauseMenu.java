package io.github.realcaptainindia.pausemenuedits;

import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.realcaptainindia.pausemenuedits.config.MenuConfig;
import net.minecraft.client.gui.advancements.AdvancementsScreen;
import net.minecraft.client.gui.screen.DirtMessageScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.OptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ShareToLanScreen;
import net.minecraft.client.gui.screen.StatsScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.realms.RealmsBridgeScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;

@OnlyIn(Dist.CLIENT)
public class DefaultPauseMenu extends Screen {

	public DefaultPauseMenu() {
		super(new TranslationTextComponent(MenuConfig.Menu_Title.get()));
	}

	protected void init() {
		this.addButtons();
	}
/*
Button Parameters:

x pos
y pos
button x size
button y size
texture file location
function

x location of texture start(make 0 default)
y location of texture start(make 0 default)
location shift downward for selected texture(button y size)
texture file width(use button x size)
texture file height(use button y size)
*/
	private void addButtons() {
		this.addButton(new ImageButton(this.width / 2 + MenuConfig.Unpause_Button.get().get(0),
				this.height / 2 - MenuConfig.Unpause_Button.get().get(1), 204, 20, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button) -> {
					this.minecraft.displayGuiScreen((Screen) null);
				}));

//		this.addButton(new Button(this.width / 2 + MenuConfig.Unpause_Button.get().get(0),
//				this.height / 2 - MenuConfig.Unpause_Button.get().get(1), 204, 20,
//				new TranslationTextComponent("menu.returnToGame"), (button2) -> {
//					this.minecraft.displayGuiScreen((Screen) null);
//				}));

		this.addButton(new Button(this.width / 2 + MenuConfig.Advancement_Button.get().get(0),
				this.height / 2 - MenuConfig.Advancement_Button.get().get(1), 98, 20,
				new TranslationTextComponent("gui.advancements"), (button2) -> {
					this.minecraft.displayGuiScreen(
							new AdvancementsScreen(this.minecraft.player.connection.getAdvancementManager()));
				}));

		this.addButton(new Button(this.width / 2 + MenuConfig.Statistics_Button.get().get(0),
				this.height / 2 - MenuConfig.Statistics_Button.get().get(1), 98, 20,
				new TranslationTextComponent("gui.stats"), (button2) -> {
					this.minecraft.displayGuiScreen(new StatsScreen(this, this.minecraft.player.getStats()));
				}));

		this.addButton(new Button(this.width / 2 + MenuConfig.Options_Button.get().get(0),
				this.height / 2 - MenuConfig.Options_Button.get().get(1), 204, 20,
				new TranslationTextComponent("menu.options"), (button2) -> {
					this.minecraft.displayGuiScreen(new OptionsScreen(this, this.minecraft.gameSettings));
				}));

		this.addButton(new Button(this.width / 2 + MenuConfig.Mod_List_Button.get().get(0),
				this.height / 2 - MenuConfig.Mod_List_Button.get().get(1), 98, 20,
				new TranslationTextComponent("fml.menu.mods"), (button2) -> {
					this.minecraft.displayGuiScreen(new net.minecraftforge.fml.client.gui.screen.ModListScreen(this));
				}));

		Button button = this.addButton(new Button(this.width / 2 + MenuConfig.Lan_Button.get().get(0),
				this.height / 2 - MenuConfig.Lan_Button.get().get(1), 98, 20,
				new TranslationTextComponent("menu.shareToLan"), (button2) -> {
					this.minecraft.displayGuiScreen(new ShareToLanScreen(this));
				}));
		button.active = this.minecraft.isSingleplayer() && !this.minecraft.getIntegratedServer().getPublic();

		Button button1 = this.addButton(new Button(this.width / 2 + MenuConfig.Quit_Button.get().get(0),
				this.height / 2 - MenuConfig.Quit_Button.get().get(1), 204, 20,
				new TranslationTextComponent("menu.returnToMenu"), (button2) -> {
					boolean flag = this.minecraft.isIntegratedServerRunning();
					button2.active = false;
					this.minecraft.world.sendQuittingDisconnectingPacket();
					if (flag) {
						this.minecraft
								.unloadWorld(new DirtMessageScreen(new TranslationTextComponent("menu.savingLevel")));
					} else {
						this.minecraft.unloadWorld();
					}

					if (flag) {
						this.minecraft.displayGuiScreen(new MainMenuScreen());
					} else if (minecraft.isConnectedToRealms()) {
						RealmsBridgeScreen realmsbridgescreen = new RealmsBridgeScreen();
						realmsbridgescreen.func_231394_a_(new MainMenuScreen());
					} else {
						this.minecraft.displayGuiScreen(new MultiplayerScreen(new MainMenuScreen()));
					}

				}));
		if (!this.minecraft.isIntegratedServerRunning()) {
			button1.setMessage(new TranslationTextComponent("menu.disconnect"));
		}
	}

	public void tick() {
		super.tick();
	}

	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(matrixStack);
		drawCenteredString(matrixStack, this.font, this.title, this.width / 2, 40, 16777215);
		super.render(matrixStack, mouseX, mouseY, partialTicks);
	}

}
