package io.github.realcaptainindia.pausemenuedits.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import io.github.realcaptainindia.pausemenuedits.PauseMenuEdits;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.loading.FMLPaths;

public class ButtonInfo {
	static Minecraft game = Minecraft.getInstance();

	public final int x_position;
	public final int y_position;

	public final int width;
	public final int height;
	private final String texture;
	public final int texture_start_x;
	public final int texture_start_y;

	private final String action_value;

	public final Boolean show_name;

	public ButtonInfo(Boolean nameShow, int x_pos, int y_pos, int width, int height, String texture, int texstartx,
			int texstarty, String value) {
		this.x_position = x_pos;
		this.y_position = y_pos;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.texture_start_x = texstartx;
		this.texture_start_y = texstarty;
		this.action_value = value;
		this.show_name = nameShow;
	}

	public ResourceLocation getTexture() {
		try {
			// Returns default button texture as ResourceLocation
			if (texture.toLowerCase() == "default.png")
				return new ResourceLocation("pausemenuedits:textures/default.png");

			// Gets texture form config as ResourceLocation
			InputStream stream = new FileInputStream(
					FMLPaths.CONFIGDIR.get() + "\\pausemenuedits\\textures\\" + texture);
			;
			NativeImage textureNativeImage = NativeImage.read(stream);
			return game.textureManager.getDynamicTextureLocation(texture, new DynamicTexture(textureNativeImage));

		} catch (IOException e) {
			// Returns default texture if custom is missing
			PauseMenuEdits.LOGGER
			.info("This went wrong with button texture:" + e.getMessage() + ". Changing to default texture");
			return new ResourceLocation("pausemenuedits:textures/default.png");
		}
	}

	public IPressable getAction() {
		// Gets IPressable for stated action
		return Actions.JsontoAction(action_value);
	}

}
