package io.github.realcaptainindia.pausemenuedits;

import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Map.Entry;

import com.mojang.blaze3d.matrix.MatrixStack;

import io.github.realcaptainindia.pausemenuedits.buttons.ButtonInfo;
import io.github.realcaptainindia.pausemenuedits.buttons.CustomButton;
import io.github.realcaptainindia.pausemenuedits.config.ConfigLoader;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;

@OnlyIn(Dist.CLIENT)
public class PauseMenuCreator extends Screen {

	public PauseMenuCreator() {
		super(new TranslationTextComponent(""));
	}

	protected void init() {
		// Gets the center of screen
		int w = this.width / 2;
		int h = this.height / 2;

		// Creates all buttons from Buttons Map
		for (Entry<String, ButtonInfo> button : ConfigLoader.Buttons.entrySet()) {
			
			ButtonInfo val = button.getValue();
			
			String name = val.show_name ? button.getKey() : "";
			
			this.addButton(new CustomButton(name, w + val.x_position, h - val.y_position, val.width, val.height, val.texture_start_x, val.texture_start_y, val.height,
					val.getTexture(), val.width, val.height, val.getAction()));
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
