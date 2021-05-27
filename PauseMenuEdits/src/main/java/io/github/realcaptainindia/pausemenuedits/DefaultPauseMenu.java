package io.github.realcaptainindia.pausemenuedits;

import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.matrix.MatrixStack;

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
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;

@OnlyIn(Dist.CLIENT)
public class DefaultPauseMenu extends Screen {

	public DefaultPauseMenu() {
		super(new TranslationTextComponent(""));
	}

	protected void init() {
		this.addButtons();
	}
	
	private void addButtons() {
		int w = this.width / 2;
		int h = this.height / 2;
		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Pause Button").x_pos,
				h - JsonConfig.Buttons.get("Pause Button").y_pos, JsonConfig.Buttons.get("Pause Button").width,
				JsonConfig.Buttons.get("Pause Button").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button) -> {
					this.minecraft.displayGuiScreen((Screen) null);
				}));
		
		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Advancement Button").x_pos,
				h - JsonConfig.Buttons.get("Advancement Button").y_pos, JsonConfig.Buttons.get("Advancement Button").width,
				JsonConfig.Buttons.get("Advancement Button").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"),204, 40,
				(button) -> {
					this.minecraft.displayGuiScreen(
							new AdvancementsScreen(this.minecraft.player.connection.getAdvancementManager()));
				}));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Stats Button").x_pos,
				h - JsonConfig.Buttons.get("Stats Button").y_pos, JsonConfig.Buttons.get("Stats Button").width,
				JsonConfig.Buttons.get("Stats Button").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button) -> {
					this.minecraft.displayGuiScreen(new StatsScreen(this, this.minecraft.player.getStats()));
				}));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Options Button").x_pos,
				h - JsonConfig.Buttons.get("Options Button").y_pos, JsonConfig.Buttons.get("Options Button").width,
				JsonConfig.Buttons.get("Options Button").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button) -> {
					this.minecraft.displayGuiScreen(new OptionsScreen(this, this.minecraft.gameSettings));
				}));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Mods Menu").x_pos,
				h - JsonConfig.Buttons.get("Mods Menu").y_pos, JsonConfig.Buttons.get("Mods Menu").width,
				JsonConfig.Buttons.get("Mods Menu").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button) -> {
					this.minecraft.displayGuiScreen(new net.minecraftforge.fml.client.gui.screen.ModListScreen(this));
				}));

		Button button1 = this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Lan Button").x_pos,
				h - JsonConfig.Buttons.get("Lan Button").y_pos, JsonConfig.Buttons.get("Lan Button").width,
				JsonConfig.Buttons.get("Lan Button").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button2) -> {
					this.minecraft.displayGuiScreen(new ShareToLanScreen(this));
				}));
		button1.active = this.minecraft.isSingleplayer() && !this.minecraft.getIntegratedServer().getPublic();

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Main Menu").x_pos,
				h - JsonConfig.Buttons.get("Main Menu").y_pos, JsonConfig.Buttons.get("Main Menu").width,
				JsonConfig.Buttons.get("Main Menu").height, 0, 0, 20,
				new ResourceLocation("pausemenuedits:textures/defaultbuttons/button_unselected.png"), 204, 40,
				(button) -> {
					boolean flag = this.minecraft.isIntegratedServerRunning();
					button.active = false;
					this.minecraft.world.sendQuittingDisconnectingPacket();
					if (flag) {
						this.minecraft.unloadWorld(new DirtMessageScreen(new TranslationTextComponent("menu.savingLevel")));
						this.minecraft.displayGuiScreen(new MainMenuScreen());
					} else {
						this.minecraft.unloadWorld();
						this.minecraft.displayGuiScreen(new MultiplayerScreen(new MainMenuScreen()));
					}
				}));
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
