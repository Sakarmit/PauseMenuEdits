package io.github.realcaptainindia.pausemenuedits.elements;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CustomButton extends Button {
	private final String name;
	
	private final ResourceLocation resourceLocation;
	private final int xTexStart;
	private final int yTexStart;
	private final int yDiffText;

	public CustomButton(String nameIn, int xIn, int yIn, int widthIn, int heightIn, int xTexStartIn, int yTexStartIn,
			int yDiffTextIn, ResourceLocation resourceLocationIn,
			Button.IPressable onPressIn) {
		super(xIn, yIn, widthIn, heightIn, new StringTextComponent(nameIn), onPressIn);
		this.name = nameIn;
		this.xTexStart = xTexStartIn;
		this.yTexStart = yTexStartIn;
		this.yDiffText = yDiffTextIn;
		this.resourceLocation = resourceLocationIn;
	}

	public void renderWidget(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		Minecraft game = Minecraft.getInstance();
		game.getTextureManager().bindTexture(this.resourceLocation);
		int i = this.yTexStart;
		if (this.isHovered()) {
			i += this.yDiffText;
		}
		RenderSystem.enableDepthTest();
		blit(matrixStack, this.x, this.y, (float) this.xTexStart, (float) i, this.width, this.height, this.width,
				this.height * 2);
		drawCenteredString(matrixStack, game.fontRenderer, name, this.x + this.width/2, this.y + this.height/4, 16777215);

	}
}
