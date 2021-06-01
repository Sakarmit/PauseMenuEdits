package io.github.realcaptainindia.pausemenuedits;

import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.realcaptainindia.pausemenuedits.button.Actions;
import net.minecraft.client.gui.screen.DirtMessageScreen;
import net.minecraft.client.gui.screen.MainMenuScreen;
import net.minecraft.client.gui.screen.MultiplayerScreen;
import net.minecraft.client.gui.screen.OptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.ShareToLanScreen;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
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
		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("UnPause Button").x_pos,
				h - JsonConfig.Buttons.get("UnPause Button").y_pos, JsonConfig.Buttons.get("UnPause Button").width,
				JsonConfig.Buttons.get("UnPause Button").height, 0, 0, 20,
				JsonConfig.Buttons.get("UnPause Button").texture, 204, 40, 
				Actions.JsontoAction("opengui", "Unpause")));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Advancements Button").x_pos,
				h - JsonConfig.Buttons.get("Advancements Button").y_pos,
				JsonConfig.Buttons.get("Advancements Button").width,
				JsonConfig.Buttons.get("Advancements Button").height, 0, 0, 20,
				JsonConfig.Buttons.get("Advancements Button").texture, 204, 40,
				Actions.JsontoAction("opengui", "Advancement")));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Statistics Button").x_pos,
				h - JsonConfig.Buttons.get("Statistics Button").y_pos,
				JsonConfig.Buttons.get("Statistics Button").width, JsonConfig.Buttons.get("Statistics Button").height,
				0, 0, 20, JsonConfig.Buttons.get("Statistics Button").texture, 204, 40, 
				Actions.JsontoAction("opengui", "Statistics")));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Options Button").x_pos,
				h - JsonConfig.Buttons.get("Options Button").y_pos, JsonConfig.Buttons.get("Options Button").width,
				JsonConfig.Buttons.get("Options Button").height, 0, 0, 20,
				JsonConfig.Buttons.get("Options Button").texture, 204, 40,
				Actions.JsontoAction("opengui", "Options")));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Mods List Button").x_pos,
				h - JsonConfig.Buttons.get("Mods List Button").y_pos, JsonConfig.Buttons.get("Mods List Button").width,
				JsonConfig.Buttons.get("Mods List Button").height, 0, 0, 20,
				JsonConfig.Buttons.get("Mods List Button").texture, 204, 40,
				Actions.JsontoAction("opengui", "Mods List")));

		Button button1 = this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Lan Button").x_pos,
				h - JsonConfig.Buttons.get("Lan Button").y_pos, JsonConfig.Buttons.get("Lan Button").width,
				JsonConfig.Buttons.get("Lan Button").height, 0, 0, 20, JsonConfig.Buttons.get("Lan Button").texture,
				204, 40, Actions.JsontoAction("opengui", "Lan")));

		this.addButton(new ImageButton(w + JsonConfig.Buttons.get("Main Menu Button").x_pos,
				h - JsonConfig.Buttons.get("Main Menu Button").y_pos, JsonConfig.Buttons.get("Main Menu Button").width,
				JsonConfig.Buttons.get("Main Menu Button").height, 0, 0, 20,
				JsonConfig.Buttons.get("Main Menu Button").texture, 204, 40,Actions.JsontoAction("opengui", "Quit")));
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
