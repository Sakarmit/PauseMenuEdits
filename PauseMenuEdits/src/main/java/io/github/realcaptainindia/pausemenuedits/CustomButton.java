package io.github.realcaptainindia.pausemenuedits;

import io.github.realcaptainindia.pausemenuedits.button.Actions;
import net.minecraft.client.gui.widget.button.Button.IPressable;
import net.minecraft.util.ResourceLocation;

public class CustomButton {
	public final int x_pos;
	public final int y_pos;
	public final int width;
	public final int height;
	public final int texstartx;
	public final int texstarty;
	
	private final String action;
	private final String action_val;
	private final String texture;
	
	public CustomButton(int x_pos, int y_pos, int width, int height, String texture, int texstartx,int texstarty, String action, String value) {
		this.x_pos = x_pos;
		this.y_pos = y_pos;
		this.width = width;
		this.height = height;
		this.texture = texture;
		this.texstartx = texstartx;
		this.texstarty = texstarty;
		this.action = action;
		this.action_val = value;
	}

	public ResourceLocation getTexture() {
		return new ResourceLocation(texture);
	}

	public IPressable getAction() {
		return Actions.JsontoAction(action, action_val);
	}
	
}
