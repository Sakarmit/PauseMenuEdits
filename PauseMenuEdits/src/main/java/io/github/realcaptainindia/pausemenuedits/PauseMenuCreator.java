package io.github.realcaptainindia.pausemenuedits;

import net.minecraftforge.api.distmarker.OnlyIn;
import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.realcaptainindia.pausemenuedits.config.Actions;
import io.github.realcaptainindia.pausemenuedits.config.CustomButton;
import io.github.realcaptainindia.pausemenuedits.config.JsonConfig;
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
public class PauseMenuCreator extends Screen {

	public PauseMenuCreator() {
		super(new TranslationTextComponent(""));
	}

	protected void init() {
		this.addButtons();
	}

	private void addButtons() {
		int w = this.width / 2;
		int h = this.height / 2;

		for (CustomButton val : JsonConfig.Buttons.values()) {
			this.addButton(new ImageButton(w + val.x_pos, h - val.y_pos, val.width, val.height, 0, 0, 20,
					val.getTexture(), 204, 40, val.getAction()));
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
